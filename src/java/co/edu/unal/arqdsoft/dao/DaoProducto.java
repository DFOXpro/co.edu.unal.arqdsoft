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
     * @param viejoProducto
     * @param nuevoObjeto
     * @return 
     */
    public static boolean modificarProducto(Producto viejoProducto, Producto nuevoObjeto) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            Producto object = getProducto(viejoProducto.getId());
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
    public static Producto getProducto(int idProducto) {
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
     * @param p
     * @param object
     * @return
     */
    public static boolean eliminarProducto(Producto p) {       
        boolean exito=false;
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try{
           Producto producto=em.find(Producto.class,p.getId());
           em.remove(producto);
           em.getTransaction().commit();
           exito= true;
        }catch(Exception e){
         em.getTransaction().rollback();
        }
        finally{
         em.close();
         return exito;
        }   
    }

    /**
     *
     * @param producto
     * @return 
     */
    public static boolean crearProducto(Producto producto) {
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            em.persist(producto);
            em.getTransaction().commit();
        } catch (Exception e) {
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
    public static Producto leerProducto(Producto prod) {
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
        EntityManager em = emf.createEntityManager();
        ArrayList<Producto> productos = new ArrayList();
        Query q = em.createQuery("SELECT u FROM Producto u");
        try {
            productos = (ArrayList<Producto>) q.getResultList();
        } catch (Exception e) {
            //e.printStackTrace();
        } finally {
            em.close();
            return productos;
        }
    }
}
