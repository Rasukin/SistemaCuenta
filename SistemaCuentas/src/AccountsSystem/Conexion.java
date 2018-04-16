package AccountsSystem;

import Model.Cliente;
import Model.Cuenta;
import Model.CuentaAhorro;
import Model.CuentaCorriente;
import Model.Movimiento;
import Model.TipoMovimiento;
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
            this.conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Subasta_DB","postgres","postgres");
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
            this.conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Subasta_DB","postgres","postgres");
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
    
    public boolean CrearCuentaAhorro(CuentaAhorro cuentaAhorro, int idCliente){
        String Cuenta = cuentaAhorro.getTipoCuenta().toString();
        String moneda = cuentaAhorro.getTipoMoneda().toString();
        Timestamp fecha = cuentaAhorro.getFechaApertura();
        Float tasaInteres = cuentaAhorro.getTasaInteres();
        Float valorComision = cuentaAhorro.getValorComision();
        try {            
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM crearcuenta(?,?,?,?,?,?,?)");
            pstmt.setString(1, Cuenta);
            pstmt.setString(2, moneda);
            pstmt.setTimestamp(3, fecha);
            pstmt.setFloat(4, tasaInteres);
            pstmt.setInt(5, idCliente);
            pstmt.setFloat(6, valorComision);
            pstmt.setInt(7, -1);
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

    public boolean CrearCuentaCorriente(CuentaCorriente cuenta, int idCliente){
        String Cuenta = cuenta.getTipoCuenta().toString();
        String moneda = cuenta.getTipoMoneda().toString();
        Timestamp fecha = cuenta.getFechaApertura();
        Float tasaInteres = cuenta.getTasaInteres();
        int limiteTransaccion = cuenta.getLimiteTransaccion();
        try {            
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM crearcuenta(?,?,?,?,?,?,?)");
            pstmt.setString(1, Cuenta);
            pstmt.setString(2, moneda);
            pstmt.setTimestamp(3, fecha);
            pstmt.setFloat(4, tasaInteres);
            pstmt.setInt(5, idCliente);
            pstmt.setFloat(6, -1);
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
        try {
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM listarclientes()");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Cliente cliente = new Cliente(rs.getInt(1),rs.getString(2),rs.getString(3), rs.getString(4));
                result.add(cliente);
            }
        } catch (SQLException ex) {
            System.out.println("Error en Listarusuarios: " + ex);
        }
        return result;
    }
    
    public  ArrayList<ArrayList<String>> ListarCuentas(int idCliente){
        ArrayList<ArrayList<String>> resultOut = new ArrayList<ArrayList<String>>();
        ArrayList<String> result = new ArrayList<String>();        
        try {
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM listarcuentas(?)");
            pstmt.setInt(1, idCliente);
            ResultSet rs = pstmt.executeQuery();
            int valor = 1;
            while (rs.next()) { 
                result.add(rs.getString(1));
                result.add(rs.getString(2));
                result.add(rs.getString(3));
                result.add(rs.getString(4));
                result.add(rs.getString(5));
                result.add(rs.getString(6));
                result.add(rs.getString(7));
                result.add(rs.getString(8));
                result.add(rs.getString(9));
                resultOut.add(result);
                result = new ArrayList<String>(result);
                resultOut.add(result);
                resultOut.remove(valor);
                valor = valor +1;
                result.clear();
            }
        } catch (SQLException ex) {
            System.out.println("Error en ListarCuentas: " + ex);            
        }
        return resultOut;
    }
    
    public ArrayList<Movimiento> ListarMovimientos(int idCuenta){
        ArrayList<Movimiento> result = new ArrayList<Movimiento>();
        try {
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM listarmovimientos(?)");
            pstmt.setInt(1, idCuenta);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Movimiento movimiento = new Movimiento(TipoMovimiento.valueOf(rs.getString(2)),rs.getTimestamp(3),rs.getBoolean(4), rs.getFloat(5));
                result.add(movimiento);
            }
        } catch (SQLException ex) {
            System.out.println("Error en ListarMovimientos: " + ex);
        }
        return result;
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
