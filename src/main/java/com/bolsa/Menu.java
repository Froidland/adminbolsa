package com.bolsa;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Menu {
    //TODO: Implementar verificacion de datos.

    private static BufferedReader lectura = new BufferedReader(new InputStreamReader(System.in));
    /**
     * Metodo que lista las opciones del menu y solicita al usuario escoger lo que necesita realizar mediante una opcion numerica.
     * @throws IOException 
     */

    public static void runConsole() throws IOException {

        while (true) {
            System.out.println("###   MENU   ###");
            System.out.println();
            System.out.println("1. Crear puesto de trabajo.");
            System.out.println("2. Crear postulante.");
            System.out.println("3. Mostrar puestos de trabajo.");
            System.out.println("4. Mostrar postulantes.");
            System.out.println("5. Eliminar un puesto de trabajo.");
            System.out.println("6. Eliminar un postulante.");
        //    System.out.println("7. Modificar un puesto de trabajo.");
        //    System.out.println("8. Modificar un postulante.");
            System.out.println("0. Salir.");
            System.out.println("-1. Ejecutar prueba.");

            int opcion = Integer.parseInt(lectura.readLine());

            switch (opcion) {
                case 1:
                    clearScreen();
                    menuCrearPuestoTrabajo();
                    break;
                case 2:
                    clearScreen();
                    menuCrearPostulante();
                    break;
                case 3:
                    clearScreen();
                    menuMostrarPuestosDeTrabajo();
                    break;
                case 4:
                    clearScreen();
                    menuMostrarPostulantes();
                    break;
                case 5:
                    clearScreen();
                    menuEliminarPuestoDeTrabajo();
                                       
                    break;
                case 6:
                    clearScreen();
                    menuEliminarPostulante();
                    break;
            /*    case 7:
                    clearScreen();
                    menuModificarPuestoDeTrabajo();
                    break;
                case 8:
                    clearScreen();
                    menuModificarPostulante();
                    break;*/
                case 0:
                    return;
                case -1:
                    Test.runTest();
                    break;
                default:
                    System.out.println("Porfavor ingrese una opcion valida.");
            }
        }
    }
  
    /**
     * Metodo que solicita al usuario ingresar los datos del puesto de trabajo que desea crear.
     * @throws IOException 
     */

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

    /**
     * Metodo que solicita al usuario los datos del postulante a crear y tambien pregunta a que puesto de trabajo desea a�adirlo.
     * @throws IOException 
     */
    private static void menuCrearPostulante() throws IOException {
        //TODO: Implementar sistema de paginas.
        String datoNombre, datoFecha, datoRut, datoDireccion, datoCorreo, datoTelefono;
        int opcion = 0;


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

        while (true) {
            System.out.println("¿A que puesto de trabajo desearia añadir este postulante?: ");
            for (PuestoDeTrabajo puesto : copiaPuestos) {
                System.out.println(i + ". Nombre: " + puesto.getNombre() + " | UUID: " + puesto.getUUID());
            }
            System.out.println("-1. Cancelar la operacion.");

            opcion = Integer.parseInt(lectura.readLine());

            if (opcion == -1) {
                return;
            }

            if (validarOpcion(opcion, 0, copiaPuestos.size())) {
                break;
            }

            System.out.println("Porfavor ingrese una opcion valida.");
        }
        PuestoDeTrabajo puestoSeleccionado = Main.empresa.buscarPuestoDeTrabajo(copiaPuestos.get(opcion - 1).getUUID());
        puestoSeleccionado.anadirPostulante(postulanteNuevo);
    }
    /**
     * Metodo que muestra al usuario los puestos de trabajo existentes de la empresa.
     */
    private static void menuMostrarPuestosDeTrabajo() {
        Main.empresa.mostrarPuestosDeTrabajo();
    }
    /**
     * Metodo que le pregunta al usuario de que puesto de trabajo quiere listar los postulantes.
     * @throws IOException 
     */
    private static void menuMostrarPostulantes() throws IOException {
        int opcion = 0, i = 1;
        ArrayList<PuestoDeTrabajo> copiaPuestos = Main.empresa.getPuestosDeTrabajo();

        while (true) {
            System.out.println("¿De que puesto desea listar los postulantes?: ");
            for (PuestoDeTrabajo puesto : copiaPuestos) {
                System.out.println(i + ". Nombre: " + puesto.getNombre() + " | UUID: " + puesto.getUUID());
                i++;
            }
            System.out.println("-1. Cancelar la operacion.");

            opcion = Integer.parseInt(lectura.readLine());

            if (opcion == -1) {
                return;
            }

            if (validarOpcion(opcion, 0, copiaPuestos.size())) {
                break;
            }

            System.out.println("Porfavor ingrese una opcion valida.");
        }

        copiaPuestos.get(opcion - 1).mostrarPostulantes();
    }
    /**
     * Metodo para eliminar un postulante de un puesto de trabajo. se le pregunta al usuario el puesto de trabajo y el postulante que desea eliminar.
     * @throws IOException 
     */
    private static void menuEliminarPostulante() throws IOException {
        int opcion = 0, i = 1;
        ArrayList<PuestoDeTrabajo> copiaPuestos = Main.empresa.getPuestosDeTrabajo();

        while (true) {
            System.out.println("�De que puesto desea eliminar el postulante?: ");
            for (PuestoDeTrabajo puesto : copiaPuestos) {
                System.out.println(i + ". Nombre: " + puesto.getNombre() + " | UUID: " + puesto.getUUID());
                i++;
            }
            System.out.println("-1. Cancelar la operacion.");

            opcion = Integer.parseInt(lectura.readLine());

            if (opcion == -1) {
                return;
            }

            if (validarOpcion(opcion, 0, copiaPuestos.size())) {
                break;
            }

            System.out.println("Porfavor ingrese una opcion valida.");
        }
        System.out.println("�Que postulante desea eliminar?: ");
        copiaPuestos.get(opcion - 1).mostrarPostulantes();
        System.out.println("Ingrese el Rut del postulante a eliminar: ");
        
        String rutElegido = lectura.readLine();
        copiaPuestos.get(opcion - 1).quitarPostulante(rutElegido);
        
    }
    
    private static void menuEliminarPuestoDeTrabajo() throws IOException {
        int opcion = 0, i = 1;
        ArrayList<PuestoDeTrabajo> copiaPuestos = Main.empresa.getPuestosDeTrabajo();

        while (true) {
            System.out.println("�Que puesto de trabajo desea eliminar?: ");
            for (PuestoDeTrabajo puesto : copiaPuestos) {
                System.out.println(i + ". Nombre: " + puesto.getNombre() + " | UUID: " + puesto.getUUID());
                i++;
            }
            System.out.println("-1. Cancelar la operacion.");

            opcion = Integer.parseInt(lectura.readLine());

            if (opcion == -1) {
                return;
            }

            if (validarOpcion(opcion, 0, copiaPuestos.size())) {
                break;
            }

            System.out.println("Porfavor ingrese una opcion valida.");
        }

        Main.empresa.eliminarPuestoDeTrabajo(copiaPuestos.get(opcion - 1).getUUID());

    }

    private static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    private static boolean validarOpcion(int opcion, int min, int max) {
        return opcion > min && opcion <= max;
    }
}
