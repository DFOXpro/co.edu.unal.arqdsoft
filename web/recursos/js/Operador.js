Operador = new Object();
Operador.Soporte = new Object();
Operador.Cliente = new Object();

//Operador.Soporte.get = function (){};

Operador.Soporte.set = function (){
    
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