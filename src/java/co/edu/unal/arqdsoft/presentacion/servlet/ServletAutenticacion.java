/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unal.arqdsoft.presentacion.servlet;

import co.edu.unal.arqdsoft.presentacion.JSON;
import co.edu.unal.arqdsoft.control.ControlAutenticacion;
import co.edu.unal.arqdsoft.entidad.Empleado;
import co.edu.unal.arqdsoft.presentacion.Contenido;
import co.edu.unal.arqdsoft.presentacion.Respuesta;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.simple.JSONObject;

/**
 *
 * @author dfoxpro
 */
public class ServletAutenticacion extends HttpServlet {

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
            /*TEST*/
            //Empleado emp = null;//Si no da autorizacion
            Empleado emp = new Empleado("Pedro", "asd", null, "pedro", null, Empleado.roles.VENDEDOR,null,null,null);//Si sí da autorización
            /*TEST FIN*/
            /*CONDUCTO REGULAR*/
//            JSONObject obj = JSON.toObject(request);
//            Empleado emp = ControlAutenticacion.certificarUsuario(
//                    "" + obj.get("accion"),
//                    "" + obj.get("datos")
//            );
            /*CONDUCTO REGULAR FIN*/
            response.setContentType("application/json;charset=UTF-8");
            try (PrintWriter out = response.getWriter()) {
                Respuesta r;
                if (emp == null) {
                    r = new Respuesta("El usuario o la contraseña están mal escritas", new Contenido());
                } else {
                    String t = JSON.getTemplate(getServletContext().getResourceAsStream("/vistas/" + emp.getRol().name() + ".html"));
                    JSONObject d = new JSONObject();
                    d.put("id", emp.getId());
                    d.put("nombre", emp.getNombre());
                    d.put("rol", emp.getRol().name());
                    Contenido c = new Contenido(d, t);
                    r = new Respuesta("", c);
                }
                out.write(r.toJSON());
            } catch (Exception ex) {
                Logger.getLogger(ServletAutenticacion.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (Exception ex) {
            Logger.getLogger(ServletAutenticacion.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error con el request, no es valido:" + ex);
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
