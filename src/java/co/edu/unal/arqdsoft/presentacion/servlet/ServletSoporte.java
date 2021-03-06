/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unal.arqdsoft.presentacion.servlet;

import co.edu.unal.arqdsoft.control.ControlSoporte;
import co.edu.unal.arqdsoft.entidad.VisitaTecnica;
import co.edu.unal.arqdsoft.presentacion.Contenido;
import co.edu.unal.arqdsoft.presentacion.JSON;
import co.edu.unal.arqdsoft.presentacion.Respuesta;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

/**
 *
 * @author dmlr
 */
@WebServlet(name = "ServletReporteDano", urlPatterns = {"/soporte"})
public class ServletSoporte extends HttpServlet {

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
            /*if (obj.get("accion").equals("getCliente")) {
             r = buscarTecnico(obj);
             } else*/ if (obj.get("accion").equals("setventa")) {
                r = crearVisistaTecnica(obj);
            } else if (obj.get("accion").equals("setSoporte")) {
                r = crearReporteDano(obj);
            } else if (obj.get("accion").equals("getReporte")) {
                r = getReporte(obj);
            } else if (obj.get("accion").equals("modificarVisitaTecnica")) {
                r = modificarVisitaTecnica(obj);
            } else if (obj.get("accion").equals("modificarReporteDaño")) {
                r = modificarReporteDano(obj);
            } else if (obj.get("accion").equals("tiempoTecnicos")) {
                r = tiempoTecnicos(obj);
            } else if (obj.get("accion").equals("visitas")) {
                r = visitas(obj);
            } else if (obj.get("accion").equals("visitarPorEmpleado")) {
                r = visitasPorEmpleado(obj);
            } else if (obj.get("accion").equals("visitasPorReporte")) {
                r = visitasPorReporte(obj);
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

//    private Respuesta buscarTecnico(JSONObject obj) {
//        //ArrayList<Producto> prdts = ControlProductos.getProductos();
//        /*TEST*
//         /*TEST FIN*/
////        int idTecnico = Integer.parseInt(obj.get("datos").toString());
////        Empleado tecnico = ControlSoporte.buscarTecnico(idTecnico);
////        JSONObject t = new JSONObject();
////        if (tecnico != null) {
////            t.put("id", tecnico.getId());
////            t.put("nombre", tecnico.getNombre());
////            t.put("informacion", tecnico.getInformacion());
////        }
////
////        return new Respuesta("wii?", new Contenido(t, ""));
//    }
    private Respuesta tiempoTecnicos(JSONObject obj) {
        //ArrayList<Producto> prdts = ControlProductos.getProductos();
        /*TEST*/
        JSONObject t = new JSONObject();

        return new Respuesta("not implemented", new Contenido(t, ""));
    }

    private Respuesta visitas(JSONObject obj) {
        List<VisitaTecnica> vT = ControlSoporte.visitas();
        JSONArray list = new JSONArray();
        for (VisitaTecnica temp : vT) {
            JSONObject t = new JSONObject();
            t.put("fechavisita", temp.getFechaVisita());
            t.put("cliente", temp.getReporte().getCliente());
            t.put("direccion", temp.getDireccion());
            t.put("id", temp.getId());
            list.add(t);
        }
        return new Respuesta("", new Contenido(list, ""));
    }

    private Respuesta visitasPorEmpleado(JSONObject obj) {
        List<VisitaTecnica> vT = ControlSoporte.visitasPorEmpleado(Integer.valueOf(obj.get("id").toString()));
        JSONArray list = new JSONArray();
        for (VisitaTecnica temp : vT) {
            JSONObject t = new JSONObject();
            t.put("fechavisita", temp.getFechaVisita());
            t.put("cliente", temp.getReporte().getCliente());
            t.put("direccion", temp.getDireccion());
            t.put("id", temp.getId());
            list.add(t);
        }
        return new Respuesta("", new Contenido(list, ""));
    }

    private Respuesta visitasPorReporte(JSONObject obj) {
        List<VisitaTecnica> vT = ControlSoporte.visitas(Integer.valueOf(obj.get("id").toString()));
        JSONArray list = new JSONArray();
        for (VisitaTecnica temp : vT) {
            JSONObject t = new JSONObject();
            t.put("fechavisita", temp.getFechaVisita());
            t.put("cliente", temp.getReporte().getCliente());
            t.put("direccion", temp.getDireccion());
            t.put("id", temp.getId());
            list.add(t);
        }
        return new Respuesta("", new Contenido(list, ""));
    }

    private Respuesta crearVisistaTecnica(JSONObject obj) {

        JSONObject t = new JSONObject();

        return new Respuesta("not implemented", new Contenido(t, ""));
    }

    private Respuesta crearReporteDano(JSONObject obj) {
        JSONObject datos = (JSONObject) JSONValue.parse(obj.get("datos").toString());
        long idCliente = Long.parseLong(datos.get("cliente").toString());
        int idOperador = Integer.parseInt(datos.get("operador").toString());;
        boolean enviaTecnico = Boolean.valueOf(datos.get("enviaTecnico").toString());
        Date fechatecnico = null;
        boolean solucion = Boolean.valueOf(datos.get("solucion").toString());
        try {
            if(!solucion)
            fechatecnico = new SimpleDateFormat("dd/mm/yy").parse(datos.get("fechaTecnico").toString());
        } catch (ParseException ex) {
            Logger.getLogger(ServletSoporte.class.getName()).log(Level.SEVERE, null, ex);
        }
        String info = datos.get("info").toString();
        String direccion = datos.get("direccion").toString();
        int respuestaControl = ControlSoporte.crearReporteDano(
            idCliente,
            info,
            idOperador,
            solucion,
            enviaTecnico,
            direccion,
            fechatecnico
        );
        if(
            respuestaControl
            <= 0
        ) return new Respuesta("Error de servidor: "+respuestaControl, new Contenido(null, ""));
//        return new Respuesta("not implemented", new Contenido(t, ""));
        return new Respuesta("Reporte creado con exito", new Contenido(null, ""));
    }

    private Respuesta modificarReporteDano(JSONObject obj) {

        JSONObject t = new JSONObject();

        return new Respuesta("not implemented", new Contenido(t, ""));
    }

    private Respuesta modificarVisitaTecnica(JSONObject obj) {

        JSONObject t = new JSONObject();

        return new Respuesta("not implemented", new Contenido(t, ""));
    }

    private Respuesta getReporte(JSONObject obj) {
        int id = Integer.valueOf(obj.get("id").toString());
        JSONObject t = new JSONObject();
        t.put("Reporte", ControlSoporte.getReporte(id));

        return new Respuesta("not implemented", new Contenido(t, ""));
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
