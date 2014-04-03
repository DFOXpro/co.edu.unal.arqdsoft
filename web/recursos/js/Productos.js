Productos = new Object();
Productos.getProductos = function (){
    sendRequest(
        "productos",
        Productos.mostrarProductos,
        "listarProductos",
        ""
    );
};
Productos.mostrarProductos = function (respuesta){
    if(respuesta.error.length == 0){
        var array = respuesta.contenido.dato;
        var s = "";
        for (var i in array) {
            s+="<li><a href='#' onclick='doSomething("+array[i].id+"); return false;'>"+array[i].nombre+"</a></li>";
        }
        $("#ad_listaProductos").html(s);
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

Productos.mostrarProducto = function (respuesta){
    
};

Productos.getProducto = function (nombre){
    sendRequest(
        "productos",
        Productos.mostrarProducto,
        "getProducto",
        nombre
    );
};

//Productos.innit();
console.log("AdminProductos cargados");