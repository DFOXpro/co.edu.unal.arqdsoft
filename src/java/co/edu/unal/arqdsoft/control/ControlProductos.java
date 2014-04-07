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
     * @param producto1
     * @param producto2
     * @return informa si se pudo insertar o no el producto
     */
    public static boolean nuevoProducto(String producto, String producto1, String producto2) {
        if (producto.isEmpty() || producto1.isEmpty() || producto2.isEmpty()) {
            return false;
        }
        Producto p = new Producto(producto, producto1, Double.valueOf(producto2));
        DaoProducto dP = new DaoProducto();
        return dP.crearProducto(p);
    }

    /**
     *
     * @param idProducto id del producto a modificar
     * @param producto nueva definicion del producto
     * @param producto1
     * @param producto2
     * @return
     */
    public static boolean modificarProducto(Producto p, String producto, String producto1, String producto2) {
        if (producto.isEmpty() || producto1.isEmpty() || producto2.isEmpty() || p == null) {
            return false;
        }
        Producto p2 = new Producto(producto, producto1, Double.valueOf(producto2));
        p2.setId(p.getId());
        DaoProducto dP=new DaoProducto();
        return dP.modificarProducto(p, p2);

    }

    /**
     *
     * @param plan1
     * @param plan2
     * @param plan3
     * @param productos lista de ids de los productos
     * @return
     */
    public static boolean nuevoPlan(String plan1, String plan2, String plan3, List<Producto> productos) {
        if (plan1.isEmpty() || plan2.isEmpty() || plan3.isEmpty() || productos.isEmpty()) {
            return false;
        }
        Plan p = new Plan(plan1, plan2, Double.valueOf(plan3), productos);
        return DaoPlan.CrearPlan(p);

    }

    /**
     *
     * @param id
     * @param plan1
     * @param plan2
     * @param plan3
     * @param productos
     * @return
     */
    public static boolean modificarPlan(int id, String plan1, String plan2, String plan3, List<Producto> productos) {
        if (plan1.isEmpty() || plan2.isEmpty() || plan3.isEmpty() || productos.isEmpty() || id == 0 || id < -1) {
            return false;
        }
        Plan p = new Plan(plan1, plan2, Double.valueOf(plan3), productos);
        DaoPlan dP = new DaoPlan();
        boolean b = dP.modificarPlan(dP.getPlan(id), p);

        return b;
    }

    /**
     *
     * @return retorna lista de productos
     */
    public static ArrayList<Producto> getProductos() {
        return DaoProducto.getProductos();
    }

    /**
     *
     * @return lista de planes
     */
    public static ArrayList<Plan> getPlanes() {
        return DaoPlan.getPlanes();
    }

    /**
     *
     * @param idProducto
     * @return retorna lista de productos
     */
    public static Producto getProducto(int idProducto) {
        if (idProducto == 0 || idProducto < -1) {
            return null;

        }
        DaoProducto dP = new DaoProducto();
        return dP.getProducto(idProducto);
    }

    /**
     *
     * @param idPlan
     * @return
     */
    public static Plan getPlane(int idPlan) {
        if (idPlan == 0 || idPlan < -1) {
            return null;

        }
        return DaoPlan.getPlan(idPlan);
    }

    /**
     *
     * @param id id del producto a modificar / nulo si se esta creando
     * @param get nombre del producto
     * @param get0 descripcion del producto
     * @param get1 valor del producto
     * @return retorna nulo si no se creo el producto o no se modifico
     */
    public static Producto setProducto(int id, String get, String get0, String get1) {
        if (id == 0 || id < -1 || get.isEmpty() || get0.isEmpty() || get1.isEmpty()) {
            return null;

        }
        DaoProducto dP =new DaoProducto();
        Producto p2 = new Producto(get, get0, Double.valueOf(get1));
        try {
            String[] p = {get, get0, get1};
            if (id == -1) {
                if(ControlProductos.nuevoProducto(p[0],p[1],p[2])) return p2;
                else return null;
            } else {
                if(ControlProductos.modificarProducto(dP.getProducto(id), p[0],p[1],p[2])) return p2;
                else return null;
            }
        } catch (Exception e) {
            return null;
        }
    }

    /**
     *
     * @param id
     * @return
     */
    public static boolean borrarProducto(int id) {
        if (id == 0 || id < -1) {
            return false;
        }
        DaoProducto p = new DaoProducto();
        return p.eliminarProducto(ControlProductos.getProducto(id));

    }

    /**
     *
     * @param id
     * @return
     */
    public static boolean borrarPlan(int id) {
        if (id == 0 || id < -1) {
            return false;
        }
        DaoPlan p = new DaoPlan();
        return p.eliminarPlan(DaoPlan.getPlan(id));

    }

    /**
     *
     * @param parseInt
     * @param toString
     * @param toString0
     * @param toString1
     * @param ar
     * @return
     */
    public static Plan setPlan(int parseInt, String toString, String toString0, String toString1, ArrayList<Producto> ar) {
        if (parseInt < -1 || parseInt == 0 || toString.isEmpty() || toString0.isEmpty() || toString1.isEmpty()) {
            return null;
        }
        Plan p = new Plan(toString, toString1, parseInt, ar);
        if (parseInt != -1) {
            modificarPlan(parseInt, toString1, toString, toString, ar);
        } else {
            nuevoPlan(toString1, toString, toString, ar);
        }
        return p;
    }
}
