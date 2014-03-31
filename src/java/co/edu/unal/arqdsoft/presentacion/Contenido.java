/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.unal.arqdsoft.presentacion;

import co.edu.unal.arqdsoft.entidad.Empleado;
import java.util.Objects;

/**
 *
 * @author dfoxpro
 */
public class Contenido {
    private Empleado usuario;
    private String section;

    public Contenido(Empleado usuario, String section) {
        this.usuario = usuario;
        this.usuario.setContrasena(null);
        this.usuario.setHorarioDisponible(null);
        this.usuario.setInformacion(null);
        this.section = section;
    }
    public Contenido() {
        this.usuario = new Empleado();
        this.usuario.setNombre("");
        this.usuario.setId(0);
        this.usuario.setRol(Empleado.roles.VENDEDOR);
        this.section = "";
    }

    public Empleado getUsuario() {
        return usuario;
    }

    public void setUsuario(Empleado usuario) {
        this.usuario = usuario;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.usuario);
        hash = 97 * hash + Objects.hashCode(this.section);
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
        final Contenido other = (Contenido) obj;
        if (!Objects.equals(this.usuario, other.usuario)) {
            return false;
        }
        if (!Objects.equals(this.section, other.section)) {
            return false;
        }
        return true;
    }

    public String toJSON() {
        return 
            "{" +
                "\"usuario\":{" +
                    "\"nombre\":\""+usuario.getNombre() +
                    "\",\"id\":\"" + usuario.getId() +
                    "\", \"rol\":\"" + usuario.getRol().name() +
                "\"}, \"section\":\"" + section + "\"}";
    }
}