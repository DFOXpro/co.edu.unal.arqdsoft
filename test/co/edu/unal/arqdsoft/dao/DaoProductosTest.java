/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.unal.arqdsoft.dao;

import co.edu.unal.arqdsoft.entidad.Productos;
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
public class DaoProductosTest {
    
    public DaoProductosTest() {
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
     * Test of crear method, of class DaoProductos.
     */
    @Test
    public void testCrear() {
        System.out.println("crear");
        //int id = 132456;
        double valor = 11111;
        Productos productos = new Productos(null, null, valor);
        System.out.print("creo o no creo...pero llego aca");
        DaoProductos daoProducto = new DaoProductos();
        
        daoProducto.crear(productos);
        //TODO
        
        
    }
    
}