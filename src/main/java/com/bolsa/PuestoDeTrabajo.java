package com.bolsa;

import java.util.*;

public class PuestoDeTrabajo implements Disponibilidad {
    private UUID id;
    private String nombre;
    private int sueldoBase;
    private int vacantes;
    private boolean disponibilidad;
    private ArrayList<Competencia> competenciasRequeridas;
    private HashMap<String, Postulante> postulantes;
    private ArrayList<Postulante> postulantesSeleccionados;

    public PuestoDeTrabajo(String nombre, int sueldoBase, int vacantes) {
        this.id = UUID.randomUUID();
        this.nombre = nombre;
        this.sueldoBase = sueldoBase;
        this.vacantes = vacantes;
        this.disponibilidad = false;
        this.competenciasRequeridas = new ArrayList<>();
        this.postulantes = new HashMap<>();
        this.postulantesSeleccionados = new ArrayList<Postulante>();
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

    public ArrayList<Competencia> getCompetenciasRequeridas() {
        return new ArrayList<>(this.competenciasRequeridas);
    }

    public boolean isDisponible() {
        return disponibilidad;
    }

    public void setDisponibilidad(boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public void setDisponibilidad(String disponibilidad) {
        if (disponibilidad.toLowerCase().contentEquals("si")) {
            this.disponibilidad = Disponibilidad.DISPONIBLE;
            return;
        }

        if (disponibilidad.toLowerCase().contentEquals("no")) {
            this.disponibilidad = Disponibilidad.NODISPONIBLE;
        }
    }

    public void anadirPostulante(Postulante nuevoPostulante) {
        this.postulantes.put(nuevoPostulante.getRut(), nuevoPostulante);
    }

    public void anadirCompetenciaRequerida(Competencia competencia) {
        this.competenciasRequeridas.add(competencia);
    }

    public void quitarCompetenciaRequerida(Competencia competencia) {
        this.competenciasRequeridas.remove(competencia);
    }

    /**
     * Metodo que elimina un postulante, debe recibir el rut del postulante que se busca eliminar.
     *
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
     *
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
     * Este metodo muestra las competencias requeridas de un puesto de trabajo.
     */
    public void mostrarCompetenciasRequeridas() {
        System.out.println("Competencias requeridas: ");

        if (this.competenciasRequeridas.isEmpty()) {
            System.out.println("- Ninguno.");
            System.out.println();
            return;
        }

        for (Competencia competencia : this.competenciasRequeridas) {
            System.out.println("- " + competencia.toString().replaceAll("_", " "));
        }

        System.out.println();
    }

    /**
     * Este metodo recibe una competencia y revisa si se encuentra dentro de las competencias que tiene un puesto de trabajo.
     *
     * @param competencia
     * @return true o false dependiendo de si la competencia fue encontrada.
     */
    public boolean hasCompetencia(Competencia competencia) {
        return this.competenciasRequeridas.contains(competencia);
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
     *
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

    public String obtenerStringDatosPostulantes() {
        StringBuilder datos = new StringBuilder();
        int i = 1;

        for (Map.Entry<String, Postulante> iterator : postulantes.entrySet()) {
            datos.append("###   Postulante #").append(i++).append("   ###\n");
            datos.append(postulantes.get(iterator.getKey()).toString()).append('\n');
        }

        return datos.toString();
    }

    public void mostrarPostulantesResumido() {
        int i = 1;

        for (Map.Entry<String, Postulante> iterator : postulantes.entrySet()) {
            System.out.print(i + ". ");
            postulantes.get(iterator.getKey()).mostrarPostulanteResumido();
            System.out.println();
        }
    }

    public PostulantePracticante practicanteMayorPromedioEnPuesto() {
        PostulantePracticante practicanteMayorPromedio = null;
        double mayorPromedio = 0, promedioPracticanteActual = 0;

        for (Map.Entry<String, Postulante> iterator : postulantes.entrySet()) {
            if (postulantes.get(iterator.getKey()) instanceof PostulantePracticante) {
                promedioPracticanteActual = ((PostulantePracticante) postulantes.get(iterator.getKey())).getPromedioNotas();

                if (promedioPracticanteActual > mayorPromedio) {
                    mayorPromedio = promedioPracticanteActual;
                    practicanteMayorPromedio = ((PostulantePracticante) postulantes.get(iterator.getKey()));
                }
            }
        }
        return practicanteMayorPromedio;
    }

    public void seleccionarPostulantes() {
        int cantidadCompetenciasACumplir = this.competenciasRequeridas.size();

        for (Map.Entry<String, Postulante> iterator : postulantes.entrySet()) {
            int cantidadCompetenciasPostulante = 0;

            for (Competencia competencia : this.competenciasRequeridas) {
                if (iterator.getValue().competencias.contains(competencia)) {
                    cantidadCompetenciasPostulante++;
                }
            }

            if (cantidadCompetenciasPostulante == cantidadCompetenciasACumplir) {
                this.postulantesSeleccionados.add(iterator.getValue());
            }
        }
    }
}
