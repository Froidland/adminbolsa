package com.bolsa.gui;

import javax.swing.*;
import java.awt.*;

public class VentanaImplementacionFaltante {
    JFrame frame;
    JPanel panel;

    public VentanaImplementacionFaltante() {
        frame = new JFrame();
        panel = new JPanel();


        // Label stuff
        JLabel exitoLabel = new JLabel("Menu no implementado.", SwingConstants.CENTER);

        // Panel stuff
        panel.setLayout(new GridLayout(1, 1));
        panel.add(exitoLabel);

        // Frame stuff
        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setTitle("Error");
        frame.setLocationRelativeTo(null);
        frame.setSize(230, 120);
        frame.setResizable(false);
        frame.setVisible(true);
    }
}
