package com.example.dispetser;

public class Alimentador {
    private String nombre;
    private String id;
    private int porcentaje_comida;

    public Alimentador(){}

    public Alimentador(String nombre, String id, int porcentaje_comida) {
        this.nombre = nombre;
        this.id = id;
        this.porcentaje_comida = porcentaje_comida;
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
}
