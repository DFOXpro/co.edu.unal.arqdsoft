/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.unal.arqdsoft.entidad;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import javax.persistence.OneToMany;

/**
 *
 * @author jspoloa
 */
@Entity
public class Empleado implements Serializable {

    /**
     * La variable rol contiene los diferentes roles que puede tener un empleado.
     * Un empleado solo puede tener un rol especifico. 
     **/
    public enum roles {OPERARIO,VENDEDOR,TECNICO,ADMINPRODUCTOS};
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private int id;
    private String nombre;
    private String informacion;
    //TODO definir como manejar los horarios de los tecnicos
    private ArrayList<Date> horarioDisponible;
    private String usuario;
    private String contrasena;
    private roles rol; 

    //TODO Arreglar relaciones
    /*@OneToMany
    private List<Venta> ventas;
    //TODO definir como se manejara la relacion entre VisitaTecnica y Empleado
    @OneToMany
    private List<VisitaTecnica> visitasTecnicas;  */
    /*public Empleado(int id, String nombre, String informacion, ArrayList<Date> horarioDisponible, String usuario, String contrasena, roles rol, List<Venta> ventas, List<VisitaTecnica> visitasTecnicas) {
    this.id = id;
    this.nombre = nombre;
    this.informacion = informacion;
    this.horarioDisponible = horarioDisponible;
    this.usuario = usuario;
    this.contrasena = contrasena;
    this.rol = rol;
    this.ventas = ventas;
    this.visitasTecnicas = visitasTecnicas;
    }*/
    
    /**
     * Constructor para pruebas de guardado en la base de datos
     * sin relaciones con las otras entidades.
     * @param id
     * @param nombre
     * @param informacion
     * @param horarioDisponible
     * @param usuario
     * @param contrasena
     * @param rol 
     */
    public Empleado(String nombre, String informacion, ArrayList<Date> horarioDisponible, String usuario, String contrasena, roles rol) {
        //this.id = id;
        this.nombre = nombre;
        this.informacion = informacion;
        this.horarioDisponible = horarioDisponible;
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.rol = rol;
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

    public ArrayList<Date> getHorarioDisponible() {
        return horarioDisponible;
    }

    public void setHorarioDisponible(ArrayList<Date> horarioDisponible) {
        this.horarioDisponible = horarioDisponible;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public roles getRol() {
        return rol;
    }

    public void setRol(roles rol) {
        this.rol = rol;
    }

//    public List<Venta> getVentas() {
//        return ventas;
//    }
//
//    public void setVentas(List<Venta> ventas) {
//        this.ventas = ventas;
//    }
//
//    public List<VisitaTecnica> getVisitasTecnicas() {
//        return visitasTecnicas;
//    }
//
//    public void setVisitasTecnicas(List<VisitaTecnica> visitasTecnicas) {
//        this.visitasTecnicas = visitasTecnicas;
//    }
}
