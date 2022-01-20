package com.example.dispetser;

public class Cuenta {
    private String Usuario;
    private String Nombres;
    private String Apellidos;
    private String Clave;
    private String Correo;

    private Cuenta(){}

    public Cuenta(String usuario, String nombres, String apellidos, String clave, String correo) {
        this.Usuario = usuario;
        this.Nombres = nombres;
        this.Apellidos = apellidos;
        this.Clave = clave;
        this.Correo = correo;
    }

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String usuario) {
        Usuario = usuario;
    }

    public String getNombres() {
        return Nombres;
    }

    public void setNombres(String nombres) {
        Nombres = nombres;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public void setApellidos(String apellidos) {
        Apellidos = apellidos;
    }

    public String getClave() {
        return Clave;
    }

    public void setClave(String clave) {
        Clave = clave;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String correo) {
        Correo = correo;
    }

}
