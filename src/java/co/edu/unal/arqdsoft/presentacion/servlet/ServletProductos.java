/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unal.arqdsoft.presentacion.servlet;

import co.edu.unal.arqdsoft.control.ControlProductos;
import co.edu.unal.arqdsoft.entidad.Plan;
import co.edu.unal.arqdsoft.entidad.Producto;
import co.edu.unal.arqdsoft.presentacion.Contenido;
import co.edu.unal.arqdsoft.presentacion.JSON;
import co.edu.unal.arqdsoft.presentacion.Respuesta;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

/**
 *
 * @author dfoxpro
 */
public class ServletProductos extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            JSONObject obj = JSON.toObject(request);
            Respuesta r;
            if (obj.get("accion").equals("listarProductos")) {
                r = listarProductos();
            } else if (obj.get("accion").equals("getProducto")) {
                r = getProducto(obj);
            } else if (obj.get("accion").equals("setProducto")) {
                r = setProducto(obj);//Crear y Actualizar
            } else if (obj.get("accion").equals("borrarProducto")) {
                r = borrarProducto(obj);
            } else if (obj.get("accion").equals("listarPlanes")) {
                r = listarPlanes();
            } else if (obj.get("accion").equals("getPlan")) {
                r = getPlan(obj);
            } else if (obj.get("accion").equals("setPlan")) {
                r = setPlan(obj);
            } else if (obj.get("accion").equals("borrarPlanes")) {
                r = borrarPlan(obj);
            } else {
                r = new Respuesta("Error de comunicación", new Contenido());
            }

            response.setContentType("application/json;charset=UTF-8");
            try (PrintWriter out = response.getWriter()) {
                out.write(r.toJSON());
            } catch (Exception ex) {
                Logger.getLogger(ServletProductos.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (Exception ex) {
            Logger.getLogger(ServletProductos.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error con el request, no es valido:" + ex);

            response.setContentType("application/json;charset=UTF-8");
            try (PrintWriter out = response.getWriter()) {
                out.write(
                        new Respuesta("Error de comunicación", new Contenido()).toJSON()
                );
            } catch (Exception ex1) {
                Logger.getLogger(ServletProductos.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private Respuesta listarProductos() {
        //ArrayList<Producto> prdts = ControlProductos.getProductos();
        /*TEST*/
        ArrayList<Producto> prdts = new ArrayList();
        prdts.add(new Producto("Telefono", null, 0));
        prdts.add(new Producto("Internet", null, 0));
        prdts.add(new Producto("PBX", null, 0));
        /*TEST FIN*/
        JSONArray list = new JSONArray();
        for (Producto temp : prdts) {
            JSONObject t = new JSONObject();
            t.put("nombre", temp.getNombre());
            t.put("id", temp.getId());
            list.add(t);
        }
        return new Respuesta("", new Contenido(list, ""));
    }

    private Respuesta getProducto(JSONObject obj) {
        String error = "Problemas con la comunicación";
        try {
            //Producto p = ControlProductos.getProducto((int) obj.get("datos"));
            /*TEST*/
            Producto p = new Producto("Telefono", "muy comunicativo", 18000);
            p.setId(123);
            /*TEST FIN*/
            if (p != null) {
                JSONObject t = new JSONObject();
                t.put("nombre", p.getNombre());
                t.put("id", p.getId());
                t.put("descripcion", p.getDescripcion());
                t.put("valor", p.getValor());
                return new Respuesta("", new Contenido(t, ""));
            } else {
                error = "No existe el producto, no debería de pasar, no sea curioso";//ERROR de SEGURIDAD
                throw new SecurityException(obj.get("datos").toString());
            }
        } catch (Exception ex) {
            Logger.getLogger(ServletProductos.class.getName()).log(Level.SEVERE, null, ex);
            return new Respuesta(error, new Contenido());
        }
    }

    private Respuesta setProducto(JSONObject obj) {
        String error = "Problemas con la comunicación";
        try {
            obj = (JSONObject) JSONValue.parse(obj.get("datos").toString());
            Producto p = ControlProductos.setProducto(
                    Integer.parseInt(obj.get("id").toString()),
                    obj.get("nombre").toString(),
                    obj.get("descripcion").toString(),
                    obj.get("valor").toString());
            /*TEST*/
//            p = new Producto(obj.get("nombre").toString(), obj.get("descripcion").toString(), 100);//Si se guardó
//            p = null;//Si NO se guardó
            /*TEST FIN*/

            p.setId(4321);
            if (p != null) {
                JSONObject t = new JSONObject();
                t.put("nombre", p.getNombre());
                t.put("id", p.getId());
                t.put("descripcion", p.getDescripcion());
                t.put("valor", p.getValor());
                return new Respuesta("", new Contenido(t, ""));
            } else {
                error = "No se creó el producto";
                throw new Exception();
            }
        } catch (Exception ex) {
            Logger.getLogger(ServletProductos.class.getName()).log(Level.SEVERE, null, ex);
            return new Respuesta(error, new Contenido());
        }
    }

    private Respuesta borrarProducto(JSONObject obj) {
        String error = "Problemas con la comunicación";
        try {
            //boolean p = ControlProductos.borrarProducto((int) obj.get("datos"));
            /*TEST*/
            boolean p = true;
            //boolean p = false;
            /*TEST FIN*/
            if (p) {
                return new Respuesta("", new Contenido());
            } else {
                error = "No se pudo borrar el producto.";//ERROR de SEGURIDAD ?
                throw new SecurityException(obj.get("datos").toString());
            }
        } catch (Exception ex) {
            Logger.getLogger(ServletProductos.class.getName()).log(Level.SEVERE, null, ex);
            return new Respuesta(error, new Contenido());
        }
    }

    private Respuesta listarPlanes() {
        //ArrayList<Producto> prdts = ControlProductos.getProductos();
        /*TEST*/
        ArrayList<Plan> planes = new ArrayList();
        planes.add(new Plan("Plan A", null, 0, null));
        planes.add(new Plan("Plan Telefono", null, 0, null));
        planes.add(new Plan("Plan dadaese", null, 0, null));
        planes.add(new Plan("Plan datos", null, 0, null));
        /*TEST FIN*/
        JSONArray list = new JSONArray();
        for (Plan temp : planes) {
            JSONObject t = new JSONObject();
            t.put("nombre", temp.getNombre());
            t.put("id", temp.getId());
            list.add(t);
        }
        return new Respuesta("", new Contenido(list, ""));
    }

    private Respuesta getPlan(JSONObject obj) {
        String error = "Problemas con la comunicación";
        try{
            //Producto p = ControlProductos.getProducto((int) obj.get("datos"));
            /*TEST*/
            ArrayList<Producto> pr= new ArrayList<Producto>();
            pr.add(new Producto("Telefono", null, 0));
            pr.add(new Producto("Internet", null, 0));
            pr.get(0).setId(123);
            pr.get(1).setId(465);
            Plan p = new Plan("TelefonoASD", "muy comunicativo", 18000,pr);
            p.setId(123);
            /*TEST FIN*/
            if(p != null){
                JSONObject t = new JSONObject();
                t.put("nombre", p.getNombre());
                t.put("id", p.getId());
                t.put("descripcion", p.getDescripcion());
                t.put("valor", p.getValor());
                JSONArray list = new JSONArray();
                for (Producto temp : pr) {
                    JSONObject t1 = new JSONObject();
                    t1.put("nombre", temp.getNombre());
                    t1.put("id", temp.getId());
                    list.add(t1);
                }
                t.put("productos", list);
                return new Respuesta("", new Contenido(t, ""));
            }else{
                error = "No existe el producto, no debería de pasar, no sea curioso";//ERROR de SEGURIDAD
                throw new SecurityException(obj.get("datos").toString());
            }
        } catch(Exception ex){
            Logger.getLogger(ServletProductos.class.getName()).log(Level.SEVERE, null, ex);
            return new Respuesta(error, new Contenido());
        }
    }

    private Respuesta setPlan(JSONObject obj) {
        String error = "Problemas con la comunicación";
        try{
            obj = (JSONObject)JSONValue.parse(obj.get("datos").toString());
            JSONArray ja = (JSONArray) obj.get("productos");
            ArrayList<Producto> ar = new ArrayList<>();
            for(int i = 0; i<ja.size();i++){
                JSONObject t = (JSONObject)ja.get(i);
                ar.add(new Producto(t.get("nombre").toString(), null, 0));
                ar.get(i).setId((int)t.get("id"));
            }
            Plan p = ControlProductos.setPlan(
                Integer.parseInt(obj.get("id").toString()),
                obj.get("nombre").toString(),
                obj.get("descripcion").toString(),
                obj.get("valor").toString(),
                ar
            );
            /*TEST*/
//            p = new Producto(obj.get("nombre").toString(), obj.get("descripcion").toString(), 100);//Si se guardó
//            p = null;//Si NO se guardó
            /*TEST FIN*/

            p.setId(4321);
            if(p != null){
                JSONObject t = new JSONObject();
                t.put("nombre", p.getNombre());
                t.put("id", p.getId());
                t.put("descripcion", p.getDescripcion());
                t.put("valor", p.getValor());
                return new Respuesta("", new Contenido(t, ""));
            }else{
                error = "No se creó el producto";
                throw new Exception();
            }
        } catch(Exception ex){
            Logger.getLogger(ServletProductos.class.getName()).log(Level.SEVERE, null, ex);
            return new Respuesta(error, new Contenido());
        }
    }

    private Respuesta borrarPlan(JSONObject obj) {
        String error = "Problemas con la comunicación";
        try {
            //boolean p = ControlProductos.borrarPlan((int) obj.get("datos"));
            /*TEST*/
            boolean p = true;
            //boolean p = false;
            /*TEST FIN*/
            if (p) {
                return new Respuesta("", new Contenido());
            } else {
                error = "No se pudo borrar el producto.";//ERROR de SEGURIDAD ?
                throw new SecurityException(obj.get("datos").toString());
            }
        } catch (Exception ex) {
            Logger.getLogger(ServletProductos.class.getName()).log(Level.SEVERE, null, ex);
            return new Respuesta(error, new Contenido());
        }
    }
}
