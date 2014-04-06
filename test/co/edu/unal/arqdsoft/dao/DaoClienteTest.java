/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.unal.arqdsoft.dao;

import co.edu.unal.arqdsoft.entidad.Cliente;
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
public class DaoClienteTest {
    
    public DaoClienteTest() {
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
     * Test of NuevoCliente method, of class DaoCliente.
     */
//    @Test
//    public void testNuevoCliente_Cliente() {
//        System.out.println("NuevoCliente");
//        Cliente e = null;
//        DaoCliente.NuevoCliente(e);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of NuevoCliente method, of class DaoCliente.
     */
    @Test
    public void testNuevoCliente_3args() {
        System.out.println("NuevoCliente");
        int id = 80128928;
        String nombre = "José Santiago Polo Acosta";
        String informacion = "carrera 24 #48-50;3184654140";
        boolean expResult = true;//true para la primera ejecucion, si no se cambia el id debe ponerse false
        boolean result = DaoCliente.NuevoCliente(id, nombre, informacion);
        assertEquals(expResult, result);
    }

    /**
     * Test of getCliente method, of class DaoCliente.
     */
    @Test
    public void testGetCliente() {
        System.out.println("getCliente");
        long idCliente = 80128928;
        DaoCliente instance = new DaoCliente();
        long expResult = 80128928;
        long result = instance.getCliente(idCliente).getId();
        assertEquals(expResult, result);
    }

    /**
     * Test of getClientes method, of class DaoCliente.
     */
//    @Test
//    public void testGetClientes() {
//        System.out.println("getClientes");
//        DaoCliente instance = new DaoCliente();
//        ArrayList<Cliente> expResult = null;
//        ArrayList<Cliente> result = instance.getClientes();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    
}
