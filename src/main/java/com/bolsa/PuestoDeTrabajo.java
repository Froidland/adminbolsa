package com.bolsa;

import java.util.*;

public class PuestoDeTrabajo {
    private int id;
    private String nombre;
    private int sueldoBase;
    private int vacantes;
    private boolean disponibilidad;
    private ArrayList<Requisito> requisitos;
    private HashMap<String,Postulante> postulantes;

    public PuestoDeTrabajo(int id, String nombre, int sueldoBase, int vacantes, boolean disponibilidad) {
        this.id = id;
        this.nombre = nombre;
        this.sueldoBase = sueldoBase;
        this.vacantes = vacantes;
        this.disponibilidad = disponibilidad;
        this.requisitos = new ArrayList<>();
        postulantes = new HashMap<>();
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

    public boolean isDisponible() {
        return disponibilidad;
    }

    public void setDisponibilidad(boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public void anadirPostulante(Postulante nuevoPostulante) {
        this.postulantes.put(nuevoPostulante.getRut(), nuevoPostulante);
    }

    public void anadirRequisito(Requisito requisito) {
        this.requisitos.add(requisito);
    }

    public void quitarRequisito(Requisito requisito) {
        this.requisitos.remove(requisito);
    }

    public void quitarPostulante(String rut) {
        String borrar=null;
        for (Map.Entry<String,Postulante> iterator : postulantes.entrySet()) {
            if(iterator.getKey().equals(rut)){
                borrar = rut;
            }
        }
        postulantes.remove(borrar);
        if(borrar==null)
            System.out.println("No se ha podido quitar el postulante porque no se encontró.");
    }

    public Postulante buscarPostulante(String rut) {
        for (Map.Entry<String,Postulante> iterator : postulantes.entrySet()) {
            if (iterator.getKey().equals(rut)) {
                return postulantes.get(rut);
            }
        }
        return null;
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

    public boolean hasRequisito(Requisito requisito) {
        return this.requisitos.contains(requisito);
    }

    public void mostrarPostulantes() {
        int i = 1;

        for (Map.Entry<String,Postulante> iterator : postulantes.entrySet()) {
            System.out.printf("###   Postulante #%d   ###", i++);
            postulantes.get(iterator.getKey()).mostrarPostulante();
            System.out.println();
        }
    }

    public void mostrarPostulantes(Competencia competencia) {
        int i = 1;

        for (Map.Entry<String,Postulante> iterator : postulantes.entrySet()) {
            if (postulantes.get(iterator.getKey()).hasCompetencia(competencia)) {
                System.out.printf("###   Postulante #%d   ###", i++);
                postulantes.get(iterator.getKey()).mostrarPostulante();
                System.out.println();
            }
        }
    }
}
