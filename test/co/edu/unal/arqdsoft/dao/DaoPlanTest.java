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
//    @Test
//    public void testGetPlanes() {
//        DaoPlan daoPlan = new DaoPlan();
//        
//        System.out.println(daoPlan.getPlanes().get(0).getNombre());
//    }

    /**
     * Test of CrearPlan method, of class DaoPlan.
     */
    @Test
    public void testCrearPlan() {
        DaoProducto daoProducto = new DaoProducto();
   
        System.out.println("crearPlan");
        List<Producto> productos=new ArrayList();
        productos.add(daoProducto.getProducto(1));
        productos.add(daoProducto.getProducto(6));
        Plan p = new Plan("Plan local ilimitado + Internet 1 Megas", "Linea fija con llamadas locales ilimitadas y banda ancha 1 megas", 30000, productos);
        productos=new ArrayList();
        productos.add(daoProducto.getProducto(4));
        productos.add(daoProducto.getProducto(7));
        Plan p1 = new Plan("Plan local ilimitado + Internet 4 Megas", "Linea fija con llamadas nacional ilimitadas y banda ancha 4 megas", 30000, productos);
        DaoPlan instance = new DaoPlan();
        
        assertTrue(instance.CrearPlan(p));
        assertTrue(instance.CrearPlan(p1));
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getPlane method, of class DaoPlan.
     */
//    @Test
//    public void testGetPlan() {
//        System.out.println("getPlan");
//        int idPlan = 32768;
//        DaoPlan instance = new DaoPlan();
//        
//        Plan result = instance.getPlan(idPlan);
////      System.out.println(result);
//        assertEquals(idPlan, result.getId());
//        // TODO review the generated test code and remove the default call to fail.
//        //fail("The test case is a prototype.");
//
//    }


    /**
     * Test of eliminarPlan method, of class DaoPlan.
     */
   /* @Test
    public void testEliminarPlan() {
        System.out.println("eliminarPlan");
        //int id = 132456;
        Plan plan;
        DaoPlan daoPlan = new DaoPlan();
        // id del plan depende de la base de datos
        plan = daoPlan.getPlan(65536);
        //System.out.println("ACa llego Eliminar");
        assertTrue(daoPlan.eliminarPlan(plan));
    }

    /**
     * Test of modificarPlan method, of class DaoPlan.
     */
//    @Test
//    public void testModificarPlan() {
//        System.out.println("modificarProducto");
//        Plan planAModificar = DaoPlan.getPlan(32768);
//        Plan p = new Plan();
//        p.setNombre("Nuevo Plan");
//        p.setDescripcion("Descrip del nuevo plan");
//        p.setValor(35000);
//        DaoProducto daoProducto= new DaoProducto();
//        List<Producto> productos=new ArrayList();
//        productos.add(daoProducto.getProducto(1));
//        productos.add(daoProducto.getProducto(32768));
//        p.setProductos(productos);
//        assertTrue(DaoPlan.modificarPlan(planAModificar,p));
//        
//    }

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
/*

    @Test
    public void testCrearPlanConProductoExistente() {
        System.out.println("CrearPlanConProductoExistente");
        DaoProducto daoProducto= new DaoProducto();
        List<Producto> productos=new ArrayList();
        productos.add(daoProducto.getProducto(1));
        productos.add(daoProducto.getProducto(32768));
        Plan p = new Plan("Plan local ilimitado + Internet 5 Megas", "Linea fija con llamadas locales ilimitadas y banda ancha 5 megas", 70000, productos);
        DaoPlan daoPlan= new DaoPlan();
        daoPlan.CrearPlan(p);
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
