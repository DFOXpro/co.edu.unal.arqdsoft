/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.unal.arqdsoft.dao;

import co.edu.unal.arqdsoft.entidad.Empleado;
import java.util.ArrayList;
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
public class DaoEmpleadoTest {
    
    public DaoEmpleadoTest() {
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
     * Test of persist method, of class DaoEmpleado.
     */
    @Test
    public void testPersist() {
        System.out.println("persist");
        DaoEmpleado dao=new DaoEmpleado();
        String nombre="José Santiago Polo Acosta";
        String informacion="80128928;31846541440;carrera24 #23-20";
        ArrayList<Date> horarioDisponible=null;
        String usuario="jspoloa";
        String contrasena="123456";
        Empleado.roles rol=Empleado.roles.VENDEDOR;
        
        Empleado empleado= new Empleado(nombre,informacion,horarioDisponible,usuario,contrasena,rol);
        dao.persist(empleado);
        System.out.println(empleado.getNombre()+" "+empleado.getInformacion());
    }

    /**
     * Test of login method, of class DaoEmpleado.
     */
//    @Test
//    public void testLogin() {
//        System.out.println("login");
//        String usuario = "";
//        String contrasena = "";
//        DaoEmpleado instance = new DaoEmpleado();
//        Empleado expResult = null;
//        Empleado result = instance.login(usuario, contrasena);
//        assertEquals(expResult, result);
//    }
    
}
