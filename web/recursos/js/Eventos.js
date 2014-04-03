/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
Evento = new Object();

Evento.innit = function() {
    //console.log("a");
    $("#autenticacion").submit(function(event) {
        //console.log("b");
        event.preventDefault();
        if(Autenticacion.verificar())
        Autenticacion.enviar();
    });
};

Evento.cerrarSesion = function (elemento){
    elemento.click(function (){location.reload()});
};

Evento.menu = function (origen, objetivo){
    origen.click(function (){Contenido.cambiarArticulo(objetivo)});
}
window.addEventListener("load",Evento.innit);
console.log("Eventos cargados");