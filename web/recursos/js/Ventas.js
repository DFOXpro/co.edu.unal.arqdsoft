Ventas = new Object();
Ventas.Cliente = new Object();
Ventas.Cliente.get = function (id){
    sendRequest(
        "ventas",
        Ventas.Cliente.mostrarCliente,
        "getCliente",
        id
    );
};

Ventas.Cliente.mostrarCliente = function (respuesta){
    
}

Ventas.Venta = new Object();

Venta.innit = function (){
};