package org.example;

import java.sql.Date;

public class factura {
    
    private Date Fecha_emision;
    
    private float Monto;
    
    private Date Vencimiento;
    
    private int fk_afiliado_ID;
    
    private int fk_cita_ID;
    
    private String Estado_pago;
    
    
    public Date getFecha_emision() {
        return Fecha_emision;
    }
    
    public void setFecha_emision(Date fecha_emision) {
        this.Fecha_emision = fecha_emision;
    }
    
    public float getMonto() {
        return Monto;
    }
    
    public void setMonto(float monto) {
        this.Monto = monto;
    }
    
    public Date getVencimiento() {
        return Vencimiento;
    }
    
    public void setVencimiento(Date vencimiento) {
        this.Vencimiento = vencimiento;
    }
    
    public int getFk_afiliado_ID() {
        return fk_afiliado_ID;
    }
    
    public void setFk_afiliado_ID(int fk_afiliado_ID) {
        this.fk_afiliado_ID = fk_afiliado_ID;
    }
    
    public int getFk_cita_ID() {
        return fk_cita_ID;
    }
    
    public void setFk_cita_ID(int fk_cita_ID) {
        this.fk_cita_ID = fk_cita_ID;
    }
    
    public String getEstado_pago() {
        return Estado_pago;
    }
    
    public void setEstado_pago(String estado_pago) {
        this.Estado_pago = estado_pago;
    }
}