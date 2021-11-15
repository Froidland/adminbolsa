package com.bolsa.estructuras;

import com.bolsa.interfaces.Disponibilidad;

import java.util.UUID;

public class ParPostulante {
    private String nombre;
    private String rut;

    public ParPostulante(String nombre, String rut) {
        this.nombre = nombre;
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }
}