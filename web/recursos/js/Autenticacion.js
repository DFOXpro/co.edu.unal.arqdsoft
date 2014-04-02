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
Autenticacion.enviar = function (){
    /*Modo JSON*/
//    var data = {
//        usuario:$("#a_usuario").value,
//        contrasena:$("#a_contrasena").value
//    };
//    sendRequest(url_root+"autenticacion",Contenido.cambiar,JSON.stringify(data));

    /* Modo request*/
    data = "usuario="+$("#a_usuario").value+"&contrasena="+$("#a_contrasena").value;
    sendRequest(url_root+"autenticacion",Contenido.cambiar,data);
    
};