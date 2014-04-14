/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.unal.arqdsoft.control;

import co.edu.unal.arqdsoft.entidad.Cliente;
import co.edu.unal.arqdsoft.entidad.Venta;
import java.util.ArrayList;
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
public class ControlVentasTest {
    
    public ControlVentasTest() {
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
     * Test of venta method, of class ControlVentas.
     */
    @Test
    public void testVenta() {
        System.out.println("ventaNuevoCliente");
        int empleado = 3;
        long idCliente = 1000232453;
        String nombre = "Nueva dao";
        String informacion = "Emperador de Asia";
        int plan = 2;
        String dirreccion = "China";
        boolean expResult = true;
        boolean result = ControlVentas.ventaNuevoCliente(empleado, idCliente, nombre, informacion, plan, dirreccion);
        assertEquals(expResult, result);
    }

    /**
     * Test of ventaClienteExiste method, of class ControlVentas. Funciona
     */
    //@Test
    public void testVentaCE() {
        System.out.println("ventaCE");
        int empleado = 3;
        int cliente = 123456789;
        int plan = 1;
        String dirreccion = "China";
        boolean expResult = true;
        boolean result = ControlVentas.ventaClienteExiste(empleado, cliente, plan, dirreccion);
        assertEquals(expResult, result);
    }

    /**
     * Test of agregarCliente method, of class ControlVentas.
     */

    /**
     * Test of getclientes method, of class ControlVentas.
     */
    //@Test
    public void testGetclientes() {
        System.out.println("getclientes");
        ArrayList<Cliente> expResult = null;
        ArrayList<Cliente> result = ControlVentas.getclientes();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getcliente method, of class ControlVentas.
     */
    //@Test
    public void testGetcliente() {
        System.out.println("getcliente");
        int id = 0;
        Cliente expResult = null;
        Cliente result = ControlVentas.getcliente(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setVenta method, of class ControlVentas.
     */
    //@Test
    public void testSetVenta() {
        System.out.println("setVenta"); 
        boolean expResult = true;
        boolean result = ControlVentas.setVenta(3, 45678903, "Camilo Andres", "carrera 15 #20-30;3154654140", 2, "Carrera 30 # 20-17");
        assertEquals(expResult, result);
    }
    
}
