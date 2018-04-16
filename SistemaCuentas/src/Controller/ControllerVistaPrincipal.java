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
import java.sql.Timestamp;
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
        ArrayList<Cliente> clientes = new ArrayList<Cliente>();
        Cliente cliente1 = new Cliente(1, "12", "Kafay" , "Ng");
        Cliente cliente2 = new Cliente(2, "23", "Francisco" , "Monge");
        Cliente cliente3 = new Cliente(3, "34", "Roberto" , "Liang");
        Cliente cliente4 = new Cliente(4, "45", "Pedro", "Cespedes");
        clientes.add(cliente1);
        clientes.add(cliente2);
        clientes.add(cliente3);
        clientes.add(cliente4);
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
            controladorVistaCuentas.initInterface();
            JFrame frame = new JFrame();
            frame.setLayout(new BorderLayout());
            frame.getContentPane().add(vistaCuentas);
            frame.pack();
            frame.setResizable(false);
        }
        if(vistaPrincipal.btnCrearCuenta == e.getSource()){
            VistaCrearCuenta vistaCrearCuenta = new VistaCrearCuenta();
            ControllerVistaCrearCuenta controladorVistaCrearCuenta = new ControllerVistaCrearCuenta();
            controladorVistaCrearCuenta.initInterface();
            JFrame frame = new JFrame();
            frame.setLayout(new BorderLayout());
            frame.getContentPane().add(vistaCrearCuenta);
            frame.pack();
            frame.setResizable(false);
        }
    }
}
