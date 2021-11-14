package com.bolsa;

import com.bolsa.entidades.Empresa;
import com.bolsa.entidades.PuestoDeTrabajo;
import com.bolsa.gui.VentanaPrincipal;

import java.io.IOException;

public class Main {

    public static Empresa empresa;

    public static void main(String[] args) throws IOException {
        empresa = new Empresa(
                "PLACEHOLDER",
                "PLACEHOLDER",
                "PLACEHOLDER",
                "PLACEHOLDER",
                "PLACEHOLDER",
                "PLACEHOLDER"
        );

        empresa.anadirPuestoDeTrabajo(new PuestoDeTrabajo(
                "Hola",
                5000,
                20
        ));
        empresa.anadirPuestoDeTrabajo(new PuestoDeTrabajo(
                "Chao",
                5000,
                20
        ));
        empresa.anadirPuestoDeTrabajo(new PuestoDeTrabajo(
                "Buenos dias",
                5000,
                20
        ));
        empresa.anadirPuestoDeTrabajo(new PuestoDeTrabajo(
                "Buenas noches",
                5000,
                20
        ));
        new VentanaPrincipal();
        //Menu.runConsole();
    }
}
