/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Timestamp;

public abstract class Cuenta {
    protected int idCuenta;
    protected float saldo;
    protected TipoMoneda tipoMoneda;
    protected Timestamp fechaApertura;
    protected float  TasaInteres;

    public int getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(int idCuenta) {
        this.idCuenta = idCuenta;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public TipoMoneda getTipoMoneda() {
        return tipoMoneda;
    }

    public void setTipoMoneda(TipoMoneda tipoMoneda) {
        this.tipoMoneda = tipoMoneda;
    }

    public Timestamp getFechaApertura() {
        return fechaApertura;
    }

    public void setFechaApertura(Timestamp fechaApertura) {
        this.fechaApertura = fechaApertura;
    }

    public float getTasaInteres() {
        return TasaInteres;
    }

    public void setTasaInteres(float TasaInteres) {
        this.TasaInteres = TasaInteres;
    }
    
    public void credito(){
        
    }
    public void debito(){
        
    }
    public void generarRegistro(){
        
    }
    public void cobrarComision(){
        
    }
    
    public abstract void pagoInteres();
}
