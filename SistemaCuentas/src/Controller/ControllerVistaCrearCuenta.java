package Controller;

import AccountsSystem.Conexion;
import Model.CuentaAhorro;
import Model.CuentaCorriente;
import Model.TipoCuenta;
import Model.TipoMoneda;
import View.MainFrame;
import View.VistaCrearCuenta;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Timestamp;
import javax.swing.JOptionPane;

public class ControllerVistaCrearCuenta implements ActionListener{
    private static ControllerVistaCrearCuenta controladorCrearCuenta;
    private MainFrame mainFrame;
    private VistaCrearCuenta vistaCrearCuenta;
    private int idCliente;
    public Conexion conexion;
    public int idCliente;
    
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
    
    public void initInterface(int idCliente) {
        conexion = new Conexion();
        mainFrame.setLayout(new BorderLayout());
        mainFrame.getContentPane().add(vistaCrearCuenta);
        this.idCliente = idCliente;
        this.vistaCrearCuenta.cbTipoCuenta.addItem(TipoCuenta.Ahorro.toString());
        this.vistaCrearCuenta.cbTipoCuenta.addItem(TipoCuenta.Corriente.toString());
        this.vistaCrearCuenta.cbTipoMoneda.addItem(TipoMoneda.Colones.toString());
        this.vistaCrearCuenta.cbTipoMoneda.addItem(TipoMoneda.Dolares.toString());
        mainFrame.pack();
        mainFrame.setResizable(false);
        mainFrame.setVisible(true);
        mainFrame.setDefaultCloseOperation(1);
<<<<<<< HEAD
        this.idCliente = idCliente;
=======
        mainFrame.setDefaultCloseOperation(mainFrame.DISPOSE_ON_CLOSE);
>>>>>>> origin/BranchMuestraCuentas
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(vistaCrearCuenta.btnCrear == e.getSource()){
            if(vistaCrearCuenta.btnCrear == e.getSource()){
<<<<<<< HEAD
                TipoCuenta tipoCuenta = TipoCuenta.valueOf(vistaCrearCuenta.cbTipoCuenta.getSelectedItem().toString());
                TipoMoneda tipoMoneda = TipoMoneda.valueOf(vistaCrearCuenta.cbTipoMoneda.getSelectedItem().toString());
                Timestamp fechaApertura = new Timestamp(System.currentTimeMillis());
                float tasaInteresAhorro = (float) 0.17;
                float tasaInteresCorriente = (float) 0.10;
                float valorComision = (float) (12/100);
                if(tipoCuenta == TipoCuenta.Ahorro){
                    CuentaAhorro cuentaAhorro = new CuentaAhorro(tipoCuenta, tipoMoneda, fechaApertura, tasaInteresAhorro, 10000, valorComision);
                    if(conexion.CrearCuentaAhorro(cuentaAhorro, idCliente)){
                        JOptionPane.showMessageDialog(null, "Cuenta de ahorros creado");
                    }
                }else{
                    CuentaCorriente cuentaCorriente = new CuentaCorriente(tipoCuenta, tipoMoneda, fechaApertura, tasaInteresCorriente, 10000, 10);
                    if(conexion.CrearCuentaCorriente(cuentaCorriente, idCliente)){
                        JOptionPane.showMessageDialog(null, "Cuenta corriente creado");
=======
                String tipoCuenta = (String) vistaCrearCuenta.cbTipoCuenta.getSelectedItem();
                String tipoMoneda = (String) vistaCrearCuenta.cbTipoMoneda.getSelectedItem();
                Timestamp fechaApertura = new Timestamp(System.currentTimeMillis());
                float tasaInteres = (float) 1.65;
                float valorComision = (float) 0.40;
                int limiteTransaccion = 10;
                if(tipoCuenta.equals("Ahorro")){
                    CuentaAhorro cuentaAhorro = new CuentaAhorro(TipoCuenta.Ahorro, TipoMoneda.valueOf(tipoMoneda), fechaApertura, tasaInteres, 10000, valorComision);
                    if(conexion.CrearCuentaAhorro(cuentaAhorro,idCliente)){
                        JOptionPane.showMessageDialog(null, "Cuenta de ahorros añadida a base d datos");
                    }
                }else{
                    CuentaCorriente cuentaCorriente = new CuentaCorriente(TipoCuenta.Corriente, TipoMoneda.valueOf(tipoMoneda), fechaApertura, tasaInteres, 10000, limiteTransaccion);
                    if(conexion.CrearCuentaCorriente(cuentaCorriente,idCliente)){
                        JOptionPane.showMessageDialog(null, "Cuenta corriente añadida a base de datos");
>>>>>>> origin/BranchMuestraCuentas
                    }
                }
                mainFrame.dispose();
            }
        }
        
        if(vistaCrearCuenta.btnSalir == e.getSource()){
            this.mainFrame.dispose();
        }
    }
}
