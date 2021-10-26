package com.bolsa;

import java.time.LocalDate;
import java.util.ArrayList;

public class PostulantePracticante extends Postulante {
    private double promedioNotas;

    public double getPromedioNotas() {
        return promedioNotas;
    }

    public void setPromedioNotas(double promedioNotas) {
        this.promedioNotas = promedioNotas;
    }

    public PostulantePracticante(String nombre, String fechaDeNacimiento, String rut, String direccion, String correo, String telefono, double promedioNotas) {
        this.nombre = nombre;
        this.fechaDeNacimiento = LocalDate.parse(fechaDeNacimiento);
        this.rut = parseRut(rut);
        this.direccion = direccion;
        this.correo = correo;
        this.telefono = telefono;
        this.promedioNotas = promedioNotas;
        this.competencias = new ArrayList<>();
    }

    /**
     * Metodo que muestra un postulante junto con una lista de sus competencias.
     */
    public void mostrarPostulante() {
        System.out.println("Nombre: " + this.nombre);
        System.out.println("Fecha de nacimiento: " + this.fechaDeNacimiento);
        System.out.println("RUT: " + this.rut);
        System.out.println("Direccion: " + this.direccion);
        System.out.println("Correo: " + this.correo);
        System.out.println("Telefono: " + this.telefono);
        System.out.println("Promedio de notas: " + this.promedioNotas);
        System.out.println("Competencias: ");

        if (this.competencias.isEmpty()) {
            System.out.println("- Ninguna.");
        } else {
            for (Competencia competencia : this.competencias) {
                System.out.println("- " + competencia.toString().replaceAll("_", " "));
            }
        }
    }

    public String toString() {
        StringBuilder datos = new StringBuilder();

        datos.append("Nombre: ").append(this.nombre).append('\n');
        datos.append("Fecha de nacimiento: ").append(this.fechaDeNacimiento).append('\n');
        datos.append("RUT: ").append(this.rut).append('\n');
        datos.append("Direccion: ").append(this.direccion).append('\n');
        datos.append("Correo: ").append(this.correo).append('\n');
        datos.append("Telefono: ").append(this.telefono).append('\n');
        datos.append("Promedio de notas: ").append(this.promedioNotas).append('\n');
        datos.append("Competencias: \n");

        if (this.competencias.isEmpty()) {
            datos.append("- Ninguna.\n");
        } else {
            for (Competencia competencia : this.competencias) {
                datos.append("- ").append(competencia.toString().replaceAll("_", " ")).append('\n');
            }
        }

        return datos.toString();
    }

    public void mostrarPostulanteResumido() {
        System.out.println("Nombre: " + this.nombre + " | RUT: " + this.rut + " | Estado: Practicante");
    }
}
