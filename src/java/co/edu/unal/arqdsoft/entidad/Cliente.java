package co.edu.unal.arqdsoft.entidad;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author jspoloa
 */
@Entity
public class Cliente implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private int id;
    private String nombre;
    private String informacion;
    //@ManyToOne
    private Plan planes;
    //@OneToMany
    private List<ReporteDano> reporteDano;
    
    public Cliente(int id, String nombre, String informacion, Plan planes, List<ReporteDano> reporteDano) {
        this.id = id;
        this.nombre = nombre;
        this.informacion = informacion;
        this.planes = planes;
        this.reporteDano = reporteDano;
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
     * @return the informacion
     */
    public String getInformacion() {
        return informacion;
    }

    /**
     * @param informacion the informacion to set
     */
    public void setInformacion(String informacion) {
        this.informacion = informacion;
    }

    /**
     * @return the planes
     */
    public Plan getPlanes() {
        return planes;
    }

    /**
     * @param planes the planes to set
     */
    public void setPlanes(Plan planes) {
        this.planes = planes;
    }

    /**
     * @return the reporteDano
     */
    public List<ReporteDano> getReporteDano() {
        return reporteDano;
    }

    /**
     * @param reporteDano the reporteDano to set
     */
    public void setReporteDano(List<ReporteDano> reporteDano) {
        this.reporteDano = reporteDano;
    }
    
    
}
