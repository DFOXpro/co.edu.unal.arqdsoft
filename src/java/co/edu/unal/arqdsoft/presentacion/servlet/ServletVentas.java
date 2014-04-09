/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unal.arqdsoft.presentacion.servlet;

import co.edu.unal.arqdsoft.control.*;
import co.edu.unal.arqdsoft.entidad.*;
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
                r = getCliente(obj);
            } else if (obj.get("accion").equals("setVenta")) {
                r = setVenta(obj);
            } else {
                r = new Respuesta("Error de comunicación", new Contenido());
            }
            response.setContentType("application/json;charset=UTF-8");
            try (PrintWriter out = response.getWriter()) {
                out.write(r.toJSON());
            } catch (Exception ex) {
                Logger.getLogger(ServletProductos.class.getName()).log(Level.SEVERE, null, ex);
            }// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
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
            }//</editor-fold>
        }

    }


    private Respuesta getCliente(JSONObject obj) {
        String error = "Problemas con la comunicación";
        try {
            int idCliente = Integer.parseInt(obj.get("datos").toString());
            Cliente cliente = ControlVentas.getcliente(idCliente);

            /*TEST*/
            //Cliente p = new Cliente(0, "Telefono", "muy comunicativo", null, null);
            /*TEST FIN*/
            if (cliente != null) {
                JSONObject t = new JSONObject();
                t.put("nombre", cliente.getNombre());
                t.put("id", cliente.getId());
                t.put("informacion", cliente.getInformacion());
                return new Respuesta("", new Contenido(t, ""));
            } else {
                error = "No existe el cliente";//ERROR de SEGURIDAD
                throw new SecurityException(obj.get("datos").toString());
            }
        } catch (Exception ex) {
            Logger.getLogger(ServletProductos.class.getName()).log(Level.SEVERE, null, ex);
            return new Respuesta(error, new Contenido());
        }
    }

    private Respuesta setVenta(JSONObject ventaJson) {
        String error = "Problemas con la comunicación";
        try {
            ventaJson = (JSONObject) JSONValue.parse(ventaJson.get("datos").toString());

            int idEmpleado = Integer.parseInt(ventaJson.get("empleado").toString());
            int idPlan = Integer.parseInt(ventaJson.get("plan").toString());
            String direccionVenta = ventaJson.get("dirInstal").toString();
            int idCliente = 0;
            String nombreCliente = "";
            String informacionCliente = "";
            try {
                JSONObject clienteJson = (JSONObject) JSONValue.parse(ventaJson.get("cliente").toString());
                idCliente = Integer.parseInt(clienteJson.get("id").toString());
                nombreCliente = clienteJson.get("nombre").toString();
                informacionCliente = clienteJson.get("informacion").toString();
            } catch (Exception e) {
                error = "Problemas con el cliente";
            }
            boolean respuesta = ControlVentas.setVenta(idEmpleado, idCliente, nombreCliente,
                    informacionCliente, idPlan, direccionVenta);
            /*TEST*/
//        respuesta = true;
//        respuesta = false;
            /*TEST FIN*/

            if (respuesta) {
//                t.put("nombre", p.getCliente().getNombre());
//                t.put("id", p.getId());
//                t.put("informacion", p.getCliente().getInformacion());
//                t.put("empleado", p.getVendedor().getId());
//                t.put("plan", p.getPlan());
//                t.put("dirInstal", p.getDireccionInstalacion());
                return new Respuesta("", new Contenido(null, "Venta realizada exitosamente"));
            } else {
                error = "No se realizó la venta";
                throw new Exception();
            }
        } catch (Exception ex) {
            Logger.getLogger(ServletProductos.class.getName()).log(Level.SEVERE, null, ex);
            return new Respuesta(error, new Contenido());
        }
    }


    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}
