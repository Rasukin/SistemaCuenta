package Model;

import java.sql.Timestamp;

public class CuentaCorriente extends Cuenta{
    private  int limiteTransaccion;
    
    public CuentaCorriente(int id, TipoCuenta tipoCuenta, TipoMoneda tipoMoneda, Timestamp fechaApertura,float  tasaInteres, float saldo, int limiteTransaccion){
        this.idCuenta = id;
        this.tipoCuenta = tipoCuenta;
        this.tipoMoneda = tipoMoneda;
        this.fechaApertura = fechaApertura;
        this.tasaInteres = tasaInteres;
        this.saldo = saldo;
        this.limiteTransaccion = limiteTransaccion;        
    }
    
    public CuentaCorriente(TipoCuenta tipoCuenta, TipoMoneda tipoMoneda, Timestamp fechaApertura,float  tasaInteres, float saldo, int limiteTransaccion){
        this.tipoCuenta = tipoCuenta;
        this.tipoMoneda = tipoMoneda;
        this.fechaApertura = fechaApertura;
        this.tasaInteres = tasaInteres;
        this.saldo = saldo;
        this.limiteTransaccion = limiteTransaccion;        
    }
    
    public void cobrarComision(){
        this.saldo = this.saldo - (this.saldo * (float) 0.2);
    }
   
    
    public void pagoInteres(){
        this.saldo = this.saldo + (this.saldo * this.tasaInteres);
    }

    public int getLimiteTransaccion() {
        return limiteTransaccion;
    }

    public void setLimiteTransaccion(int limiteTransaccion) {
        this.limiteTransaccion = limiteTransaccion;
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
    
    
}
