package org.example;

import java.time.LocalDateTime;

public class cita {

    private LocalDateTime Fecha;

    private String Estado;

    private int fk_afiliado_ID;

    private int fk_profesional_ID;

    private int fk_centro_salud_ID;

    private String Motivo;

    public LocalDateTime getFecha() {
        return Fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.Fecha = fecha;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String estado) {
        this.Estado = estado;
    }

    public int getFk_afiliado_ID() {
        return fk_afiliado_ID;
    }

    public void setFk_afiliado_ID(int fk_afiliado_ID) {
        this.fk_afiliado_ID = fk_afiliado_ID;
    }

    public int getFk_profesional_ID() {
        return fk_profesional_ID;
    }

    public void setFk_profesional_ID(int fk_profesional_ID) {
        this.fk_profesional_ID = fk_profesional_ID;
    }

    public int getFk_centro_salud_ID() {
        return fk_centro_salud_ID;
    }

    public void setFk_centro_salud_ID(int fk_centro_salud_ID) {
        this.fk_centro_salud_ID = fk_centro_salud_ID;
    }

    public String getMotivo() {
        return Motivo;
    }

    public void setMotivo(String motivo) {
        this.Motivo = motivo;
    }

}