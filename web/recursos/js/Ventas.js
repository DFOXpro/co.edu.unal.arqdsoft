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
        $("#ve_informacionCliente").val(respuesta.contenido.dato.informacion);
    } else $("#error").html(respuesta.error);
}

Ventas.Venta = new Object();

Ventas.Venta.getPlanes = function (){
    sendRequest(
        "productos",
        Ventas.Venta.mostrarPlanes,
        "listarPlanes",
        ""
    );
};

Ventas.Venta.mostrarPlanes = function (respuesta){
    if(respuesta.error.length == 0){
        $("#error").html("");
        var array = respuesta.contenido.dato;
        var s = "";
        for (var i in array) {
            s+="<li><a href='#' onclick='Ventas.Venta.setPlan("+array[i].id+","+array[i].nombre+"); return false;'>"+array[i].nombre+"</a></li>";//TODO FUTURE: use templates
        }
        $("#ve_PlanLista").html(s);
    } else $("#error").html(respuesta.error);
};

Ventas.innit = function (){
    Evento.boton($("#ve_b_buscarCliente"),Ventas.Cliente.get);
    Evento.boton($("#ve_b_cancelarVenta"),function (){
        $("#ve_idCliente").val("");
        $("#ve_nombreCliente").val("");
        $("#ve_informacionCliente").val("");
        $("#ve_Plan").val("");
    });
    Ventas.Venta.getPlanes();
};