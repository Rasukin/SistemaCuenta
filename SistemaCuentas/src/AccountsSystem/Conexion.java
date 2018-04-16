package AccountsSystem;

import Model.Cliente;
import Model.Cuenta;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class Conexion {
    ResultSet rs;
    private Connection conn;
    
    public Connection Conexion() {
        try {
            Class.forName("org.postgresql.Driver");
            this.conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/SistemaCuentas","postgres","postgrespsw");
            System.out.println("Opened database SistemaCuentas successfully");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error en Conexion: " + e);
            JOptionPane.showMessageDialog(null, "El usuario o contraseña no se encontraron en la base de datos: ", "Datos no encontrados", JOptionPane.ERROR_MESSAGE);   
        }
        return conn;
    }
    
    public Conexion(){
        try {
            Class.forName("org.postgresql.Driver");
            this.conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/SistemaCuentas","postgres","postgrespsw");
        } catch (ClassNotFoundException | SQLException e) {
        }    
    }
    
    public boolean CrearCliente(Cliente cliente){
        String cedula = cliente.getCedula();
        String nombre = cliente.getNombre();
        String apellidos = cliente.getApellido();
        try {            
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM crearcliente(?,?,?)");
            pstmt.setString(1, cedula);
            pstmt.setString(2, nombre);
            pstmt.setString(3, apellidos);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {  
                System.out.println("Cliente añadido a base de datos");
                return true;
            }
        } catch (SQLException ex) {
            System.out.println("Error en CrearCliente: " + ex);
        }        
        return false;
    }
    
    public boolean CrearCuenta(Cuenta cuenta, int idCliente, float valorComision, int limiteTransaccion){
        String Cuenta = cuenta.getTipoCuenta().toString();
        String moneda = cuenta.getTipoMoneda().toString();
        Timestamp fecha = cuenta.getFechaApertura();
        Float tasaInteres = cuenta.getTasaInteres();
        try {            
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM crearcuenta(?,?,?,?,?,?,?)");
            pstmt.setString(1, Cuenta);
            pstmt.setString(2, moneda);
            pstmt.setTimestamp(3, fecha);
            pstmt.setFloat(4, tasaInteres);
            pstmt.setInt(5, idCliente);
            pstmt.setFloat(6, valorComision);
            pstmt.setInt(7, limiteTransaccion);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {  
                System.out.println("Cuenta añadida a base de datos");
                return true;
            }
        } catch (SQLException ex) {
            System.out.println("Error en CrearCuenta: " + ex);
        }        
        return false;      
    }      
    
    public ArrayList<Cliente> ListarUsuarios(){
        ArrayList<Cliente> result = new ArrayList<Cliente>();
        //ArrayList<ArrayList<String>> resultOut = new ArrayList<ArrayList<String>>();
        
        return result;
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
