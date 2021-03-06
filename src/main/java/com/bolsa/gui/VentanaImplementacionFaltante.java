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
        JLabel errorMenuLabel1 = new JLabel("Menu no implementado.", SwingConstants.CENTER);
        JLabel errorMenuLabel2 = new JLabel("Por favor utilice la consola.", SwingConstants.CENTER);

        // Panel stuff
        panel.setLayout(new GridLayout(2, 1));
        panel.add(errorMenuLabel1);
        panel.add(errorMenuLabel2);

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
