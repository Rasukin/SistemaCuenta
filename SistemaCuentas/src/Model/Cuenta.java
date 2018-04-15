/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Timestamp;

public abstract class Cuenta {
    protected int idCuenta;
    protected TipoCuenta tipoCuenta;
    protected TipoMoneda tipoMoneda;
    protected Timestamp fechaApertura;
    protected float  tasaInteres;
    protected float saldo;  
    
    public Cuenta(TipoCuenta tipoCuenta, TipoMoneda tipoMoneda, Timestamp fechaApertura, float tasaInteres, float saldo){
        this.tipoCuenta = tipoCuenta;
        this.tipoMoneda = tipoMoneda;
        this.fechaApertura = fechaApertura;
        this.tasaInteres = tasaInteres;
        this.saldo = saldo;
    }

    public Cuenta(TipoCuenta tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }

    public int getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(int idCuenta) {
        this.idCuenta = idCuenta;
    }

    public TipoCuenta getTipoCuenta() {
        return tipoCuenta;
    }

    public void setTipoCuenta(TipoCuenta tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
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
        return tasaInteres;
    }

    public void setTasaInteres(float tasaInteres) {
        this.tasaInteres = tasaInteres;
    }
    
    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
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
