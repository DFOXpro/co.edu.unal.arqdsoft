/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
Autenticacion = new Object();

/**
*   La siguiente funcion se encarga de una verificacion a priori de la contraseña y el usuario para
*   permitir descartar errores comunes como espacios en blanco u tamaños de campos antes de ralizar
*   la validacion
*  
*   @return true en caso de encontrar un error y false en caso de no hacerlo
*/
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

/**
*   Funcion que se encarga de redireccionar a la seccion  adecuada dependiendo
*   del rol de el usuario no sin antes haber validado si hay algun tipo de error
*   @param Respuesta del ajax
*/
Autenticacion.recibir = function (respuesta){
    if(respuesta.error.length == 0){
        usuario.id = respuesta.contenido.dato.id;
        usuario.rol = respuesta.contenido.dato.rol;
        usuario.nombre = respuesta.contenido.dato.nombre;
//        $("#h_usuario").html(usuario.nombre);
//        $("#h_rol").html(usuario.rol);
        $("#h_b_sesion").class="";
    }
    Contenido.cambiarSeccion(respuesta);
};

/**
*   Funcion que se encarga del envio de la peticion hacia el servlet de autenticacion
*   con los datos de usuario y contraseña administrados por el usuario
*/
Autenticacion.enviar = function (){
    sendRequest(
        "autenticacion",
        Autenticacion.recibir,
        $("#a_usuario").val(),
        $("#a_contrasena").val()
    );
};