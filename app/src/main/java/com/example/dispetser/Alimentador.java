package com.example.dispetser;

public class Alimentador {
    private String nombre;
    private String id;
    private int porcentaje_comida;
    private boolean activacion;
    private int porcentaje_llenar;

    public Alimentador(){}

    public Alimentador(String nombre, String id, int porcentaje_comida, boolean activacion, int porcentaje_llenar) {
        this.nombre = nombre;
        this.id = id;
        this.porcentaje_comida = porcentaje_comida;
        this.activacion = activacion;
        this.porcentaje_llenar = porcentaje_llenar;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getPorcentaje_comida() {
        return porcentaje_comida;
    }

    public void setPorcentaje_comida(int porcentaje_comida) {
        this.porcentaje_comida = porcentaje_comida;
    }

    public boolean getActivacion() {
        return activacion;
    }

    public void setActivacion(boolean activacion) {
        this.activacion = activacion;
    }

    public int getPorcentaje_llenar() {
        return porcentaje_llenar;
    }

    public void setPorcentaje_llenar(int porcentaje_llenar) {
        this.porcentaje_llenar = porcentaje_llenar;
    }

    public String toString(){
         return "Nombre del alimentador: " + getNombre() + "\n"
                +"id: " + getId() + "\n"
                +"Porcentaje de Comida: " + String.valueOf(getPorcentaje_comida()) + "\n"
                +"Motor encendido: " + String.valueOf(getActivacion()) + "\n"
                +"Porcentaje a llenar: " + String.valueOf(getPorcentaje_llenar());
    }



}
