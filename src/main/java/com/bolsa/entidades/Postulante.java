package com.bolsa.entidades;

import com.bolsa.Competencia;
import com.bolsa.interfaces.Seleccionable;

import java.time.LocalDate;
import java.util.ArrayList;

public abstract class Postulante implements Seleccionable {
    protected String nombre;
    protected LocalDate fechaDeNacimiento;
    protected String rut;
    protected String direccion;
    protected String correo;
    protected String telefono;
    protected boolean seleccionado;
    protected ArrayList<Competencia> competencias;

    public Postulante() {
        this.nombre = "";
        this.fechaDeNacimiento = LocalDate.MIN;
        this.rut = "";
        this.direccion = "";
        this.correo = "";
        this.telefono = "";
        this.seleccionado = Seleccionable.NOSELECCIONADO;
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

    protected String parseRut(String rut) {
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

    public boolean isSeleccionado() {
        return seleccionado;
    }

    public void setSeleccionado(boolean seleccionado) {
        this.seleccionado = seleccionado;
    }

    public ArrayList<Competencia> getCompetencias() {
        return new ArrayList<>(this.competencias);
    }

    /**
     * Metodo que indica si un postulante tiene una competencia a traves de true o false.
     *
     * @param competencia
     * @return
     */
    public boolean hasCompetencia(Competencia competencia) {
        return this.competencias.contains(competencia);
    }

    /**
     * Metodo que añade una competencia a un postulante.
     *
     * @param competencia
     */
    public void anadirCompetencia(Competencia competencia) {
        this.competencias.add(competencia);
    }

    /**
     * Metodo que elimina una competencia de un postulante. Debe recibir la competencia que se desea eliminar.
     *
     * @param competencia
     */
    public void quitarCompetencia(Competencia competencia) {
        this.competencias.remove(competencia);
    }

    /**
     * Metodo que muestra un postulante junto con una lista de sus competencias.
     */
    public void seleccionar() {
        this.seleccionado = Seleccionable.SELECCIONADO;
    }

    public abstract void mostrarPostulante();

    public abstract String toString();

    public abstract void mostrarPostulanteResumido();

    public abstract boolean esPracticante();
}
