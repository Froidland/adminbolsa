package com.bolsa;

import java.util.ArrayList;
import java.util.UUID;

public class Empresa {
    private String rut;
    private String nombre;
    private String direccion;
    private String paginaWeb;
    private String correo;
    private String telefono;
    private ArrayList<PuestoDeTrabajo> puestosDeTrabajo;

    public Empresa(String rut, String nombre, String direccion, String paginaWeb, String correo, String telefono) {
        this.rut = parseRut(rut);
        this.nombre = nombre;
        this.direccion = direccion;
        this.paginaWeb = paginaWeb;
        this.correo = correo;
        this.telefono = telefono;
        this.puestosDeTrabajo = new ArrayList<>();
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getPaginaWeb() {
        return paginaWeb;
    }

    public void setPaginaWeb(String paginaWeb) {
        this.paginaWeb = paginaWeb;
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

    public ArrayList<PuestoDeTrabajo> getPuestosDeTrabajo() {
        return new ArrayList<>(this.puestosDeTrabajo);
    }

    public void anadirPuestoDeTrabajo(PuestoDeTrabajo puesto) {
        this.puestosDeTrabajo.add(puesto);
    }
    /**
     * Este metodo busca un puesto de trabajo, para ello debe recibir el UUID del puesto buscado, en caso de no encontrar el puesto retornará null.
     * @param uuid
     * @return 
     */
    public PuestoDeTrabajo buscarPuestoDeTrabajo(UUID uuid) {
        for (PuestoDeTrabajo puesto : this.puestosDeTrabajo) {
            if (puesto.getUUID().compareTo(uuid) == 0) {
                return puesto;
            }
        }

        return null;
    }
    public void eliminarPuestoDeTrabajo(UUID uuid) {
        PuestoDeTrabajo borrar = null;
        for (PuestoDeTrabajo puesto : this.puestosDeTrabajo) {
            if (puesto.getUUID().compareTo(uuid) == 0) {
                borrar = puesto;
            }
        }
        puestosDeTrabajo.remove(borrar);
        if (borrar == null)
            System.out.println("No se ha podido quitar el postulante porque no se encontró.");
        else
            System.out.println("Postulante eliminado.");
    }
    
    /**
     * Metodo que muestra los datos de la empresa.
     */
    public void mostrarEmpresa() {

        System.out.println("###   Empresa   ###");
        System.out.println("Rut: " + this.rut);
        System.out.println("Nombre: " + this.nombre);
        System.out.println("Direccion: " + this.direccion);
        System.out.println("Pagina web: " + this.paginaWeb);
        System.out.println("Correo: " + this.correo);
        System.out.println("Telefono: " + this.telefono);
        System.out.println();
    }
    /**
     * Método sin parametros que listará todos los puestos de trabajo de una empresa.
     */
    public void mostrarPuestosDeTrabajo() {
        int i = 1;

        System.out.println("###   Puestos de trabajo   ###");
        if (!this.puestosDeTrabajo.isEmpty()) {
            for (PuestoDeTrabajo puesto : this.puestosDeTrabajo) {
                System.out.printf("###   Puesto N°%d   ###\n", i++);
                System.out.println("ID: " + puesto.getUUID());
                System.out.println("Nombre: " + puesto.getNombre());
                System.out.println("Sueldo Base: " + puesto.getSueldoBase());
                System.out.println("Vacantes: " + puesto.getVacantes());
                System.out.print("¿Esta disponible?: ");

                if (puesto.isDisponible()) {
                    System.out.println("Si.");
                } else {
                    System.out.println("No.");
                }

                System.out.println();
                puesto.mostrarRequisitos();

                System.out.println("###   Lista de postulantes   ###");
                puesto.mostrarPostulantes();
            }
        } else {
            System.out.println("Esta empresa no tiene puestos de trabajo.");
        }
    }

    /**
     * Método para listar puestos de trabajo según su disponibilidad.
     * @param disponibilidad Valor (si/no) que determina si se muestran los puestos de trabajo que estan disponibles o los sin disponibilidad.
     */
    public void mostrarPuestosDeTrabajo(boolean disponibilidad) {
        int i = 1;
        boolean flagEncontrado = false;

        System.out.println("###   Puestos de trabajo   ###");
        for (PuestoDeTrabajo puesto : this.puestosDeTrabajo) {
            if (puesto.isDisponible() == disponibilidad) {
                flagEncontrado = true;
                System.out.printf("###   Puesto N°%d   ###\n", i++);
                System.out.println("ID: " + puesto.getUUID());
                System.out.println("Nombre: " + puesto.getNombre());
                System.out.println("Sueldo Base: " + puesto.getSueldoBase());
                System.out.println("Vacantes: " + puesto.getVacantes());

                System.out.println();
                puesto.mostrarRequisitos();

                System.out.println("###   Lista de postulantes   ###");
                puesto.mostrarPostulantes();
            }
        }

        if (!flagEncontrado) {
            System.out.println("Esta empresa no tiene puestos de trabajo disponibles.");
        }
    }
    /**
     * Método que lista los puestos de trabajo deacuerdo a un requisito.
     * @param requisito Es el requisito que se espera que tengan los puestos de trabajo que se listarán.
     */
    public void mostrarPuestosDeTrabajo(Requisito requisito) {
        int i = 1;
        boolean flagEncontrado = false;

        System.out.println("###   Puestos de trabajo   ###");
        for (PuestoDeTrabajo puesto : this.puestosDeTrabajo) {
            if (puesto.hasRequisito(requisito)) {
                flagEncontrado = true;
                System.out.printf("###   Puesto #%d   ###\n", i++);
                System.out.println("ID: " + puesto.getUUID());
                System.out.println("Nombre: " + puesto.getNombre());
                System.out.println("Sueldo Base: " + puesto.getSueldoBase());
                System.out.println("Vacantes: " + puesto.getVacantes());

                System.out.println();
                puesto.mostrarRequisitos();

                System.out.println("###   Lista de postulantes   ###");
                puesto.mostrarPostulantes();
            }
        }

        if (!flagEncontrado) {
            System.out.println("Esta empresa no tiene puestos de trabajo que contengan el requisito " + requisito.name() + ".");
        }
    }
}
