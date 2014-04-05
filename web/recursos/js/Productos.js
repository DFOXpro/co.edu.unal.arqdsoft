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

Productos.setProducto = function (){
    
    var data = {
        id:$("#ad_idProductos").val(),
        nombre:$("#ad_nombreProductos").val(),
        descripcion:$("#ad_descripcionProductos").val(),
        valor:$("#ad_valorProductos").val()
    }
    sendRequest(
        "productos",
        function (respuesta){
            Productos.mostrarProducto(respuesta);
            Productos.getProductos();
        },
        "setProducto",
        JSON.stringify(data)
    );
};

Productos.borrarProducto = function (){
    
    sendRequest(
        "productos",
        function (respuesta){
            Productos.mostrarProducto(respuesta);
            Productos.getProductos();
        },
        "borrarProducto",
        id
    );
};

Productos.mostrarProductos = function (respuesta){
    if(respuesta.error.length == 0){
        $("#error").html("");
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
        $("#error").html("");
        $("#ad_idProductos").val(respuesta.contenido.dato.id);
        $("#ad_nombreProductos").val(respuesta.contenido.dato.nombre);
        $("#ad_descripcionProductos").val(respuesta.contenido.dato.descripcion);
        $("#ad_valorProductos").val(respuesta.contenido.dato.valor);
        $("#ad_infoProducto").removeClass("hidden");
        $("#ad_b_ActualizarProductos").removeClass("hidden");
        $("#ad_b_BorrarProductos").removeClass("hidden");
        $("#ad_b_CancelarProductos").removeClass("hidden");
    } else $("#error").html(respuesta.error);
};

Productos.getPlanes = function (){
    //TODO
};

Productos.innit = function (){
    Evento.menu($("#l_ad_productos"), $("#ad_productos"));
    Evento.boton($("#ad_b_CrearProductos"), function (){
        $("#ad_idProductos").val(-1);
        Productos.setProducto();
    });
    Evento.boton($("#ad_b_ActualizarProductos"), Productos.setProducto);
    Evento.boton($("#ad_b_BorrarProductos"), Productos.borrarProducto);
    Evento.boton($("#ad_b_CancelarProductos"), function (){
        $("#ad_infoProducto").addClass("hidden");
        $("#ad_b_ActualizarProductos").addClass("hidden");
        $("#ad_b_BorrarProductos").addClass("hidden");
        $("#ad_b_CancelarProductos").addClass("hidden");
    });
    Evento.menu($("#l_ad_planes"), $("#ad_planes"));
    Evento.cerrarSesion($("#l_ad_cerrarSesion"));
    Productos.getProductos();
};

//Productos.innit();
console.log("AdminProductos cargados");