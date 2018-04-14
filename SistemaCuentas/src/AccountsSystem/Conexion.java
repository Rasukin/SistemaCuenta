/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccountsSystem;



import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author Francisco
 */
public class Conexion {
    ResultSet rs;
    private Connection conn;
    
    public Connection Conexion(String username, String password) {
        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Subasta_DB",username,password);
            System.out.println("Opened database Subasta_DB successfully");
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, "El usuario o contraseña no se encontraron en la base de datos", "Datos no encontrados", JOptionPane.ERROR_MESSAGE);   
        }
        return conn;
    }
}
