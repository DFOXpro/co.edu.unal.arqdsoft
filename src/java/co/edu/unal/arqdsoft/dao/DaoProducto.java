/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unal.arqdsoft.dao;

import co.edu.unal.arqdsoft.entidad.Producto;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Jhh
 */
public class DaoProducto {

    /**
     *
     * @param idProducto
     * @param p
     */
    public static void modificarProducto(int idProducto, Producto p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     *
     * @param idProducto
     * @return
     */
    public static Producto getProducto(int idProducto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     *
     * @param p
     */
    public static void crearProducto(Producto p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     *
     */
    public DaoProducto() {
    }

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("co-edu-unal-arqdsoftPU");

    /**
     *
     * @param producto
     */
    public void crear(Producto producto) {
        
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            em.persist(producto);
            em.getTransaction().commit();
        } catch (Exception e) {
            
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "NO GUARDO!!!!", e);
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    /**
     *
     * @return
     */
    public static ArrayList<Producto> getProductos() {
        
        return null;

    }
}
