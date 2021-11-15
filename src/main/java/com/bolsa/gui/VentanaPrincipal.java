package com.bolsa.gui;

import com.bolsa.Menu;
import com.bolsa.Reporte;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

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
    private final JButton ejecutarMenuConsola;
    private final JButton salirYGuardarReporte;
    private final JPanel panel;
    boolean reporteExitoso = false;

    public VentanaPrincipal() {
        frame = new JFrame();
        panel = new JPanel();

        // Button stuff
        crearPuestoDeTrabajoButton = new JButton("Crear puesto de trabajo");
        crearPuestoDeTrabajoButton.addActionListener(this);
        crearPostulanteButton = new JButton("Crear postulante");
        crearPostulanteButton.addActionListener(this);
        mostrarPuestosDeTrabajoButton = new JButton("Mostrar Puestos de trabajo");
        mostrarPuestosDeTrabajoButton.addActionListener(this);
        mostrarPostulantesButton = new JButton("Mostrar Postulantes");
        mostrarPostulantesButton.addActionListener(this);
        eliminarPuestoDeTrabajoButton = new JButton("Eliminar puesto de trabajo");
        eliminarPuestoDeTrabajoButton.addActionListener(this);
        eliminarPostulanteButton = new JButton("Eliminar postulante");
        eliminarPostulanteButton.addActionListener(this);
        modificarPuestoDeTrabajoButton = new JButton("Modificar puesto de trabajo");
        modificarPuestoDeTrabajoButton.addActionListener(this);
        modificarPostulanteButton = new JButton("Modificar postulante");
        modificarPostulanteButton.addActionListener(this);
        modificarDatosEmpresaButton = new JButton("Modificar datos empresa");
        modificarDatosEmpresaButton.addActionListener(this);
        mostrarPracticanteMayorPromedioButton = new JButton("Mostrar practicante con mayor promedio");
        mostrarPracticanteMayorPromedioButton.addActionListener(this);
        ejecutarMenuConsola = new JButton(("Ejecutar menu en consola"));
        ejecutarMenuConsola.addActionListener(this);
        salirYGuardarReporte = new JButton("Salir y guardar reporte");
        salirYGuardarReporte.addActionListener(this);

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
        panel.add(ejecutarMenuConsola).setBounds(10, 320, 274, 25);
        panel.add(salirYGuardarReporte).setBounds(10, 350, 274, 25);

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
            new VentanaCrearPuestoDeTrabajo();
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
            new VentanaMostrarPostulantes();
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
            new VentanaSeleccionarPuestoDeTrabajo();
        }

        if (source == modificarPostulanteButton) {
            new VentanaSeleccionarPostulante();
        }

        if (source == modificarDatosEmpresaButton) {
            new VentanaModificarDatosEmpresa();
        }

        if (source == mostrarPracticanteMayorPromedioButton) {
            //new VentanaMostrarPracticanteMayorPromedio();
            new VentanaImplementacionFaltante();
        }

        if (source == ejecutarMenuConsola) {
            frame.dispose();
            Menu.runConsole();
        }

        if (source == salirYGuardarReporte) {
            try {
                reporteExitoso = Reporte.generarReporte();
                frame.dispose();
            } catch (IOException exception) {
                new VentanaReporteFallido();
            }
        }
    }
}
