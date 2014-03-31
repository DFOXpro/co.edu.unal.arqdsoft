/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.unal.arqdsoft.entidad;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author Jhhfrancos
 */
@Entity
public class ReporteDano implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private long id;
    //@ManyToOne
    private Cliente cliente;
    //@ManyToOne 
    private Empleado operador;
    private Date fechaCreacion;
    private String descripcion;
    private Boolean resuelto;

    /**
     * Constructor de la clase ReporteDano especificando todos los campos del objeto
     * @param id    Numero de tipo long representando la id del reporte 
     * @param cliente   Objeto de tipo cliente que hace referencia a quien presento el reporte
     * @param operador  Objeto de tipo empleado que se refiere al operador que tomo la llamada de soporte
     * @param fechaCreacion Variable tipo date con la fecha de creacion de el reporte
     * @param descripcion   Una breve descripcion del daño que se especifico en el reporte
     * @param resuleto  Objeto de tipo booleano representando si el problema fue resuelto(1) o si aun no tiene solucion(0)
     */
    public ReporteDano(long id, Cliente cliente, Empleado operador, Date fechaCreacion, String descripcion, Boolean resuleto){
        this.id = id;
        this.cliente = cliente;
        this.operador = operador;
        this.fechaCreacion = fechaCreacion;
        this.descripcion = descripcion;
        this.resuelto = resuleto;
    }

    /**
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * @return the cliente
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * @param cliente the cliente to set
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    /**
     * @return the operador
     */
    public Empleado getOperador() {
        return operador;
    }

    /**
     * @param operador the operador to set
     */
    public void setOperador(Empleado operador) {
        this.operador = operador;
    }

    /**
     * @return the fechaCreacion
     */
    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    /**
     * @param fechaCreacion the fechaCreacion to set
     */
    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * @return the resuelto
     */
    public Boolean getResuelto() {
        return resuelto;
    }

    /**
     * @param resuelto the resuelto to set
     */
    public void setResuelto(Boolean resuelto) {
        this.resuelto = resuelto;
    }
}
