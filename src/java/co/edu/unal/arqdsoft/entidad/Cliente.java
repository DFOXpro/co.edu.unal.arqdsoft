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
    private List<Plan> planes;
    //@OneToMany
    private List<ReporteDano> reporteDano;

    /**
     * Constructor de la clase cliente especificando cada uno de los campos
     * @param id    Un entero representando la id asignada al nuevo cliente
     * @param nombre    Una cadena de caracteres con el nombre del nuevo cliente 
     * @param informacion   Una cadena de caracdteres con informacion de interes sobre el cliente
     * @param planes    Un objeto de tipo plan representando el plan que tiene actualmente el cliente
     * @param reporteDano   Una lista de objetos de tipo ReporteDano con todos los reportes realizados por el cliente
     */
        public Cliente(int id, String nombre, String informacion, List<Plan> planes, List<ReporteDano> reporteDano) {
        this.id = id;
        this.nombre = nombre;
        this.informacion = informacion;
        this.planes = planes;
        this.reporteDano = reporteDano;
    }

    public Cliente(int id, String nombre, String informacion, int idPlan, Object object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
    public List<Plan> getPlanes() {
        return planes;
    }

    /**
     * @param planes the planes to set
     */
    public void setPlanes(List<Plan> planes) {
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
