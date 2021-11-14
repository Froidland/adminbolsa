package com.bolsa;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Reporte {
    public static boolean generarReporte() throws IOException {
        boolean creacionArchivoExitosa;

        File reporteNuevo = new File("reporte.txt");
        creacionArchivoExitosa = reporteNuevo.createNewFile();

        if (!creacionArchivoExitosa) {
            return false;
        }

        FileWriter escritura = new FileWriter(reporteNuevo, true);

        escritura.append(Main.empresa.obtenerStringDatosEmpresa());
        escritura.flush();
        escritura.append(Main.empresa.obtenerStringDatosPuestosDeTrabajo());
        escritura.flush();

        escritura.close();

        return true;
    }
}
