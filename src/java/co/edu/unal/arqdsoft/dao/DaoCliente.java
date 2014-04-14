/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.unal.arqdsoft.dao;

import co.edu.unal.arqdsoft.entidad.Cliente;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author dfoxpro
 */
public class DaoCliente {
    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("co-edu-unal-arqdsoftPU");
    

    /**
     *
     * @param cliente
     * @return 
     * 
     */
    public static boolean nuevoCliente(Cliente cliente) {
        EntityManager em = emf.createEntityManager();
        boolean exito=false;
        em.getTransaction().begin();
        try {
            em.persist(cliente);
            em.getTransaction().commit();
            exito=true;
        } catch (Exception e) {
            em.getTransaction().rollback();
            return false;
        } finally {
            em.close();
            return exito;
        }
    }

    /**
     *
     * @param idCliente
     * @return
     */
    public static Cliente getCliente(long idCliente) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Cliente cliente =null;
        try {
            cliente = em.find(Cliente.class, idCliente);
        }catch (Exception e) {
            cliente= null;
        }finally {
            em.close();
            return cliente;
        }
    }

    /**
     * @deprecated 
     * @return
     */
    public static ArrayList<Cliente> getClientes() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
