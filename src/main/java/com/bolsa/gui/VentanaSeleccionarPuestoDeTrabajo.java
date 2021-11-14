package com.bolsa.gui;

import com.bolsa.Main;
import com.bolsa.entidades.PuestoDeTrabajo;
import com.bolsa.estructuras.ParPuesto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class VentanaSeleccionarPuestoDeTrabajo implements ActionListener {
    JFrame frame;
    JPanel panel;
    DefaultListModel<String> modeloLista;
    ArrayList<ParPuesto> elementosLista;
    JList<String> lista;
    PuestoDeTrabajo puestoModificar;
    JButton seleccionarButton;
    JButton cancelarButton;


    public VentanaSeleccionarPuestoDeTrabajo() {
        frame = new JFrame();
        panel = new JPanel();
        elementosLista = Main.empresa.obtenerParPuestosDeTrabajo();

        // Button stuff
        seleccionarButton = new JButton("Seleccionar");
        seleccionarButton.addActionListener(this);
        cancelarButton = new JButton("Cancelar");
        cancelarButton.addActionListener(this);

        // Label stuff
        JLabel listaLabel = new JLabel("Puestos de trabajo");

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
        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setTitle("Insertar Postulante");
        frame.setLocationRelativeTo(null);
        frame.setSize(329, 438);
        frame.setResizable(false);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if (source == seleccionarButton) {
            puestoModificar = Main.empresa.buscarPuestoDeTrabajo(elementosLista.get(lista.getSelectedIndex()).getUUID());
            frame.dispose();
            new VentanaModificarPuestoDeTrabajo(puestoModificar);
        }
    }
}
