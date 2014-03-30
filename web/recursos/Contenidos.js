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
    //if(req)
    var respuesta = JSON.parse(req);
    if(respuesta.error.lenght > 0) $("#error").innerHTML=respuesta.error;
    else $("article").innerHTML=respuesta.contenido;
    console.log("Contenido.cambiar"+req);
};

//Autenticacion Inicio
Autenticacion = new Object();
Autenticacion.enviar = function (){
    var data = {
        usuario:$("#usuario").value,
        contrasena:$("#contrasena").value
    };
    //var data = "usuario="+$("#usuario").value+"&contrasena="+$("#contrasena").value;
//    var data = new FormData();
//    data.append("usuario", $("#usuario").value);
//    data.append("contrasena", $("#contrasena").value);

    sendRequest(url_root+"autenticacion",Contenido.cambiar,JSON.stringify(data));
};
//Autenticacion Fin

console.log("Contenidos cargados");