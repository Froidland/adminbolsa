package com.bolsa.gui;

import com.bolsa.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaPrincipal implements ActionListener {
    private String name;

    private final JFrame frame;
    private final JButton crearPuestoDeTrabajoButton;
    private final JButton crearPostulanteButton;
    private final JButton mostrarPuestosDeTrabajoButton;
    private final JButton mostrarPostulantesButton;
    private final JButton eliminarPuestoDeTrabajoButton;
    private final JButton eliminarPostulanteButton;
    private final JButton modificarPuestoDeTrabajoButton;
    private final JButton modificarPostulanteButton;
    private final JButton modificarDatosEmpresaButton;
    private final JButton mostrarPracticanteMayorPromedioButton;
    private final JPanel panel;

    public VentanaPrincipal() {
        frame = new JFrame();
        panel = new JPanel();

        // Boton crear puesto de trabajo
        crearPuestoDeTrabajoButton = new JButton("Crear puesto de trabajo");
        crearPuestoDeTrabajoButton.addActionListener(this);

        // Boton crear postulante
        crearPostulanteButton = new JButton("Crear postulante");
        crearPostulanteButton.addActionListener(this);

        // Boton mostrar puestos de trabajo
        mostrarPuestosDeTrabajoButton = new JButton("Mostrar Puestos de trabajo");
        mostrarPuestosDeTrabajoButton.addActionListener(this);

        // Boton mostrar postulantes
        mostrarPostulantesButton = new JButton("Mostrar Postulantes");
        mostrarPostulantesButton.addActionListener(this);

        // Boton eliminar puesto de trabajo
        eliminarPuestoDeTrabajoButton = new JButton("Eliminar puesto de trabajo");
        eliminarPuestoDeTrabajoButton.addActionListener(this);

        // Boton eliminar postulante
        eliminarPostulanteButton = new JButton("Eliminar postulante");
        eliminarPostulanteButton.addActionListener(this);

        // Boton modificar puesto de trabajo
        modificarPuestoDeTrabajoButton = new JButton("Modificar puesto de trabajo");
        modificarPuestoDeTrabajoButton.addActionListener(this);

        // Boton mmodificar postulante
        modificarPostulanteButton = new JButton("Modificar postulante");
        modificarPostulanteButton.addActionListener(this);

        // Boton modificar datos empresa
        modificarDatosEmpresaButton = new JButton("Modificar datos empresa");
        modificarDatosEmpresaButton.addActionListener(this);

        // Boton mostrar practicanto con el mayor promedio
        mostrarPracticanteMayorPromedioButton = new JButton("Mostrar practicante con mayor promedio");
        mostrarPracticanteMayorPromedioButton.addActionListener(this);

        // Panel stuff
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        panel.setLayout(null);
        panel.add(crearPuestoDeTrabajoButton).setBounds(10, 20, 274, 25);
        panel.add(crearPostulanteButton).setBounds(10, 50, 274, 25);
        panel.add(mostrarPuestosDeTrabajoButton).setBounds(10, 80, 274, 25);
        panel.add(mostrarPostulantesButton).setBounds(10, 110, 274, 25);
        panel.add(eliminarPuestoDeTrabajoButton).setBounds(10, 140, 274, 25);
        panel.add(eliminarPostulanteButton).setBounds(10, 170, 274, 25);
        panel.add(modificarPuestoDeTrabajoButton).setBounds(10, 200, 274, 25);
        panel.add(modificarPostulanteButton).setBounds(10, 230, 274, 25);
        panel.add(modificarDatosEmpresaButton).setBounds(10, 260, 274, 25);
        panel.add(mostrarPracticanteMayorPromedioButton).setBounds(10, 290, 274, 25);

        // Frame stuff
        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Administrador de bolsa");
        frame.setLocationRelativeTo(null);
        frame.setSize(310, 600);
        frame.setResizable(false);
        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if (source == crearPuestoDeTrabajoButton) {
            //new VentanaCrearPuestoDeTrabajo();
            new VentanaImplementacionFaltante();
        }

        if (source == crearPostulanteButton) {
            new VentanaCrearPostulante();
        }

        if (source == mostrarPuestosDeTrabajoButton) {
            //new VentanaMostrarPuestosDeTrabajo();
            //Main.empresa.mostrarPuestosDeTrabajo();
            new VentanaImplementacionFaltante();
        }

        if (source == mostrarPostulantesButton) {
            //new VentanaMostrarPostulantes();
            new VentanaImplementacionFaltante();
        }

        if (source == eliminarPuestoDeTrabajoButton) {
            //new VentanaEliminarPuestoDeTrabajo();
            new VentanaImplementacionFaltante();
        }

        if (source == eliminarPostulanteButton) {
            //new VentanaEliminarPostulante();
            new VentanaImplementacionFaltante();
        }

        if (source == modificarPuestoDeTrabajoButton) {
            //new VentanaModificarPuestoDeTrabajo();
            new VentanaImplementacionFaltante();
        }

        if (source == modificarPostulanteButton) {
            //new VentanaModificarPostulante();
            new VentanaImplementacionFaltante();
        }

        if (source == modificarDatosEmpresaButton) {
            //new VentanaModificarDatosEmpresa();
            new VentanaImplementacionFaltante();
        }

        if (source == mostrarPracticanteMayorPromedioButton) {
            //new VentanaMostrarPracticanteMayorPromedio();
            new VentanaImplementacionFaltante();
        }
    }
}
