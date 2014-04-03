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
Contenido.cambiarSeccion = function (respuesta){
    if(respuesta.error.length > 0) $("#error").html(respuesta.error);
    else $("section").html(respuesta.contenido.html);
    //console.log("Contenido.cambiar: "+respuesta);
};

Contenido.cambiarArticulo = function (articulo){
    $("article").addClass("hidden");
    articulo.removeClass("hidden");
};

console.log("Contenidos cargados");