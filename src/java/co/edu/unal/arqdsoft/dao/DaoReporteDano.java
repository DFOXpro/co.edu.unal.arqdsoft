/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.unal.arqdsoft.dao;

import co.edu.unal.arqdsoft.entidad.Cliente;
import co.edu.unal.arqdsoft.entidad.Empleado;
import co.edu.unal.arqdsoft.entidad.Plan;
import co.edu.unal.arqdsoft.entidad.Producto;
import co.edu.unal.arqdsoft.entidad.ReporteDano;
import co.edu.unal.arqdsoft.entidad.Venta;
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
     * @param fechaCreacion
     * @param descripcion
     * @param resuelto
     * @param idOperador
     * @param idCliente
     * @return
     */
    public static boolean crearReporteDano(Date fechaCreacion, String descripcion, boolean resuelto, int idOperador, long idCliente) {
        Cliente cliente = DaoCliente.getCliente(idCliente);
        Empleado operador = DaoEmpleado.getEmpleado(idOperador);
        if(cliente==null || operador == null)
            return false;
        ReporteDano reporte = new ReporteDano(fechaCreacion,descripcion,resuelto,cliente,operador,null);
        EntityManager em = emf.createEntityManager();
        boolean exito = false;
        try {
            em.getTransaction().begin();
            em.persist(reporte);
            em.getTransaction().commit();
            exito = true;
        } catch (Exception e) {
            em.getTransaction().rollback();
            exito = false;
        } finally {
            em.close();
            return exito;
        }
    }
    
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
