package com.bolsa;

import java.util.UUID;

public class Test {
    public static void runTest() {
        final String ANSI_RESET = "\u001B[0m";
        final String ANSI_BLACK = "\u001B[30m";
        final String ANSI_RED = "\u001B[31m";
        final String ANSI_GREEN = "\u001B[32m";
        final String ANSI_YELLOW = "\u001B[33m";
        final String ANSI_BLUE = "\u001B[34m";
        final String ANSI_PURPLE = "\u001B[35m";
        final String ANSI_CYAN = "\u001B[36m";
        final String ANSI_WHITE = "\u001B[37m";

        Postulante postulante1 = new Postulante(
                "Ella Hyginos",
                "1962-10-20",
                "47261284-8",
                "P. Sherman, Wallaby St. 42, Sydney",
                "jimxugle@msn.com",
                "812-340-3980"
        );

        Postulante postulante2 = new Postulante(
                "Quirino Rosa",
                "1977-05-02",
                "84628364-8",
                "2831 Fincham Road, La Mesa, California",
                "makarow@icloud.com",
                "775-936-8557"
        );

        Postulante postulante3 = new Postulante(
                "Nandita Jasmina",
                "1984-12-30",
                "94726153-4",
                "2805 Conaway Street, Bloomington, Indiana",
                "stakasa@yahoo.com",
                "406-554-8986"
        );

        Empresa empresa1 = new Empresa(
                "79814271-2",
                "Discord",
                "2559 Ridenour Street, MOUNT CLEMENS, Michigan",
                "https://discord.com/",
                "support@discordapp.com",
                "305-999-9880"
        );


        PuestoDeTrabajo puesto1 = new PuestoDeTrabajo(
                "Puesto de prueba",
                500000,
                5
        );

        String nombre = postulante1.getRut();

        // Obtener el id generado aleatoriamente para luego ser buscado en la lista.
        UUID idGenerado = puesto1.getUUID();

        // Prueba: Formato de un rut sin guion.
        postulante3.setRut("947261534");

        System.out.println(ANSI_RED + "Prueba: Cambio de rut.");
        System.out.println("Resultado esperado: " + ANSI_BLUE + "94726153-4");
        System.out.println(ANSI_RED + "Resultado obtenido: " + ANSI_GREEN + postulante3.getRut());
        System.out.println();


        empresa1.anadirPuestoDeTrabajo(puesto1);

        // Prueba: Busqueda de puesto de trabajo por ID y añadirle postulantes.
        empresa1.buscarPuestoDeTrabajo(idGenerado).anadirPostulante(postulante1);
        empresa1.buscarPuestoDeTrabajo(idGenerado).anadirPostulante(postulante2);
        empresa1.buscarPuestoDeTrabajo(idGenerado).anadirPostulante(postulante3);

        System.out.println(ANSI_RED + "Prueba: Agregar postulantes a un puesto de trabajo.");
        System.out.println("Resultado esperado: " + ANSI_BLUE + "Una lista con tres postulantes.");
        System.out.println(ANSI_RED + "Resultado obtenido: " + ANSI_GREEN);

        empresa1.buscarPuestoDeTrabajo(idGenerado).mostrarPostulantes();

        // Prueba: Cambio de sueldo base despues de ser instanciado el puesto de trabajo.
        empresa1.buscarPuestoDeTrabajo(idGenerado).setSueldoBase(500000.576);

        System.out.println(ANSI_RED + "Prueba: Cambio de sueldo.");
        System.out.println("Resultado esperado: " + ANSI_BLUE + "500001");
        System.out.println(ANSI_RED + "Resultado obtenido: " + ANSI_GREEN + empresa1.buscarPuestoDeTrabajo(idGenerado).getSueldoBase());
        System.out.println();

        // Prueba: Buscar un postulante por ID y quitarlo de la lista de postulantes.
        empresa1.buscarPuestoDeTrabajo(idGenerado).quitarPostulante("84628364-8");

        System.out.println(ANSI_RED + "Prueba: Buscar un postulante y quitarlo.");
        System.out.println("Resultado esperado: " + ANSI_BLUE + "Una lista con dos postulantes de los cuales ninguno contenga el rut 84628364-8");
        System.out.println(ANSI_RED + "Resultado obtenido: " + ANSI_GREEN);

        empresa1.buscarPuestoDeTrabajo(idGenerado).mostrarPostulantes();

        // Prueba: Agregar competencias a un postulante despues de ser instanciado.
        empresa1.buscarPuestoDeTrabajo(idGenerado).buscarPostulante("47261284-8").anadirCompetencia(Competencia.TRABAJO_EN_EQUIPO);
        empresa1.buscarPuestoDeTrabajo(idGenerado).buscarPostulante("47261284-8").anadirCompetencia(Competencia.TENACIDAD);
        empresa1.buscarPuestoDeTrabajo(idGenerado).buscarPostulante("47261284-8").anadirCompetencia(Competencia.TOLERANCIA_AL_ESTRES);

        System.out.println(ANSI_RED + "Prueba: Buscar un postulante y agregarle 3 competencias.");
        System.out.println("Resultado esperado: " + ANSI_BLUE + "Una lista con dos postulantes de los cuales uno tiene 3 competencias.");
        System.out.println(ANSI_RED + "Resultado obtenido: " + ANSI_GREEN);

        empresa1.buscarPuestoDeTrabajo(idGenerado).mostrarPostulantes();

        // Prueba: Quitar competencia de un postulante.
        empresa1.buscarPuestoDeTrabajo(idGenerado).buscarPostulante("47261284-8").quitarCompetencia(Competencia.TOLERANCIA_AL_ESTRES);

        System.out.println(ANSI_RED + "Prueba: Quitarle una competencia a un postulante.");
        System.out.println("Resultado esperado: " + ANSI_BLUE + "Un postulante con dos competencias.");
        System.out.println(ANSI_RED + "Resultado obtenido: " + ANSI_GREEN);

        empresa1.buscarPuestoDeTrabajo(idGenerado).buscarPostulante("47261284-8").mostrarPostulante();

        // Prueba: Cambiar la disponibilidad de un puesto de trabajo.
        empresa1.buscarPuestoDeTrabajo(idGenerado).setDisponibilidad(false);

        System.out.println(ANSI_RED + "Prueba: Cambiar disponibilidad de un puesto de trabajo.");
        System.out.println("Resultado esperado: " + ANSI_BLUE + "false");
        System.out.println(ANSI_RED + "Resultado obtenido: " + ANSI_GREEN + empresa1.buscarPuestoDeTrabajo(idGenerado).isDisponible());

        // Prueba: Mostrar puestos de trabajo, filtrando los puestos de trabajo por disponibilidad.
        System.out.println(ANSI_RED + "Prueba: Mostrar puestos dependiendo de disponibilidad.");
        System.out.println("Resultado esperado: " + ANSI_BLUE + "Un mensaje de error indicando que no hay puesto con ese filtro.");
        System.out.println(ANSI_RED + "Resultado obtenido: " + ANSI_GREEN);

        empresa1.mostrarPuestosDeTrabajo(true);

        // Prueba: Agregar requisito a un puesto de trabajo.
        empresa1.buscarPuestoDeTrabajo(idGenerado).anadirRequisito(Requisito.TRABAJO_EN_EQUIPO);

        System.out.println(ANSI_RED + "Prueba: Agregar un requisito a un puesto de trabajo.");
        System.out.println("Resultado esperado: " + ANSI_BLUE + "Una lista con un requisito.");
        System.out.println(ANSI_RED + "Resultado obtenido: " + ANSI_GREEN);

        empresa1.buscarPuestoDeTrabajo(idGenerado).mostrarRequisitos();

        // Prueba: Mostrar datos, filtrando los puestos de trabajo por un requisito especifico.
        System.out.println(ANSI_RED + "Prueba: Filtar puestos por requisito y mostrarlos.");
        System.out.println("Resultado esperado: " + ANSI_BLUE + "Un puesto de trabajo con un requisito.");
        System.out.println(ANSI_RED + "Resultado obtenido: " + ANSI_GREEN);

        empresa1.mostrarPuestosDeTrabajo(Requisito.TRABAJO_EN_EQUIPO);

        // Mostrar datos generales.
        System.out.println(ANSI_CYAN + "###   DATOS GENERALES   ###" + ANSI_BLUE);
        empresa1.mostrarEmpresa();
        empresa1.mostrarPuestosDeTrabajo();
        System.out.print(ANSI_RESET);
    }
}
