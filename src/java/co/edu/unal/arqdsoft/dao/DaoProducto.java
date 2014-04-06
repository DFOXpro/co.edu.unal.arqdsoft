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
import javax.persistence.NonUniqueResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Jhh
 */
public class DaoProducto {

    /**
     *
     */
    public DaoProducto() {
    }

    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("co-edu-unal-arqdsoftPU");

    /**
     *
     * @param idObject
     * @param nuevoObjeto
     * @return 
     */
    public boolean modificarProducto(int idObject, Producto nuevoObjeto) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            Producto object = getProducto(idObject);
            object.setNombre(nuevoObjeto.getNombre());
            object.setDescripcion(nuevoObjeto.getDescripcion());
            object.setValor(nuevoObjeto.getValor());
            em.merge(object);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
            return false;
        } finally {
            em.close();
            return true;
        }
    }

    /**
     *
     * @param idProducto
     * @return
     */
    public Producto getProducto(int idProducto) {
        EntityManager em = emf.createEntityManager();
        Producto producto = null;
        //System.out.println("ANTES DEL QUERY" + idProducto);
        Query q = em.createQuery("SELECT u FROM Producto u "
                + "WHERE u.id = :idProducto").setParameter("idProducto", idProducto);
        //System.out.println("llego");
        try {
            producto = (Producto) q.getSingleResult();
          //  System.out.println("LOGRO SINGLE");
        } catch (NonUniqueResultException e) {
            producto = (Producto) q.getResultList().get(0);
          //  System.out.println("LOGRO CATCH SIMPLE");
        } catch (Exception e) {
            e.printStackTrace();
          //  System.out.println("LOGRO CATCH EXCEPT" + e.toString());
        } finally {
            em.close();
          //  System.out.println(producto.getNombre() + "nombre DEL PRODUCTO");
        }
        return producto;
    }

    /**
     *
     * @param object
     * @return
     */
    public boolean eliminarProducto(Producto object) {
               
        EntityManager em = emf.createEntityManager();
        Producto producto = null;
        //System.out.println("ANTES DEL QUERY" + object.getId());
        Query q = em.createQuery("DELETE FROM Producto u "
                + "WHERE u.id = :idProducto").setParameter("idProducto", object.getId());
        //System.out.println("llego");
        
        try {
            System.out.println("llego");
            int result = q.executeUpdate();
            System.out.println("Rows affected: " + result);
            System.out.println("LOGRO SINGLE");
            
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("LOGRO CATCH EXCEPT" + e.toString());
            return false;
        } finally {
            em.close();
            System.out.println(producto.getNombre() + "nombre DEL PRODUCTO");
            return true;
        }
        
        
        
        
    }

    /**
     *
     * @param producto
     */
    public boolean crearProducto(Producto producto) {
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            em.persist(producto);
            em.getTransaction().commit();
        } catch (Exception e) {

            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "NO GUARDO!!!!", e);
            em.getTransaction().rollback();
            return false;
        } finally {
            em.close();
            return true;
        }
    }

    /**
     *
     * @param prod
     * @return
     */
    public Producto leerProducto(Producto prod) {
        EntityManager em = emf.createEntityManager();
        Producto producto = null;
        //System.out.println("ANTES DEL QUERY" + prod.getNombre());
        Query q = em.createQuery("SELECT u FROM Producto u "
                + "WHERE u.nombre LIKE :nombre").setParameter("nombre", prod.getNombre());
        //System.out.println("llego");
        try {
            producto = (Producto) q.getSingleResult();
         //   System.out.println("LOGRO SINGLE");
        } catch (NonUniqueResultException e) {
            producto = (Producto) q.getResultList().get(0);
         //   System.out.println("LOGRO CATCH SIMPLE");
        } catch (Exception e) {
            e.printStackTrace();
         //   System.out.println("LOGRO CATCH EXCEPT" + e.toString());
        } finally {
            em.close();
         //   System.out.println(producto.getNombre() + "nombre DEL PRODUCTO");
            return producto;
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
