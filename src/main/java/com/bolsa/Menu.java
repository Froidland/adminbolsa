package com.bolsa;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Menu {

    private static BufferedReader lectura = new BufferedReader(new InputStreamReader(System.in));

    public static void runConsole() throws IOException {

        while (true) {
            System.out.println("###   MENU   ###");
            System.out.println();
            System.out.println("1. Crear puesto de trabajo.");
            System.out.println("2. Crear postulante.");
            System.out.println("3. Mostrar puestos de trabajo.");
            System.out.println("4. Mostrar postulantes.");
            System.out.println("5. Modificar datos");
            System.out.println("0. Salir.");
            System.out.println("-1. Ejecutar prueba.");

            String opcion = lectura.readLine();

            switch (opcion) {
                case "1":
                    clearScreen();
                    menuCrearPuestoTrabajo();
                    break;
                case "2":
                    clearScreen();
                    menuCrearPostulante();
                    break;
                case "3" :
                    clearScreen();
                    menuMostrarPuestosDeTrabajo();
                    break;
                case "4" :
                    clearScreen();
                    menuMostrarPostulantes();
                case "5" :
                    clearScreen();
                    System.out.println("Funcion no implementada actualmente.");
                case "0":
                    return;
                case "-1":
                    Test.runTest();
                    break;
                default:
                    System.out.println("Porfavor ingrese una opcion valida.");
            }
        }
    }

    private static void menuCrearPuestoTrabajo() throws IOException {
        String datoNombre, datoDisponibilidad;
        int datoSueldo, datoVacantes;

        System.out.println("###   CREAR PUESTO DE TRABAJO   ###");
        System.out.println("Ingrese el nombre del puesto de trabajo: ");
        datoNombre = lectura.readLine();
        System.out.println("Ingrese el sueldo base del puesto: ");
        datoSueldo = Integer.parseInt(lectura.readLine());
        System.out.println("Ingrese las cantidad de vacantes que tiene el puesto: ");
        datoVacantes = Integer.parseInt(lectura.readLine());
        System.out.println("¿Esta disponible este puesto de trabajo? (Si/No): ");
        datoDisponibilidad = lectura.readLine();

        PuestoDeTrabajo puestoNuevo = new PuestoDeTrabajo(
                datoNombre,
                datoSueldo,
                datoVacantes
        );

        puestoNuevo.setDisponibilidad(datoDisponibilidad);

        Main.empresa.anadirPuestoDeTrabajo(puestoNuevo);
    }

    private static void menuCrearPostulante() throws IOException {
        String datoNombre, datoFecha, datoRut, datoDireccion, datoCorreo, datoTelefono;
        String opcion;

        System.out.println("###   CREAR POSTULANTE   ###");
        System.out.println("Ingrese el nombre del postulante: ");
        datoNombre = lectura.readLine();
        System.out.println("Ingrese la fecha de nacimiento del postulante (aaaa-mm-dd): ");
        datoFecha = lectura.readLine();
        System.out.println("Ingrese el RUT del postulante: ");
        datoRut = lectura.readLine();
        System.out.println("Ingrese la direccion del postulante: ");
        datoDireccion = lectura.readLine();
        System.out.println("Ingrese el correo del postulante: ");
        datoCorreo = lectura.readLine();
        System.out.println("Ingrese el telefono del postulante: ");
        datoTelefono = lectura.readLine();

        Postulante postulanteNuevo = new Postulante(
                datoNombre,
                datoFecha,
                datoRut,
                datoDireccion,
                datoCorreo,
                datoTelefono
        );

        int i = 1;
        ArrayList<PuestoDeTrabajo> copiaPuestos = Main.empresa.getPuestosDeTrabajo();

        System.out.println("A que puesto de trabajo desearia añadir este postulante: ");
        for (PuestoDeTrabajo puesto : copiaPuestos) {
            System.out.println(i + ". Nombre: " + puesto.getNombre() + " | UUID: " + puesto.getUUID());
        }
        opcion = lectura.readLine();

        PuestoDeTrabajo puestoSeleccionado =  Main.empresa.buscarPuestoDeTrabajo(copiaPuestos.get(Integer.parseInt(opcion) - 1).getUUID());
        puestoSeleccionado.anadirPostulante(postulanteNuevo);
    }

    private static void menuMostrarPuestosDeTrabajo() {
        Main.empresa.mostrarPuestosDeTrabajo();
    }

    private static void menuMostrarPostulantes() throws IOException {
        int i = 1;
        String opcion;
        ArrayList<PuestoDeTrabajo> copiaPuestos = Main.empresa.getPuestosDeTrabajo();

        System.out.println("A que puesto de trabajo desearia añadir este postulante: ");
        for (PuestoDeTrabajo puesto : copiaPuestos) {
            System.out.println(i + ". Nombre: " + puesto.getNombre() + " | UUID: " + puesto.getUUID());
        }
        opcion = lectura.readLine();

        copiaPuestos.get(Integer.parseInt(opcion) - 1).mostrarPostulantes();
    }

    private static void menuModificarDatos() {
        System.out.println("Opcion no implementada.");
    }

    private static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
