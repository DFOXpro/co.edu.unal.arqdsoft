/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.unal.arqdsoft.dao;

import co.edu.unal.arqdsoft.entidad.VisitaTecnica;
import java.util.ArrayList;
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
public class DaoVisitaTecnicaTest {
    
    public DaoVisitaTecnicaTest() {
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
     * Test of getVisitasTecnicasReporte method, of class DaoVisitaTecnica.
     */
    @Test
    public void testGetVisitasTecnicasReporte() {
        System.out.println("getVisitasTecnicasReporte");
        int idReporte = 0;
        ArrayList<VisitaTecnica> expResult = null;
        ArrayList<VisitaTecnica> result = DaoVisitaTecnica.getVisitasTecnicasReporte(idReporte);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of modificarVisitaTecnica method, of class DaoVisitaTecnica.
     */
    @Test
    public void testModificarVisitaTecnica() {
        System.out.println("modificarVisitaTecnica");
        VisitaTecnica oldVisita = null;
        VisitaTecnica newVisita = null;
        boolean expResult = false;
        boolean result = DaoVisitaTecnica.modificarVisitaTecnica(oldVisita, newVisita);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of obtenerVisitasSinTecnico method, of class DaoVisitaTecnica.
     */
    @Test
    public void testObtenerVisitasSinTecnico() {
        System.out.println("obtenerVisitasSinTecnico");
        ArrayList<VisitaTecnica> expResult = null;
        ArrayList<VisitaTecnica> result = DaoVisitaTecnica.obtenerVisitasSinTecnico();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of obtenerVisitasPorTecnico method, of class DaoVisitaTecnica.
     */
    @Test
    public void testObtenerVisitasPorTecnico() {
        System.out.println("obtenerVisitasPorTecnico");
        int idTecnico = 0;
        ArrayList<VisitaTecnica> expResult = null;
        ArrayList<VisitaTecnica> result = DaoVisitaTecnica.obtenerVisitasPorTecnico(idTecnico);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of crearVisita method, of class DaoVisitaTecnica.
     */
    @Test
    public void testCrearVisita() {
        System.out.println("crearVisita");
        VisitaTecnica vT = null;
        DaoVisitaTecnica instance = new DaoVisitaTecnica();
        boolean expResult = false;
        boolean result = instance.crearVisita(vT);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
