/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.unal.arqdsoft.dao;

import co.edu.unal.arqdsoft.entidad.Plan;
import co.edu.unal.arqdsoft.entidad.Producto;
import java.util.ArrayList;
import java.util.List;
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
//    @Test
//    public void testGetPlanes() {
//        System.out.println("getPlanes");
//        ArrayList<Plan> expResult = null;
//        ArrayList<Plan> result = DaoPlan.getPlanes();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }


    @Test
    public void testCrearPlanConProductoExistente() {
        System.out.println("CrearPlanConProductoExistente");
        DaoProducto daoProducto= new DaoProducto();
        List<Producto> productos=new ArrayList();
        productos.add(daoProducto.getProducto(1));
        productos.add(daoProducto.getProducto(32768));
        Plan p = new Plan("Plan local ilimitado + Internet 5 Megas", "Linea fija con llamadas locales ilimitadas y banda ancha 5 megas", 70000, productos);
        DaoPlan daoPlan= new DaoPlan();
        daoPlan.crear(p);
    }

    /**
     * Test of getPlane method, of class DaoPlan.
     */
//    @Test
//    public void testGetPlane() {
//        System.out.println("getPlane");
//        int idPlan = 0;
//        Plan expResult = null;
//        Plan result = DaoPlan.getPlane(idPlan);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of crear method, of class DaoPlan.
     */
//    @Test
//    public void testCrear() {
//        System.out.println("crear");
//        List<Producto> productos;
//        Plan object = new Plan("datos para familias", "ninguna Descript", 12000.0,null);
//        DaoPlan instance = new DaoPlan();
//        instance.crear(object);
//    }
    
}
