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
     * @deprecated 
     * se encarga de buscar a los tecnicos por id y su tiempo libre
     * 
     * @return retorna un mapa con llave el id, y valor el arreglo de horario
     * disponible del empleado
     */
    public static Map<Integer, ArrayList<Date>> tiempoTecnicos() {
        List<Empleado> n = DaoEmpleado.buscarEmpleadosDisponibles();
        Map<Integer, ArrayList<Date>> d = new LinkedHashMap<>();
        for (Empleado empleado : n) {
            d.put(empleado.getId(), null);//se cambio esto chambonamente por tiempo
        }
        return d;
    }

    /**
     *
     * @return
     */
    public static List<VisitaTecnica> visitas() {
        List<VisitaTecnica> visitasTecnicas = DaoVisitaTecnica.obtenerVisitasSinTecnico();
        return visitasTecnicas;
    }

    public static List<VisitaTecnica> visitasPorEmpleado(int id) {
        List<VisitaTecnica> visitasTecnicas = DaoVisitaTecnica.obtenerVisitasPorTecnico(id);
        return visitasTecnicas;
    }

    /**
     *
     * @param id
     * @return
     */
    public static List<VisitaTecnica> visitas(int id) {
        List<VisitaTecnica> visitasTecnicas = DaoVisitaTecnica.getVisitasTecnicasReporte(id);
        return visitasTecnicas;
    }

    /**
     *
     * @param idCliente
     * @param idTecnico
     * @param fecha
     * @param idReporte
     * @param direccion
     * @return
     */
    public static boolean crearVisitaTecnica(int idCliente,int idTecnico, Date fecha, int idReporte, String direccion) {
        if (idCliente == 0 || idCliente < -1 || idTecnico == 0 || idTecnico < -1 || idReporte == 0 || idReporte < -1 || fecha == null
                || direccion.isEmpty()) {
            return false;
        }
        DaoVisitaTecnica dVT = new DaoVisitaTecnica();
        Empleado tecnico = DaoEmpleado.getEmpleado(idTecnico);
        ReporteDano rD = DaoReporteDano.getReporte(idReporte);
        VisitaTecnica vT = new VisitaTecnica(tecnico, fecha, rD, direccion);
        return dVT.crearVisita(vT);
    }

    /**
     *
     * @param idCliente
     * @param fechaCreacionReporte
     * @param descripcion
     * @param idOperador
     * @param fueResuelto
     * @param crearVisita
     * @param direccionVisita
     * @param fechaVisita
     * @return
     */
    public static boolean crearReporteDano(int idCliente, Date fechaCreacionReporte, String descripcion, int idOperador, 
            boolean fueResuelto, boolean crearVisita, String direccionVisita, Date fechaVisita) {
        if (idCliente == 0 || idCliente < -1 || idOperador == 0 || idOperador < -1 || fechaCreacionReporte == null
                || fechaVisita == null) {
            return false;
        }
        boolean exito=false;
        Cliente cliente = DaoCliente.getCliente(idCliente);
        Empleado operador = DaoEmpleado.getEmpleado(idOperador);
        VisitaTecnica visita;
        ReporteDano reporte = new ReporteDano(fechaCreacionReporte,descripcion,fueResuelto,cliente,operador,null);
        reporte = DaoReporteDano.crearReporteDano(reporte);
        if(reporte==null)
            return exito;
        exito=true;
        System.out.println("id "+reporte.getId());
        if(crearVisita==true){
            //se crea una visita sin tecnico asignado
            visita = new VisitaTecnica(null, fechaVisita, reporte,direccionVisita);
            exito=DaoVisitaTecnica.crearVisita(visita);
        }
        return exito;
    }

    /**
     *
     * @param old
     * @param new1
     * @return
     */
    public static boolean modificarReportedano(ReporteDano old, ReporteDano new1) {
        if (old == null || new1 == null) {
            return false;
        }
        return DaoReporteDano.modificarReporteDano(old, new1);
    }

    /**
     *
     * @param old
     * @param new1
     * @return
     */
    public static boolean modificarVisitaTecnica(VisitaTecnica old, VisitaTecnica new1) {
        if (old == null || new1 == null) {
            return false;
        }
        return DaoVisitaTecnica.modificarVisitaTecnica(old, new1);
    }

    /**
     *
     * @param id
     * @return
     */
    public static ReporteDano getReporte(int id) {
        if (id == 0 || id < -1) {
            return null;
        }
        return DaoReporteDano.getReporte(id);

    }

}
