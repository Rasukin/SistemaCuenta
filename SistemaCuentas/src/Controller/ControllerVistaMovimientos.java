package Controller;

import AccountsSystem.Conexion;
import Model.Movimiento;
import View.MainFrame;
import View.VistaMovimientos;
import java.awt.BorderLayout;
import java.util.ArrayList;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

public class ControllerVistaMovimientos{
    private static ControllerVistaMovimientos controladorVistaMovimientos;
    private MainFrame mainFrame;
    private VistaMovimientos vistaMovimientos;
    public Conexion conexion;
    DefaultTableModel movimientos;
    
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
    
    public void initInterface(int idCuenta){
        mainFrame.setLayout(new BorderLayout());
        mainFrame.getContentPane().add(vistaMovimientos);
        mainFrame.pack();
        mainFrame.setResizable(true);
        mainFrame.setVisible(true);
        mainFrame.setDefaultCloseOperation(mainFrame.DISPOSE_ON_CLOSE);
        
        vistaMovimientos.tbMovimientos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        conexion = new Conexion();
        ArrayList<Movimiento> movimientos = conexion.ListarMovimientos(idCuenta);
        this.movimientos = (DefaultTableModel) vistaMovimientos.tbMovimientos.getModel();
        for(int i=0; i<movimientos.size(); i++){            
            this.movimientos.addRow(new Object[]{
                movimientos.get(i).getTipoMovimiento(), 
                movimientos.get(i).getFecha(), 
                movimientos.get(i).isExcento(),
                movimientos.get(i).getMonto()});    
            }
        }
    }
