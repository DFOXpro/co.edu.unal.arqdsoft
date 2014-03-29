/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unal.arqdsoft.control;
import co.edu.unal.arqdsoft.dao.*;

/**
 *
 * @author dmlr
 */
public class Autenticacion {

    //TODO/**
    /**
     * Comprueba que el usuario que esta ingresando 
     * exista en la base de datos.
     * 
     * @param usuario usuario a comprobar
     * @param contraseña la contraseña del usuario
     * @return esUsuario devuelve true en caso de ser usario, false de no serlo
     */
    public boolean CetificarUsuario(String usuario, String contraseña) {
        boolean esUsuario=false;
        
        Empleado a=Empleado.Buscar(usuario);
        if(contraseña.equals(a.contraseña)){
            return true;
        }
                      
        return false;
        
    }
}
