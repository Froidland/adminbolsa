package com.bolsa.gui;

import com.bolsa.Main;
import com.bolsa.entidades.PuestoDeTrabajo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaModificarPuestoDeTrabajo implements ActionListener {
    String datoNombre;
    boolean datoDisponibilidad;
    int datoVacantes, datoSueldoBase;
    JFrame frame;
    JPanel panel;
    JTextField datoNombreTextField;
    JTextField datoSueldoBaseTextField;
    JTextField datoVacantesTextField;
    JCheckBox datoDisponibilidadCheckBox;
    JButton confirmarButton;
    PuestoDeTrabajo puestoModificar;

    public VentanaModificarPuestoDeTrabajo(PuestoDeTrabajo puesto) {
        frame = new JFrame();
        panel = new JPanel();
        puestoModificar = puesto;

        // Button stuff
        confirmarButton = new JButton("Confirmar");
        confirmarButton.addActionListener(this);

        // Label stuff
        JLabel datoNombreLabel = new JLabel("Nombre:");
        JLabel datoSueldoBaseLabel = new JLabel("Sueldo base:");
        JLabel datoVacantesLabel = new JLabel("Vacantes:");

        // TextField stuff
        datoNombreTextField = new JTextField(puestoModificar.getNombre());
        datoSueldoBaseTextField = new JTextField(puestoModificar.getSueldoBase());
        datoVacantesTextField = new JTextField(puestoModificar.getVacantes());

        // CheckBox stuff
        datoDisponibilidadCheckBox = new JCheckBox("Esta disponible?", puestoModificar.isDisponible());

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
        frame.setTitle("Modificar puesto de trabajo");
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

                if (datoDisponibilidadCheckBox.isEnabled()) {
                    datoDisponibilidad = true;
                }

                if (!datoDisponibilidadCheckBox.isEnabled()) {
                    datoDisponibilidad = false;
                }
            } catch (NumberFormatException exception) {
                exceptionThrown = true;
                new VentanaDatoInvalido();
            }

            if (!exceptionThrown) {
                puestoModificar.setNombre(datoNombre);
                puestoModificar.setSueldoBase(datoSueldoBase);
                puestoModificar.setVacantes(datoVacantes);
                puestoModificar.setDisponibilidad(datoDisponibilidad);
                frame.dispose();
                new VentanaAccionExitosa();
            }
        }
    }
}
