Operador = new Object();
Operador.Soporte = new Object();
Operador.Cliente = new Object();

//Operador.Soporte.get = function (){};

Operador.Soporte.set = function (){
    s = "";
    if ($("#op_idCliente").val().length < 6) s += "Escriba bien el numero de cedula.<br>";
    if ($("#op_nombreCliente").val() == "") s += "Qué cliente presenta el problema.<br>";
    //if ($("#op_planDano").find(":selected").val() == "-1") s += "Seleccione el plan dañado primero.<br>";
    if ($("#op_informacionDano").val().length < 20) s += "Escriba una información detallada del error.<br>";
    //if ($("#op_solucionOfrecida").val().length < 20) s += "Escriba una solución dada detallada de la solucion dada.<br>";
    if ($("#op_cb_Solucinado").is(':checked')){
        if($("#op_cb_EnvioDeTecnico").is(':checked'))
            s += "para qué enviar tecnico si se solucionó el problema.<br>";
    } else if(!$("#op_cb_EnvioDeTecnico").is(':checked'))
        s += "Si no se solucionó el problema envía un tecnico.<br>";
    if($("#op_cb_EnvioDeTecnico").is(':checked'))
        if($("#op_i_fechaTecnico").val()=="" | new Date() > $("#op_i_fechaTecnico").datepicker("getDate"))
            s += "Hay un error con la fecha.<br>";

    if(s != "") $("#error").html(s);
    else {
        var data = {
            cliente : $("#op_idCliente").val(),
            //plan: $("#op_planDano").find(":selected").val(),
            fechaTecnico: $("#op_i_fechaTecnico").datepicker("getDate").toJSON(),
            enviaTecnico: $("op_cb_EnvioDeTecnico").is(':checked'),
            solucion: $("op_cb_Solucinado").is(':checked'),
            info: $("#op_informacionDano").val()//,
            direccion: $("op_i_direccionVisita")
            //solucion: $("#op_solucionOfrecida").val()
        };
//{"cliente":"1234567","enviaTecnico":false,"fechaTecnico":"2014-04-09T05:00:00.000Z","solucion":false,"info":"awqeqeqeqeqeqeqeqweqweqew"}
        sendRequest(
            "ventas",
            Operador.Soporte.respuesta,
            "setSoporte",
            JSON.stringify(data)
        );
    }
};
Operador.reset = function (){
    $("#op_idCliente").prop('disabled', false);
    $("#op_idCliente").val("");
    $("#op_nombreCliente").val("");
    $("#op_informacionDano").val("");
    $("#op_solucionOfrecida").val("");
    $("#op_productoDano").html("");
    $('#op_cb_EnvioDeTecnico').attr('checked', false);
    $('#op_cb_Solucinado').attr('checked', false);
};


Operador.Cliente.mostrar = function (respuesta){
    if(respuesta.error.length == 0){
        $("#error").html("");
        $("#op_idCliente").prop('disabled', true);
        $("#op_idCliente").val(respuesta.contenido.dato.id);
        $("#op_nombreCliente").val(respuesta.contenido.dato.nombre);
        var array = respuesta.contenido.dato.planes;
        var s = "";
        for (var i in array) {
            s+="<option value='"+array[i].id+"'>"+array[i].nombre+": "+array[i].direccion+"</option>";//TODO FUTURE: use templates
        }
    } else $("#error").html(respuesta.error);
};
Operador.Cliente.get = function (){
    if($("#op_idCliente").val().length>5)
        sendRequest(
            "ventas",
            Operador.Cliente.mostrar,
            "getCliente",
            $("#op_idCliente").val()
        );
    else $("#error").html("Escriba bien el numero de cedula");
};

Operador.innit = function (){
    $("#op_b_buscarCliente").submit(function(event) {
        event.preventDefault();
        Operador.Cliente.get();
    });
    Evento.boton($("#op_b_enviarReporte"),Operador.Soporte.set);
    Evento.boton($("#op_b_resetReporte"),Operador.reset);
    $("#op_i_fechaTecnico").datepicker({dateFormat: "DD dd 'de' MM"});
    Evento.cerrarSesion($("#l_op_cerrarSesion"));
};