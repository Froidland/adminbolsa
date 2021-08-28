package com.bolsa;

import java.util.ArrayList;

public class Test {
    public static void runTest() {
        Postulante postulante1 = new Postulante(
                "Ella Hyginos",
                "1962-10-20",
                "47261284-8",
                "P. Sherman, Wallaby St. 42, Sydney",
                "jimxugle@msn.com",
                "812-340-3980",
                new ArrayList<>()
        );

        Postulante postulante2 = new Postulante(
                "Quirino Rosa",
                "1977-05-02",
                "84628364-8",
                "2831 Fincham Road, La Mesa, California",
                "makarow@icloud.com",
                "775-936-8557",
                new ArrayList<>()
        );

        Postulante postulante3 = new Postulante(
                "Nandita Jasmina",
                "1984-12-30",
                "94726153-4",
                "2805 Conaway Street, Bloomington, Indiana",
                "stakasa@yahoo.com",
                "406-554-8986",
                new ArrayList<>()
        );

        Empresa empresa1 = new Empresa(
                "79814271-2",
                "Discord",
                "2559 Ridenour Street, MOUNT CLEMENS, Michigan",
                "https://discord.com/",
                "support@discordapp.com",
                "305-999-9880",
                new ArrayList<>()
        );


        PuestoDeTrabajo puesto1 = new PuestoDeTrabajo(
                1,
                "Puesto de prueba",
                500000,
                5,
                true,
                new ArrayList<>(),
                new ArrayList<>()
        );

        empresa1.anadirPuestoDeTrabajo(puesto1);

        empresa1.getPuestosDeTrabajo().get(0).anadirPostulante(postulante1);
        empresa1.getPuestosDeTrabajo().get(0).anadirPostulante(postulante2);
        empresa1.getPuestosDeTrabajo().get(0).anadirPostulante(postulante3);

        empresa1.mostrarEmpresa();

        empresa1.getPuestosDeTrabajo().get(0).quitarPostulante("84628364-8");

        empresa1.mostrarEmpresa();
    }
}
