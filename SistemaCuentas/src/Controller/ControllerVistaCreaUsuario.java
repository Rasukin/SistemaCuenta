/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Cliente;
import View.MainFrame;
import View.VistaCreaUsuario;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class ControllerVistaCreaUsuario implements ActionListener{
    private static ControllerVistaCreaUsuario controladorCreaUsuario;
    private MainFrame mainFrame;
    private VistaCreaUsuario vistaCreaUsuario;
    //public Conexion conexion;
    
    public static ControllerVistaCreaUsuario getSingletonInstance() {
        if (controladorCreaUsuario == null) {
            controladorCreaUsuario = new ControllerVistaCreaUsuario();
        }
        return controladorCreaUsuario;
    }
    
    ControllerVistaCreaUsuario() {
        mainFrame = new MainFrame();
        vistaCreaUsuario = new VistaCreaUsuario();
        vistaCreaUsuario.btnCrear.addActionListener(this);
        vistaCreaUsuario.btnSalir.addActionListener(this);
    }
    
    public MainFrame getMainFrame() {
        return mainFrame;
    }
    
    public void setMainFrame(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
    }
    
    public void initInterface() {
        //conexion = new Conexion();
        mainFrame.setLayout(new BorderLayout());
        mainFrame.getContentPane().add(vistaCreaUsuario);
        mainFrame.pack();
        mainFrame.setResizable(false);
        mainFrame.setVisible(true);
        mainFrame.setDefaultCloseOperation(1);
    }
    
      @Override
    public void actionPerformed(ActionEvent e) {
        if(vistaCreaUsuario.btnCrear == e.getSource()){
            if((vistaCreaUsuario.txtApellidos.getText().equals("")) && (vistaCreaUsuario.txtNombre.equals("")) && (vistaCreaUsuario.txtCedula.equals(""))){
                JOptionPane.showMessageDialog(null, "Debe de llenar todas las casillas");
            }else{
                String nombre = vistaCreaUsuario.txtNombre.getText();
                String apellidos = vistaCreaUsuario.txtApellidos.getText();
                int cedula = Integer.parseInt(vistaCreaUsuario.txtCedula.getText());
                Cliente cliente = new Cliente(cedula, nombre, apellidos);
                JOptionPane.showMessageDialog(null, "Cliente agregado al sistema");
                //if(conexion.InsertaCliente(cliente)){
                    System.out.println(cliente.getApellido()+" "+cliente.getNombre()+" "+cliente.getCedula());
                //}
            }  
        }
        if(vistaCreaUsuario.btnSalir == e.getSource()) {
            this.mainFrame.dispose();
        }
    }
}
