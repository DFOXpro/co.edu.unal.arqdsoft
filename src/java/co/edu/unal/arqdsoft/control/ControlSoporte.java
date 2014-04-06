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
     * se encarga de buscar a los tecnicos por id y su tiempo libre
     *
     * @return retorna un mapa con llave el id, y valor el arreglo de horario
     * disponible del empleado
     */
    public static Map<Integer, ArrayList<Date>> tiempoTecnicos() {
        List<Empleado> n = DaoEmpleado.buscarEmpleados();
        Map<Integer, ArrayList<Date>> d = new HashMap<>();
        n.stream().forEach((empleado) -> {
            d.put(empleado.getId(), empleado.getHorarioDisponible());
        });
        return d;
    }

    /**
     *
     * @return
     */
    public static List<VisitaTecnica> visitas() {
        List<VisitaTecnica> visitasTecnicas = DaoEmpleado.buscarEmpleado().getVisitasTecnicas();

        return visitasTecnicas;
    }

    /**
     *
     * @param idCliente
     * @param tecnico
     * @param fecha
     * @param rD
     * @param dirreccion
     * @return
     */
    public static boolean crearVisitaTecnica(int idCliente, Empleado tecnico,Date fecha,ReporteDano rD,String dirreccion) {
        DaoVisitaTecnica dVT=new DaoVisitaTecnica();
        VisitaTecnica vT=new VisitaTecnica(idCliente, tecnico, fecha, rD, dirreccion);
        return dVT.crearVisita(vT);
    }
    public static boolean crearReportedano(int idCliente,Date fecha,String dirreccion,int idOperador,boolean fueResuelto) {
        DaoReporteDano dRD=new DaoReporteDano();
        DaoCliente c=new DaoCliente();
        DaoEmpleado o= new DaoEmpleado();
        ReporteDano rD=new ReporteDano(fecha, dirreccion, fueResuelto, c.getCliente(idCliente),o.getEmpleado(idOperador),null);
        return dRD.crearReporteDano(rD);
    }
    

}
