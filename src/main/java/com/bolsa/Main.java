package com.bolsa;

import com.bolsa.menugrafico.VentanaPrincipal;

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
        //new VentanaPrincipal();
        Menu.runConsole();
    }
}
