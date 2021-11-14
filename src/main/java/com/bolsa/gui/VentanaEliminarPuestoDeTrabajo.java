package com.bolsa.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaEliminarPuestoDeTrabajo implements ActionListener {
    JFrame frame;
    JPanel panel;
    JTextField texto;

    public VentanaEliminarPuestoDeTrabajo() {
        frame = new JFrame();
        panel = new JPanel();

        // Text stuff
        texto = new JTextField("Postulante");

        // Panel stuff
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        panel.setLayout(new GridLayout(10, 1));
        panel.add(texto);

        // Frame stuff
        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setTitle("Eliminar puesto de trabajo");
        frame.setLocationRelativeTo(null);
        frame.setSize(500, 500);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
