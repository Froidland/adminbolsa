package com.bolsa;

public class Test {
    public static void runTest() {
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
                5,
                true
        );

        // Obtener el id generado aleatoriamente para luego ser buscado en la lista.
        String idGenerado = puesto1.getId().toString();

        // Prueba: Formato de un rut sin guion.
        postulante3.setRut("947261534");

        empresa1.anadirPuestoDeTrabajo(puesto1);

        // Prueba: Busqueda de puesto de trabajo por ID y añadirle postulantes.
        empresa1.buscarPuestoDeTrabajo(idGenerado).anadirPostulante(postulante1);
        empresa1.buscarPuestoDeTrabajo(idGenerado).anadirPostulante(postulante2);
        empresa1.buscarPuestoDeTrabajo(idGenerado).anadirPostulante(postulante3);

        // Mostrar datos.
        empresa1.mostrarEmpresa();
        empresa1.mostrarPuestosDeTrabajo();

        // Prueba: Cambio de sueldo base despues de ser instanciado el puesto de trabajo.
        empresa1.buscarPuestoDeTrabajo(idGenerado).setSueldoBase(500000.576);

        // Prueba: Buscar un postulante por ID y quitarlo de la lista de postulantes.
        empresa1.buscarPuestoDeTrabajo(idGenerado).quitarPostulante("84628364-8");

        // Mostrar datos.
        empresa1.mostrarEmpresa();
        empresa1.mostrarPuestosDeTrabajo();

        // Prueba: Agregar competencias a un postulante despues de ser instanciado.
        empresa1.buscarPuestoDeTrabajo(idGenerado).buscarPostulante("47261284-8").anadirCompetencia(Competencia.TEST1);
        empresa1.buscarPuestoDeTrabajo(idGenerado).buscarPostulante("47261284-8").anadirCompetencia(Competencia.TEST2);
        empresa1.buscarPuestoDeTrabajo(idGenerado).buscarPostulante("47261284-8").anadirCompetencia(Competencia.TEST3);

        // Mostrar datos.
        empresa1.mostrarEmpresa();
        empresa1.mostrarPuestosDeTrabajo();

        // Prueba: Quitar competencia de un postulante.
        empresa1.buscarPuestoDeTrabajo(idGenerado).buscarPostulante("47261284-8").quitarCompetencia(Competencia.TEST2);

        // Prueba: Cambiar la disponibilidad de un puesto de trabajo.
        empresa1.buscarPuestoDeTrabajo(idGenerado).setDisponibilidad(false);

        // Prueba: Mostrar datos, filtrando los puestos de trabajo por disponibilidad.
        empresa1.mostrarEmpresa();
        empresa1.mostrarPuestosDeTrabajo(true);

        // Prueba: Agregar requisito a un puesto de trabajo.
        empresa1.buscarPuestoDeTrabajo(idGenerado).anadirRequisito(Requisito.TEST1);

        // Prueba: Mostrar datos, filtrando los puestos de trabajo por un requisito especifico.
        empresa1.mostrarEmpresa();
        empresa1.mostrarPuestosDeTrabajo(Requisito.TEST2);
    }
}
