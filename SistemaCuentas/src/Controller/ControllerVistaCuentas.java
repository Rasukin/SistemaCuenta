package Controller;

import Model.TipoMovimiento;
import View.MainFrame;
import View.VistaCuentas;
import View.VistaMovimientos;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import java.util.Random;

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
        vistaCuenta.btnSalir.addActionListener(this);
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
            
            int filaSeleccionada = vistaCuenta.tbCuentas.getSelectedRow();
            try{
                String value = (String) vistaCuenta.tbCuentas.getValueAt(filaSeleccionada, 0);
                System.out.println(value);
            } catch(Exception ex){
                System.out.println("Error en: \n" + ex);
            }
            
            VistaMovimientos vistaMovimientos = new VistaMovimientos();
            ControllerVistaMovimientos controladorVistaMovimientos = new ControllerVistaMovimientos();
            controladorVistaMovimientos.initInterface();
            JFrame frame = new JFrame();
            frame.setLayout(new BorderLayout());
            frame.getContentPane().add(vistaMovimientos);
            frame.pack();
            frame.setResizable(false);
        }
        
        if(vistaCuenta.btnGenerarMovimientos == e.getSource()){
            System.out.println("btnGenerarMovimientos");
            
            int filaSeleccionada = vistaCuenta.tbCuentas.getSelectedRow();
            try{
                String value = (String) vistaCuenta.tbCuentas.getValueAt(filaSeleccionada, 0);
                System.out.println(value);
            } catch(Exception ex){
                System.out.println("Error en: \n" + ex);
            }
            
            final float saldoMin = 5000;
            final float saldoMax = 1000000;
            final int movMax = 50;
            final int movMin = 5;
            
            float randSaldo = saldoMin + (float)Math.random() * (saldoMax - saldoMin);
            int randCantMov = movMin + (int) (Math.random() * ((1 + movMax) - movMin));
            Random random = new Random();
            int tipoMov = random.nextInt(TipoMovimiento.values().length + 1);
            
            
        }
        
    }
}
