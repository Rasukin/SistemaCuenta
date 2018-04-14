/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccountsSystem;

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
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/SistemaCuentas","postgres","postgrespsw");
            System.out.println("Opened database SistemaCuentas successfully");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error en Conexion: " + e);
            JOptionPane.showMessageDialog(null, "El usuario o contraseña no se encontraron en la base de datos: ", "Datos no encontrados", JOptionPane.ERROR_MESSAGE);   
        }
        return conn;
    }
    
    public void CrearCuenta(String tipoCuenta, String tipoMoneda, Timestamp fechaApertura, Float tasaInteres){
    
    }
    
    public void CrearUsuario(String cedula, String nombre, String apellidos){
    
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
