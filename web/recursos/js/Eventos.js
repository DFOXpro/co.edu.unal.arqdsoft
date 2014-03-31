/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
Evento = new Object();

Evento.innit = function() {
    //console.log("a");
    $("#autenticacion").addEventListener("submit", function(event) {
        //console.log("b");
        event.preventDefault();
        if(Autenticacion.verificar())
        Autenticacion.enviar();
    });
};

console.log("Eventos cargados");