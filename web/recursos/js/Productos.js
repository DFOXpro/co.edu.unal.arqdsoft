/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
Productos = new Object();
Productos.getProductos = function (){
    sendRequest(
        "productos",
        Productos.mostrarProductos,
        "listarProductos",
        ""
    );
};
Productos.mostrarProductos = function (respuesta){
    if(respuesta.error.length == 0){
        $("ad_listaProductos").html(respuesta.contenido.section);
    }else $("#error").html(respuesta.error);
};
Productos.getPlanes = function (){
    //TODO
};
Productos.innit = function (){
    Evento.menu($("#l_ad_productos"), $("#ad_productos"));
    Evento.menu($("#l_ad_planes"), $("#ad_planes"));
    Evento.cerrarSesion($("#l_ad_cerrarSesion"));
    Productos.getProductos();
};

Productos.innit();
console.log("AdminProductos cargados");