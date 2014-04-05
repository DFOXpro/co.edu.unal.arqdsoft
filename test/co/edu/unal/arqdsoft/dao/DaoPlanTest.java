/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.unal.arqdsoft.dao;

import co.edu.unal.arqdsoft.entidad.Plan;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Jhh
 */
public class DaoPlanTest {
    
    public DaoPlanTest() {
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
     * Test of getPlanes method, of class DaoPlan.
     */
    @Test
    public void testGetPlanes() {
        System.out.println("getPlanes");
        ArrayList<Plan> expResult = null;
        ArrayList<Plan> result = DaoPlan.getPlanes();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of CrearPlan method, of class DaoPlan.
     */
    @Test
    public void testCrearPlan() {
        System.out.println("CrearPlan");
        Plan p = null;
        DaoPlan.CrearPlan(p);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPlane method, of class DaoPlan.
     */
    @Test
    public void testGetPlane() {
        System.out.println("getPlane");
        int idPlan = 0;
        Plan expResult = null;
        Plan result = DaoPlan.getPlane(idPlan);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of crear method, of class DaoPlan.
     */
    @Test
    public void testCrear() {
        System.out.println("crear");
        List<Producto> productos;
        Plan object = new Plan("datos para familias", "ninguna Descript", 12000, );
        DaoPlan instance = new DaoPlan();
        instance.crear(object);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
