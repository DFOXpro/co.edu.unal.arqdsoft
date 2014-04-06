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
import java.util.Objects;
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
        ADMINPRODUCTOS
    };
    
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private int id;
    private String nombre;
    private String informacion;
    private boolean disponible;
    private String usuario;
    private String contrasena;
    private roles rol; 
     /**
     * Relaciones:
     * Las relaciones de Empleado son de uno a muchos con ventas ya que un empleado puede tener muchas ventas
     * pero una venta solo tiene un empleado.
     * De igual forma un empleado puede tener muchas visitas tecnicas o reportes de daños a su nombre
     * pero cada visita y reporte de daño tienen un solo empleado a cargo.
     */ 
    @OneToMany(mappedBy = "vendedor")
    private List<Venta> ventas;
    @OneToMany(mappedBy = "operador")
    private List<ReporteDano> reportesDanos;
    @OneToMany(mappedBy = "tecnico")
    private List<VisitaTecnica> visitasTecnicas;

         /**
     * Clase constructor
     */
    public Empleado() {
    }
    
    /**
     *
     * @param nombre
     * @param informacion
     * @param disponible
     * @param usuario
     * @param contrasena
     * @param rol
     * @param ventas
     * @param visitasTecnicas
     * @param reportesDanos
     */
    public Empleado(String nombre, String informacion, boolean disponible, String usuario, String contrasena, roles rol, List<Venta> ventas, List<VisitaTecnica> visitasTecnicas, List<ReporteDano> reportesDanos) {
        this.nombre = nombre;
        this.informacion = informacion;
        this.disponible = disponible;
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.rol = rol;
        this.ventas = ventas;
        this.visitasTecnicas = visitasTecnicas;
        this.reportesDanos = reportesDanos;
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
     * 
     * @return boolean
     */
    public boolean isDisponible() {
        return disponible;
    }

    /**
     * o
     * @param disponible 
     */
    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
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

    /**
     *
     * @return
     */
    public List<Venta> getVentas() {
        return ventas;
    }

    /**
     *
     * @param ventas
     */
    public void setVentas(List<Venta> ventas) {
        this.ventas = ventas;
    }

    /**
     *
     * @return
     */
    public List<VisitaTecnica> getVisitasTecnicas() {
        return visitasTecnicas;
    }

    /**
     *
     * @param visitasTecnicas
     */
    public void setVisitasTecnicas(List<VisitaTecnica> visitasTecnicas) {
        this.visitasTecnicas = visitasTecnicas;
    }

    /**
     *
     * @return
     */
    public List<ReporteDano> getReportesDanos() {
        return reportesDanos;
    }

    /**
     *
     * @param reportesDanos
     */
    public void setReportesDanos(List<ReporteDano> reportesDanos) {
        this.reportesDanos = reportesDanos;
    }

    /**
     *
     * @return
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + this.id;
        hash = 41 * hash + Objects.hashCode(this.nombre);
        hash = 41 * hash + Objects.hashCode(this.usuario);
        hash = 41 * hash + Objects.hashCode(this.contrasena);
        hash = 41 * hash + Objects.hashCode(this.rol);
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
        final Empleado other = (Empleado) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.usuario, other.usuario)) {
            return false;
        }
        if (!Objects.equals(this.contrasena, other.contrasena)) {
            return false;
        }
        if (this.rol != other.rol) {
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
        return "Empleado{" + "id=" + id + ", nombre=" + nombre + ", informacion=" + informacion + ", disponible=" + disponible + ", usuario=" + usuario + ", contrasena=" + contrasena + ", rol=" + rol + ", ventas=" + ventas + ", visitasTecnicas=" + visitasTecnicas + ", reportesDanos=" + reportesDanos + '}';
    }

}
