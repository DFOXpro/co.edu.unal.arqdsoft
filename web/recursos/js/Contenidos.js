/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
Contenido = new Object();
var usuario = {
    nombre:"",
    id:"",
    rol:""
};
/**
 * Función de ejecución asincrona tras la respuesta del request ajax
 * @param {type} req
 * @returns {undefined}
 */
Contenido.cambiar = function (respuesta){
    if(respuesta.error.length > 0) $("#error").innerHTML=respuesta.error;
    else {
        if(usuario.id == "") {
            usuario.id = respuesta.contenido.usuario.id;
            usuario.rol = respuesta.contenido.usuario.rol;
            usuario.nombre = respuesta.contenido.usuario.nombre;
            $("#h_usuario").innerHTML=usuario.nombre;
            $("#h_rol").innerHTML=usuario.rol;
        }
        $("section").innerHTML=respuesta.contenido.section;
    }
    //console.log("Contenido.cambiar: "+respuesta);
};

console.log("Contenidos cargados");