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
 * @author dmlr7
 */
public class ControlProductos {

    /**
     *
     * @param producto
     * @return
     */
    public static boolean nuevoProducto(String[] producto) {
        
        
        return false;
    }

    /**
     *
     * @param id id del producto a modificar
     * @param producto nueva definicion del producto
     * @return
     */
    public static boolean modificarProducto(int id, String[] producto) {
        
        return false;
    }
    /**
     *
     * @param plan String con los datos del plan sin productos
     * @param productos lista de ids de los productos
     * @return
     */
    public static boolean nuevoPlan(String[] plan, List<Producto> productos) {
        Plan p = new Plan(Integer.getInteger(plan[0]),plan[1], plan[2], Double.valueOf(plan[3]), productos);
        DaoPlan.CrearPlan(p);
        return false;
    }

    /**
     *
     * @param id id del producto a modificar
     * @param producto nueva definicion del producto
     * @return
     */
    public static boolean modificarPlan(int id, String[] plan) {
        
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
