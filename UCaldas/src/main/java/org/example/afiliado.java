package org.example;

public class afiliado {

    private String Nombre_afiliado;

    private String Documento;

    private String Telefono;

    private int fk_plan_salud_ID;

    private String Estado;


    public String getNombre_afiliado() {
        return Nombre_afiliado;
    }

    public void setNombre_afiliado(String nombre_afiliado) {
        this.Nombre_afiliado = nombre_afiliado;
    }

    public String getDocumento() {
        return Documento;
    }

    public void setDocumento(String documento) {
        this.Documento = documento;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String telefono) {
        this.Telefono = telefono;
    }

    public int getFk_plan_salud_ID() {
        return fk_plan_salud_ID;
    }

    public void setFk_plan_salud_ID(int fk_plan_salud_ID) {
        this.fk_plan_salud_ID = fk_plan_salud_ID;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String estado) {
        this.Estado = estado;
    }

}