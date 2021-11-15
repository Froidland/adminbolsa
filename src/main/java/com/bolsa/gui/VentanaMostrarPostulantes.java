package com.bolsa.gui;

import com.bolsa.Main;
import com.bolsa.entidades.Empresa;
import com.bolsa.entidades.PuestoDeTrabajo;
import com.bolsa.estructuras.ParPostulante;
import com.bolsa.estructuras.ParPuesto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class VentanaMostrarPostulantes implements ActionListener {
    JFrame frame;
    JPanel panel;
    DefaultListModel<String> modeloLista;
    ArrayList<ParPostulante> elementosLista;
    JList<String> lista;
    JTextField rutPostulanteModificarTextField;
    JButton salirButton;

    public VentanaMostrarPostulantes() {
        frame = new JFrame();
        panel = new JPanel();
        Empresa empresa = Main.empresa;
        elementosLista = new ArrayList<>();
        ArrayList<ParPuesto> puestos = empresa.obtenerParPuestosDeTrabajo();

        for (ParPuesto puesto : puestos) {
            PuestoDeTrabajo puestoActual = empresa.buscarPuestoDeTrabajo(puesto.getUUID());
            elementosLista.addAll(puestoActual.getParPostulantes());
        }

        // Button stuff
        salirButton = new JButton("Salir");
        salirButton.addActionListener(this);

        // Label stuff
        JLabel listaLabel = new JLabel("Postulantes:");

        // List stuff
        modeloLista = new DefaultListModel<>();
        for (ParPostulante postulante : elementosLista) {
            modeloLista.addElement(postulante.getNombre() + " | " + postulante.getRut());
        }
        lista = new JList<>(modeloLista);

        // Panel stuff
        panel.setLayout(null);
        panel.add(listaLabel).setBounds(10, 10, 300, 25);
        panel.add(new JScrollPane(lista)).setBounds(10, 40, 294, 300);
        panel.add(salirButton).setBounds(10, 350, 120, 25);

        // Frame stuff
        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setTitle("Seleccionar postulante");
        frame.setLocationRelativeTo(null);
        frame.setSize(329, 438);
        frame.setResizable(false);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if (source == salirButton) {
            frame.dispose();
        }
    }
}
