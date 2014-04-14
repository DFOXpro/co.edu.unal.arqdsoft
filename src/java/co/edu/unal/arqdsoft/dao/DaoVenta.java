/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.unal.arqdsoft.dao;

import static co.edu.unal.arqdsoft.dao.DaoEmpleado.emf;
import co.edu.unal.arqdsoft.entidad.Cliente;
import co.edu.unal.arqdsoft.entidad.Empleado;
import co.edu.unal.arqdsoft.entidad.Plan;
import co.edu.unal.arqdsoft.entidad.Venta;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author jspoloa
 */
public class DaoVenta {
    
    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("co-edu-unal-arqdsoftPU");

    /**
     *
     * @param venta
     * @return 
     */
    public static boolean CrearVenta(Venta venta) {
        EntityManager em = emf.createEntityManager();
        boolean exito = false;
        try {
            em.getTransaction().begin();
            em.persist(venta);
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

    
}