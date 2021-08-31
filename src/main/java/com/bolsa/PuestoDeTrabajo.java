package com.bolsa;

import java.util.ArrayList;

public class PuestoDeTrabajo {
    private int id;
    private String nombre;
    private int sueldoBase;
    private int vacantes;
    private boolean disponible;
    private ArrayList<Requisito> requisitos;
    private ArrayList<Postulante> postulantes;

    public PuestoDeTrabajo(int id, String nombre, int sueldoBase, int vacantes, boolean disponible) {
        this.id = id;
        this.nombre = nombre;
        this.sueldoBase = sueldoBase;
        this.vacantes = vacantes;
        this.disponible = disponible;
        this.requisitos = new ArrayList<>();
        this.postulantes = new ArrayList<>();
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

    public void setSueldoBase(double sueldoBase) {
        this.sueldoBase = (int) Math.round(sueldoBase);
    }

    public int getVacantes() {
        return vacantes;
    }

    public void setVacantes(int vacantes) {
        this.vacantes = vacantes;
    }

    public ArrayList<Requisito> getRequisitos() {
        return new ArrayList<>(this.requisitos);
    }

    public void setRequisitos(ArrayList<Requisito> requisitos) {
        this.requisitos = requisitos;
    }

    public ArrayList<Postulante> getPostulantes() {
        return new ArrayList<>(this.postulantes);
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

    public void anadirRequisito(Requisito requisito) {
        this.requisitos.add(requisito);
    }

    public void quitarRequisito(Requisito requisito) {
        this.requisitos.remove(requisito);
    }

    public void quitarPostulante(String rut) {
        for (Postulante postulante : this.postulantes) {
            if (postulante.getRut().equals(rut)) {
                this.postulantes.remove(postulante);
                return;
            }
        }
    }

    public Postulante buscarPostulante(String rut) {
        for (Postulante postulante : this.postulantes) {
            if (postulante.getRut().equals(rut)) {
                return postulante;
            }
        }

        return null;
    }

    public void mostrarPuestoDeTrabajo() {
        System.out.println("ID: "+ this.id);
        System.out.println("Nombre: "+ this.nombre);
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
