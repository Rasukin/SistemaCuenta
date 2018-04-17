package Controller;

import AccountsSystem.Conexion;
import Model.CuentaAhorro;
import Model.CuentaCorriente;
import Model.Movimiento;
import Model.TipoMovimiento;
import View.MainFrame;
import View.VistaCuentas;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

public class ControllerVistaCuentas implements ActionListener{
    private static ControllerVistaCuentas controladorCuenta;
    private MainFrame mainFrame;
    private VistaCuentas vistaCuenta;
    public Conexion conexion;
    DefaultTableModel clientes;
    
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
    
    public void initInterface(int idCliente){
        conexion = new Conexion();
        mainFrame.setLayout(new BorderLayout());
        mainFrame.getContentPane().add(vistaCuenta);
        mainFrame.pack();
        mainFrame.setResizable(true);
        mainFrame.setVisible(true);
        mainFrame.setDefaultCloseOperation(mainFrame.DISPOSE_ON_CLOSE);
        
        vistaCuenta.tbCuentas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        conexion = new Conexion();
        ArrayList<ArrayList<String>> clientes = conexion.ListarCuentas(idCliente);
        this.clientes = (DefaultTableModel) vistaCuenta.tbCuentas.getModel();
        for(int i=0; i<clientes.size(); i++){
            if(clientes.get(i).get(1).equals("Ahorro")){
                this.clientes.addRow(new Object[]{
                clientes.get(i).get(0), 
                clientes.get(i).get(1), 
                clientes.get(i).get(2),
                clientes.get(i).get(3),
                clientes.get(i).get(4),
                clientes.get(i).get(5),
                clientes.get(i).get(6),
                clientes.get(i).get(7),
                "null"});
            }
            else{
                this.clientes.addRow(new Object[]{
                clientes.get(i).get(0), 
                clientes.get(i).get(1), 
                clientes.get(i).get(2),
                clientes.get(i).get(3),
                clientes.get(i).get(4),
                clientes.get(i).get(5),
                clientes.get(i).get(6),
                "null",
                clientes.get(i).get(8)});
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(vistaCuenta.btnListarMovimientos == e.getSource()){            
            int filaSeleccionada = vistaCuenta.tbCuentas.getSelectedRow();
            String idCuenta = (String) vistaCuenta.tbCuentas.getValueAt(filaSeleccionada, 0);
            ControllerVistaMovimientos controladorVistaMovimientos = new ControllerVistaMovimientos();
            controladorVistaMovimientos.initInterface(Integer.parseInt(idCuenta));
        }
        
        if(vistaCuenta.btnGenerarMovimientos == e.getSource()){
            
            
            boolean flagCuenta = false; // false es CuentaCorriente
            CuentaAhorro cuentaAhorro = new CuentaAhorro();
            CuentaCorriente cuentaCorriente = new CuentaCorriente();
            
            int filaSeleccionada = vistaCuenta.tbCuentas.getSelectedRow();
            try{
                String tipoCuenta = (String) vistaCuenta.tbCuentas.getValueAt(filaSeleccionada, 1);
                if(tipoCuenta.equals("Ahorro")){
                    flagCuenta = true;
                    cuentaAhorro.setIdCuenta(Integer.parseInt((String) vistaCuenta.tbCuentas.getValueAt(filaSeleccionada, 0)));
                    cuentaAhorro.setTasaInteres(Float.parseFloat((String) vistaCuenta.tbCuentas.getValueAt(filaSeleccionada, 4)));
                    cuentaAhorro.setSaldo(Float.parseFloat((String) vistaCuenta.tbCuentas.getValueAt(filaSeleccionada, 5)));
                    cuentaAhorro.setValorComision(Float.parseFloat((String) vistaCuenta.tbCuentas.getValueAt(filaSeleccionada, 7)));
                }
                else{
                    System.out.println("entro al esle");
                    cuentaCorriente.setIdCuenta(Integer.parseInt((String) vistaCuenta.tbCuentas.getValueAt(filaSeleccionada, 0)));
                    cuentaCorriente.setTasaInteres(Float.parseFloat((String) vistaCuenta.tbCuentas.getValueAt(filaSeleccionada, 4)));
                    cuentaCorriente.setSaldo(Float.parseFloat((String) vistaCuenta.tbCuentas.getValueAt(filaSeleccionada, 5)));
                    cuentaCorriente.setLimiteTransaccion(Integer.parseInt((String) vistaCuenta.tbCuentas.getValueAt(filaSeleccionada, 8)));
                }
                System.out.println(tipoCuenta);
            } catch(Exception ex){
                System.out.println("Error btnGenerar en: \n" + ex);
            }
            
            final float montoMin = 5000;
            final float montoMax = 10000;
            final int movMax = 15;
            final int movMin = 1;
            final TipoMovimiento[] listaMov = TipoMovimiento.values();
            
            float randSaldo;
            int randCantMov = movMin + (int) (Math.random() * ((1 + movMax) - movMin));
            Random random = new Random();
            int tipoMov;
            Timestamp fecha;
            Movimiento movimiento;
            float intereses;
            int cuentaID = Integer.parseInt((String) vistaCuenta.tbCuentas.getValueAt(filaSeleccionada, 0));
            System.out.println(cuentaID);
            
            for (int i = 0; i < randCantMov; i++) {
                tipoMov = random.nextInt(TipoMovimiento.values().length);     
                randSaldo = montoMin + (float)Math.random() * (montoMax - montoMin);
                //System.out.println(listaMov[tipoMov].toString() + "---"+String.valueOf(randSaldo));
                
                switch (listaMov[0].toString()){//listaMov[tipoMov].toString()) {
                    case "Credito":
                        System.out.println("entro al caso Credito");
                        fecha = new Timestamp(System.currentTimeMillis());
                        movimiento = new Movimiento(listaMov[tipoMov], fecha, false, randSaldo);
                        conexion.CrearMovimiento(movimiento, cuentaID);
                        if (flagCuenta) {
                            cuentaAhorro.credito(randSaldo);
                            conexion.ActualizarSaldo(cuentaID, cuentaAhorro.getSaldo());    
                        }else{
                            cuentaCorriente.credito(randSaldo);
                            conexion.ActualizarSaldo(cuentaID, cuentaCorriente.getSaldo());
                        }
                        break;
                    case "Debito":
                        System.out.println("Entro al caso Debito");
                        fecha = new Timestamp(System.currentTimeMillis());
                        movimiento = new Movimiento(listaMov[tipoMov], fecha, false, randSaldo);
                        conexion.CrearMovimiento(movimiento, cuentaID);
                        if (flagCuenta) {
                            cuentaAhorro.debito(randSaldo);
                            conexion.ActualizarSaldo(cuentaID, cuentaAhorro.getSaldo());
                        }else{
                            cuentaCorriente.debito(randSaldo);
                            conexion.ActualizarSaldo(cuentaID, cuentaCorriente.getSaldo());
                        }
                        break;
                    case "PagoInteres":
                        System.out.println("Este es el caso PagoIntereses");
                        fecha = new Timestamp(System.currentTimeMillis());
                        if(flagCuenta){
                            cuentaAhorro.pagoInteres();
                            intereses = cuentaAhorro.getSaldo() * cuentaAhorro.getTasaInteres();
                            movimiento = new Movimiento(listaMov[tipoMov], fecha, false, intereses);
                            conexion.ActualizarSaldo(cuentaID, cuentaAhorro.getSaldo());
                        }else{
                            cuentaCorriente.pagoInteres();
                            intereses = cuentaCorriente.getSaldo() * cuentaCorriente.getTasaInteres();
                            movimiento = new Movimiento(listaMov[tipoMov], fecha, false, intereses);
                            conexion.ActualizarSaldo(cuentaID, cuentaCorriente.getSaldo());
                        }
                        conexion.CrearMovimiento(movimiento, cuentaID);
                        break;
                    case "CobroComision":System.out.println("Este es el caso CobroComision");
                        fecha = new Timestamp(System.currentTimeMillis());
                        movimiento = new Movimiento(listaMov[tipoMov], fecha, false, randSaldo);
                        if(flagCuenta){
                            cuentaAhorro.cobrarComision();
                            intereses = cuentaAhorro.getSaldo() - (cuentaAhorro.getSaldo() * (float) 0.2);
                            movimiento = new Movimiento(listaMov[tipoMov], fecha, false, intereses);
                            conexion.ActualizarSaldo(cuentaID, cuentaAhorro.getSaldo());
                        }else{
                            cuentaCorriente.cobrarComision();
                            intereses = cuentaCorriente.getSaldo() - (cuentaCorriente.getSaldo() * (float) 0.2);
                            movimiento = new Movimiento(listaMov[tipoMov], fecha, false, intereses);
                            conexion.ActualizarSaldo(cuentaID, cuentaCorriente.getSaldo());
                        }
                        conexion.CrearMovimiento(movimiento, cuentaID);
                        break;
                    case "CobroComercio": System.out.println("Este es el caso CobroComercio");
                        fecha = new Timestamp(System.currentTimeMillis());
                        movimiento = new Movimiento(listaMov[tipoMov], fecha, false, randSaldo);
                        if (flagCuenta) {
                            cuentaAhorro.debito(randSaldo);
                            conexion.ActualizarSaldo(cuentaID, cuentaAhorro.getSaldo());
                        }else{
                            cuentaCorriente.debito(randSaldo);
                            conexion.ActualizarSaldo(cuentaID, cuentaCorriente.getSaldo());
                        }
                        conexion.CrearMovimiento(movimiento, cuentaID);
                        break;
                    case "RetiroCajero":System.out.println("Este es el caso RetiroCajero");
                        fecha = new Timestamp(System.currentTimeMillis());
                        movimiento = new Movimiento(listaMov[tipoMov], fecha, false, randSaldo);
                        if (flagCuenta) {
                            cuentaAhorro.debito(randSaldo);
                            conexion.ActualizarSaldo(cuentaID, cuentaAhorro.getSaldo());
                        }else{
                            cuentaCorriente.debito(randSaldo);
                            conexion.ActualizarSaldo(cuentaID, cuentaCorriente.getSaldo());
                        }
                        conexion.CrearMovimiento(movimiento, cuentaID);
                    default:
                        System.out.println(listaMov[tipoMov].toString());
                }
            }
        }
        
        if(vistaCuenta.btnSalir == e.getSource()){
            this.mainFrame.dispose();
        }
    }
}
