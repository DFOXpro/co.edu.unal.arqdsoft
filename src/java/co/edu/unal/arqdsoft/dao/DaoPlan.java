/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.unal.arqdsoft.dao;

import static co.edu.unal.arqdsoft.dao.DaoProducto.emf;
import co.edu.unal.arqdsoft.entidad.Plan;

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
 * @author dfoxpro
 */
public class DaoPlan {
    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("co-edu-unal-arqdsoftPU");

    /**
     *
     * @return
     */
    public static ArrayList<Plan> getPlanes() {
        EntityManager em = emf.createEntityManager();
        ArrayList<Plan> planes = new ArrayList();
        Query q = em.createQuery("SELECT u FROM Plan u");
        try {
            planes = (ArrayList<Plan>) q.getResultList();
        } catch (Exception e) {
            //e.printStackTrace();
        } finally {
            em.close();
            return planes;
        }
    }

    /**
     *
     * @param p
     * @return 
     */
    public static boolean CrearPlan(Plan p) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(p);
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
     * @param idPlan
     * @return
     */
    public static Plan getPlan(int idPlan) {
        EntityManager em = emf.createEntityManager();
        Plan plan = null;
        //System.out.println("ANTES DEL QUERY" + idProducto);
        Query q = em.createQuery("SELECT u FROM Producto u "
                + "WHERE u.id = :idPlan").setParameter("idPlan", idPlan);
        //System.out.println("llego");
        try {
            plan = (Plan) q.getSingleResult();
          //  System.out.println("LOGRO SINGLE");
        } catch (NonUniqueResultException e) {
            plan = (Plan) q.getResultList().get(0);
          //  System.out.println("LOGRO CATCH SIMPLE");
        } catch (Exception e) {
            e.printStackTrace();
          //  System.out.println("LOGRO CATCH EXCEPT" + e.toString());
        } finally {
            em.close();
          //  System.out.println(producto.getNombre() + "nombre DEL PRODUCTO");
        }
        return plan;
    }

    /**
     */
    public DaoPlan() {
    }
    
    /**
     *
     * @param plan
     * @return 
     */
    public boolean crear(Plan plan) {
        EntityManager em = emf.createEntityManager();
        boolean exito=false;
        try {
            em.getTransaction().begin();
            em.persist(plan);
            em.getTransaction().commit();
            exito=true;
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            em.getTransaction().rollback();
        } finally {
            em.close();
            return exito;
        }
    }

    /**
     *
     * @param producto
     * @return
     */
    public boolean eliminarPlan(Plan plan) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     *
     * @param id
     * @param p
     * @return
     */
    public boolean modificarPlan(int id, Plan p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
