/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import AccountsSystem.Conexion;
import java.sql.Timestamp;
import java.util.ArrayList;

/**
 *
 * @author Francisco
 */
public class Movimiento {
    private TipoMovimiento tipoMovimiento;
    private Timestamp fecha;
    private boolean excento;
    private float monto;

    public Movimiento (){};
    
    public Movimiento(TipoMovimiento tipoMovimiento, Timestamp fecha, boolean excento, float monto) {
        this.tipoMovimiento = tipoMovimiento;
        this.fecha = fecha;
        this.excento = excento;
        this.monto = monto;
    }
    
    public TipoMovimiento getTipoMovimiento() {
        return tipoMovimiento;
    }

    public void setTipoMovimiento(TipoMovimiento tipoMovimiento) {
        this.tipoMovimiento = tipoMovimiento;
    }

    public Timestamp getFecha() {
        return fecha;
    }

    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
    }

    public boolean isExcento() {
        return excento;
    }

    public void setExcento(boolean excento) {
        this.excento = excento;
    }

    public float getMonto() {
        return monto;
    }

    public void setMonto(float monto) {
        this.monto = monto;
    }
    
    public ArrayList<Movimiento> ListarMovimiento(int idCuenta){
        Conexion conexion = new Conexion();
        return conexion.ListarMovimientos(idCuenta);
    }
}
