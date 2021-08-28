package com.bolsa;

import java.util.ArrayList;
import java.util.Objects;

public class PuestoDeTrabajo {
    private int id;
    private String nombre;
    private int sueldoBase;
    private int vacantes;
    private boolean disponible;
    private ArrayList<Requisito> requisitos;
    private ArrayList<Postulante> postulantes;

    public PuestoDeTrabajo(int id, String nombre, int sueldoBase, int vacantes, boolean disponible, ArrayList<Requisito> requisitos, ArrayList<Postulante> postulantes) {
        this.id = id;
        this.nombre = nombre;
        this.sueldoBase = sueldoBase;
        this.vacantes = vacantes;
        this.disponible = disponible;
        this.requisitos = requisitos;
        this.postulantes = postulantes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getSueldoBase() {
        return sueldoBase;
    }

    public void setSueldoBase(int sueldoBase) {
        this.sueldoBase = sueldoBase;
    }

    public int getVacantes() {
        return vacantes;
    }

    public void setVacantes(int vacantes) {
        this.vacantes = vacantes;
    }

    public ArrayList<Requisito> getRequisitos() {
        return requisitos;
    }

    public void setRequisitos(ArrayList<Requisito> requisitos) {
        this.requisitos = requisitos;
    }

    public ArrayList<Postulante> getPostulantes() {
        return postulantes;
    }

    public void setPostulantes(ArrayList<Postulante> postulantes) {
        this.postulantes = postulantes;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public void anadirPostulante(Postulante nuevoPostulante) {
        this.postulantes.add(nuevoPostulante);
    }

    public void quitarPostulante(String rutPostulanteAQuitar) {
        for (Postulante postulante : this.postulantes) {
            if (postulante.getRut().equals(rutPostulanteAQuitar)) {
                this.postulantes.remove(postulante);
                break;
            }
        }
    }

    public void mostrarPuestoDeTrabajo() {
        System.out.println("ID: "+ this.id);
        System.out.println("Nombre: "+ this.id);
        System.out.println("Sueldo Base: "+ this.sueldoBase);
        System.out.println("Vacantes: "+ this.vacantes);
        System.out.print("¿Esta disponible?: ");

        if (this.isDisponible()) {
            System.out.println("Si.");
        } else {
            System.out.println("No.");
        }

        System.out.println();
        this.mostrarRequisitos();

        System.out.println("###   Lista de postulantes   ###");
        this.mostrarPostulantes();
    }

    public void mostrarRequisitos() {
        System.out.println("Requisitos: ");

        if (this.requisitos.isEmpty()) {
            System.out.println("- Ninguno.");
            System.out.println();
            return;
        }

        for (Requisito requisito : this.requisitos) {
            System.out.println("- " + requisito);
        }

        System.out.println();
    }

    public void mostrarPostulantes() {
        int i = 1;

        for (Postulante postulanteActual : this.postulantes) {
            System.out.println("###   Postulante N°" + i + "   ###");
            postulanteActual.mostrarPostulante();
            System.out.println();
            i++;
        }
    }
}
