package Model;

import java.sql.Timestamp;

public abstract class Cuenta {
    protected int idCuenta;
    protected TipoCuenta tipoCuenta;
    protected TipoMoneda tipoMoneda;
    protected Timestamp fechaApertura;
    protected float  tasaInteres;
    protected float saldo;  
    
    public Cuenta(){
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
    
    public void credito(float monto){
        this.saldo = this.saldo + monto;
    }
    
    public void debito(float monto){
        this.saldo = this.saldo - monto;
    }
    
    public void generarRegistro(){
        
    }
    
    public abstract void cobrarComision();
    
    public abstract void pagoInteres();
}
