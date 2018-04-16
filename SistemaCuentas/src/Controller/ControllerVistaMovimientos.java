package Controller;

import View.MainFrame;
import View.VistaMovimientos;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControllerVistaMovimientos{
    private static ControllerVistaMovimientos controladorVistaMovimientos;
    private MainFrame mainFrame;
    private VistaMovimientos vistaMovimientos;
    
    public static ControllerVistaMovimientos getSingletonInstance() {
        if (controladorVistaMovimientos == null) {
            controladorVistaMovimientos = new ControllerVistaMovimientos();
        }
        return controladorVistaMovimientos;
    }
    
    ControllerVistaMovimientos() {
        mainFrame = new MainFrame();
        vistaMovimientos = new VistaMovimientos();
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
        mainFrame.getContentPane().add(vistaMovimientos);
        mainFrame.pack();
        mainFrame.setResizable(true);
        mainFrame.setVisible(true);
        mainFrame.setDefaultCloseOperation(1);
    }
}
