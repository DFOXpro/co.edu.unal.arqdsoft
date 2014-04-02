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
        String nombre="Daniel Reinaldo Zorro";
        String informacion="1033123456;3194232200;calle falsa 123";
        ArrayList<Date> horarioDisponible=null;
        String usuario="drzorro";
        String contrasena="123456";
        Empleado.roles rol=Empleado.roles.OPERARIO;
        
        Empleado empleado= new Empleado(nombre,informacion,horarioDisponible,usuario,contrasena,rol);
        dao.persist(empleado);
        dao.persist(new Empleado("Pedro", "abc", null, "pedro", "123456", Empleado.roles.ADMINPRODUCTOS));
        dao.persist(new Empleado("Potter", "abc", null, "potter", "123456", Empleado.roles.TECNICO));
        System.out.println(empleado.getNombre()+" "+empleado.getInformacion());
    }

    /**
     * Test of login method, of class DaoEmpleado.
     */
//    @Test
//    public void testLogin() {
//        System.out.println("login");
//        String usuario = "drzorro";
//        String contrasena = "123456";
//        DaoEmpleado dao=new DaoEmpleado();
//        Empleado empleado = dao.login(usuario, contrasena);
//        if(empleado!=null)
//            System.out.println(empleado.getNombre());
//        else
//            System.out.println("empleado es null");
//        //assertEquals(expResult, result);
//    }
    
}
