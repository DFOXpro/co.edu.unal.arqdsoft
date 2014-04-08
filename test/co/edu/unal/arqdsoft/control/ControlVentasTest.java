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
//    @Test
//    public void testVenta() {
//        System.out.println("venta");
//        int empleado = 3;
//        String idCliente = "123456789";
//        String nombre = "Gengiskan";
//        String informacion = "Emperador de Asia";
//        int plan = 2;
//        String dirreccion = "China";
//        boolean expResult = true;
//        boolean result = ControlVentas.venta(empleado, idCliente, nombre, informacion, plan, dirreccion);
//        assertEquals(expResult, result);
//    }
//
//    /**
//     * Test of ventaCE method, of class ControlVentas. Funciona
//     */
    @Test
    public void testVentaCE() {
        System.out.println("ventaCE");
        int empleado = 3;
        int cliente = 123456789;
        int plan = 1;
        String dirreccion = "China";
        boolean expResult = true;
        boolean result = ControlVentas.ventaCE(empleado, cliente, plan, dirreccion);
        assertEquals(expResult, result);
    }

    /**
     * Test of agregarCliente method, of class ControlVentas.
     */
//    @Test
//    public void testAgregarCliente() {
//        System.out.println("agregarCliente");
//        int id = 0;
//        String nombre = "";
//        String informacion = "";
//        boolean expResult = false;
//        boolean result = ControlVentas.agregarCliente(id, nombre, informacion);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getclientes method, of class ControlVentas.
//     */
//    @Test
//    public void testGetclientes() {
//        System.out.println("getclientes");
//        ArrayList<Cliente> expResult = null;
//        ArrayList<Cliente> result = ControlVentas.getclientes();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getcliente method, of class ControlVentas.
//     */
//    @Test
//    public void testGetcliente() {
//        System.out.println("getcliente");
//        int id = 0;
//        Cliente expResult = null;
//        Cliente result = ControlVentas.getcliente(id);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of setVenta method, of class ControlVentas.
//     */
//    @Test
//    public void testSetVenta() {
//        System.out.println("setVenta");
//        int parseInt = 0;
//        String toString = "";
//        String toString0 = "";
//        String toString1 = "";
//        int parseInt0 = 0;
//        String toString2 = "";
//        Venta expResult = null;
//        Venta result = ControlVentas.setVenta(parseInt, toString, toString0, toString1, parseInt0, toString2);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    
}
