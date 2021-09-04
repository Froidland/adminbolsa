package com.bolsa;

import java.util.ArrayList;
/**
 * 
 * 
 */
public class Empresa {
    private String rut;
    private String nombre;
    private String direccion;
    private String paginaWeb;
    private String correo;
    private String telefono;
    private ArrayList<PuestoDeTrabajo> puestosDeTrabajo;

    public Empresa(String rut, String nombre, String direccion, String paginaWeb, String correo, String telefono) {
        this.rut = rut;
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
        if (rut.charAt(rut.length() - 2) != '-') {
            String rutPreGuion = rut.substring(0, rut.length() - 1);
            this.rut = rutPreGuion + '-' + rut.charAt(rut.length() - 1);
            return;
        }
        this.rut = rut;
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

    public void anadirPuestoDeTrabajo(PuestoDeTrabajo puesto) {
        this.puestosDeTrabajo.add(puesto);
    }

    public PuestoDeTrabajo buscarPuestoDeTrabajo(int id) {
        for (PuestoDeTrabajo puesto : this.puestosDeTrabajo) {
            if (puesto.getId() == id) {
                return puesto;
            }
        }

        return null;
    }

    public void mostrarEmpresa() {
        int i = 1;
        System.out.println("###   Empresa   ###");
        System.out.println("Rut: " + this.rut);
        System.out.println("Nombre: " + this.nombre);
        System.out.println("Direccion: " + this.direccion);
        System.out.println("Pagina web: " + this.paginaWeb);
        System.out.println("Correo: " + this.correo);
        System.out.println("Telefono: " + this.telefono);
        System.out.println();
    }

    public void mostrarPuestosDeTrabajo() {
        System.out.println("###   Puestos de trabajo   ###");
        if (!this.puestosDeTrabajo.isEmpty()) {
            for (PuestoDeTrabajo puesto : this.puestosDeTrabajo) {
                System.out.println("ID: " + puesto.getId());
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


    public void mostrarPuestosDeTrabajo(boolean disponibilidad) {
        int i = 1;
        boolean flagEncontrado = false;

        System.out.println("###   Puestos de trabajo   ###");
        for (PuestoDeTrabajo puesto : this.puestosDeTrabajo) {
            if (puesto.isDisponible() == disponibilidad) {
                flagEncontrado = true;
                System.out.printf("###   Puesto N°%d   ###", i++);
                System.out.println("ID: "+ puesto.getId());
                System.out.println("Nombre: "+ puesto.getNombre());
                System.out.println("Sueldo Base: "+ puesto.getSueldoBase());
                System.out.println("Vacantes: "+ puesto.getVacantes());

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

    public void mostrarPuestoDeTrabajo(Requisito requisito) {
        int i = 1;
        boolean flagEncontrado = false;

        System.out.println("###   Puestos de trabajo   ###");
        for (PuestoDeTrabajo puesto : this.puestosDeTrabajo) {
            if (puesto.hasRequisito(requisito)) {
                flagEncontrado = true;
                System.out.printf("###   Puesto N°%d   ###", i++);
                System.out.println("ID: " + puesto.getId());
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
