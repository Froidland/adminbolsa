package com.bolsa.gui;

import javax.swing.*;
import java.awt.*;

public class VentanaReporteFallido {
    JFrame frame;
    JPanel panel;

    public VentanaReporteFallido() {
        frame = new JFrame();
        panel = new JPanel();
        JLabel datoInvalidoLabel = new JLabel("NO SE HA PODIDO GENERAR EL REPORTE.", SwingConstants.CENTER);
        JLabel datoInvalidoLabel2 = new JLabel("POR FAVOR INTENTELO DE NUEVO.", SwingConstants.CENTER);

        // Panel stuff
        panel.setLayout(new GridLayout(2, 1));

        // Label panel stuff
        panel.add(datoInvalidoLabel).setBounds(10, 10, 200, 25);
        panel.add(datoInvalidoLabel2).setBounds(10, 20, 200, 25);

        // Frame stuff
        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setTitle("Error");
        frame.setLocationRelativeTo(null);
        frame.setSize(270, 120);
        frame.setVisible(true);
    }
}
