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

    public boolean nuevoProducto(String empleado, String cliente, Plan pĺan) {

        return false;
    }

    public boolean modificarProducto(String empleado, String cliente, Plan pĺan) {

        return false;
    }

    public static ArrayList<Producto> getProductos() {
        //TODO
        ArrayList<Producto> P = DaoProducto.getProductos();
        return P;
    }
    public static ArrayList<Plan> getPlanes() {
        //TODO
        ArrayList<Plan> P = DaoPlan.getPlanes();
        return P;
    }
}
