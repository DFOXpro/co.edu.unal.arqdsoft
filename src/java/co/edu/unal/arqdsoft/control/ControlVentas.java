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
     * @param cliente cliente al que se el hizo la venta
     * @param cliente1
     * @param cliente2
     * @param plan plan que el cliente adquiere
     * @param dirreccion
     * @return retorna si se hizo la venta
     */
    public boolean venta(String empleado, String cliente,String cliente1,String cliente2, int plan,String dirreccion) {
        this.agregarCliente(Integer.valueOf(cliente), cliente1,cliente2,plan);
        
        DaoVenta.CrearVenta(Integer.valueOf(cliente), empleado, plan, dirreccion);
        return false;
    }

    /**
     *
     * @param empleado
     * @param cliente
     * @param plan
     * @param dirreccion
     * @return
     */
    public boolean ventaCE(String empleado, int cliente, int plan,String dirreccion) {
        return DaoVenta.CrearVenta(cliente,empleado,plan,dirreccion);
        
    }

    /**
     *
     * @param id
     * @param nombre
     * @param informacion
     * @param idPlan
     * @return
     */
    public static boolean agregarCliente(int id, String nombre, String informacion,int idPlan) {
        return DaoCliente.NuevoCliente(id, nombre, informacion);
        
    }

    /**
     *
     * @return
     */
    public static ArrayList<Cliente> getclientes(){
        DaoCliente dC =new DaoCliente();
        return dC.getClientes();
    }

    /**
     *
     * @param id
     * @return
     */
    public static Cliente getcliente(int id){
        DaoCliente dC=new DaoCliente();
        return dC.getCliente(id);    
    }

}
