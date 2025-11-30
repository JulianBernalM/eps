package org.example;

public class usuario {

    private String Nombre;

    private String Contraseña;

    private String Email;

    private String Rol;

    private int fk_Afiliado_ID;

    private int fk_profesional_ID;

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        this.Nombre = nombre;
    }

    public String getContraseña() {
        return Contraseña;
    }

    public void setContraseña(String contraseña) {
        this.Contraseña = contraseña;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        this.Email = email;
    }

    public String getRol() {
        return Rol;
    }

    public void setRol(String rol) {
        this.Rol = rol;
    }

    public int getFk_Afiliado_ID() {
        return fk_Afiliado_ID;
    }

    public void setFk_Afiliado_ID(int fk_Afiliado_ID) {
        this.fk_Afiliado_ID = fk_Afiliado_ID;
    }

    public int getFk_profesional_ID() {
        return fk_profesional_ID;
    }

    public void setFk_profesional_ID(int fk_profesional_ID) {
        this.fk_profesional_ID = fk_profesional_ID;
    }

}
