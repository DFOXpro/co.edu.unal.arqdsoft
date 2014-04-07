/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.unal.arqdsoft.dao;

import co.edu.unal.arqdsoft.entidad.Empleado;
import co.edu.unal.arqdsoft.entidad.ReporteDano;
import co.edu.unal.arqdsoft.entidad.VisitaTecnica;
import java.util.ArrayList;
import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Jhh
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
     * Test of getVisitaTecnica method, of class DaoVisitaTecnica.
     */
    @Test
    public void testGetVisitaTecnica() {
        System.out.println("getVisitaTecnica");
        ReporteDano reporteDano = null;
        ArrayList<VisitaTecnica> expResult = null;
        ArrayList<VisitaTecnica> result = DaoVisitaTecnica.getVisitaTecnica(reporteDano);
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
        DaoEmpleado daoEmpleado = new DaoEmpleado();
        Empleado tecnico = daoEmpleado.getEmpleado(2);
        DaoReporteDano daoReporteDano = new DaoReporteDano();
        ReporteDano reporteDano = daoReporteDano
                
        VisitaTecnica visitaTecnica = new VisitaTecnica(tecnico, new Date(2012,02,20), null, null);
        
        DaoProducto daoProducto = new DaoProducto();

        assertTrue(daoProducto.crearProducto(productos));
    }
        
        
        
        
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
