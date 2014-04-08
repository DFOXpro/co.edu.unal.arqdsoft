/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.unal.arqdsoft.control;

import co.edu.unal.arqdsoft.entidad.Empleado;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author dmlr
 */
public class ControlAutenticacionTest {
    
    public ControlAutenticacionTest() {
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
     * Test of certificarUsuario method, of class ControlAutenticacion.
     */
    @Test
    public void testCertificarUsuario() {
        System.out.println("certificarUsuario");
        String usuario = "";
        String contraseña = "";
        Empleado expResult = null;
        Empleado result = ControlAutenticacion.certificarUsuario(usuario, contraseña);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
