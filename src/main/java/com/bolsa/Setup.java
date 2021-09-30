package com.bolsa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Setup {
    /**
     * Este m�todo pide los datos para crear la empresa, sin embargo el llenado ser� automatico hasta que se desarrolle la base de datos del proyecto.
     * @throws IOException 
     */
    public static void run() throws IOException {
/*        BufferedReader lectura = new BufferedReader(new InputStreamReader(System.in));
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
        ); */
      
        Main.empresa = new Empresa(
                "79814271-2",
                "Discord",
                "2559 Ridenour Street, MOUNT CLEMENS, Michigan",
                "https://discord.com/",
                "support@discordapp.com",
                "305-999-9880"
        );
    }
}
