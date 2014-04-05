/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unal.arqdsoft.control;

import co.edu.unal.arqdsoft.dao.*;
import co.edu.unal.arqdsoft.entidad.*;
import java.util.*;

/**
 *
 * @author dfoxpro
 */
public class ControlSoporte {

    /**
     *
     * @param id
     * @return
     */
    public static Empleado buscarTecnico(int id) {
        return DaoEmpleado.buscarEmpleado();
    }

    /**
     *
     * @return
     */
    public static List<Empleado> buscarTecnicos() {

        return DaoEmpleado.buscarEmpleados();
    }

    /**
     *
     * @return
     */
    public static List<Date> visitas() {
        DaoEmpleado.buscarEmpleado();
        return null;
    }

    /**
     *
     * @return
     */
    public static boolean crearVisitaTecnica() {
        return false;
    }
    
}
