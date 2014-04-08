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
     * @param nombre
     * @param descripcion
     * @param valor
     * @return informa si se pudo insertar o no el producto
     */
    public static boolean nuevoProducto(String nombre, String descripcion, String valor) {
        if (nombre.isEmpty() || descripcion.isEmpty() || valor.isEmpty()) {
            return false;
        }
        Producto p = new Producto(nombre, descripcion, Double.valueOf(valor));
        return DaoProducto.crearProducto(p);
    }

    /**
     *
     * @param p
     * @param nombre nueva definicion del producto
     * @param informacion
     * @param valor
     * @return
     */
    public static boolean modificarProducto(Producto p, String nombre, String informacion, String valor) {
        if (nombre.isEmpty() || informacion.isEmpty() || valor.isEmpty() || p == null) {
            return false;
        }
        Producto p2 = new Producto(nombre, informacion, Double.valueOf(valor));
        p2.setId(p.getId());
        return DaoProducto.modificarProducto(p, p2);

    }

    /**
     *
     * @param nombre
     * @param descripcion
     * @param valor
     * @param listaProductos lista de ids de los productos
     * @return
     */
    public static boolean nuevoPlan(String nombre, String descripcion, String valor, List<Producto> listaProductos) {
        if (nombre.isEmpty() || descripcion.isEmpty() || valor.isEmpty() || listaProductos.isEmpty()) {
            return false;
        }
        Plan p = new Plan(nombre, descripcion, Double.valueOf(valor), listaProductos);
        return DaoPlan.CrearPlan(p);

    }

    /**
     *
     * @param id
     * @param nombre
     * @param descripcion
     * @param valor
     * @param listaProductos
     * @return
     */
    public static boolean modificarPlan(int id, String nombre, String descripcion, String valor, List<Producto> listaProductos) {
        if (nombre.isEmpty() || descripcion.isEmpty() || valor.isEmpty() || listaProductos.isEmpty() || id == 0 || id < -1) {
            return false;
        }
        Plan p = new Plan(nombre, descripcion, Double.valueOf(valor), listaProductos);
        boolean b = DaoPlan .modificarPlan(DaoPlan.getPlan(id), p);

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
     * @param nombre
     * @param descripcion descripcion del producto
     * @param valor valor del producto
     * @return 
     * @nombre retorna nulo si no se creo el producto o no se modifico
     */
    public static Producto setProducto(int id, String nombre, String descripcion, String valor) {
        if (id == 0 || id < -1 || nombre.isEmpty() || descripcion.isEmpty() || valor.isEmpty()) {
            return null;

        }
        Producto p2 = new Producto(nombre, descripcion, Double.valueOf(valor));
        try {
            if (id == -1) {
                if(nuevoProducto(nombre,descripcion,valor)) return p2;
                else return null;
            } else {
                if(modificarProducto(DaoProducto.getProducto(id),nombre,descripcion,valor)) return p2;
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
        return DaoProducto.eliminarProducto(ControlProductos.getProducto(id));

    }

    /**
     *
     * @param idPlan
     * @return
     */
    public static boolean borrarPlan(int idPlan) {
        if (idPlan == 0 || idPlan < -1) {
            return false;
        }
        DaoPlan p = new DaoPlan();
        return p.eliminarPlan(DaoPlan.getPlan(idPlan));

    }

    /**
     *
     * @param idPlan
     * @param nombre
     * @param valor
     * @param descripcion
     * @param ar
     * @return
     */
    public static Plan setPlan(int idPlan, String nombre, String descripcion, String valor, ArrayList<Producto> ar) {
        if (idPlan < -1 || idPlan == 0 || nombre.isEmpty() || valor.isEmpty() || descripcion.isEmpty()) {
            return null;
        }//String nombre, String descripcion, double valor, List<Producto> productos
        Plan p = new Plan(nombre, descripcion, Double.parseDouble(valor), ar);
        if (idPlan != -1) {
            if(modificarPlan(idPlan, nombre, descripcion, valor, ar)) return p;
            else return null;
        } else {
            if(nuevoPlan(nombre, descripcion, valor, ar)) return p;
            else return null;
        }
    }
}
