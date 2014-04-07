/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.unal.arqdsoft.dao;

import co.edu.unal.arqdsoft.entidad.*;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author dmlr
 */
public class DaoVisitaTecnica {

    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("co-edu-unal-arqdsoftPU");
    
    public static ArrayList<VisitaTecnica> getVisitaTecnica(ReporteDano reporteDano) {
        EntityManager em = emf.createEntityManager();
        ArrayList<VisitaTecnica> visitasTecnicas = new ArrayList();
        Query q = em.createQuery("SELECT u FROM VisitasTecnicas u "+
                "WHERE u.reporte_id = :idReporte").setParameter("idReporte", reporteDano.getId());
        try {
            visitasTecnicas = (ArrayList<VisitaTecnica>) q.getResultList();
        } catch (Exception e) {
            //e.printStackTrace();
        } finally {
            em.close();
            return visitasTecnicas;
        }
    }
    
    /**
     *
     * @param vT
     * @return
     */
    public boolean crearVisita(VisitaTecnica vT) {
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            em.persist(vT);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            return false;
        } finally {
            em.close();
            return true;
        }
    }
    
}
