/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.unal.arqdsoft.dao;

import co.edu.unal.arqdsoft.entidad.Cliente;
import co.edu.unal.arqdsoft.entidad.Empleado;
import co.edu.unal.arqdsoft.entidad.ReporteDano;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author jspoloa
 */
public class DaoReporteDano {

    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("co-edu-unal-arqdsoftPU");
    
    /**
     *
     * @param reporte
     * @return retorna el reporte, null si no se crea
     */
    public static ReporteDano crearReporteDano(ReporteDano reporte) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(reporte);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            return null;
        } finally {
            em.close();
            return reporte;
        }
    }
    
    /**
     *
     * @param viejoReporte
     * @param nuevoReporte
     * @return
     */
    public static boolean modificarReporteDano(ReporteDano viejoReporte, ReporteDano nuevoReporte) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            ReporteDano object = getReporte(viejoReporte.getId());
            object.setDescripcion(nuevoReporte.getDescripcion());
            object.setResuelto(nuevoReporte.getResuelto());
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
     * @param idReporte
     * @return
     */
    public static ReporteDano getReporte(int idReporte) {
        EntityManager em = emf.createEntityManager();
        ReporteDano reporte = null;
        try{
            em.getTransaction().begin();
            reporte=em.find(ReporteDano.class, idReporte);
        }catch(Exception e){
            reporte=null;
        }finally{
            em.close();
            return reporte;
        }
    }
    
}
