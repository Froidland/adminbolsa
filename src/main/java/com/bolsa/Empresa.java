package com.bolsa;

import java.util.ArrayList;
import java.util.UUID;
import com.bolsa.estructuras.ParPuesto;

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

    public void anadirPuestoDeTrabajo(PuestoDeTrabajo puesto) {
        this.puestosDeTrabajo.add(puesto);
    }

    /**
     * Este metodo busca un puesto de trabajo, para ello debe recibir el UUID del puesto buscado, en caso de no encontrar el puesto retornará null.
     *
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

    public String obtenerStringDatosEmpresa() {
        StringBuilder datos = new StringBuilder();

        datos.append("###   Empresa   ###\n");
        datos.append("Rut: ").append(this.rut).append('\n');
        datos.append("Nombre: ").append(this.nombre).append('\n');
        datos.append("Direccion: ").append(this.direccion).append('\n');
        datos.append("Pagina web: ").append(this.paginaWeb).append('\n');
        datos.append("Correo: ").append(this.correo).append('\n');
        datos.append("Telefono: ").append(this.telefono).append("\n\n");

        return datos.toString();
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

                System.out.println("###   Competencias requeridas   ###");
                System.out.println();
                puesto.mostrarCompetenciasRequeridas();

                System.out.println("###   Lista de postulantes   ###");
                puesto.mostrarPostulantes();
            }
        } else {
            System.out.println("Esta empresa no tiene puestos de trabajo.");
        }
    }

    public String obtenerStringDatosPuestosDeTrabajo() {
        int i = 1, j = 1;
        StringBuilder datos = new StringBuilder();


        datos.append("###   Puestos de trabajo   ###\n");
        if (!this.puestosDeTrabajo.isEmpty()) {
            for (PuestoDeTrabajo puesto : this.puestosDeTrabajo) {
                datos.append("###   Puesto #").append(i++).append("   ###\n");
                datos.append("ID: ").append(puesto.getUUID()).append('\n');
                datos.append("Nombre: ").append(puesto.getNombre()).append('\n');
                datos.append("Sueldo Base: ").append(puesto.getSueldoBase()).append('\n');
                datos.append("Vacantes: ").append(puesto.getVacantes()).append('\n');
                datos.append("¿Esta disponible?: ");

                if (puesto.isDisponible()) {
                    datos.append("Si.\n\n");
                } else {
                    datos.append("No.\n\n");
                }

                datos.append("###   Competencias requeridas   ###\n");

                if (puesto.getCompetenciasRequeridas().isEmpty()) {
                    datos.append("- Ninguno.\n\n");
                } else {
                    for (Competencia competencia : puesto.getCompetenciasRequeridas()) {
                        datos.append("- ").append(competencia.toString().replaceAll("_", " ")).append('\n');
                    }
                }
                datos.append('\n');


                datos.append("###   Lista de postulantes   ###\n");
                datos.append(puesto.obtenerStringDatosPostulantes());
            }
        } else {
            datos.append("Esta empresa no tiene puestos de trabajo.\n");
        }


        return datos.toString();
    }

    /**
     * Método para listar puestos de trabajo según su disponibilidad.
     *
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
                puesto.mostrarCompetenciasRequeridas();

                System.out.println("###   Lista de postulantes   ###");
                puesto.mostrarPostulantesResumido();
            }
        }

        if (!flagEncontrado) {
            System.out.println("Esta empresa no tiene puestos de trabajo disponibles.");
        }
    }

    /**
     * Método que lista los puestos de trabajo deacuerdo a una competencia.
     *
     * @param competencia Es la competencia que se espera que tengan los puestos de trabajo que se listarán.
     */
    public void mostrarPuestosDeTrabajo(Competencia competencia) {
        int i = 1;
        boolean flagEncontrado = false;

        System.out.println("###   Puestos de trabajo   ###");
        for (PuestoDeTrabajo puesto : this.puestosDeTrabajo) {
            if (puesto.hasCompetencia(competencia)) {
                flagEncontrado = true;
                System.out.printf("###   Puesto #%d   ###\n", i++);
                System.out.println("ID: " + puesto.getUUID());
                System.out.println("Nombre: " + puesto.getNombre());
                System.out.println("Sueldo Base: " + puesto.getSueldoBase());
                System.out.println("Vacantes: " + puesto.getVacantes());

                System.out.println();
                puesto.mostrarCompetenciasRequeridas();

                System.out.println("###   Lista de postulantes   ###");
                puesto.mostrarPostulantesResumido();
            }
        }

        if (!flagEncontrado) {
            System.out.println("Esta empresa no tiene puestos de trabajo que contengan el requisito " + competencia.name() + ".");
        }
    }

    public ArrayList<ParPuesto> obtenerParPuestosDeTrabajo() {
        ArrayList<ParPuesto> listaPuestos = new ArrayList<>();

        for (PuestoDeTrabajo puesto : puestosDeTrabajo) {
            listaPuestos.add(new ParPuesto(puesto.getNombre(), puesto.getUUID()));
        }

        return listaPuestos;
    }

    public void mostrarPracticanteMayorPromedio() {
        PostulantePracticante practicanteActual;
        String nombrePracticanteMayorPromedio = null;
        double mayorPromedio = 0, promedioActual;

        for (PuestoDeTrabajo puesto : this.puestosDeTrabajo) {
            practicanteActual = puesto.practicanteMayorPromedioEnPuesto();
            promedioActual = practicanteActual.getPromedioNotas();

            if (promedioActual > mayorPromedio) {
                nombrePracticanteMayorPromedio = practicanteActual.getNombre();
                mayorPromedio = promedioActual;
            }
        }

        System.out.println("El practicante con el mayor promedio es " + nombrePracticanteMayorPromedio + " con un promedio de" + mayorPromedio);
    }

    public void seleccionarPostulantesGlobal() {
        for (PuestoDeTrabajo puesto : this.puestosDeTrabajo) {
            puesto.seleccionarPostulantes();
        }
    }
}
