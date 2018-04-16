package Controller;

import AccountsSystem.Conexion;
import Model.Cliente;
import View.MainFrame;
import View.VistaCreaUsuario;
import View.VistaCrearCuenta;
import View.VistaCuentas;
import View.VistaPrincipal;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

public class ControllerVistaPrincipal implements ActionListener{
    private MainFrame mainFrame;
    private VistaPrincipal vistaPrincipal;
    private static ControllerVistaPrincipal controllerVistaPrincipal;   
    public Conexion conexion;
    DefaultTableModel model;
    
    public static ControllerVistaPrincipal getSingletonInstance () {
        if(controllerVistaPrincipal == null) {
            controllerVistaPrincipal = new ControllerVistaPrincipal();
        }
        return controllerVistaPrincipal;
    }
    
    public ControllerVistaPrincipal(){
        mainFrame = new MainFrame();
        vistaPrincipal = new VistaPrincipal();
        vistaPrincipal.btnVerCuentas.addActionListener(this);
        vistaPrincipal.btnCrearCuenta.addActionListener(this);
        vistaPrincipal.btnCrearUsuario.addActionListener(this);
    }
    
    public MainFrame getMainFrame() {
        return mainFrame;
    }
    
    public void setMainFrame(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
    }
    
    public void initInterface(){
        conexion = new Conexion();
        mainFrame.setLayout(new BorderLayout());
        mainFrame.getContentPane().add(vistaPrincipal);
        mainFrame.pack();
        mainFrame.setResizable(true);
        mainFrame.setVisible(true);        
        vistaPrincipal.tbClientes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        conexion = new Conexion();
        ArrayList<Cliente> clientes = conexion.ListarUsuarios();
        this.model = (DefaultTableModel) vistaPrincipal.tbClientes.getModel();
        for(int i=0; i<clientes.size(); i++){
            model.addRow(new Object[]{clientes.get(i).getIdCliente(), clientes.get(i).getCedula(), clientes.get(i).getNombre(), clientes.get(i).getApellido()});
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
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
            VistaCuentas vistaCuentas = new VistaCuentas();
            ControllerVistaCuentas controladorVistaCuentas = new ControllerVistaCuentas();
            int selectedRow = vistaPrincipal.tbClientes.getSelectedRow();
            int idCliente = (int) this.vistaPrincipal.tbClientes.getValueAt(selectedRow, 0);
            controladorVistaCuentas.initInterface(idCliente);
            JFrame frame = new JFrame();
            frame.setLayout(new BorderLayout());
            frame.getContentPane().add(vistaCuentas);
            frame.pack();
            frame.setResizable(false);
        }
        if(vistaPrincipal.btnCrearCuenta == e.getSource()){
            int selectedRow = vistaPrincipal.tbClientes.getSelectedRow();
            int idCliente = Integer.parseInt(this.model.getValueAt(selectedRow, 0).toString());
            VistaCrearCuenta vistaCrearCuenta = new VistaCrearCuenta();
            ControllerVistaCrearCuenta controladorVistaCrearCuenta = new ControllerVistaCrearCuenta();
            controladorVistaCrearCuenta.initInterface(idCliente);
            JFrame frame = new JFrame();
            frame.setLayout(new BorderLayout());
            frame.getContentPane().add(vistaCrearCuenta);
            frame.pack();
            frame.setResizable(false);
        }
    }
}
