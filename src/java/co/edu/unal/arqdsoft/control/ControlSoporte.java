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
        if (id == 0 || id < -1) {
            return null;
        }
        return DaoEmpleado.getEmpleado(id);
    }

    /**
     * se encarga de buscar a los tecnicos por id y su tiempo libre
     *
     * @return retorna un mapa con llave el id, y valor el arreglo de horario
     * disponible del empleado
     */
    public static Map<Integer, ArrayList<Date>> tiempoTecnicos() {
        List<Empleado> n = DaoEmpleado.buscarEmpleadosDisponibles();
        Map<Integer, ArrayList<Date>> d = new HashMap<>();
        n.stream().forEach((empleado) -> {
            d.put(empleado.getId(), null);
        });
        return d;
    }

    /**
     *
     * @param idTecnico
     * @return
     */
    public static List<VisitaTecnica> visitas(int idTecnico) {
        if (idTecnico == 0 || idTecnico < -1) {
            return null;
        }
        List<VisitaTecnica> visitasTecnicas = DaoVisitaTecnica.getVisitasTecnicas();

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
    public static boolean crearVisitaTecnica(int idCliente, Empleado tecnico, Date fecha, ReporteDano rD, String dirreccion) {
        if (idCliente == 0 || idCliente < -1 || tecnico.getId() == 0 || tecnico.getId() < -1 || rD.getId() == 0 || rD.getId() < -1 || fecha.equals(null)
                || dirreccion.isEmpty()) {
            return false;
        }
        DaoVisitaTecnica dVT = new DaoVisitaTecnica();
        VisitaTecnica vT = new VisitaTecnica(idCliente, tecnico, fecha, rD, dirreccion);
        return dVT.crearVisita(vT);
    }

    /**
     *
     * @param idCliente
     * @param fecha
     * @param dirreccion
     * @param idOperador
     * @param fueResuelto
     * @return
     */
    public static boolean crearReportedano(int idCliente, Date fecha, String dirreccion, int idOperador, boolean fueResuelto) {
        if (idCliente == 0 || idCliente < -1 || idOperador == 0 || idOperador < -1 || fecha.equals(null)) {
            return false;
        }
        return DaoReporteDano.crearReporteDano(fecha, dirreccion, fueResuelto, idOperador, idCliente);
    }

    public static boolean modificarReportedano(ReporteDano old, ReporteDano  new1) {
        if (old.equals(null) || new1.equals(null)) {
            return false;
        }
        return DaoReporteDano.modificarReporteDano(old, new1);
    }
    public static ReporteDano getReporte(int id){
        if(id==0||id<-1){
            return null;
        }
        return DaoReporteDano.getReporte(id);
    
    }

}
