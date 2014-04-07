/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unal.arqdsoft.dao;

import co.edu.unal.arqdsoft.entidad.ReporteDano;
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
//    @Test
//    public void testCrearReporteDano() {
//        System.out.println("crearReporteDano");
//        Date fechaCreacion = new Date();
//        String descripcion = "Internet no funciona, se reiniciaron los puertos";
//        boolean resuelto = true;
//        int idOperador = 4;
//        long idCliente = 80128928;
//        boolean expResult = true;
//        boolean result = DaoReporteDano.crearReporteDano(fechaCreacion, descripcion, resuelto, idOperador, idCliente);
//        assertEquals(expResult, result);
//    }
//    @Test
//    public void testGetReporteDano() {
//        System.out.println("getReporte");
//        long expResult = 80128928;
//        long result = DaoReporteDano.getReporte(1).getCliente().getId();
//        assertEquals(expResult, result);
//    }

   @Test
    public void testModificarReporteDano() {
        System.out.println("modificarReporteDano");
        ReporteDano reporteAModificar = DaoReporteDano.getReporte(1);
        ReporteDano p = new ReporteDano();
        p.setCliente(reporteAModificar.getCliente());
        p.setOperador(reporteAModificar.getOperador());
        p.setResuelto(true);
        p.setDescripcion("Internet lento se ordeno cabio de modem");
        assertTrue(DaoReporteDano.modificarReporteDano(reporteAModificar,p));
        
    }

}
