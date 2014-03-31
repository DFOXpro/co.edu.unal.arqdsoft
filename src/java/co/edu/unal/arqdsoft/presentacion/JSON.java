/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unal.arqdsoft.presentacion;

import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

/**
 *
 * @author dfoxpro
 */
public class JSON {

    /**
     * 
     * @param request
     * @return JSONObject con los parametros del request
     * @throws Exception 
     */
    public static JSONObject toObject(HttpServletRequest request) throws Exception {
        InputStream is = request.getInputStream();
        byte[] charr = new byte[is.available()];
        is.read(charr);
        return (JSONObject) JSONValue.parse(new String(charr, "UTF-8"));
    }

    /**
     * 
     * @param arg
     * @return JSON String del ojbeto parametro
     */
    public static String toString(Respuesta arg) {
        JSONObject obj=new JSONObject();
        obj.put("error",arg.getError());
        obj.put("contenido",arg.getContenido().toJSON());
        return obj.toJSONString();
    }

    public static String getTemplate(InputStream is){
        try {
            byte[] charr = new byte[is.available()];
            is.read(charr);
            String text = new String(charr, "UTF-8");
            text = text.replace("\n", "").replace("\r", "").replace("  ", "");
            return text;
        } catch (IOException ex) {
            Logger.getLogger(JSON.class.getName()).log(Level.SEVERE, null, ex);
            return "";
        }
    }

    private static Object getServletContext() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}