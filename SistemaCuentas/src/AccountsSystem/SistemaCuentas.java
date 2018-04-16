package AccountsSystem;

import Controller.ControllerVistaPrincipal;

public class SistemaCuentas {
    public static void main(String[] args) {
        Conexion conexion = new Conexion();
        if(conexion.Conexion() != null){        //Si la conexion no es nula, entonces fue exitosa
            Controller.ControllerVistaPrincipal controllerVistaPrincipal = new ControllerVistaPrincipal();
            controllerVistaPrincipal.initInterface();
        }
    }    
}
