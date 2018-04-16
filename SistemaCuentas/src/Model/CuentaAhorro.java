package Model;

import java.sql.Timestamp;

public class CuentaAhorro extends Cuenta{

    private  float valorComision;
    
    public CuentaAhorro(int id, TipoCuenta tipoCuenta, TipoMoneda tipoMoneda, Timestamp fechaApertura,float  tasaInteres, float saldo, float valorComision){
        this.idCuenta = id;
        this.tipoCuenta = tipoCuenta;
        this.tipoMoneda = tipoMoneda;
        this.fechaApertura = fechaApertura;
        this.tasaInteres = tasaInteres;
        this.saldo = saldo;
        this.valorComision = valorComision;        
    }
    
    public CuentaAhorro(TipoCuenta tipoCuenta, TipoMoneda tipoMoneda, Timestamp fechaApertura,float  tasaInteres, float saldo, float valorComision){
        this.tipoCuenta = tipoCuenta;
        this.tipoMoneda = tipoMoneda;
        this.fechaApertura = fechaApertura;
        this.tasaInteres = tasaInteres;
        this.saldo = saldo;
        this.valorComision = valorComision;        
    }
    
    public void cobrarComision(){
        this.saldo = this.saldo - (this.saldo * this.valorComision);
    }
    
    public void pagoInteres(){
        this.saldo = this.saldo + (this.saldo * this.tasaInteres);
    }

    public float getValorComision() {
        return valorComision;
    }

    public void setValorComision(float valorComision) {
        this.valorComision = valorComision;
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
