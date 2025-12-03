package org.example;

import java.util.Date;

public class historial_clinico {

    private Date Fecha_consulta;

    private String Diagnostico;

    private String Tratamiento;

    private int fk_afiliado_ID;

    private int fk_cita_ID;

    private int fk_Profesional_ID;


    public Date getFecha_consulta() {
        return Fecha_consulta;
    }

    public void setFecha_consulta(Date fecha_consulta) {
        this.Fecha_consulta = fecha_consulta;
    }


    public String getDiagnostico() {
        return Diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.Diagnostico = diagnostico;
    }


    public String getTratamiento() {
        return Tratamiento;
    }

    public void setTratamiento(String tratamiento) {
        this.Tratamiento = tratamiento;
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


    public int getFk_Profesional_ID() {
        return fk_Profesional_ID;
    }

    public void setFk_Profesional_ID(int fk_Profesional_ID) {
        this.fk_Profesional_ID = fk_Profesional_ID;
    }
}