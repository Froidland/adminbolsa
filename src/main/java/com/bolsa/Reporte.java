package com.bolsa;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Reporte {
    public static boolean generarReporte() throws IOException {
        try {
            File reporteNuevo = new File("reporte.txt");
            reporteNuevo.createNewFile();
            FileWriter escritura = new FileWriter(reporteNuevo, true);

            escritura.append(Main.empresa.obtenerStringDatosEmpresa());
            escritura.flush();
            escritura.append(Main.empresa.obtenerStringDatosPuestosDeTrabajo());
            escritura.flush();

            escritura.close();
        } catch (IOException e) {
            return false;
        }
        return true;
    }
}
