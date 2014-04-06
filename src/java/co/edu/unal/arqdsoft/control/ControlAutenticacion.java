    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unal.arqdsoft.control;

import co.edu.unal.arqdsoft.dao.*;
import co.edu.unal.arqdsoft.entidad.*;

/**
 *
 * @author dmlr
 */
public class ControlAutenticacion {

    /**
     * Comprueba que el usuario que esta ingresando exista en la base de datos.
     *
     * @param usuario usuario a comprobar
     * @param contraseña la contraseña del usuario
     * @return retornara el empleado logeado o null de no existir el usuario
     */
    public static Empleado certificarUsuario(String usuario, String contraseña) {
        if (usuario==null && contraseña==null) {
            return null;
        }
        Empleado a = DaoEmpleado.login(usuario, contraseña);
        if (a == null) {
            return null;
        }
        a.setUsuario(null);
        a.setContrasena(null);
        return a;
    }
}
