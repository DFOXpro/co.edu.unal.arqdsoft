/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unal.arqdsoft.control;

import co.edu.unal.arqdsoft.dao.*;
import co.edu.unal.arqdsoft.entidad.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dfoxpro
 */
public class ControlVentas {

    /**
     *
     * @param empleado identificacion del empleado que realizo la venta
     * @param idCliente idCliente al que se el hizo la venta
     * @param nombre
     * @param informacion
     * @param plan plan que el idCliente adquiere
     * @param dirreccion
     * @return retorna si se hizo la venta
     */
    public static boolean venta(int empleado, String idCliente, String nombre, String informacion, int plan, String dirreccion) {
        if (plan == 0 || plan < -1 || empleado == 0 || empleado < -1 || idCliente.isEmpty() || nombre.isEmpty() || informacion.isEmpty() || dirreccion.isEmpty()) {

            return false;
        }
        ControlVentas.agregarCliente(Integer.valueOf(idCliente), nombre, informacion);

        return DaoVenta.CrearVenta(Integer.valueOf(idCliente), empleado, plan, dirreccion);
    }

    /**
     *
     * @param empleado
     * @param cliente
     * @param plan
     * @param dirreccion
     * @return
     */
    public static boolean ventaCE(int empleado, int cliente, int plan, String dirreccion) {
        if (plan == 0 || plan < -1 || empleado == 0 || empleado < -1 || dirreccion.isEmpty() || cliente == 0 || cliente < -1) {

            return false;
        }
        return DaoVenta.CrearVenta(cliente, empleado, plan, dirreccion);

    }

    /**
     *
     * @param id
     * @param nombre
     * @param informacion
     * @param idPlan
     * @return
     */
    public static boolean agregarCliente(int id, String nombre, String informacion) {
        if (informacion.isEmpty() || nombre.isEmpty() || id == 0 || id < -1) {
            return false;
        }
        return DaoCliente.nuevoCliente(id, nombre, informacion);

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

    public static Venta setVenta(int parseInt, String toString, String toString0, String toString1, int parseInt0, String toString2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
