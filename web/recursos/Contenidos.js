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
    //var json = "{usuario:"+$("#usuario").value+",contrasena:"+$("#contrasena").value+"}";
    //var data = "usuario="+$("#usuario").value+"&contrasena="+$("#contrasena").value;
    var data = new FormData();
    data.append("usuario", $("#usuario").value);
    data.append("contrasena", $("#contrasena").value);

    sendRequest(url_root+"autenticacion",Contenido.cambiar,data);
};
//Autenticacion Fin

console.log("Contenidos cargados");