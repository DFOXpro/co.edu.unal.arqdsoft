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
    @Test
    public void testCrearProducto() {
        System.out.println("crear");
        //int id = 132456;
        
        Producto producto = new Producto("Internet Ilimitado 1 Megas", "Internet banda ancha 1 megas", 20000);
        Producto producto1 = new Producto("Internet Ilimitado 2 Megas", "Internet banda ancha 2 megas", 30000);
        Producto producto2 = new Producto("Internet Ilimitado 3 Megas", "Internet banda ancha 3 megas", 38000);
        Producto producto3 = new Producto("Internet Ilimitado 4 Megas", "Internet banda ancha 4 megas", 45000);
        Producto producto4 = new Producto("Internet Ilimitado 5 Megas", "Internet banda ancha 5 megas", 50000);
        Producto producto5 = new Producto("Telefono Ilimitado local", "Telefono Ilimitado local", 15000);
        Producto producto6 = new Producto("Telefono Ilimitado nacional", "Telefono Ilimitado nacional", 25000);
        Producto producto7 = new Producto("Telefono Ilimitado nacional+500min UE", "Telefono Ilimitado nacional+500min UE", 35000);
        Producto producto8 = new Producto("Telefono Ilimitado nacional+500min USA", "Telefono Ilimitado nacional+500min USA", 40000);
        
        DaoProducto daoProducto = new DaoProducto();

        assertTrue(daoProducto.crearProducto(producto));
        assertTrue(daoProducto.crearProducto(producto1));
        assertTrue(daoProducto.crearProducto(producto2));
        assertTrue(daoProducto.crearProducto(producto3));
        assertTrue(daoProducto.crearProducto(producto4));
        assertTrue(daoProducto.crearProducto(producto5));
        assertTrue(daoProducto.crearProducto(producto6));
        assertTrue(daoProducto.crearProducto(producto7));
        assertTrue(daoProducto.crearProducto(producto8));
    }
       
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
   
//    @Test
//    public void testGetProductos(){
//        DaoProducto daoProductos = new DaoProducto();
//        
//        System.out.println(daoProductos.getProductos().get(0).getNombre());
//    }
}
