package Controller;

import AccountsSystem.Conexion;
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
    public Conexion conexion;
    
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
        conexion = new Conexion();
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
                String cedula = vistaCreaUsuario.txtCedula.getText();
                Cliente cliente = new Cliente(cedula, nombre, apellidos);
                if(conexion.CrearCliente(cliente)){
                    JOptionPane.showMessageDialog(null, "Cliente agregado al sistema");
                    vistaCreaUsuario.txtApellidos.setText("");
                    vistaCreaUsuario.txtCedula.setText("");
                    vistaCreaUsuario.txtNombre.setText("");
                }
            }  
        }
        if(vistaCreaUsuario.btnSalir == e.getSource()) {
            this.mainFrame.dispose();
        }
    }
}
