Operador = new Object();
Operador.Soporte = new Object();
Operador.Cliente = new Object();

//Operador.Soporte.get = function (){};

Operador.Soporte.set = function (){
    s = "";
    if ($("#op_idCliente").val().length < 6) s += "Escriba bien el numero de cedula.<br>";
    if ($("#op_nombreCliente").val() == "") s += "Qué cliente presenta el problema.<br>";
    if ($("#op_planDano").find(":selected").val() == "-1") s += "Seleccione el plan dañado primero.<br>";
    if ($("#op_informacionDano").val().length < 20) s += "Escriba una información detallada del error.<br>";
    if ($("#op_solucionOfrecida").val().length < 20) s += "Escriba una solución dada detallada de la solucion dada.<br>";
    if (
        !($("#op_cb_EnvioDeTecnico").is(':checked') |
        $("#op_cb_Solucinado").is(':checked'))
    ) s += "Si no se solucionó el problema envía un tecnico.<br>";

    if(s != "") $("#error").html(s);
    else {
        var data = {
            cliente : $("#op_idCliente").val(),
            plan: $("#op_planDano").find(":selected").val(),
            enviaTecnico: $("op_cb_EnvioDeTecnico").is(':checked'),
            solucionado: $("op_cb_Solucinado").is(':checked'),
            info: $("#op_informacionDano").val(),
            solucion: $("#op_solucionOfrecida").val()
        };
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
    Evento.cerrarSesion($("#l_op_cerrarSesion"));
};