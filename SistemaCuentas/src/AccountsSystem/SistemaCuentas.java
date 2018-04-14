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
        ControllerVistaPrincipal controladorVistaPrincipal = new ControllerVistaPrincipal();//.getSingletonInstance();
        controladorVistaPrincipal.initInterface();
    }
    
}
