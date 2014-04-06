/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unal.arqdsoft.presentacion.servlet;

import co.edu.unal.arqdsoft.control.ControlProductos;
import co.edu.unal.arqdsoft.entidad.Cliente;
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
@WebServlet(name = "ServletVentas", urlPatterns = {"/ventas"})
public class ServletVentas extends HttpServlet {

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
                r = getClientes(obj);
            } else if (obj.get("accion").equals("setCliente")) {
                r = setVenta(obj);
            }
            else if (obj.get("accion").equals("listaVentas")) {
                r = listarVentas();
            } else if (obj.get("accion").equals("getVentas")) {
                r = getVenta(obj);
            } else if (obj.get("accion").equals("setVentas")) {
                r = setVenta(obj);
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

    private Respuesta listarClientes() {
        //ArrayList<Cliente> clnts = Control.getProductos();
        /*TEST*/
        ArrayList<Cliente> clnts = new ArrayList();
        clnts.add(new Cliente(0,"Cliente A", "Direccion falsa 123", null, null));
        clnts.add(new Cliente(1,"Cliente B", "Direccion falsa 123", null, null));
        clnts.add(new Cliente(2,"Cliente C", "Direccion falsa 123", null, null));
        /*TEST FIN*/
        JSONArray list = new JSONArray();
        for (Cliente temp : clnts) {
            JSONObject t = new JSONObject();
            t.put("nombre", temp.getNombre());
            t.put("id", temp.getId());
            list.add(t);
        }
        return new Respuesta("", new Contenido(list, ""));
    }
    private Respuesta crearCliente(JSONObject obj) {
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

    private Respuesta getCliente(JSONObject obj) {
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

    private Respuesta setVenta(JSONObject obj) {
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

    private Respuesta getClientes(JSONObject obj) {
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
