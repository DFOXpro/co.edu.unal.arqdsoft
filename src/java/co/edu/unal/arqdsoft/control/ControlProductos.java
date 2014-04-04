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
 * @author dmlr7
 */
public class ControlProductos {

    /**
     *
     * @param empleado empleado que
     * @param cliente
     * @param pĺan
     * @return
     */
    public static boolean nuevoProducto(String empleado, String cliente, Plan pĺan) {

        return false;
    }

    /**
     *
     * @param empleado
     * @param cliente
     * @param pĺan
     * @return
     */
    public static boolean modificarProducto(String empleado, String cliente, Plan pĺan) {

        return false;
    }

    /**
     *
     * @return
     */
    public static ArrayList<Producto> getProductos() {
        //TODO 
        return DaoProducto.getProductos();
    }

    /**
     *
     * @return
     */
    public static ArrayList<Plan> getPlanes() {
        //TODO
        return DaoPlan.getPlanes();
    }
}
