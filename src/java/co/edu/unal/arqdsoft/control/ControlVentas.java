/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unal.arqdsoft.control;

import co.edu.unal.arqdsoft.dao.*;
import co.edu.unal.arqdsoft.entidad.*;
import java.util.ArrayList;

/**
 *
 * @author dfoxpro
 */
public class ControlVentas {

    /**
     *
     * @param idEmpleado identificacion del idEmpleado que realizo la venta
     * @param idCliente idCliente al que se el hizo la venta
     * @param nombreCliente
     * @param informacionCliente
     * @param idPlan idPlan que el idCliente adquiere
     * @param direccionVenta
     * @return retorna si se hizo la venta
     */
    public static boolean ventaNuevoCliente(int idEmpleado, int idCliente, String nombreCliente, 
            String informacionCliente, int idPlan, String direccionVenta) {
        boolean exito=false;
        if(DaoCliente.nuevoCliente(idCliente, nombreCliente, informacionCliente)==true)
            exito= DaoVenta.CrearVenta(idCliente, idEmpleado, idPlan, direccionVenta);
        return exito;
    }

    /**
     *
     * @param idEmpleado
     * @param idCliente
     * @param idPlan
     * @param dirreccion
     * @return
     */
    public static boolean ventaClienteExiste(int idEmpleado, int idCliente, int idPlan, String dirreccion) {
        return DaoVenta.CrearVenta(idCliente, idEmpleado, idPlan, dirreccion);
    }

    /**
     * @deprecated 
     * @return
     */
    public static ArrayList<Cliente> getclientes() {
        return DaoCliente.getClientes();
    }

    /**
     *
     * @param id
     * @return
     */
    public static Cliente getcliente(int id) {
        if (id == 0 || id < -1) {
            return null;
        }
        return DaoCliente.getCliente(id);
    }

    /**
     *
     * @param idEmpleado
     * @param idCliente
     * @param nombreCliente
     * @param informacionCliente
     * @param idPlan
     * @param direccionVenta
     * @return
     */
    public static boolean setVenta(int idEmpleado, int idCliente, String nombreCliente, String informacionCliente, 
            int idPlan, String direccionVenta) {
        if (idPlan == 0 || idPlan < -1 || idEmpleado == 0 || idEmpleado < -1 || idCliente == 0 || idCliente < -1 ||
                nombreCliente.isEmpty() || informacionCliente.isEmpty() || direccionVenta.isEmpty()) {
            return false;
        }
        boolean exito;
        if(DaoCliente.getCliente(idCliente) == null)
            exito=ventaNuevoCliente(idEmpleado, idCliente, nombreCliente, informacionCliente, idPlan, direccionVenta);
        else
            exito=ventaClienteExiste(idEmpleado, idCliente, idPlan, direccionVenta);
        return exito;
    }

}
