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
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaVisita;
    private String direccion; 
    /**
     * Relaciones:
     * Una vista tecnica tiene un solo tecnico a cargo y esta asignada a un solo reporte de daño.
     */
    @ManyToOne
    private Empleado tecnico;
    @ManyToOne
    private ReporteDano reporte;
    
    /**
     *
     */
    public VisitaTecnica() {
    }
    
    /**
     * Constructor de la clase VisitaTecnica especificando todos los campos del objeto
     * @param id    Variable entera con el identificador de el numero de visita tecnica
     * @param tecnico   Variable tipo empleado que hace referencia a el tecnico que realizo o realizara la visita
     * @param fechaVisita   Variable de tipo daate con la fecha en la cual se realizo o realizara la visita tecnica
     * @param reporte   Objeto de tipo ReporteDano con la llamada y respectivo reporte de la cual deriva esta visita tecnica
     * @param direccion Cadena de caracteres conteniendo la direccion exacta donde se llevara a cabo la visita
     */
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
