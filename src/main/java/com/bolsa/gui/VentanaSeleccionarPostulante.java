package com.bolsa.gui;

import com.bolsa.Main;
import com.bolsa.entidades.Postulante;
import com.bolsa.entidades.PuestoDeTrabajo;
import com.bolsa.estructuras.ParPuesto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaSeleccionarPostulante implements ActionListener {
    String rutPostulanteModificar;
    Postulante postulanteModificar = null;
    JFrame frame;
    JPanel panel;
    JTextField rutPostulanteModificarTextField;
    JButton confirmarButton;

    public VentanaSeleccionarPostulante() {
        frame = new JFrame();
        panel = new JPanel();

        // Button stuff
        confirmarButton = new JButton("Confirmar");
        confirmarButton.addActionListener(this);


        // Label stuff
        JLabel rutPostulanteModificarLabel = new JLabel("RUT postulante:");

        // TextField stuff
        rutPostulanteModificarTextField = new JTextField("1111111-1");

        // Panel stuff
        panel.setLayout(null);

        panel.add(rutPostulanteModificarLabel).setBounds(10, 20, 120, 25);

        panel.add(rutPostulanteModificarTextField).setBounds(140, 20, 165, 25);

        panel.add(confirmarButton).setBounds(70, 170, 165, 25);

        // Frame stuff
        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setTitle("Seleccionar postulante");
        frame.setLocationRelativeTo(null);
        frame.setSize(329, 363);
        frame.setResizable(false);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if (source == confirmarButton) {
            rutPostulanteModificar = rutPostulanteModificarTextField.getText();

            boolean found = false;
            for (ParPuesto puesto : Main.empresa.obtenerParPuestosDeTrabajo()) {
                PuestoDeTrabajo puestoActual = Main.empresa.buscarPuestoDeTrabajo(puesto.getUUID());
                postulanteModificar = puestoActual.buscarPostulante(rutPostulanteModificar);

                if (postulanteModificar != null) {
                    found = true;
                    break;
                }
            }

            if (found) {
                frame.dispose();
                new VentanaModificarPostulante(postulanteModificar);
            }
        }
    }
}
