package com.bolsa.estructuras;

import java.util.UUID;

public class parPuesto {
    private String nombre;
    private UUID uuid;

    public parPuesto(String nombre, UUID uuid) {
        this.nombre = nombre;
        this.uuid = uuid;
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

}
