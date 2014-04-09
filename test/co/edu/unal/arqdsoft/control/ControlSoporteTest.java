/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.unal.arqdsoft.control;

import co.edu.unal.arqdsoft.entidad.Empleado;
import co.edu.unal.arqdsoft.entidad.ReporteDano;
import co.edu.unal.arqdsoft.entidad.VisitaTecnica;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
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
public class ControlSoporteTest {
    
    public ControlSoporteTest() {
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
     * Test of buscarTecnico method, of class ControlSoporte.
     */
//    @Test
    public void testBuscarTecnico() {
        System.out.println("buscarTecnico");
        int id = 0;
        Empleado expResult = null;
        Empleado result = ControlSoporte.buscarTecnico(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of tiempoTecnicos method, of class ControlSoporte.
     */
//    @Test
    public void testTiempoTecnicos() {
        System.out.println("tiempoTecnicos");
        Map<Integer, ArrayList<Date>> expResult = null;
        Map<Integer, ArrayList<Date>> result = ControlSoporte.tiempoTecnicos();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of visitas method, of class ControlSoporte.
     */
//    @Test
    public void testVisitas_0args() {
        System.out.println("visitas");
        List<VisitaTecnica> expResult = null;
        List<VisitaTecnica> result = ControlSoporte.visitas();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of visitasPorEmpleado method, of class ControlSoporte.
     */
//    @Test
    public void testVisitasPorEmpleado() {
        System.out.println("visitasPorEmpleado");
        int id = 0;
        List<VisitaTecnica> expResult = null;
        List<VisitaTecnica> result = ControlSoporte.visitasPorEmpleado(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of visitas method, of class ControlSoporte.
     */
//    @Test
    public void testVisitas_int() {
        System.out.println("visitas");
        int id = 0;
        List<VisitaTecnica> expResult = null;
        List<VisitaTecnica> result = ControlSoporte.visitas(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of crearVisitaTecnica method, of class ControlSoporte.
     */
    @Test
    public void testCrearVisitaTecnica() {
        System.out.println("crearVisitaTecnica");
        int idCliente = 987654321;
        int idTecnico = 2;
        Date fecha = new Date();
        int idReporte = 1;
        String direccion = "carrera 20 #23-30";
        boolean expResult = true;
        boolean result = ControlSoporte.crearVisitaTecnica(idCliente, idTecnico, fecha, idReporte, direccion);
        assertEquals(expResult, result);
    }

    /**
     * Test of crearReportedano method, of class ControlSoporte.
     */
//    @Test
//    public void testCrearReportedano() {
//        System.out.println("crearReportedano");
//        int idCliente = 987654321;
//        Date fechaCreacionReporte = new Date();
//        String descripcion = "El internet no funciona, se reiniciaron los puertos";
//        int idOperador = 4;
//        boolean fueResuelto = true;
//        boolean expResult = true;
//        boolean result = ControlSoporte.crearReportedano(idCliente, fechaCreacionReporte, descripcion, idOperador, fueResuelto);
//        assertEquals(expResult, result);
//    }

    /**
     * Test of modificarReportedano method, of class ControlSoporte.
     */
//    @Test
    public void testModificarReportedano() {
        System.out.println("modificarReportedano");
        ReporteDano old = null;
        ReporteDano new1 = null;
        boolean expResult = false;
        boolean result = ControlSoporte.modificarReportedano(old, new1);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of modificarVisitaTecnica method, of class ControlSoporte.
     */
//    @Test
    public void testModificarVisitaTecnica() {
        System.out.println("modificarVisitaTecnica");
        VisitaTecnica old = null;
        VisitaTecnica new1 = null;
        boolean expResult = false;
        boolean result = ControlSoporte.modificarVisitaTecnica(old, new1);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getReporte method, of class ControlSoporte.
     */
//    @Test
    public void testGetReporte() {
        System.out.println("getReporte");
        int id = 0;
        ReporteDano expResult = null;
        ReporteDano result = ControlSoporte.getReporte(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
