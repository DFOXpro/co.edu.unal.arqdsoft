/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//AJAX inicio
/**
 * Funcion principal esta se encarga de enviar peticiones para realizar conexiones
 * al servidor mediante los servlets usando los parametros descritos acontinuacion.
 * @param {string} url por medio de esta cambiaremos el servlet al cual accederemos
 * @param {function(req)} callback Funcion de respuesta esta se ejecuta luego de recibir la respuesta, es asincrono
 * @param {string} data Datos que se van a enviar Json 
 */
function sendRequest(url, callback, accion, datos) {
    $("#error").html("Confirmando...");
    var xhr = new XMLHttpRequest();
    xhr.open("POST", url_root+url, true);
    xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    xhr.onreadystatechange = function() {//Call a function when the state changes.
        if (xhr.readyState == 4 && xhr.status == 200) {
            callback(JSON.parse(xhr.responseText));
        }
    };
    var data = "accion="+accion+"&datos="+datos;
    console.log(data);
    //xhr.send("Content-Type: application/x-www-form-urlencoded\n\n"+"Content-Length: "+data.length+"\n"+data);
    xhr.send(data);
}
//AJAX Fin
console.log("Utiles cargados");
