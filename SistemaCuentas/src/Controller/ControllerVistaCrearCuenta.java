package Controller;

import AccountsSystem.Conexion;
import Model.Cuenta;
import Model.TipoCuenta;
import Model.TipoMoneda;
import View.MainFrame;
import View.VistaCrearCuenta;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Timestamp;

public class ControllerVistaCrearCuenta implements ActionListener{
    private static ControllerVistaCrearCuenta controladorCrearCuenta;
    private MainFrame mainFrame;
    private VistaCrearCuenta vistaCrearCuenta;
    public Conexion conexion;
    
    public static ControllerVistaCrearCuenta getSingletonInstance() {
        if (controladorCrearCuenta == null) {
            controladorCrearCuenta = new ControllerVistaCrearCuenta();
        }
        return controladorCrearCuenta;
    }
    
    ControllerVistaCrearCuenta() {
        mainFrame = new MainFrame();
        vistaCrearCuenta = new VistaCrearCuenta();
        vistaCrearCuenta.btnCrear.addActionListener(this);
        vistaCrearCuenta.btnSalir.addActionListener(this);
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
        mainFrame.getContentPane().add(vistaCrearCuenta);
        this.vistaCrearCuenta.cbTipoCuenta.addItem(TipoCuenta.Ahorro.toString());
        this.vistaCrearCuenta.cbTipoCuenta.addItem(TipoCuenta.Corriente.toString());
        this.vistaCrearCuenta.cbTipoMoneda.addItem(TipoMoneda.Colones.toString());
        this.vistaCrearCuenta.cbTipoMoneda.addItem(TipoMoneda.Dolares.toString());
        mainFrame.pack();
        mainFrame.setResizable(false);
        mainFrame.setVisible(true);
        mainFrame.setDefaultCloseOperation(1);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(vistaCrearCuenta.btnCrear == e.getSource()){
            if(vistaCrearCuenta.btnCrear == e.getSource()){
                String tipoCuenta = vistaCrearCuenta.cbTipoCuenta.getSelectedItem().toString();
                String tipoMoneda = vistaCrearCuenta.cbTipoMoneda.getSelectedItem().toString();
                Timestamp fechaApertura = new Timestamp(System.currentTimeMillis());
                //float tasaInteres = conexion.getTasaInteres();
                if(tipoCuenta == "Ahorro"){
                    
                }else{
                    
                }
                
                //Cuenta cuenta = new Cuenta(tipoCuenta, tipoMoneda, fechaApertura, tasaInteres, 0);
            }
        }
        if(vistaCrearCuenta.btnSalir == e.getSource()){
            this.mainFrame.dispose();
        }
    }
}
