/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.unal.arqdsoft.dao;

import co.edu.unal.arqdsoft.entidad.Producto;
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
public class DaoProductoTest {
    
    public DaoProductoTest() {
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
     * Test of modificarProducto method, of class DaoProducto.
     */
//   @Test
//    public void testModificarProducto() {
//        System.out.println("modificarProducto");
//        Producto productoAModificar = DaoProducto.getProducto(32768);
//        Producto p = new Producto();
//        p.setNombre(productoAModificar.getNombre());
//        p.setDescripcion(productoAModificar.getDescripcion());
//        p.setValor(35000);
//        assertTrue(DaoProducto.modificarProducto(productoAModificar,p));
//        
//    }

    /**
     * Test of EliminarProducto method, of class DaoProducto.
     */
   /*@Test
    public void testEliminarProducto(){
        System.out.println("eliminar");
        //int id = 132456;
        Producto productos;
        DaoProducto daoProducto = new DaoProducto();
        productos = daoProducto.getProducto(32768);
        //System.out.println("ACa llego Eliminar");
        assertTrue(daoProducto.eliminarProducto(productos));
    }
    /**
     * Test of crearProducto method, of class DaoProducto.
     */
//    @Test
//    public void testCrearProducto() {
//        System.out.println("crear");
//        //int id = 132456;
//        
//        Producto productos = new Producto("Internet Ilimitado 5 Megas", "Internet banda ancha 5 megas", 40000);
//        
//        DaoProducto daoProducto = new DaoProducto();
//
//        assertTrue(daoProducto.crearProducto(productos));
//    }
       
    /**
     * Test of crearProducto method, of class DaoProducto.
     */
//    @Test
//    public void testGetProducto() {
//        System.out.println("getProducto");
//        int idProd = 1;
//        DaoProducto instance = new DaoProducto();
//        
//        Producto result = instance.getProducto(idProd);
//        
//        assertEquals(idProd, result.getId());
//        // TODO review the generated test code and remove the default call to fail.
//        //fail("The test case is a prototype.");
//    }
   
    @Test
    public void testGetProductos(){
        DaoProducto daoProductos = new DaoProducto();
        
        System.out.println(daoProductos.getProductos().get(0).getNombre());
    }
}
