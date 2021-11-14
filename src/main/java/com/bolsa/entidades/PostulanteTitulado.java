package com.bolsa.entidades;

import com.bolsa.Competencia;

import java.time.LocalDate;
import java.util.ArrayList;

public class PostulanteTitulado extends Postulante {
    private int anosDeExperiencia;

    public int getAnosDeExperiencia() {
        return anosDeExperiencia;
    }

    public void setAnosDeExperiencia(int anosDeExperiencia) {
        this.anosDeExperiencia = anosDeExperiencia;
    }

    public PostulanteTitulado(String nombre, String fechaDeNacimiento, String rut, String direccion, String correo, String telefono, int anosDeExperiencia) {
        this.nombre = nombre;
        this.fechaDeNacimiento = LocalDate.parse(fechaDeNacimiento);
        this.rut = parseRut(rut);
        this.direccion = direccion;
        this.correo = correo;
        this.telefono = telefono;
        this.anosDeExperiencia = anosDeExperiencia;
        this.competencias = new ArrayList<>();
    }

    @Override
    public void mostrarPostulante() {
        System.out.println("Nombre: " + this.nombre);
        System.out.println("Fecha de nacimiento: " + this.fechaDeNacimiento);
        System.out.println("RUT: " + this.rut);
        System.out.println("Direccion: " + this.direccion);
        System.out.println("Correo: " + this.correo);
        System.out.println("Telefono: " + this.telefono);
        System.out.println("Años de experiencia: " + this.anosDeExperiencia);
        System.out.println("Competencias: ");

        if (this.competencias.isEmpty()) {
            System.out.println("- Ninguna.");
        } else {
            for (Competencia competencia : this.competencias) {
                System.out.println("- " + competencia.toString().replaceAll("_", " "));
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder datos = new StringBuilder();

        datos.append("Nombre: ").append(this.nombre).append('\n');
        datos.append("Fecha de nacimiento: ").append(this.fechaDeNacimiento).append('\n');
        datos.append("RUT: ").append(this.rut).append('\n');
        datos.append("Direccion: ").append(this.direccion).append('\n');
        datos.append("Correo: ").append(this.correo).append('\n');
        datos.append("Telefono: ").append(this.telefono).append('\n');
        datos.append("Años de experiencia: ").append(this.anosDeExperiencia).append('\n');
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

    @Override
    public void mostrarPostulanteResumido() {
        System.out.println("Nombre: " + this.nombre + " | RUT: " + this.rut + " | Estado: Titulado");
    }
}
