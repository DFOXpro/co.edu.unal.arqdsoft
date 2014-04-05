/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.unal.arqdsoft.entidad;
import java.io.Serializable;
import java.util.List;
import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
/**
 *
 * @author jrfrancos
 */
@Entity
public class Plan implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private int id;
    private String nombre;
    private String descripcion;
    private double valor; 
    @ManyToMany
    private List<Producto> productos;
    
    /**
     *  Constructor de la clase plan para la creacion de  un nuevo plan especificando cada uno de los campos
     * @param nombre    una cadena de caracteres que representa el nombre del plan
     * @param descripcion   una breve descripcion de el plan
     * @param valor el costo que tendra el plan en el mercado
     * @param productos una lista conteniendo objetos de tipo productos con los productos que conforman el plan
     */
    public Plan(String nombre, String descripcion, double valor, List<Producto> productos) {
        //this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.valor = valor;
        this.productos = productos;
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
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
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
     * @return the valor
     */
    public double getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(double valor) {
        this.valor = valor;
    }

    /**
     * @return the productos
     */
    public List<Producto> getProductos() {
        return productos;
    }

    /**
     * @param productos the productos to set
     */
    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }
}