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
     * @param plan plan que el cliente adquiere
     * @return retorna si se hizo la venta
     */
    public boolean venta(String empleado, String[] cliente, int plan) {
        this.agregarCliente(Integer.valueOf(cliente[0]), cliente[1],cliente[2],plan);
        
        return false;
    }

    /**
     *
     * @param empleado
     * @param cliente
     * @param plan
     * @return
     */
    public boolean ventaCE(String empleado, int cliente, String[] plan) {
        Plan planE=new Plan(0/*id*/, null, null, 0.0/*valor*/, null);
        DaoVenta.CrearVenta(cliente,empleado,planE);
        return false;
    }

    /**
     *
     * @param id
     * @param nombre
     * @param informacion
     * @param idPlan
     * @return
     */
    public boolean agregarCliente(int id, String nombre, String informacion,int idPlan) {
        DaoCliente.NuevoCliente(id,nombre,informacion,idPlan);
        return false;
    }

}
