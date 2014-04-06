/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unal.arqdsoft.control;

import co.edu.unal.arqdsoft.dao.*;
import co.edu.unal.arqdsoft.entidad.*;
import java.util.*;
import javafx.beans.property.SimpleMapProperty;

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
    public static Map<Integer,ArrayList<Date>> buscarTecnicos() {
        List<Empleado> n = DaoEmpleado.buscarEmpleados();
        Map<Integer,ArrayList<Date>> d=new SimpleMapProperty<>();
        n.stream().forEach((empleado) -> {
            d.put(empleado.getId(), empleado.getHorarioDisponible());
        });
        return d;
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
