Productos = new Object();
Productos.getProductos = function (){
    sendRequest(
        "productos",
        Productos.mostrarProductos,
        "listarProductos",
        ""
    );
};

Productos.getProducto = function (id){
    sendRequest(
        "productos",
        Productos.mostrarProducto,
        "getProducto",
        id
    );
};

Productos.mostrarProductos = function (respuesta){
    if(respuesta.error.length == 0){
        var array = respuesta.contenido.dato;
        var s = "";
        for (var i in array) {
            s+="<li><a href='#' onclick='Productos.getProducto("+array[i].id+"); return false;'>"+array[i].nombre+"</a></li>";//TODO FUTURE: use templates
        }
        $("#ad_listaProductos").html(s);
    } else $("#error").html(respuesta.error);
};

Productos.mostrarProducto = function (respuesta){
    if(respuesta.error.length == 0){
        $("#ad_idProductos").val(respuesta.contenido.dato.id);
        $("#ad_nombreProductos").val(respuesta.contenido.dato.nombre);
        $("#ad_descripcionProductos").val(respuesta.contenido.dato.descripcion);
        $("#ad_valorProductos").val(respuesta.contenido.dato.valor);
        $("#ad_infoProducto").removeClass("hidden");
        $("#ad_b_ActualizarProductos").removeClass("hidden");
        $("#ad_b_BorrarProductos").removeClass("hidden");
    } else $("#error").html(respuesta.error);
};

Productos.getPlanes = function (){
    //TODO
};

Productos.innit = function (){
    Evento.menu($("#l_ad_productos"), $("#ad_productos"));
    Evento.menu($("#l_ad_planes"), $("#ad_planes"));
    Evento.cerrarSesion($("#l_ad_cerrarSesion"));
    Productos.getProductos();
};

//Productos.innit();
console.log("AdminProductos cargados");