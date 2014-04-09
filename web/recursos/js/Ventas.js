Ventas = new Object();
Ventas.Cliente = new Object();

Ventas.Cliente.new = function (){
    $("#ve_idCliente").prop('disabled', false);
    $("#ve_nombreCliente").prop('disabled', false);
    $("#ve_nombreCliente").val("");
    $("#ve_informacionCliente").prop('disabled', false);
    $("#ve_informacionCliente").val("");
    
};
/**
*   Esta funcion es la encargada de enviar peticiones al servlet de ventas y por 
*   medio de la id del cliente y la funcion getcliente obtener un cliente en 
*   especifico
*/
Ventas.Cliente.get = function (){
    if($("#ve_idCliente").val().length>5)
        sendRequest(
            "ventas",
            Ventas.Cliente.mostrarCliente,
            "getCliente",
            $("#ve_idCliente").val()
        );
    else $("#error").html("Escriba bien el numero de cedula");
};

/**
*   Esta funcion es la encargada de a travez de la respuesta de la anterior peticion
*   normalmente un get dar formato al objeto separando su id nombre y demas campos
*   siempre validando la respuesta de la anterior peticion
*/
Ventas.Cliente.mostrarCliente = function (respuesta){
    if(respuesta.error.length == 0){
        $("#error").html("");
        $("#ve_idCliente").prop('disabled', true);
        $("#ve_idCliente").val(respuesta.contenido.dato.id);
        $("#ve_nombreCliente").prop('disabled', true);
        $("#ve_nombreCliente").val(respuesta.contenido.dato.nombre);
        $("#ve_informacionCliente").val(respuesta.contenido.dato.informacion);
    } else $("#error").html(respuesta.error);
};

Ventas.Venta = new Object();

/**
*   Esta funcion es la encargada de enviar peticiones al servlet de ventas para
*   realizar el registro de una venta nueva con los datos suministrados, hace 
*   primero una verificacion de los datos ingresados al validarlos nos va a dar
*   la respuesta de esta peticion y limpiara los datos.
*/
Ventas.Venta.enviar = function (){
    var s = "";
    $("#error").html("");
    //Verifica que los datos estén correctos
    if($("#ve_idCliente").val() == 0) s += "Falta el cliente.<br>";
    else if($("#ve_idCliente").val() == 2){//Se crea el cliente
        if($("#ve_idCliente").val().length < 6) s += "La cedula está mal escrita.<br>";
        else if($("#ve_nombreCliente").val().length < 6) s += "Escriba completo el nombre del cliente.<br>";
        else if($("#ve_informacionCliente").val().length < 6) s += "Escriba un telefono o correo o dirección de contacto del cliente.<br>";
    }
    if($("#ve_direccionInstalacion").val().length < 6) s += "Escriba bien la dirección de instalación.<br>";
    if($("#ve_PlanID").val().length == 0) s += "Escoja un plan para la Venta.<br>";
    
    if(s == ""){//Paso la verificación
        $("#error").html("Comprobando");
        var data={
            cliente:{
                id: $("#ve_idCliente").val(),
                nombre: $("#ve_nombreCliente").val(),
                informacion: $("#ve_informacionCliente").val()
            },
            empleado: usuario.id,
            dirInstal: $("#ve_direccionInstalacion").val(),
            plan:$("#ve_PlanID").val()
        };
        sendRequest(
            "ventas",
            function (respuesta){
                if(respuesta.error.length == 0){
                    $("#error").html(respuesta.contenido.html);
                    Ventas.Venta.reset();
                } else $("#error").html(respuesta.error);
            },
            "setVenta",
            JSON.stringify(data)
        );
    }else $("#error").html(s);
};

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
*   Esta funcion es puramente de navegacion y nos permite cambiar el estado de 
*   el plan escojido a hidden asi como resetear los campos de id y nombre.
*/
Ventas.Venta.resetPlan = function (){
    $("#ve_PlanEscojido").addClass("hidden");
    $("#ve_PlanEscojer").removeClass("hidden");
    $("#ve_PlanID").val("");
    $("#ve_PlanNombre").val("");
};

/**
*   Esta funcion es puramente de navegacion y nos permite resetear los campos de
*   una venta.
*/
Ventas.Venta.reset = function (){
    $("#ve_idCliente").prop('disabled', false);
    $("#ve_idCliente").val("");
    $("#ve_nombreCliente").prop('disabled', true);
    $("#ve_nombreCliente").val("");
    $("#ve_informacionCliente").prop('disabled', true);
    $("#ve_informacionCliente").val("");
    $("#ve_direccionInstalacion").val("");
    Ventas.Venta.resetPlan();
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
    Evento.boton($("#ve_b_crearVenta"),Ventas.Cliente.new);
    Evento.boton($("#ve_b_EscojerPlan"),Ventas.Venta.resetPlan);
    Evento.boton($("#ve_b_confirmarVenta"),Ventas.Venta.enviar);
    Evento.boton($("#ve_b_cancelarVenta"),Ventas.Venta.reset);
    Evento.cerrarSesion($("#l_ve_cerrarSesion"));
    Ventas.Venta.getPlanes();
};
