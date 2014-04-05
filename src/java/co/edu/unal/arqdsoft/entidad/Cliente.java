package co.edu.unal.arqdsoft.entidad;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author jspoloa
 */
@Entity
public class Cliente implements Serializable{
    /**
     * @Var id
     * El id del cliente sera la cedula de ciudadania
     */
    @Id
    private long id;
    private String nombre;
    private String informacion;
    /**
     * Como la venta incluye el plan adquirido, solo es necesario añadir la venta al cliente
     * Los planes adquiridos por el cliente se pueden obtener usando el campo ventas.
     */    
    @OneToMany
    private List<Venta> ventas;
    @OneToMany
    private List<ReporteDano> reporteDano;

    public Cliente() {
    }

    public Cliente(long id, String nombre, String informacion, List<Venta> ventas, List<ReporteDano> reporteDano) {
        this.id = id;
        this.nombre = nombre;
        this.informacion = informacion;
        this.ventas = ventas;
        this.reporteDano = reporteDano;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getInformacion() {
        return informacion;
    }

    public void setInformacion(String informacion) {
        this.informacion = informacion;
    }

    public List<Venta> getVentas() {
        return ventas;
    }

    public void setVentas(List<Venta> ventas) {
        this.ventas = ventas;
    }

    public List<ReporteDano> getReporteDano() {
        return reporteDano;
    }

    public void setReporteDano(List<ReporteDano> reporteDano) {
        this.reporteDano = reporteDano;
    }

    @Override
    public String toString() {
        return "Cliente{" + "id=" + id + ", nombre=" + nombre + ", informacion=" + informacion + ", ventas=" + ventas + ", reporteDano=" + reporteDano + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 29 * hash + Objects.hashCode(this.nombre);
        hash = 29 * hash + Objects.hashCode(this.informacion);
        hash = 29 * hash + Objects.hashCode(this.ventas);
        hash = 29 * hash + Objects.hashCode(this.reporteDano);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cliente other = (Cliente) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.informacion, other.informacion)) {
            return false;
        }
        if (!Objects.equals(this.ventas, other.ventas)) {
            return false;
        }
        if (!Objects.equals(this.reporteDano, other.reporteDano)) {
            return false;
        }
        return true;
    }

    
    
}
