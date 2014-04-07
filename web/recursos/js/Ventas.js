Ventas = new Object();
Ventas.Cliente = new Object();
Ventas.Cliente.get = function (){
    sendRequest(
        "ventas",
        Ventas.Cliente.mostrarCliente,
        "getCliente",
        $("#ve_idCliente").val()
    );
};

Ventas.Cliente.mostrarCliente = function (respuesta){
    if(respuesta.error.length == 0){
        $("#error").html("");
        $("#ve_idCliente").val(respuesta.contenido.dato.id);
        $("#ve_nombreCliente").val(respuesta.contenido.dato.nombre);
        $("#ve_informacionCliente").val(respuesta.contenido.dato.descripcion);
        $("#ve_Plan").val(respuesta.contenido.dato.plan);
        $("#ad_infoProducto").removeClass("hidden");
        $("#ad_b_ActualizarProductos").removeClass("hidden");
        $("#ad_b_BorrarProductos").removeClass("hidden");
        $("#ad_b_CancelarProductos").removeClass("hidden");
    } else $("#error").html(respuesta.error);
}

Ventas.Venta = new Object();

Ventas.innit = function (){
    Evento.boton($("#ve_b_buscarCliente"),Ventas.Cliente.get);
    Evento.boton($("#ve_b_cancelarVenta"),function (){
        $("#ve_idCliente").val("");
        $("#ve_nombreCliente").val("");
        $("#ve_informacionCliente").val("");
        $("#ve_Plan").val("");
    });
};