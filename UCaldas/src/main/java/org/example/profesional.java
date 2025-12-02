package org.example;

public class profesional {

    private String Nombre;

    private String Documento;

    private String Especialidad;

    private int fk_centro_salud_ID;

    private String Estado;


    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        this.Nombre = nombre;
    }

    public String getDocumento() {
        return Documento;
    }

    public void setDocumento(String documento) {
        this.Documento = documento;
    }

    public String getEspecialidad() {
        return Especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.Especialidad = especialidad;
    }

    public int getFk_centro_salud_ID() {
        return fk_centro_salud_ID;
    }

    public void setFk_centro_salud_ID(int fk_centro_salud_ID) {
        this.fk_centro_salud_ID = fk_centro_salud_ID;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String estado) {
        this.Estado = estado;
    } 

}
