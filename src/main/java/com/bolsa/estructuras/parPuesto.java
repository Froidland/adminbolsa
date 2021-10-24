package com.bolsa.estructuras;

import com.bolsa.Disponibilidad;

import java.util.UUID;

public class parPuesto implements Disponibilidad {
    private String nombre;
    private UUID uuid;
    private boolean disponibilidad;

    public parPuesto(String nombre, UUID uuid) {
        this.nombre = nombre;
        this.uuid = uuid;
        this.disponibilidad = Disponibilidad.NODISPONIBLE;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public UUID getUUID() {
        return uuid;
    }

    public void setUUID(UUID uuid) {
        this.uuid = uuid;
    }

    public boolean isDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }
}
