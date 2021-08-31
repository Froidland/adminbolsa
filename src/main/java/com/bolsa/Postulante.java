package com.bolsa;

import java.time.LocalDate;
import java.util.ArrayList;

public class Postulante {
    private String nombre;
    private LocalDate fechaDeNacimiento;
    private String rut;
    private String direccion;
    private String correo;
    private String telefono;
    private ArrayList<Competencia> competencias;

    public Postulante(String nombre, String fechaDeNacimiento, String rut, String direccion, String correo, String telefono) {
        this.nombre = nombre;
        this.fechaDeNacimiento = LocalDate.parse(fechaDeNacimiento);
        this.rut = rut;
        this.direccion = direccion;
        this.correo = correo;
        this.telefono = telefono;
        this.competencias = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }

    public void setFechaDeNacimiento(LocalDate fechaDeNacimiento) {
        this.fechaDeNacimiento = fechaDeNacimiento;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        if (rut.charAt(rut.length() - 2) != '-') {
            String rutPreGuion = rut.substring(0, rut.length() - 1);
            this.rut = rutPreGuion + '-' + rut.charAt(rut.length() - 1);
            return;
        }
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

    public ArrayList<Competencia> getCompetencias() {
        return new ArrayList<>(this.competencias);
    }

    public void setCompetencias(ArrayList<Competencia> competencias) {
        this.competencias = competencias;
    }

    public void anadirCompetencia(Competencia competencia) {
        this.competencias.add(competencia);
    }

    public void quitarCompetencia(Competencia competencia) {
        this.competencias.remove(competencia);
    }

    public void mostrarPostulante() {
        System.out.println("Nombre: " + this.nombre);
        System.out.println("Fecha de nacimiento: " + this.fechaDeNacimiento);
        System.out.println("Rut: " + this.rut);
        System.out.println("Direccion: " + this.direccion);
        System.out.println("Correo: " + this.correo);
        System.out.println("Telefono: " + this.telefono);
        System.out.println("Competencias: ");

        if (this.competencias.isEmpty()) {
            System.out.println("- Ninguna.");
        } else {
            for (Competencia competencia : this.competencias) {
                System.out.println("- " + competencia);
            }
        }
    }
}
