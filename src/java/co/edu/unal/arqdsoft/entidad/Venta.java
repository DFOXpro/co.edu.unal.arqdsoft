/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.unal.arqdsoft.entidad;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;

/**
 *
 * @author jspoloa
 */
@Entity
public class Venta implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private int id;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fecha;
    /**
     * @Var direccionInstalacion
     * Dirección en a cual sera instalado el plan vendido.
     */
    private String direccionInstalacion;
     /**
     * Relaciones:
     * Cada venta tiene asignado un solo cliente, un solo vendedor y un unico plan.
     */
    @ManyToOne
    private Cliente cliente;
    @ManyToOne 
    private Empleado vendedor;
    @ManyToOne
    private Plan plan;

    /**
     *
     */
    public Venta() {
    }

    /**
     *
     * @param id
     * @param fecha
     * @param direccionInstalacion
     * @param cliente
     * @param vendedor
     * @param plan
     */
    public Venta(int id, Date fecha, String direccionInstalacion, Cliente cliente, Empleado vendedor, Plan plan) {
        this.id = id;
        this.fecha = fecha;
        this.direccionInstalacion= direccionInstalacion;
        this.cliente = cliente;
        this.vendedor = vendedor;
        this.plan = plan;
    }

    /**
     *
     * @return
     */
    public int getId() {
        return id;
    }

    /**
     *
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     *
     * @return
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     *
     * @param fecha
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    /**
     *
     * @return
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     *
     * @param cliente
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    /**
     *
     * @return
     */
    public Empleado getVendedor() {
        return vendedor;
    }

    /**
     *
     * @param vendedor
     */
    public void setVendedor(Empleado vendedor) {
        this.vendedor = vendedor;
    }

    /**
     *
     * @return
     */
    public Plan getPlan() {
        return plan;
    }

    /**
     *
     * @param plan
     */
    public void setPlan(Plan plan) {
        this.plan = plan;
    }

    /**
     *
     * @return
     */
    public String getDireccionInstalacion() {
        return direccionInstalacion;
    }

    /**
     *
     * @param direccionInstalacion
     */
    public void setDireccionInstalacion(String direccionInstalacion) {
        this.direccionInstalacion = direccionInstalacion;
    }

    /**
     *
     * @return
     */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + this.id;
        hash = 23 * hash + Objects.hashCode(this.fecha);
        hash = 23 * hash + Objects.hashCode(this.direccionInstalacion);
        hash = 23 * hash + Objects.hashCode(this.cliente);
        hash = 23 * hash + Objects.hashCode(this.vendedor);
        hash = 23 * hash + Objects.hashCode(this.plan);
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
        final Venta other = (Venta) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.fecha, other.fecha)) {
            return false;
        }
        if (!Objects.equals(this.direccionInstalacion, other.direccionInstalacion)) {
            return false;
        }
        if (!Objects.equals(this.cliente, other.cliente)) {
            return false;
        }
        if (!Objects.equals(this.vendedor, other.vendedor)) {
            return false;
        }
        if (!Objects.equals(this.plan, other.plan)) {
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
        return "Venta{" + "id=" + id + ", fecha=" + fecha + ", direccionInstalacion=" + direccionInstalacion + ", cliente=" + cliente + ", vendedor=" + vendedor + ", plan=" + plan + '}';
    }
    
    
}
