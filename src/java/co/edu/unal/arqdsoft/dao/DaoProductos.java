/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.unal.arqdsoft.dao;

import co.edu.unal.arqdsoft.entidad.Productos;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
/**
 *
 * @author Jhh
 */
public class DaoProductos {

    public DaoProductos() {
    }
    
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("co-edu-unal-arqdsoftPU");

    public void crear(Productos productos) {
        System.out.print("LOOOOOOOOOOOOOOOOL");
        EntityManager em = emf.createEntityManager();
        
        try { 
            em.getTransaction().begin();
            em.persist(productos);
            em.getTransaction().commit();
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "NO GUARDO!!!!", e);
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
    
}

