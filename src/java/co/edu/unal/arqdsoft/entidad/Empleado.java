/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.unal.arqdsoft.entidad;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author jspoloa
 */
public class Empleado {
    /**
     * La variable rol contiene los diferentes roles que puede tener un empleado.
     * Un empleado solo puede tener un rol especifico. 
     **/
    public enum roles {OPERARIO,VENDEDOR,TECNICO,ADMINPRODUCTOS};
    
    private int id;
    private String nombre;
    private String informacion;
    //TODO definir como manejar los horarios de los tecnicos
    private ArrayList<Date> horarioDisponible;
    private String usuario;
    private String contrasena;
    private roles rol; 
    //TODO definir como se manejara la relacion entre Venta y Empleado
    private Venta ventas;
    //TODO definir como se manejara la relacion entre VisitaTecnica y Empleado
    private VisitaTecnica visitasTecnicas;

    public Empleado(int id, String nombre, String informacion, ArrayList<Date> horarioDisponible, String usuario, String contrasena, roles rol, Venta ventas, VisitaTecnica visitasTecnicas) {
        this.id = id;
        this.nombre = nombre;
        this.informacion = informacion;
        this.horarioDisponible = horarioDisponible;
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.rol = rol;
        this.ventas = ventas;
        this.visitasTecnicas = visitasTecnicas;
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

    public Venta getVentas() {
        return ventas;
    }

    public void setVentas(Venta ventas) {
        this.ventas = ventas;
    }

    public VisitaTecnica getVisitasTecnicas() {
        return visitasTecnicas;
    }

    public void setVisitasTecnicas(VisitaTecnica visitasTecnicas) {
        this.visitasTecnicas = visitasTecnicas;
    }
    
    
    
}
