/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import View.MainFrame;
import View.VistaCuentas;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControllerVistaCuentas implements ActionListener{
    private static ControllerVistaCuentas controladorCuenta;
    private MainFrame mainFrame;
    private VistaCuentas vistaCuenta;
    
    public static ControllerVistaCuentas getSingletonInstance() {
        if (controladorCuenta == null) {
            controladorCuenta = new ControllerVistaCuentas();
        }
        return controladorCuenta;
    }
    
    ControllerVistaCuentas() {
        mainFrame = new MainFrame();
        vistaCuenta = new VistaCuentas();
        vistaCuenta.btnGenerarMovimientos.addActionListener(this);
        vistaCuenta.btnListarMovimientos.addActionListener(this);
    }
    
    public MainFrame getMainFrame() {
        return mainFrame;
    }
    
    public void setMainFrame(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
    }
    
    public void initInterface(){
        //conexion = new Conexion();
        mainFrame.setLayout(new BorderLayout());
        mainFrame.getContentPane().add(vistaCuenta);
        mainFrame.pack();
        mainFrame.setResizable(true);
        mainFrame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(vistaCuenta.btnListarMovimientos == e.getSource()){
            System.out.println("btnListarMovimientos");
        }
        
        if(vistaCuenta.btnGenerarMovimientos == e.getSource()){
            
            
            System.out.println("btnGenerarMovimientos");
        }
        
    }
}
