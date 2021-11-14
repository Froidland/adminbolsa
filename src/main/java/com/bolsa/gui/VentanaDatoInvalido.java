package com.bolsa.gui;

import javax.swing.*;
import java.awt.*;

public class VentanaDatoInvalido {
    JFrame frame;
    JPanel panel;

    public VentanaDatoInvalido() {
        frame = new JFrame();
        panel = new JPanel();
        JLabel datoInvalidoLabel = new JLabel("DATO INVALIDO.");
        JLabel datoInvalidoLabel2 = new JLabel("POR FAVOR CORRIJA EL ERROR.");

        // Panel stuff
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        panel.setLayout(null);

        // Label panel stuff
        panel.add(datoInvalidoLabel).setBounds(10, 10, 200, 25);
        panel.add(datoInvalidoLabel2).setBounds(10, 20, 200, 25);

        // Frame stuff
        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setTitle("Datos invalidos");
        frame.setLocationRelativeTo(null);
        frame.setSize(230, 120);
        frame.setVisible(true);
    }
}
