/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.unal.arqdsoft.dao;

import co.edu.unal.arqdsoft.entidad.Cliente;
import co.edu.unal.arqdsoft.entidad.Empleado;
import co.edu.unal.arqdsoft.entidad.Plan;
import co.edu.unal.arqdsoft.entidad.Venta;
import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Jose
 */
public class DaoVentaTest {
    
    public DaoVentaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of CrearVenta method, of class DaoVenta.
     */
    @Test
    public void testCrearVenta() {
        System.out.println("CrearVenta");
        long idCliente = 987654321;
        int idVendedor = 3;
        int idPlan = 1;
        String direccion = "carrera 15 #27 18";
        Cliente cliente = DaoCliente.getCliente(idCliente);
        Empleado vendedor = DaoEmpleado.getEmpleado(idVendedor);
        Plan plan = DaoPlan.getPlan(idPlan);
        Venta venta  = new Venta(new Date(),direccion,cliente,vendedor,plan);
        boolean expResult = true;
        boolean result = DaoVenta.CrearVenta(venta);
        assertEquals(expResult, result);
    }
    
}
