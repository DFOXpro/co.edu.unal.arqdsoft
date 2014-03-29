/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
Contenido = new Object();

/**
 * Función de ejecución asincrona tras la respuesta del request ajax
 * @param {type} req
 * @returns {undefined}
 */
Contenido.cambiar = function (req){
    //TODO
    console.log("Contenido.cambiar"+req);
};

//Autenticacion Inicio
Autenticacion = new Object();
Autenticacion.enviar = function (){
    var json = "{usuario:"+$("#usuario").value+",contrasen:"+$("#contrasena").value+"}";
    sendRequest(url_root+"autenticacion",Contenido.cambiar,json);
};
//Autenticacion Fin

console.log("Contenidos cargados");