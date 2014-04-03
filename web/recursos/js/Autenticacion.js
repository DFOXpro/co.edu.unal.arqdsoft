/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
Autenticacion = new Object();
Autenticacion.verificar = function (){
    var r = {error:""};
    if($("#a_usuario").value == "") r.error = "Escriba un usuario";
    else if($("#a_contrasena").value == "" ) r.error = "Escriba una contraseña";
    else if($("#a_usuario").value.length < 4 ) r.error = "Escriba bien el usuario";
    else if($("#a_contrasena").value.length < 4 ) r.error = "Escriba bien la contraseña";
    if (r.error == "") return true;
    else {
        Contenido.cambiar(r);
        return false;
    };
};
Autenticacion.recibir = function (respuesta){
    if(respuesta.error.length == 0){
        usuario.id = respuesta.contenido.usuario.id;
        usuario.rol = respuesta.contenido.usuario.rol;
        usuario.nombre = respuesta.contenido.usuario.nombre;
        $("#h_usuario").innerHTML=usuario.nombre;
        $("#h_rol").innerHTML=usuario.rol;
        $("#h_b_sesion").class="";
        $("#h_b_sesion").innerHTML="Cerrar sesión";
        Evento.cerrarSesion();
        $("section").innerHTML=respuesta.contenido.section;
    }
    Contenido.cambiar(respuesta);
};
Autenticacion.enviar = function (){
    /*Modo JSON*/
//    var data = {
//        usuario:$("#a_usuario").value,
//        contrasena:$("#a_contrasena").value
//    };
//    sendRequest(url_root+"autenticacion",Contenido.cambiar,JSON.stringify(data));

    /* Modo request*/
    $("#error").innerHTML = "Comprobando";
    data = "usuario="+$("#a_usuario").value+"&contrasena="+$("#a_contrasena").value;
    sendRequest(url_root+"autenticacion",Autenticacion.recibir,data);
    
};