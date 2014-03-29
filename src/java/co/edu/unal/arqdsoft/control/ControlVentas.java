/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unal.arqdsoft.control;

import co.edu.unal.arqdsoft.dao.*;
import co.edu.unal.arqdsoft.entidad.*;

/**
 *
 * @author dfoxpro
 */
public class ControlVentas {

    Empleado empleado;
    Venta venta;
    Plan plan;
    Cliente cliente;
    DaoEmpleado daoEmpleado;
    DaoVenta daoVenta;
    DaoPlan daoPlan;
    DaoCliente daoCliente;

    /**
     *
     * @param empleado identificacion del empleado que realizo la venta
     * @param cliente cliente al que se el hizo la venta
     * @param pĺan plan que el cliente adquiere
     * @return retorna si se hizo la venta
     */
    public boolean ventaExitosa(String empleado, String cliente, Plan pĺan) {
        
        return false;
    }

    public boolean agregarCliente(int id, String nombre, String informacion, Plan planes) {
        Cliente e =new Cliente(id, nombre,informacion, plan, null);
        return false;
    }

}
