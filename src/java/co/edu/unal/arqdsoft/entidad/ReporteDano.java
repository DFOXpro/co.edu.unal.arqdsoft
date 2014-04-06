/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.unal.arqdsoft.entidad;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;

/**
 *
 * @author Jhhfrancos
 */
@Entity
public class ReporteDano implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private long id; 
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaCreacion;
    private String descripcion;
    private Boolean resuelto;
    /**
     * Relaciones:
     * Cada reporte de daño tiene solo un empleado a cargo, sin embargo ese empleado puede tener varios reportes de daños
     * a su nombre.
     * De igual forma cada reporte esta asignado a un Cliente, pero un Cliente puede tener varios reportes a su nombre.
     * Un reporte de daño puede tener 0 o varias visitas tecnicas, pero cada visita tecnica esta asignada a un solo 
     * reporte de daño.
     */
    @ManyToOne
    private Empleado operador;
    @OneToMany(mappedBy = "reporte")
    private List<VisitaTecnica> visitasTecnicas;
    @ManyToOne
    private Cliente cliente;

    /**
     *
     */
    public ReporteDano() {
    }

    /**
     * Constructor de la clase ReporteDano especificando todos los campos del objeto 
     * @param cliente   Objeto de tipo cliente que hace referencia a quien presento el reporte
     * @param operador  Objeto de tipo empleado que se refiere al operador que tomo la llamada de soporte
     * @param fechaCreacion Variable tipo date con la fecha de creacion de el reporte
     * @param descripcion   Una breve descripcion del daño que se especifico en el reporte
     * @param resuelto  Objeto de tipo booleano representando si el problema fue resuelto(1) o si aun no tiene solucion(0)
     * @param visitasTecnicas Las visitas tecnicas que fueron generadas para este reporte.
     */
    public ReporteDano(Date fechaCreacion, String descripcion, Boolean resuelto, Cliente cliente, Empleado operador, List<VisitaTecnica> visitasTecnicas) {
        this.fechaCreacion = fechaCreacion;
        this.descripcion = descripcion;
        this.resuelto = resuelto;
        this.cliente = cliente;
        this.operador = operador;
        this.visitasTecnicas = visitasTecnicas;
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

    /**
     *
     * @return
     */
    public List<VisitaTecnica> getVisitasTecnicas() {
        return visitasTecnicas;
    }

    /**
     *
     * @param visitasTecnicas
     */
    public void setVisitasTecnicas(List<VisitaTecnica> visitasTecnicas) {
        this.visitasTecnicas = visitasTecnicas;
    }

    /**
     *
     * @return
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 71 * hash + Objects.hashCode(this.fechaCreacion);
        hash = 71 * hash + Objects.hashCode(this.descripcion);
        hash = 71 * hash + Objects.hashCode(this.resuelto);
        hash = 71 * hash + Objects.hashCode(this.cliente);
        hash = 71 * hash + Objects.hashCode(this.operador);
        return hash;
    }

    /**
     *
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ReporteDano other = (ReporteDano) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.fechaCreacion, other.fechaCreacion)) {
            return false;
        }
        if (!Objects.equals(this.descripcion, other.descripcion)) {
            return false;
        }
        if (!Objects.equals(this.resuelto, other.resuelto)) {
            return false;
        }
        if (!Objects.equals(this.cliente, other.cliente)) {
            return false;
        }
        if (!Objects.equals(this.operador, other.operador)) {
            return false;
        }
        return true;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "ReporteDano{" + "id=" + id + ", fechaCreacion=" + fechaCreacion + ", descripcion=" + descripcion + ", resuelto=" + resuelto + ", cliente=" + cliente + ", operador=" + operador + ", visitasTecnicas=" + visitasTecnicas + '}';
    }

    public boolean crearVisita(ReporteDano vT) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
