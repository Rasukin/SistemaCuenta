/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccountsSystem;

import Controller.ControllerVistaPrincipal;

public class SistemaCuentas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Conexion conexion = new Conexion();
        if(conexion.Conexion() != null){        //Si la conexion no es nula, entonces fue exitosa
            Controller.ControllerVistaPrincipal controllerVistaPrincipal = new ControllerVistaPrincipal();
            controllerVistaPrincipal.initInterface();
        }
    }    
}
