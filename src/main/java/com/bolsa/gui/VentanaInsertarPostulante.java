package com.bolsa.gui;

import com.bolsa.Main;
import com.bolsa.entidades.Postulante;
import com.bolsa.estructuras.ParPuesto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class VentanaInsertarPostulante implements ActionListener {
    JFrame frameActual;
    JPanel panel;
    DefaultListModel<String> modeloLista;
    ArrayList<ParPuesto> elementosLista;
    JList<String> lista;
    JFrame frameCrearEstudiante;
    Postulante postulanteNuevo;
    JButton seleccionarButton;
    JButton cancelarButton;


    public VentanaInsertarPostulante(JFrame origen, ArrayList<ParPuesto> elementos, Postulante postulante) {
        frameActual = new JFrame();
        panel = new JPanel();
        elementosLista = elementos;
        postulanteNuevo = postulante;
        frameCrearEstudiante = origen;

        // Button stuff
        seleccionarButton = new JButton("Seleccionar");
        seleccionarButton.addActionListener(this);
        cancelarButton = new JButton("Cancelar");
        cancelarButton.addActionListener(this);

        // Label stuff
        JLabel listaLabel = new JLabel("Puestos de trabajo: ");

        // List stuff
        modeloLista = new DefaultListModel<>();
        for (ParPuesto puesto : elementosLista) {
            modeloLista.addElement(puesto.getNombre());
        }
        lista = new JList<>(modeloLista);

        // Panel stuff
        panel.setLayout(null);
        panel.add(listaLabel).setBounds(10, 10, 300, 25);
        panel.add(new JScrollPane(lista)).setBounds(10, 40, 294, 300);
        panel.add(seleccionarButton).setBounds(10, 350, 120, 25);
        panel.add(cancelarButton).setBounds(183, 350, 120, 25);

        // Frame stuff
        frameActual.add(panel, BorderLayout.CENTER);
        frameActual.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frameActual.setTitle("Insertar Postulante");
        frameActual.setLocationRelativeTo(null);
        frameActual.setSize(329, 438);
        frameActual.setResizable(false);
        frameActual.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if (source == seleccionarButton) {
            Main.empresa.buscarPuestoDeTrabajo(elementosLista.get(lista.getSelectedIndex()).getUUID()).anadirPostulante(postulanteNuevo);
            frameActual.dispose();
            frameCrearEstudiante.dispose();
            new VentanaAccionExitosa();
        }

        if (source == cancelarButton) {
            frameActual.dispose();
        }
    }
}
