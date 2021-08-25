package com.bolsa;

import java.util.ArrayList;

public class Postulante {
    //TODO: Cambiar edad a fecha de nacimiento.
    private String nombre;
    private int edad;
    private String rut;
    private String direccion;
    private String correo;
    private String telefono;

    public Postulante(String nombre, int edad, String rut, String direccion, String correo, String telefono) {
        this.nombre = nombre;
        this.edad = edad;
        this.rut = rut;
        this.direccion = direccion;
        this.correo = correo;
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void mostrarPostulante() {
        System.out.println("Nombre: " + this.nombre);
        System.out.println("Edad: " + this.edad);
        System.out.println("Rut: " + this.rut);
        System.out.println("Direccion: " + this.direccion);
        System.out.println("Correo: " + this.correo);
        System.out.println("Telefono: " + this.telefono);
    }
}
