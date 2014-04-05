/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.unal.arqdsoft.presentacion;

import java.util.Objects;
import org.json.simple.JSONArray;
import org.json.simple.JSONAware;
import org.json.simple.JSONObject;

/**
 *
 * @author dfoxpro
 */
public class Contenido {
    private JSONAware dato;
    private String html;

    /**
     *
     * @param dato
     * @param section
     */
    public Contenido(JSONAware dato, String section) {
        this.dato = dato;
        this.html = section;
    }

    /**
     *
     */
    public Contenido() {
        this.dato = new JSONObject();
        this.html = "";
    }

    /**
     *
     * @return
     */
    public JSONAware getDato() {
        if(dato instanceof JSONObject) return (JSONObject) dato;
        if(dato instanceof JSONArray) return (JSONArray) dato;
        return null;
    }

    /**
     *
     * @param dato
     */
    public void setDato(JSONAware dato) {
        this.dato = dato;
    }

    /**
     *
     * @return
     */
    public String getHtml() {
        return html;
    }

    /**
     *
     * @param html
     */
    public void setHtml(String html) {
        this.html = html;
    }

    /**
     *
     * @return
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.dato);
        hash = 97 * hash + Objects.hashCode(this.html);
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
        final Contenido other = (Contenido) obj;
        if (!Objects.equals(this.dato, other.dato)) {
            return false;
        }
        if (!Objects.equals(this.html, other.html)) {
            return false;
        }
        return true;
    }

    /**
     *
     * @return
     */
    public String toJSON() {
        if(dato != null)
        return 
            "{\"dato\":" +dato.toJSONString()+",\"html\":\"" + html + "\"}";
        else return
            "{\"html\":\"" + html + "\"}";
    }
}