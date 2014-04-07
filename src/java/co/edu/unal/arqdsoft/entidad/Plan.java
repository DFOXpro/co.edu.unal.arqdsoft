/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.unal.arqdsoft.entidad;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
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
    /**
     * Relaciones:
     * Las relaciones de Plan son de muchos a muchos con Producto, ya que un Plan contiene uno o varios productos
     * y un producto esta en uno o varios planes. A su vez una Venta solo tiene un plan pero varios planes pueden
     * estar en diferentes ventas.
     */ 
    

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Producto> productos;
    
    /**
     * Constructor por defecto
     */
    public Plan() {
    }
    
    /**
     *  Constructor de la clase plan para la creacion de  un nuevo plan especificando cada uno de los campos
     * @param nombre    una cadena de caracteres que representa el nombre del plan
     * @param descripcion   una breve descripcion de el plan
     * @param valor el costo que tendra el plan en el mercado
     * @param productos una lista conteniendo objetos de tipo productos con los productos que conforman el plan
     * 
     */
    public Plan(String nombre, String descripcion, double valor, List<Producto> productos) {
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

    /**
     *
     * @return
     */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 43 * hash + this.id;
        hash = 43 * hash + Objects.hashCode(this.nombre);
        hash = 43 * hash + Objects.hashCode(this.descripcion);
        hash = 43 * hash + (int) (Double.doubleToLongBits(this.valor) ^ (Double.doubleToLongBits(this.valor) >>> 32));
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
        final Plan other = (Plan) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.descripcion, other.descripcion)) {
            return false;
        }
        if (Double.doubleToLongBits(this.valor) != Double.doubleToLongBits(other.valor)) {
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
        return "Plan{" + "id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", valor=" + valor + ", productos=" + productos + '}';
    }

}