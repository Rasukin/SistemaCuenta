/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import View.MainFrame;
import View.VistaCreaUsuario;
import View.VistaPrincipal;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

public class ControllerVistaPrincipal implements ActionListener{
    private static ControllerVistaPrincipal controladorVistaPrincipal;
    private MainFrame mainFrame;
    private VistaPrincipal vistaPrincipal;
    
    public static ControllerVistaPrincipal getSingletonInstance() {
        if (controladorVistaPrincipal == null) {
            controladorVistaPrincipal = new ControllerVistaPrincipal();
        }
        return controladorVistaPrincipal;
    }
    
    public ControllerVistaPrincipal() {
        mainFrame = new MainFrame();
        vistaPrincipal = new VistaPrincipal();
        vistaPrincipal.btnCrearUsuario.addActionListener(this);
        vistaPrincipal.btnVerCuentas.addActionListener(this);
        vistaPrincipal.btnCrearCuenta.addActionListener(this);
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
        mainFrame.getContentPane().add(vistaPrincipal);
        mainFrame.pack();
        mainFrame.setResizable(false);
        mainFrame.setVisible(true);
        mainFrame.setDefaultCloseOperation(1);
    }
    
     @Override
    public void actionPerformed(ActionEvent e) {
        if(vistaPrincipal.btnCrearCuenta == e.getSource()){
            
        }
        if(vistaPrincipal.btnCrearUsuario == e.getSource()){
            VistaCreaUsuario vistaCreaUsuario = new VistaCreaUsuario();
            ControllerVistaCreaUsuario controladorCreaUsuario = new ControllerVistaCreaUsuario();
            controladorCreaUsuario.initInterface();
            JFrame frame = new JFrame();
            frame.setLayout(new BorderLayout());
            frame.getContentPane().add(vistaCreaUsuario);
            frame.pack();
            frame.setResizable(false);
            
        }
        if(vistaPrincipal.btnVerCuentas == e.getSource()){
            
        }
    }
}
