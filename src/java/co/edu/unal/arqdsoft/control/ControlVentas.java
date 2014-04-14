/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unal.arqdsoft.control;

import co.edu.unal.arqdsoft.dao.*;
import co.edu.unal.arqdsoft.entidad.*;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author dfoxpro
 */
public class ControlVentas {

    /**
     *
     * @param idVendedor identificacion del idVendedor que realizo la venta
     * @param idCliente idCliente al que se el hizo la venta
     * @param nombreCliente
     * @param informacionCliente
     * @param idPlan idPlan que el idCliente adquiere
     * @param direccionVenta
     * @return retorna si se hizo la venta
     */
    public static boolean ventaNuevoCliente(int idVendedor, long idCliente, String nombreCliente, 
            String informacionCliente, int idPlan, String direccionVenta) {
        boolean exito=false;
        Empleado vendedor = DaoEmpleado.getEmpleado(idVendedor);
        Plan plan = DaoPlan.getPlan(idPlan);
        Cliente cliente= new Cliente(idCliente, nombreCliente, informacionCliente, null, null);
        if(DaoCliente.nuevoCliente(cliente)==true)
            exito= DaoVenta.CrearVenta(new Venta(new Date(),direccionVenta,cliente,vendedor,plan));
        return exito;
    }

    /**
     *
     * @param idVendedor
     * @param idCliente
     * @param idPlan
     * @param direccion
     * @return
     */
    public static boolean ventaClienteExiste(int idVendedor, long idCliente, int idPlan, String direccion) {
        Cliente cliente = DaoCliente.getCliente(idCliente);
        Empleado vendedor = DaoEmpleado.getEmpleado(idVendedor);
        Plan plan = DaoPlan.getPlan(idPlan);
        if(cliente==null || vendedor == null || plan==null)
            return false;
        Venta venta = new Venta(new Date(),direccion,cliente,vendedor,plan);
        return DaoVenta.CrearVenta(venta);
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
     * @param idCliente
     * @return
     */
    public static Cliente getcliente(long idCliente) {
        if (idCliente == 0 || idCliente < -1) {
            return null;
        }
        return DaoCliente.getCliente(idCliente);
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
    public static boolean setVenta(int idEmpleado, long idCliente, String nombreCliente, String informacionCliente, 
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
