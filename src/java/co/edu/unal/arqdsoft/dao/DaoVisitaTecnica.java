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
    
      public static ArrayList<VisitaTecnica> getVisitasTecnicasReporte(int idReporte) {
        EntityManager em = emf.createEntityManager();
        ReporteDano reporte=em.find(ReporteDano.class, idReporte);
        ArrayList<VisitaTecnica> visitasTecnicas = new ArrayList();
        Query q = em.createQuery("SELECT u FROM VisitaTecnica u "+
                "WHERE u.reporte.id = :idReporte").setParameter("idReporte", reporte.getId());
        try {
            visitasTecnicas = (ArrayList<VisitaTecnica>) q.getResultList();
        } catch (Exception e) {
            //e.printStackTrace();
        } finally {
            em.close();
            return visitasTecnicas;
        }
    }

    public static boolean modificarVisitaTecnica(VisitaTecnica oldVisita, VisitaTecnica newVisita) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            VisitaTecnica visita = em.find(VisitaTecnica.class, oldVisita.getId());
            visita.setFechaVisita(oldVisita.getFechaVisita());
            visita.setDireccion(oldVisita.getDireccion());
            visita.setReporte(oldVisita.getReporte());
            visita.setTecnico(oldVisita.getTecnico());
            em.merge(visita);
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

    public static ArrayList<VisitaTecnica> obtenerVisitasSinTecnico(){
        return null;
    }
    
     public static ArrayList<VisitaTecnica> obtenerVisitasPorTecnico(int idTecnico){
        EntityManager em = emf.createEntityManager();
        ArrayList<VisitaTecnica> visitasTecnicas =null;
        Query q = em.createQuery("SELECT v FROM VisitaTecnica v "
                + "WHERE Tecnico_id = :idTecnico").setParameter("idTecnico", idTecnico);
        try {
            visitasTecnicas = (ArrayList<VisitaTecnica>) q.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
        return visitasTecnicas;
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
