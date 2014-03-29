/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.unal.arqdsoft.entidad;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import javax.persistence.ManyToOne;

/**
 *
 * @author Jhhfrancos
 */
@Entity
public class VisitaTecnica implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private int id;
    //@ManyToOne
    private Empleado tecnico;
    private Date fechaVisita;
    //@ManyToOne
    private ReporteDano reporte;
    private String direccion;
    
    public VisitaTecnica(int id, Empleado tecnico, Date fechaVisita, ReporteDano reporte, String direccion){
        this.id = id;
        this.tecnico = tecnico;
        this.fechaVisita = fechaVisita;
        this.reporte = reporte;
        this.direccion = direccion;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the tecnico
     */
    public Empleado getTecnico() {
        return tecnico;
    }

    /**
     * @param tecnico the tecnico to set
     */
    public void setTecnico(Empleado tecnico) {
        this.tecnico = tecnico;
    }

    /**
     * @return the fechaVisita
     */
    public Date getFechaVisita() {
        return fechaVisita;
    }

    /**
     * @param fechaVisita the fechaVisita to set
     */
    public void setFechaVisita(Date fechaVisita) {
        this.fechaVisita = fechaVisita;
    }

    /**
     * @return the reporte
     */
    public ReporteDano getReporte() {
        return reporte;
    }

    /**
     * @param reporte the reporte to set
     */
    public void setReporte(ReporteDano reporte) {
        this.reporte = reporte;
    }

    /**
     * @return the direccion
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * @param direccion the direccion to set
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}
