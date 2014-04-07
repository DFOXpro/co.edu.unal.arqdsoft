Ventas = new Object();
Ventas.Cliente = new Object();

/**
*   Esta funcion es la encargada de enviar peticiones al servlet de ventas y por 
*   medio de la id del cliente y la funcion getcliente obtener un cliente en 
*   especifico
*/
Ventas.Cliente.get = function (){
    sendRequest(
        "ventas",
        Ventas.Cliente.mostrarCliente,
        "getCliente",
        $("#ve_idCliente").val()
    );
};

/**
*   Esta funcion es la encargada de a travez de la respuesta de la anterior peticion
*   normalmente un get dar formato al objeto separando su id nombre y demas campos
*   siempre validando la respuesta de la anterior peticion
*/
Ventas.Cliente.mostrarCliente = function (respuesta){
    if(respuesta.error.length == 0){
        $("#error").html("");
        $("#ve_idCliente").val(respuesta.contenido.dato.id);
        $("#ve_nombreCliente").val(respuesta.contenido.dato.nombre);
        $("#ve_informacionCliente").val(respuesta.contenido.dato.informacion);
    } else $("#error").html(respuesta.error);
}

Ventas.Venta = new Object();

/**
*   Esta funcion nos permite ver todos los planes actuales en la instancia de la
*   venta haciendo una peticion a el servlet de productos y utilizando la funcion 
*   listarplanes.
*/
Ventas.Venta.getPlanes = function (){
    sendRequest(
        "productos",
        Ventas.Venta.mostrarPlanes,
        "listarPlanes",
        ""
    );
};

/**
*   Esta funcion es puramente de navegacion y nos permite cambiar el estado de 
*   un plan a visible o invisible segun lo seleccionemos.
*/
Ventas.Venta.setPlan = function (id, nombre){
    $("#ve_PlanEscojido").removeClass("hidden");
    $("#ve_PlanEscojer").addClass("hidden");
    $("#ve_PlanID").val(id);
    $("#ve_PlanNombre").val(nombre);
};

/**
*   Esta funcion se encarga de dar formato a la respuesta obtenida por una peticion
*   de getplanes y nos permite visualizar los planes actuales.
*/
Ventas.Venta.mostrarPlanes = function (respuesta){
    if(respuesta.error.length == 0){
        $("#error").html("");
        var array = respuesta.contenido.dato;
        var s = "";
        for (var i in array) {
            s+="<li><a href='#' onclick='Ventas.Venta.setPlan("+array[i].id+",\""+array[i].nombre+"\"); return false;'>"+array[i].nombre+"</a></li>";//TODO FUTURE: use templates
        }
        $("#ve_PlanLista").html(s);
    } else $("#error").html(respuesta.error);
};
/**
*   Esta funcion inicializa todos los componentes
*/
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