Admin = new Object();
Admin.Productos = new Object();
Admin.Planes = new Object();

Admin.Productos.getProductos = function (){
    sendRequest(
        "productos",
        Admin.Productos.mostrarProductos,
        "listarProductos",
        ""
    );
};

Admin.Planes.getPlanes = function (){
    sendRequest(
        "productos",
        Admin.Planes.mostrarPlanes,
        "listarPlanes",
        ""
    );
};

Admin.Planes.mostrarPlanes = function (respuesta){
    if(respuesta.error.length == 0){
        $("#error").html("");
        var array = respuesta.contenido.dato;
        var s = "";
        for (var i in array) {
            s+="<li><a href='#' onclick='Admin.Planes.getPlan("+array[i].id+"); return false;'>"+array[i].nombre+"</a></li>";//TODO FUTURE: use templates
        }
        $("#ad_listaPlanes").html(s);
    } else $("#error").html(respuesta.error);
};

Admin.Planes.getPlan = function (id){
    sendRequest(
        "productos",
        Admin.Planes.mostrarPlan,
        "getPlan",
        id
    );
};
Admin.Planes.mostrarPlan = function (respuesta){
    if(respuesta.error.length == 0){
        $("#error").html("");
        $("#ad_idPlanes").val(respuesta.contenido.dato.id);
        $("#ad_nombrePlanes").val(respuesta.contenido.dato.nombre);
        $("#ad_descripcionPlanes").val(respuesta.contenido.dato.descripcion);
        $("#ad_valorPlanes").val(respuesta.contenido.dato.valor);
        var s = "";
        for (var i in respuesta.contenido.dato.productos) {
            s+="<option value='"+respuesta.contenido.dato.productos[i].id+
                "'>"+respuesta.contenido.dato.productos[i].nombre+"</option>";//TODO FUTURE: use templates
        }
        $("#ad_ProductosPlanes").html(s);

        $("#ad_infoPlanes").removeClass("hidden");
        $("#ad_b_ActualizarPlanes").removeClass("hidden");
        $("#ad_b_BorrarPlanes").removeClass("hidden");
        $("#ad_b_CancelarPlanes").removeClass("hidden");
    } else $("#error").html(respuesta.error);
};

Admin.Productos.getProducto = function (id){
    
    sendRequest(
        "productos",
        Admin.Productos.mostrarProducto,
        "getProducto",
        id
    );
};

Admin.Productos.setProducto = function (){
    
    var data = {
        id:$("#ad_idProductos").val(),
        nombre:$("#ad_nombreProductos").val(),
        descripcion:$("#ad_descripcionProductos").val(),
        valor:$("#ad_valorProductos").val()
    }
    sendRequest(
        "productos",
        function (respuesta){
            Admin.Productos.mostrarProducto(respuesta);
            Admin.Productos.getProductos();
        },
        "setProducto",
        JSON.stringify(data)
    );
};

Admin.Productos.borrarProducto = function (){
    sendRequest(
        "productos",
        function (respuesta){
            if(respuesta.error.length > 0) $("#error").html(respuesta.error);
            else{
                Admin.Productos.getProductos();
            }
        },
        "borrarProducto",
        $("#ad_idProductos").val()
    );
};

Admin.Productos.mostrarProductos = function (respuesta){
    if(respuesta.error.length == 0){
        $("#error").html("");
        var array = respuesta.contenido.dato;
        var s = "";
        for (var i in array) {
            s+="<li><a href='#' onclick='Admin.Productos.getProducto("+array[i].id+"); return false;'>"+array[i].nombre+"</a></li>";//TODO FUTURE: use templates
        }
        $("#ad_listaProductos").html(s);
    } else $("#error").html(respuesta.error);
};

Admin.Productos.mostrarProducto = function (respuesta){
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


Admin.innit = function (){
    Evento.menu($("#l_ad_productos"), $("#ad_productos"));
    Evento.boton($("#ad_b_CrearProductos"), function (){
        $("#ad_idProductos").val(-1);
        Admin.Productos.setProducto();
    });
    Evento.boton($("#ad_b_ActualizarProductos"), Admin.Productos.setProducto);
    Evento.boton($("#ad_b_BorrarProductos"), Admin.Productos.borrarProducto);
    Evento.boton($("#ad_b_CancelarProductos"), function (){
        $("#ad_infoProducto").addClass("hidden");
        $("#ad_b_ActualizarProductos").addClass("hidden");
        $("#ad_b_BorrarProductos").addClass("hidden");
        $("#ad_b_CancelarProductos").addClass("hidden");
    });
    Evento.menu($("#l_ad_planes"), $("#ad_planes"));
    Evento.cerrarSesion($("#l_ad_cerrarSesion"));
    Admin.Productos.getProductos();
    Admin.Planes.getPlanes();
};

//Admin.innit();
console.log("AdminProductos cargados");