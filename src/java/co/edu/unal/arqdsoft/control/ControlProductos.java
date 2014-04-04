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
     * @return informa si se pudo insertar o no el producto
     */
    public static boolean nuevoProducto(String[] producto) {
        Producto p = new Producto(producto[0], producto[1], Double.valueOf(producto[2]));
        DaoProducto.crearProducto(p);        
        return false;
    }

    /**
     *
     * @param idProducto id del producto a modificar
     * @param producto nueva definicion del producto
     * @return
     */
    public static boolean modificarProducto(int idProducto, String[] producto) {
        Producto p = new Producto(producto[0], producto[1], Double.valueOf(producto[2]));
        DaoProducto.modificarProducto(idProducto, p);
        return false;
    }

    /**
     *
     * @param plan String con los datos del plan sin productos
     * @param productos lista de ids de los productos
     * @return
     */
    public static boolean nuevoPlan(String[] plan, List<Producto> productos) {
        Plan p = new Plan(Integer.getInteger(plan[0]), plan[1], plan[2], Double.valueOf(plan[3]), productos);
        DaoPlan.CrearPlan(p);
        return false;
    }

    /**
     *
     * @param id id del producto a modificar
     * @param plan id del plan a modificar
     * @return
     */
    public static boolean modificarPlan(int id, String[] plan) {
        
        return false;
    }

    /**
     *
     * @return retorna lista de productos
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

    /**
     *
     * @param idProducto
     * @return retorna lista de productos
     */
    public static Producto getProducto(int idProducto) {
        //TODO 
        return DaoProducto.getProducto(idProducto);
    }

    /**
     *
     * @param idPlan
     * @return
     */
    public static Plan getPlane(int idPlan) {
        //TODO
        return DaoPlan.getPlane(idPlan);
    }
}
