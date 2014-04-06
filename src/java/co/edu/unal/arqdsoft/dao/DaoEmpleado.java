/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.unal.arqdsoft.dao;

import co.edu.unal.arqdsoft.entidad.Empleado;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author dfoxpro
 */
public class DaoEmpleado {
    
    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("co-edu-unal-arqdsoftPU");

    /**
     *
     * @return
     */
    public static Empleado buscarEmpleado() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     *
     * @return
     */
    public static List<Empleado> buscarEmpleados() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    /**
     * Este metodo solo se crea ara hacer pruebas de guardado en la base de datos
     * ya que la administración de empleados se sale de nuestro alcance.
     * @param empleado 
     * @return  
     */
    public boolean persist(Empleado empleado) {
        EntityManager em = emf.createEntityManager();
        boolean exito=false;
        try {
            em.getTransaction().begin();
            em.persist(empleado);
            em.getTransaction().commit();
            exito=true;
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            em.getTransaction().rollback();
            exito=false;
        } finally {
            em.close();
            return exito;
        }
    }

    /**
     * Metodo encargado de hacer el login de usuario, si ocurre un error o los datos ingresados no
     * corresponden a ningún usuario retorna null.
     * @param usuario
     * @param contrasena
     * @return 
     */
    
    public static Empleado login(String usuario,String contrasena) {
        EntityManager em = emf.createEntityManager();
        Empleado empleado=null;
        Query q;
        q=em.createQuery("SELECT e FROM Empleado e WHERE e.usuario LIKE :usuario AND e.contrasena LIKE :contrasena")
                .setParameter("usuario",usuario)
                .setParameter("contrasena",contrasena);
        
        try{
            em.getTransaction().begin();
            empleado=(Empleado)q.getSingleResult();
        }catch(Exception e){
            //e.printStackTrace();
            empleado=null;
        }
         em.close();
         return empleado;
    }

    public Empleado getEmpleado(int idOperador) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
