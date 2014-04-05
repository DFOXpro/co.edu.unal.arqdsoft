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
 * @author jspoloa
 */
@Entity
public class Venta implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private int id;
    private Date fecha;
    //@ManyToOne
    private Cliente cliente;
    //@ManyToOne 
    private Empleado vendedor;
    //@ManyToOne
    private Plan plan;

    /**
     *
     * @param id
     * @param fecha
     * @param cliente
     * @param vendedor
     * @param plan
     */
    public Venta(int id, Date fecha, Cliente cliente, Empleado vendedor, Plan plan) {
        this.id = id;
        this.fecha = fecha;
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
    
}
