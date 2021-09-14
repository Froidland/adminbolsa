package com.bolsa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Setup {
    public static void run() throws IOException {
        BufferedReader lectura = new BufferedReader(new InputStreamReader(System.in));
        String datoRut, datoNombre, datoDireccion, datoWeb, datoCorreo, datoTelefono;

        System.out.println("###   MENU INICIAL   ###");
        System.out.println();
        System.out.println("Ingrese el rut de la empresa: ");
        datoRut = lectura.readLine();
        System.out.println("Ingrese el nombre de la empresa: ");
        datoNombre = lectura.readLine();
        System.out.println("Ingrese la direccion de la empresa: ");
        datoDireccion = lectura.readLine();
        System.out.println("Ingrese la pagina web de la empresa: ");
        datoWeb = lectura.readLine();
        System.out.println("Ingrese el correo de la empresa: ");
        datoCorreo = lectura.readLine();
        System.out.println("Ingrese el telefono de la empresa: ");
        datoTelefono = lectura.readLine();

        Main.empresa = new Empresa(
                datoRut,
                datoNombre,
                datoDireccion,
                datoWeb,
                datoCorreo,
                datoTelefono
        );
    }
}
