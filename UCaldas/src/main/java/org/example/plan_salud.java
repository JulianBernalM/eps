package org.example;

public class plan_salud {

    private String Nombre;

    private String Descripcion;

    private float Costo;

    public String getNombre() {
        return Nombre;

    }
    public void setNombre(String nombre) {
        this.Nombre = nombre;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.Descripcion = descripcion;
    }

    public float getCosto() {
        return Costo;
    }

    public void setCosto(float costo) {
        this.Costo = costo;
    }   
}
