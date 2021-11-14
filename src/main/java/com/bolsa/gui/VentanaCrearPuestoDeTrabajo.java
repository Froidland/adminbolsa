package com.bolsa.gui;

import com.bolsa.Main;
import com.bolsa.entidades.PuestoDeTrabajo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class VentanaCrearPuestoDeTrabajo implements ActionListener {
    String datoNombre;
    boolean datoDisponibilidad = true;
    int datoVacantes, datoSueldoBase;
    JFrame frame;
    JPanel panel;
    JTextField datoNombreTextField;
    JTextField datoSueldoBaseTextField;
    JTextField datoVacantesTextField;
    JCheckBox datoDisponibilidadCheckBox;
    JButton confirmarButton;

    public VentanaCrearPuestoDeTrabajo() {
        frame = new JFrame();
        panel = new JPanel();

        // Button stuff
        confirmarButton = new JButton("Confirmar");
        confirmarButton.addActionListener(this);

        // Label stuff
        JLabel datoNombreLabel = new JLabel("Nombre:");
        JLabel datoSueldoBaseLabel = new JLabel("Sueldo base:");
        JLabel datoVacantesLabel = new JLabel("Vacantes:");

        // TextField stuff
        datoNombreTextField = new JTextField("Nombre puesto");
        datoSueldoBaseTextField = new JTextField("0");
        datoVacantesTextField = new JTextField("0");

        // CheckBox stuff
        datoDisponibilidadCheckBox = new JCheckBox("Esta disponible?", true);

        // Panel stuff
        panel.setLayout(null);

        // Labels panel stuff
        panel.add(datoNombreLabel).setBounds(10, 20, 120, 25);
        panel.add(datoSueldoBaseLabel).setBounds(10, 50, 120, 25);
        panel.add(datoVacantesLabel).setBounds(10, 80, 120, 25);

        // TextField panel stuff
        panel.add(datoNombreTextField).setBounds(140, 20, 165, 25);
        panel.add(datoSueldoBaseTextField).setBounds(140, 50, 165, 25);
        panel.add(datoVacantesTextField).setBounds(140, 80, 165, 25);

        // CheckBox panel stuff
        panel.add(datoDisponibilidadCheckBox).setBounds(10, 110, 150, 25);

        // Button panel stuff
        panel.add(confirmarButton).setBounds(70, 140, 165, 25);

        // Frame stuff
        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setTitle("Crear puesto de trabajo");
        frame.setLocationRelativeTo(null);
        frame.setSize(329, 363);
        frame.setResizable(false);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if (source == confirmarButton) {
            boolean exceptionThrown = false;
            try {
                datoNombre = datoNombreTextField.getText();
                datoSueldoBase = Integer.parseInt(datoSueldoBaseTextField.getText());
                datoVacantes = Integer.parseInt(datoVacantesTextField.getText());
            } catch (NumberFormatException exception) {
                exceptionThrown = true;
                new VentanaDatoInvalido();
            }

            if (datoDisponibilidadCheckBox.isEnabled()) {
                datoDisponibilidad = true;
            }

            if (!datoDisponibilidadCheckBox.isEnabled()) {
                datoDisponibilidad = false;
            }

            PuestoDeTrabajo puestoNuevo = new PuestoDeTrabajo(
                    datoNombre,
                    datoSueldoBase,
                    datoVacantes
            );


            if (!exceptionThrown) {
                Main.empresa.anadirPuestoDeTrabajo(puestoNuevo);
                frame.dispose();
                new VentanaAccionExitosa();
            }
        }
    }
}
