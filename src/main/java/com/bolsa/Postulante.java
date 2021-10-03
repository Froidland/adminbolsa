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
        this.rut = parseRut(rut);
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
        this.rut = parseRut(rut);
    }

    private String parseRut(String rut) {
        if (rut.charAt(rut.length() - 2) != '-') {
            String rutPreGuion = rut.substring(0, rut.length() - 1);
            return (rutPreGuion + '-' + rut.charAt(rut.length() - 1));
        }

        return rut;
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
    /**
     * Metodo que indica si un postulante tiene una competencia a traves de true o false.
     * @param competencia 
     * @return 
     */
    public boolean hasCompetencia(Competencia competencia) {
        return this.competencias.contains(competencia);
    }
    /**
     * Metodo que añade una competencia a un postulante.
     * @param competencia 
     */
    public void anadirCompetencia(Competencia competencia) {
        this.competencias.add(competencia);
    }
    /**
     * Metodo que elimina una competencia de un postulante. Debe recibir la competencia que se desea eliminar.
     * @param competencia 
     */
    public void quitarCompetencia(Competencia competencia) {
        this.competencias.remove(competencia);
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
        System.out.println("Competencias: ");

        if (this.competencias.isEmpty()) {
            System.out.println("- Ninguna.");
        } else {
            for (Competencia competencia : this.competencias) {
                System.out.println("- " + competencia.toString().replaceAll("_", " "));
            }
        }
    }

    public String obtenerStringDatosPostulante() {
        StringBuilder datos = new StringBuilder();

        datos.append("Nombre: ").append(this.nombre).append('\n');
        datos.append("Fecha de nacimiento: ").append(this.fechaDeNacimiento).append('\n');
        datos.append("RUT: ").append(this.rut).append('\n');
        datos.append("Direccion: ").append(this.direccion).append('\n');
        datos.append("Correo: ").append(this.correo).append('\n');
        datos.append("Telefono: ").append(this.telefono).append('\n');
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
        System.out.println("Nombre: " + this.nombre + " | RUT: " + this.rut);
    }
}
