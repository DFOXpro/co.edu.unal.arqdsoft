/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
Autenticacion = new Object();
Autenticacion.verificar = function (){
    var r = {error:""};
    if($("#a_usuario").val() == "") r.error = "Escriba un usuario";
    else if($("#a_contrasena").val() == "" ) r.error = "Escriba una contraseña";
    else if($("#a_usuario").val().length < 4 ) r.error = "Escriba bien el usuario";
    else if($("#a_contrasena").val().length < 4 ) r.error = "Escriba bien la contraseña";
    if (r.error == "") return true;
    else {
        Contenido.cambiarSeccion(r);
        return false;
    };
};
Autenticacion.recibir = function (respuesta){
    if(respuesta.error.length == 0){
        usuario.id = respuesta.contenido.usuario.id;
        usuario.rol = respuesta.contenido.usuario.rol;
        usuario.nombre = respuesta.contenido.usuario.nombre;
//        $("#h_usuario").html(usuario.nombre);
//        $("#h_rol").html(usuario.rol);
        $("#h_b_sesion").class="";
    }
    Contenido.cambiarSeccion(respuesta);
};
Autenticacion.enviar = function (){
    /*Modo JSON*/
//    var data = {
//        usuario:$("#a_usuario").value,
//        contrasena:$("#a_contrasena").value
//    };
//    sendRequest(url_root+"autenticacion",Contenido.cambiar,JSON.stringify(data));

    /* Modo request*/
    $("#error").html("Comprobando");
    sendRequest(
        "autenticacion",
        Autenticacion.recibir,
        $("#a_usuario").val(),
        $("#a_contrasena").val()
    );
};