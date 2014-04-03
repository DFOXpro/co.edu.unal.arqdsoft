/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.unal.arqdsoft.presentacion;

import java.util.Objects;

/**
 *
 * @author dfoxpro
 */
public class Respuesta {
    private String error;
    private Contenido contenido;

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public Contenido getContenido() {
        return contenido;
    }

    public void setContenido(Contenido contenido) {
        this.contenido = contenido;
    }

    public Respuesta(String error, Contenido contenido) {
        this.error = error;
        this.contenido = contenido;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + Objects.hashCode(this.error);
        hash = 37 * hash + Objects.hashCode(this.contenido);
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
        final Respuesta other = (Respuesta) obj;
        if (!Objects.equals(this.error, other.error)) {
            return false;
        }
        if (!Objects.equals(this.contenido, other.contenido)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Respuesta{" + "error=" + error + ", contenido=" + contenido + '}';
    }

    public String toJSON() {
        String s = "{\"error\":\""+ error +
            "\",\"contenido\":" + contenido.toJSON()+
            "}";
        System.out.println(s);
        return s;
    }
}