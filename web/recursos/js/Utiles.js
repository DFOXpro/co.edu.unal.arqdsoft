/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * 
 * @param {type} selector
 * @returns {DOM element}
 */
$ = function(selector) {
    return document.querySelector(selector);
};


//AJAX inicio
/**
 * @param {string} url
 * @param {function(req)} callback Funcion de respuesta, es asincrono
 * @param {string} data Datos a enviar Json 
 * @returns {undefined}
 */
function sendRequest(url, callback, data) {
    var xhr = new XMLHttpRequest();
    xhr.open("POST", url, true);

    xhr.onreadystatechange = function() {//Call a function when the state changes.
        if (xhr.readyState == 4 && xhr.status == 200) {
            callback(JSON.parse(xhr.responseText));
        }
    };
    console.log(data);
    xhr.send(data);
}
//AJAX Fin
console.log("Utiles cargados");
