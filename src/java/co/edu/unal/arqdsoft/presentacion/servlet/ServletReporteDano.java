/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unal.arqdsoft.presentacion.servlet;

import co.edu.unal.arqdsoft.presentacion.*;
import co.edu.unal.arqdsoft.control.*;
import co.edu.unal.arqdsoft.dao.*;
import co.edu.unal.arqdsoft.entidad.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 *
 * @author dmlr
 */
@WebServlet(name = "ServletReporteDano", urlPatterns = {"/ServletReporteDano"})
public class ServletReporteDano extends HttpServlet {

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
            if (obj.get("accion").equals("getCliente")) {
                r = buscarTecnico(obj);
            } else if (obj.get("accion").equals("setventa")) {
                r = crearVisistaTecnica(obj);
            } else if (obj.get("accion").equals("setventa")) {
                r = crearRporteDano(obj);
            } else if (obj.get("accion").equals("setventa")) {
                r = getReporte(obj);
            } else if (obj.get("accion").equals("setventa")) {
                r =  modificarVisitaTecnica(obj);
            } else if (obj.get("accion").equals("setventa")) {
                r = modificarReporteDano(obj);
            } else if (obj.get("accion").equals("setventa")) {
                r = tiempoTecnicos(obj);
            } else if (obj.get("accion").equals("setventa")) {
                r = visitas(obj);
            } else {
                r = new Respuesta("Error de comunicación", new Contenido());
            }// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
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
// </editor-fold>
    }

    private Respuesta buscarTecnico(JSONObject obj) {
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

    private Respuesta tiempoTecnicos(JSONObject obj) {
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

    private Respuesta visitas(JSONObject obj) {
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

    private Respuesta crearVisistaTecnica(JSONObject obj) {
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

    private Respuesta crearRporteDano(JSONObject obj) {
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

    private Respuesta modificarReporteDano(JSONObject obj) {
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

    private Respuesta modificarVisitaTecnica(JSONObject obj) {
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

    private Respuesta getReporte(JSONObject obj) {
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

}