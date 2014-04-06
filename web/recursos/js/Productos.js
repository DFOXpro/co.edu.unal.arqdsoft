Admin = new Object();
Admin.Productos = new Object();

Admin.Productos.getProductos = function (){
    sendRequest(
        "productos",
            function (respuesta){
                var s = Admin.Productos.mostrarProductos(respuesta);
                $("#ad_listaProductos").html(s);
                $("#ad_d_Planes_AgregarProducto").html(
                    s.replace(
                        new RegExp("Admin.Productos.getProducto", 'g'),
                        "Admin.Planes.agregarProducto"
                    )
                );
            },
        "listarProductos",
        ""
    );
};

Admin.Productos.getProducto = function (id, nombre){
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
    };
    sendRequest(
        "productos",
        function (respuesta){
            if(respuesta.error.length == 0)
                Admin.Productos.getProductos();
            else $("#error").html(respuesta.error);
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
            s+="<li><a href='#' onclick='Admin.Productos.getProducto("+array[i].id+",\""+array[i].nombre+"\"); return false;'>"+array[i].nombre+"</a></li>";//TODO FUTURE: use templates
        }
        return s;
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


Admin.Planes = new Object();

Admin.Planes.getPlanes = function (){
    sendRequest(
        "productos",
        Admin.Planes.mostrarPlanes,
        "listarPlanes",
        ""
    );
};

Admin.Planes.getPlan = function (id){
    sendRequest(
        "productos",
        Admin.Planes.mostrarPlan,
        "getPlan",
        id
    );
};

Admin.Planes.setPlan = function (){
    var array= new Array();i=0;
    $("#ad_Planes_ListaProductos option").each(function() {
        array[i]={
            id:$(this).val(),
            nombre:$(this).html()
        };
        i++;
    });
    var data = {
        id:$("#ad_idPlanes").val(),
        nombre:$("#ad_nombrePlanes").val(),
        descripcion:$("#ad_descripcionPlanes").val(),
        valor:$("#ad_valorPlanes").val(),
        productos: array
    };
    sendRequest(
        "productos",
        function (respuesta){
            Admin.Planes.mostrarPlan(respuesta);
            Admin.Planes.getPlanes();
        },
        "setPlan",
        JSON.stringify(data)
    );
};

Admin.Planes.borrarPlan = function (){
    sendRequest(
        "productos",
        function (respuesta){
            if(respuesta.error.length > 0) $("#error").html(respuesta.error);
            else{
                Admin.Planes.getPlanes();
            }
        },
        "borrarPlan",
        $("#ad_idPlanes").val()
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
        $("#ad_Planes_ListaProductos").html(s);

        $("#ad_infoPlanes").removeClass("hidden");
        $("#ad_b_ActualizarPlanes").removeClass("hidden");
        $("#ad_b_BorrarPlanes").removeClass("hidden");
        $("#ad_b_CancelarPlanes").removeClass("hidden");
    } else $("#error").html(respuesta.error);
};
Admin.Planes.agregarProducto = function (id, nombre){
    if ( $("#ad_Planes_ListaProductos option[value="+id+"]").length > 0 ) alert("El plan ya tiene este producto");
    else $("#ad_Planes_ListaProductos").append(new Option(nombre, id));
};
Admin.Planes.quitarProducto = function (){
    $("#ad_Planes_ListaProductos").find('option:selected').remove();
};


Admin.innit = function (){
    Evento.menu($("#l_ad_productos"), $("#ad_productos"));
    Evento.boton($("#ad_b_CrearProductos"), function (){
        if($("#ad_infoProducto").hasClass("hidden")){
            $("#ad_infoProducto").removeClass("hidden");
            $("#ad_b_CancelarProductos").removeClass("hidden");
            $("#ad_idProductos").val(-1);
            $("#ad_nombreProductos").val("");
            $("#ad_descripcionProductos").val("");
            $("#ad_valorProductos").val("");
        }else {
            $("#ad_idProductos").val(-1);
            Admin.Productos.setProducto();
        }
    });
    Evento.boton($("#ad_b_ActualizarProductos"), Admin.Productos.setProducto);

    Evento.boton($("#ad_b_CrearPlanes"), function (){
        if($("#ad_infoPlanes").hasClass("hidden")){
            $("#ad_infoPlanes").removeClass("hidden");
            $("#ad_b_CancelarPlanes").removeClass("hidden");
            $("#ad_idPlanes").val(-1);
            $("#ad_nombrePlanes").val("");
            $("#ad_descripcionPlanes").val("");
            $("#ad_valorPlanes").val("");
        }else {
            $("#ad_idPlanes").val(-1);
            Admin.Planes.setPlan();
        }
    });
    Evento.boton($("#ad_b_ActualizarPlanes"), Admin.Planes.setPlan);
    Evento.boton($("#ad_b_Planes_QuitarProducto"), Admin.Planes.quitarProducto);

    Evento.boton($("#ad_b_BorrarProductos"), Admin.Productos.borrarProducto);
    Evento.boton($("#ad_b_CancelarProductos"), function (){
        $("#ad_infoProducto").addClass("hidden");
        $("#ad_b_ActualizarProductos").addClass("hidden");
        $("#ad_b_BorrarProductos").addClass("hidden");
        $("#ad_b_CancelarProductos").addClass("hidden");
    });
    Evento.boton($("#ad_b_CancelarPlanes"), function (){
        $("#ad_infoPlanes").addClass("hidden");
        $("#ad_b_ActualizarPlanes").addClass("hidden");
        $("#ad_b_BorrarPlanes").addClass("hidden");
        $("#ad_b_CancelarPlanes").addClass("hidden");
    });
    Evento.menu($("#l_ad_planes"), $("#ad_planes"));
    Evento.cerrarSesion($("#l_ad_cerrarSesion"));
    Admin.Productos.getProductos();
    Admin.Planes.getPlanes();
};

//Admin.innit();
console.log("AdminProductos cargados");