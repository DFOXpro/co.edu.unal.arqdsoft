Admin = new Object();
Admin.Productos = new Object();

/**
*   Funcion que se encarga de enviar la peticion al servlet de productos 
*   permitiendo listarlos gracias a la respuesta listarproductos que envia
*   la peticion luego de su ejecucion.
*/
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

/**
*   Funcion que se encarga de enviar la peticion al servlet de productos para obtener
*   un producto enviando como dato su ID, y utilizando la funcion mostrarproducto al
*   recibir la respuesta.
*   @param {long} id El id del producto seleccionado
*   @param {string} nombre El nombre del producto seleccionado
*/
Admin.Productos.getProducto = function (id, nombre){
    sendRequest(
        "productos",
        Admin.Productos.mostrarProducto,
        "getProducto",
        id
    );
};

/**
*   Funcion que se encarga de enviar la peticion al servlet de productos para actualizar
*   un producto realizando una validacion de errores antes de realizar los cambios y 
*   mostrandonos los nuevos campos como respuesta.
*/
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

/**
*   Esta funcion se encarga de comunicarse con el servlet de productos para realizar
*   el borrado de uno de ellos usando como parametro la id de este y como respuesta
*   obteniendo el nuevo listado de productos
*/
Admin.Productos.borrarProducto = function (){
    sendRequest(
        "productos",
        function (respuesta){
            if(respuesta.error.length > 0) $("#error").html(respuesta.error);
            else Admin.Productos.getProductos();
        },
        "borrarProducto",
        $("#ad_idProductos").val()
    );
};

/**
*   Esta funcion se encarga de comunicarse con el servlet de productos para realizar
*   una busqueda de todos los productos haciendo primero una validacion de errores
*   y luego separando los datos recibidos en un arreglo mediante un get
*/
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

/**
*   Esta funcion se encarga de comunicarse con el servlet mediante la respuesta
*   de la anterior peticion usalmente un getproducto y asi mostrar los datos del
*   producto como siempre con una comprobacion de errores.
*/
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

/**
*   Esta funcion se encarga de comunicarse con el servlet de productos
*   para obtener los planes actuales por medio de la funcion listarplanes
*   ademas utiliza la funcion mostrarplanes como ejecucion despues de obtener
*   la respuesta.
*/
Admin.Planes.getPlanes = function (){
    sendRequest(
        "productos",
        Admin.Planes.mostrarPlanes,
        "listarPlanes",
        ""
    );
};

/**
*   Esta funcion se encarga de comunicarse con el servlet de productos para obtener
*   el plan seleccionado por medio de la id y luego mediante la ejecucion de 
*   mostrarplan sobre la respuesta nos permite visualizar los datos del plan   
*   @param {long} Id Este es el ID del producto seleccionado
*/
Admin.Planes.getPlan = function (id){
    sendRequest(
        "productos",
        Admin.Planes.mostrarPlan,
        "getPlan",
        id
    );
};

/**
*   Esta funcion se encarga de enviar la peticion al servlet de productos para 
*   realizar la actualizacion de un plan los productos que este incluye y luego
*   mostrarlos mediante la funcion mostrarplan usando la respuesta de esta peticion
*/
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
            if(respuesta.error.length == 0){
                Admin.Planes.mostrarPlan(respuesta);
                Admin.Planes.getPlanes();
            } else $("#error").html(respuesta.error);
        },
        "setPlan",
        JSON.stringify(data)
    );
};

/**
*   Esta funcion se encarga de comunicarse con el servlet de productos y utilizar
*   la funcion borrarplan junto con el id del plan de este para eliminar un plan
*   si la respuesta a esta peticion es un error no lo hara saber y si se realizo
*   satisfactoriamente nos listara los planes restantes.
*/
Admin.Planes.borrarPlan = function (){
    sendRequest(
        "productos",
        function (respuesta){
            if(respuesta.error.length > 0) $("#error").html(respuesta.error);
            else Admin.Planes.getPlanes();
        },
        "borrarPlan",
        $("#ad_idPlanes").val()
    );
};

/**
*   Esta funcion se encarga de comunicarse con el servlet mediante la respuesta
*   de la anterior peticion y asi mostrar los datos del todos los planes, con una
*   comprobacion de errores de la anterior peticion.
*/
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

/**
*   Esta funcion se encarga de comunicarse con el servlet mediante la respuesta
*   de la anterior peticion usalmente un getplan y asi mostrar los datos del
*   plan como siempre con una comprobacion de errores de la anterior request.
*/
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

/**
*   Esta funcion se encarga de agregar un nuevo producto al actual plan buscando
*   siempre si ya existe el producto
*   @param {long} id la id del producto a agregar al plan.
*   @param {string} string el nombre del producto nuevo a agregar
*/
Admin.Planes.agregarProducto = function (id, nombre){
    if ( $("#ad_Planes_ListaProductos option[value="+id+"]").length > 0 ) alert("El plan ya tiene este producto");
    else $("#ad_Planes_ListaProductos").append(new Option(nombre, id));
};

/**
*   Esta funcion se encarga de remover un producto del plan actual
*/
Admin.Planes.quitarProducto = function (){
    $("#ad_Planes_ListaProductos").find('option:selected').remove();
};

/**
*   Esta funcion se encarga de inicializar el contenido los planes los productos
*   y los respectivos botones para su funcionalidad
*/
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

    Evento.boton($("#ad_b_BorrarPlanes"), Admin.Planes.borrarPlan);
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