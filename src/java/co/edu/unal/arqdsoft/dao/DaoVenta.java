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

/**
 *
 * @author jspoloa
 */
public class DaoVenta {

    /**
     *
     * @param cliente
     * @param empleado
     * @param plan
     * @return 
     */
    public static boolean CrearVenta(long idCliente, int idVendedor, int idPlan, String direccion) {
        Cliente cliente = DaoCliente.getCliente(idCliente);
        Empleado vendedor = DaoEmpleado.getEmpleado(idVendedor);
        Plan plan = DaoPlan.getPlan(idPlan);
        if(cliente==null || vendedor == null || plan==null)
            return false;
        Venta venta = new Venta(new Date(),direccion,cliente,vendedor,plan);
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