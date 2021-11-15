package com.bolsa.gui;

import com.bolsa.Main;
import com.bolsa.entidades.Postulante;
import com.bolsa.entidades.PostulantePracticante;
import com.bolsa.entidades.PostulanteTitulado;
import com.bolsa.estructuras.ParPuesto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.time.LocalDate;
import java.util.ArrayList;

public class VentanaModificarPostulante implements ActionListener, ItemListener {
    String datoNombre, datoFechaNacimiento, datoRut, datoDireccion, datoCorreo, datoTelefono;
    double datoPromedioNotas;
    int datoAnosExperiencia;
    PostulantePracticante postulantePracticanteModificar;
    PostulanteTitulado postulanteTituladoModificar;
    private final JFrame frame;
    private final JPanel panel;
    private final JTextField datoNombreTextField;
    private final JTextField datoFechaNacimientoTextField;
    private final JTextField datoRutTextField;
    private final JTextField datoDireccionTextField;
    private final JTextField datoCorreoTextField;
    private final JTextField datoTelefonoTextField;
    private final JTextField datoPromedioNotasTextField;
    private final JTextField datoAnosExperienciaTextField;
    private final JButton confirmarButton;
    private final JCheckBox datoEsPracticanteCheckBox;

    public VentanaModificarPostulante(Postulante postulante) {
        frame = new JFrame();
        panel = new JPanel();

        if (postulante.esPracticante()) {
            postulantePracticanteModificar = (PostulantePracticante) postulante;
        }
        if (!postulante.esPracticante()) {
            postulanteTituladoModificar = (PostulanteTitulado) postulante;
        }

        // CheckBox stuff
        datoEsPracticanteCheckBox = new JCheckBox("Es practicante?");
        datoEsPracticanteCheckBox.addItemListener(this);

        // Button stuff
        confirmarButton = new JButton("Confirmar");
        confirmarButton.addActionListener(this);

        // Label stuff
        JLabel datoNombreLabel = new JLabel("Nombre:");
        JLabel datoFechaNacimientoLabel = new JLabel("Fecha de nacimiento:");
        JLabel datoRutLabel = new JLabel("RUT:");
        JLabel datoDireccionLabel = new JLabel("Direccion:");
        JLabel datoCorreoLabel = new JLabel("Correo:");
        JLabel datoTelefonoLabel = new JLabel("Telefono:");
        JLabel datoPromedioNotasLabel = new JLabel("Promedio de notas:");
        JLabel datoAnosExperienciaLabel = new JLabel("Anos de experiencia:");

        // TextField stuff
        datoNombreTextField = new JTextField(postulante.getNombre());
        datoFechaNacimientoTextField = new JTextField(postulante.getFechaDeNacimiento().toString());
        datoRutTextField = new JTextField(postulante.getRut());
        datoDireccionTextField = new JTextField(postulante.getDireccion());
        datoCorreoTextField = new JTextField(postulante.getCorreo());
        datoTelefonoTextField = new JTextField(postulante.getTelefono());
        datoPromedioNotasTextField = new JTextField("1.0");
        datoAnosExperienciaTextField = new JTextField("0");
        if (postulante.esPracticante()) {
            datoPromedioNotasTextField.setText(Double.toString(postulantePracticanteModificar.getPromedioNotas()));
            datoAnosExperienciaTextField.setEnabled(false);
        }
        if (!postulante.esPracticante()) {
            datoAnosExperienciaTextField.setText(Integer.toString(postulanteTituladoModificar.getAnosDeExperiencia()));
            datoPromedioNotasTextField.setEnabled(false);
        }

        // Panel stuff
        panel.setLayout(null);

        panel.add(datoEsPracticanteCheckBox).setBounds(10, 200, 150, 25);

        panel.add(confirmarButton).setBounds(70, 290, 165, 25);

        panel.add(datoNombreLabel).setBounds(10, 20, 120, 25);
        panel.add(datoFechaNacimientoLabel).setBounds(10, 50, 120, 25);
        panel.add(datoRutLabel).setBounds(10, 80, 120, 25);
        panel.add(datoDireccionLabel).setBounds(10, 110, 120, 25);
        panel.add(datoCorreoLabel).setBounds(10, 140, 120, 25);
        panel.add(datoTelefonoLabel).setBounds(10, 170, 120, 25);
        panel.add(datoPromedioNotasLabel).setBounds(10, 230, 120, 25);
        panel.add(datoAnosExperienciaLabel).setBounds(10, 260, 120, 25);

        panel.add(datoNombreTextField).setBounds(140, 20, 165, 25);
        panel.add(datoFechaNacimientoTextField).setBounds(140, 50, 165, 25);
        panel.add(datoRutTextField).setBounds(140, 80, 165, 25);
        panel.add(datoDireccionTextField).setBounds(140, 110, 165, 25);
        panel.add(datoCorreoTextField).setBounds(140, 140, 165, 25);
        panel.add(datoTelefonoTextField).setBounds(140, 170, 165, 25);
        panel.add(datoPromedioNotasTextField).setBounds(140, 230, 165, 25);
        panel.add(datoAnosExperienciaTextField).setBounds(140, 260, 165, 25);

        // Frame stuff
        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setTitle("Crear postulante");
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
            boolean esPracticante = false;
            datoNombre = datoNombreTextField.getText();
            datoFechaNacimiento = datoFechaNacimientoTextField.getText();
            datoRut = datoRutTextField.getText();
            datoDireccion = datoDireccionTextField.getText();
            datoCorreo = datoCorreoTextField.getText();
            datoTelefono = datoTelefonoTextField.getText();

            if (datoPromedioNotasTextField.isEnabled()) {
                try {
                    datoPromedioNotas = Double.parseDouble(datoPromedioNotasTextField.getText());
                    esPracticante = true;
                } catch (NumberFormatException exception) {
                    exceptionThrown = true;
                    new VentanaDatoInvalido();
                }
            }

            if (datoAnosExperienciaTextField.isEnabled()) {
                try {
                    datoAnosExperiencia = Integer.parseInt(datoAnosExperienciaTextField.getText());
                    esPracticante = false;
                } catch (NumberFormatException exception) {
                    exceptionThrown = true;
                    new VentanaDatoInvalido();
                }
            }



            if (!exceptionThrown) {
                if (esPracticante) {
                    postulantePracticanteModificar.setNombre(datoNombre);
                    postulantePracticanteModificar.setFechaDeNacimiento(LocalDate.parse(datoFechaNacimiento));
                    postulantePracticanteModificar.setRut(datoRut);
                    postulantePracticanteModificar.setDireccion((datoDireccion));
                    postulantePracticanteModificar.setCorreo(datoCorreo);
                    postulantePracticanteModificar.setTelefono(datoTelefono);
                    postulantePracticanteModificar.setPromedioNotas(datoPromedioNotas);
                    frame.dispose();
                    new VentanaAccionExitosa();
                } else {
                    postulanteTituladoModificar.setNombre(datoNombre);
                    postulanteTituladoModificar.setFechaDeNacimiento(LocalDate.parse(datoFechaNacimiento));
                    postulanteTituladoModificar.setRut(datoRut);
                    postulanteTituladoModificar.setDireccion((datoDireccion));
                    postulanteTituladoModificar.setCorreo(datoCorreo);
                    postulanteTituladoModificar.setTelefono(datoTelefono);
                    postulanteTituladoModificar.setAnosDeExperiencia(datoAnosExperiencia);
                    frame.dispose();
                    new VentanaAccionExitosa();
                }
            }
        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        Object source = e.getSource();

        datoPromedioNotasTextField.setEnabled(e.getStateChange() == ItemEvent.SELECTED);
        datoAnosExperienciaTextField.setEnabled(e.getStateChange() == ItemEvent.DESELECTED);
    }
}
