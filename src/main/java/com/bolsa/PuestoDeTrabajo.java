package com.bolsa;

import java.util.*;

public class PuestoDeTrabajo {
    private UUID id;
    private String nombre;
    private int sueldoBase;
    private int vacantes;
    private boolean disponibilidad;
    private ArrayList<Requisito> requisitos;
    private HashMap<String, Postulante> postulantes;

    public PuestoDeTrabajo(String nombre, int sueldoBase, int vacantes) {
        this.id = UUID.randomUUID();
        this.nombre = nombre;
        this.sueldoBase = sueldoBase;
        this.vacantes = vacantes;
        this.disponibilidad = false;
        this.requisitos = new ArrayList<>();
        this.postulantes = new HashMap<>();
    }

    public UUID getUUID() {
        return id;
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

    public void setDisponibilidad(String disponibilidad) {
        if (disponibilidad.toLowerCase().contentEquals("si")) {
            this.disponibilidad = true;
            return;
        }

        if (disponibilidad.toLowerCase().contentEquals("no")) {
            this.disponibilidad = false;
        }
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
    /**
     * Metodo que elimina un postulante, debe recibir el rut del postulante que se busca eliminar.
     * @param rut 
     */
    public void quitarPostulante(String rut) {
        String borrar = null;
        for (Map.Entry<String, Postulante> iterator : postulantes.entrySet()) {
            if (iterator.getKey().equals(rut)) {
                borrar = rut;
                break;
            }
        }
        postulantes.remove(borrar);
        if (borrar == null)
            System.out.println("No se ha podido quitar el postulante porque no se encontró.");
        else
            System.out.println("Postulante eliminado.");
    }
    /**
     * Metodo que busca un postulante, debe recibir el rut del postulante que se busca.
     * @param rut
     * @return Este metodo retorna el postulante si es encontrado, en caso contrario retorna null.
     */
    public Postulante buscarPostulante(String rut) {
        for (Map.Entry<String, Postulante> iterator : postulantes.entrySet()) {
            if (iterator.getKey().equals(rut)) {
                return postulantes.get(rut);
            }
        }
        return null;
    }
    /**
     * Este metodo muestra los requisitos de un puesto de trabajo.
     */
    public void mostrarRequisitos() {
        System.out.println("Requisitos: ");

        if (this.requisitos.isEmpty()) {
            System.out.println("- Ninguno.");
            System.out.println();
            return;
        }

        for (Requisito requisito : this.requisitos) {
            System.out.println("- " + requisito.toString().replaceAll("_", " "));
        }

        System.out.println();
    }
    /**
     * Este metodo recibe un requisito y revisa si se encuentra dentro de los requisitos que tiene un puesto de trabajo.
     * @param requisito
     * @return true o false dependiendo de si el requisito fue encontrado.
     */
    public boolean hasRequisito(Requisito requisito) {
        return this.requisitos.contains(requisito);
    }
    /**
     * Metodo para listar los postulantes de un puesto de trabajo.
     */
    public void mostrarPostulantes() {
        int i = 1;

        for (Map.Entry<String, Postulante> iterator : postulantes.entrySet()) {
            System.out.printf("###   Postulante #%d   ###\n", i++);
            postulantes.get(iterator.getKey()).mostrarPostulante();
            System.out.println();
        }
    }
    /**
     * Metodo que muestra los postulantes de un puesto de trabajo, siempre que tengan la competencia que se requiere. 
     * @param competencia Competencia que se espera tengan los postulantes a mostrar.
     */
    public void mostrarPostulantes(Competencia competencia) {
        int i = 1;

        for (Map.Entry<String, Postulante> iterator : postulantes.entrySet()) {
            if (postulantes.get(iterator.getKey()).hasCompetencia(competencia)) {
                System.out.printf("###   Postulante #%d   ###\n", i++);
                postulantes.get(iterator.getKey()).mostrarPostulante();
                System.out.println();
            }
        }
    }
    public void mostrarPostulantesResumido() {
        int i = 1;

        for (Map.Entry<String, Postulante> iterator : postulantes.entrySet()) {
            System.out.print(i + ". ");
            postulantes.get(iterator.getKey()).mostrarPostulanteResumido();
            System.out.println();
        }
    }
}
