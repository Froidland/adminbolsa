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
                1,
                "Puesto de prueba",
                500000,
                5,
                true
        );

        postulante3.setRut("947261534");

        empresa1.anadirPuestoDeTrabajo(puesto1);

        empresa1.buscarPuestoDeTrabajo(1).anadirPostulante(postulante1);
        empresa1.buscarPuestoDeTrabajo(1).anadirPostulante(postulante2);
        empresa1.buscarPuestoDeTrabajo(1).anadirPostulante(postulante3);

        empresa1.mostrarEmpresa();
        empresa1.mostrarPuestosDeTrabajo();

        empresa1.buscarPuestoDeTrabajo(1).setSueldoBase(500000.576);

        empresa1.buscarPuestoDeTrabajo(1).quitarPostulante("84628364-8");

        empresa1.mostrarEmpresa();
        empresa1.mostrarPuestosDeTrabajo();

        empresa1.buscarPuestoDeTrabajo(1).buscarPostulante("47261284-8").anadirCompetencia(Competencia.TEST1);
        empresa1.buscarPuestoDeTrabajo(1).buscarPostulante("47261284-8").anadirCompetencia(Competencia.TEST2);
        empresa1.buscarPuestoDeTrabajo(1).buscarPostulante("47261284-8").anadirCompetencia(Competencia.TEST3);

        empresa1.mostrarEmpresa();
        empresa1.mostrarPuestosDeTrabajo();

        empresa1.buscarPuestoDeTrabajo(1).buscarPostulante("47261284-8").quitarCompetencia(Competencia.TEST2);
        empresa1.buscarPuestoDeTrabajo(1).setDisponibilidad(false);
        empresa1.mostrarEmpresa();
        empresa1.mostrarPuestosDeTrabajo(true);

        empresa1.buscarPuestoDeTrabajo(1).anadirRequisito(Requisito.TEST1);
        empresa1.mostrarEmpresa();
        empresa1.mostrarPuestoDeTrabajo(Requisito.TEST2);
        
        empresa1.buscarPuestoDeTrabajo(1).mostrarPostulantes();
    }
}
