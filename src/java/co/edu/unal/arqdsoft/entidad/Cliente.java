package co.edu.unal.arqdsoft.entidad;

/**
 *
 * @author jspoloa
 */
public class Cliente {
    private int id;
    private String nombre;
    private String informacion;
    private Plan planes;

    public Cliente(int id, String nombre, String informacion, Plan planes) {
        this.id = id;
        this.nombre = nombre;
        this.informacion = informacion;
        this.planes = planes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public Plan getPlanes() {
        return planes;
    }

    public void setPlanes(Plan planes) {
        this.planes = planes;
    }
    
    
}
