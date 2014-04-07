/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.unal.arqdsoft.dao;

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
public class DaoReporteDanoTest {
    
    public DaoReporteDanoTest() {
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
     * Test of crearReporteDano method, of class DaoReporteDano.
     */
    @Test
    public void testCrearReporteDano() {
        System.out.println("crearReporteDano");
        Date fechaCreacion = new Date();
        String descripcion = "Internet no funciona, se reiniciaron los puertos";
        boolean resuelto = true;
        int idOperador = 4;
        long idCliente = 80128928;
        boolean expResult = true;
        boolean result = DaoReporteDano.crearReporteDano(fechaCreacion, descripcion, resuelto, idOperador, idCliente);
        assertEquals(expResult, result);
    }
    
}
