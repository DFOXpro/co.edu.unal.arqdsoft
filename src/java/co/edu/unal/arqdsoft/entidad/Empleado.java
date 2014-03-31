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
    public enum roles {

        /**
         *Rol encargado de reportar errores tecnicos y agendar las respectivas visitas de soporte
         */
        OPERARIO,

        /**
         *Rol encargado de añadir nuevos clientes al sistema asi como añadirle productos a los actuales clientes
         */
        VENDEDOR,

        /**
         *Rol encargado de realizar las visitas domiciliarias e informar sobre correcciones de errores
         */
        TECNICO,

        /**
         *Rol encargado de crear, modificar y/o eliminar productos de la bandeja de productos de la compañia
         */
        ADMINPRODUCTOS};
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

    /**
     * Clase constructor
     */
    public Empleado() {
    }
    
    /**
     * Retorna la id del empleado
     * @return la id del empleado
     */
    public int getId() {
        return id;
    }

    /**
     * Define la nueva id del empleado
     * @param id nueva id
     */
    public void setId(int id) {
        this.id = id;
    }
    
    /**
     * Retorna el nombre del empleado
     * @return nombre del empleado
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Define el nuevo nombre del empleado
     * @param nombre nuevo nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    /**
     * Retorna la informacion relevante del empleado
     * @return Informacion adicional del empleado
     */
    public String getInformacion() {
        return informacion;
    }
    
    /**
     *  Define la nueva informacion relevante para el empleado
     * @param informacion informacion relevante
     */
    public void setInformacion(String informacion) {
        this.informacion = informacion;
    }

    /**
     * Obtiene el arreglo de fechas correspondiente al horario disponible
     * @return el/los horarios disponibles
     */
    public ArrayList<Date> getHorarioDisponible() {
        return horarioDisponible;
    }

    /**
     * Define el nuevo conjunto de horarios disponibles para el empleado
     * @param horarioDisponible el/los horarios disponibles
     */
    public void setHorarioDisponible(ArrayList<Date> horarioDisponible) {
        this.horarioDisponible = horarioDisponible;
    }
    
    /**
     *  Obtiene el nombre de usuario de login para el empleado
     * @return nombre de usuario
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     *  Define el nuevo nombre de usuario para realizar un login
     * @param usuario string que define el nuevo usuario
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    
    /**
     *  Obtiene la contraseña definida para este empleado
     * @return la contraseña del empleado
     */
    public String getContrasena() {
        return contrasena;
    }
    
    /**
     * Define una nueva contraseña para el empleado a partir de un parametro 
     * @param contrasena cadena de caracteres que define la nueva contraseña
     */
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    /**
     *  Obtiene el rol del empleado
     * @return rol del empleado
     */
    public roles getRol() {
        return rol;
    }

    /**
     * Fija el nuevo rol de el empleado de una lista predefinida
     * @param rol parametro de tipo rol predefinido en una lista
     */
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
