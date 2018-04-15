package AccountsSystem;

import Model.Cliente;
import Model.Cuenta;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class Conexion {
    ResultSet rs;
    private Connection conn;
    
    public Connection Conexion() {
        try {
            Class.forName("org.postgresql.Driver");
            this.conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/P1_Pruebas","postgres","12345678");
            System.out.println("Opened database SistemaCuentas successfully");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error en Conexion: " + e);
            JOptionPane.showMessageDialog(null, "El usuario o contraseña no se encontraron en la base de datos: ", "Datos no encontrados", JOptionPane.ERROR_MESSAGE);   
        }
        return conn;
    }
    
    public boolean CrearCuenta(Cuenta cuenta, Timestamp fechaApertura){ //String tipoCuenta, String tipoMoneda, Timestamp fechaApertura, Float tasaInteres, Cuenta cuenta){
        String Cuenta = cuenta.getTipoCuenta().toString();
        String Moneda = cuenta.getTipoMoneda().toString();
        Timestamp fecha = fechaApertura;
        Float tasaInteres = cuenta.getTasaInteres();
        return true;
    }
    
    public boolean CrearUsuario(Cliente cliente){//String cedula, String nombre, String apellidos){
        int cedulta = cliente.getCedula();
        String nombre = cliente.getNombre();
        String apellidos = cliente.getApellido();
        return true;
    }  
    
    public ArrayList<ArrayList<String>> ListarUsuarios(){
        ArrayList<String> result = new ArrayList<String>();
        ArrayList<ArrayList<String>> resultOut = new ArrayList<ArrayList<String>>();
        
        return resultOut;
    }
    
    public ArrayList<ArrayList<String>> ListarCuentas(){
        ArrayList<String> result = new ArrayList<String>();
        ArrayList<ArrayList<String>> resultOut = new ArrayList<ArrayList<String>>();
        
        return resultOut;
    }
    
    public ArrayList<ArrayList<String>> ListarMovimientos(){
        ArrayList<String> result = new ArrayList<String>();
        ArrayList<ArrayList<String>> resultOut = new ArrayList<ArrayList<String>>();
        
        return resultOut;
    }
    
    public void Credito(Float monto){
    
    }
    
    public void Debito(Float monto){
    
    }
    
    public void GenerarRegistro(){
        
    }
    
    public void CobrarComision(){
        
    }
    
    public void PagoInteres(){
    
    }
}
