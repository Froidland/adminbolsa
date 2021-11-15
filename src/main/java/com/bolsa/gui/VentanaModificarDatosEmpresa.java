package com.bolsa.gui;

import com.bolsa.Main;
import com.bolsa.entidades.Empresa;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaModificarDatosEmpresa implements ActionListener {
    String datoRut, datoNombre, datoDireccion, datoPaginaWeb, datoCorreo, datoTelefono;
    Empresa empresa;
    JFrame frame;
    JPanel panel;
    JTextField datoRutTextField;
    JTextField datoNombreTextField;
    JTextField datoDireccionTextField;
    JTextField datoPaginaWebTextField;
    JTextField datoCorreoTextField;
    JTextField datoTelefonoTextField;
    JButton confirmarButton;

    public VentanaModificarDatosEmpresa() {
        frame = new JFrame();
        panel = new JPanel();
        empresa = Main.empresa;

        // Button stuff
        confirmarButton = new JButton("Confirmar");
        confirmarButton.addActionListener(this);

        // Label stuff
        JLabel datoRutLabel = new JLabel("Rut:");
        JLabel datoNombreLabel = new JLabel("Nombre:");
        JLabel datoDireccionLabel = new JLabel("Direccion:");
        JLabel datoPaginaWebLabel = new JLabel("Pagina web:");
        JLabel datoCorreoLabel = new JLabel("Correo:");
        JLabel datoTelefonoLabel = new JLabel("Telefono:");

        // TextField stuff
        datoRutTextField = new JTextField(empresa.getRut());
        datoNombreTextField = new JTextField(empresa.getNombre());
        datoDireccionTextField = new JTextField(empresa.getDireccion());
        datoPaginaWebTextField = new JTextField(empresa.getPaginaWeb());
        datoCorreoTextField = new JTextField(empresa.getCorreo());
        datoTelefonoTextField = new JTextField(empresa.getTelefono());

        // Panel stuff
        panel.setLayout(null);

        panel.add(datoRutLabel).setBounds(10, 20, 120, 25);
        panel.add(datoNombreLabel).setBounds(10, 50, 120, 25);
        panel.add(datoDireccionLabel).setBounds(10, 80,120, 25);
        panel.add(datoPaginaWebLabel).setBounds(10, 110, 120, 25);
        panel.add(datoCorreoLabel).setBounds(10, 140, 120, 25);
        panel.add(datoTelefonoLabel).setBounds(10, 170, 120, 25);

        panel.add(datoRutTextField).setBounds(140, 20, 165, 25);
        panel.add(datoNombreTextField).setBounds(140, 50, 165, 25);
        panel.add(datoDireccionTextField).setBounds(140, 80,165, 25);
        panel.add(datoPaginaWebTextField).setBounds(140, 110, 165, 25);
        panel.add(datoCorreoTextField).setBounds(140, 140, 165, 25);
        panel.add(datoTelefonoTextField).setBounds(140, 170, 165, 25);

        panel.add(confirmarButton).setBounds(70, 200, 165, 25);

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
            empresa.setRut(datoRutTextField.getText());
            empresa.setNombre(datoNombreTextField.getText());
            empresa.setDireccion(datoDireccionTextField.getText());
            empresa.setPaginaWeb(datoPaginaWebTextField.getText());
            empresa.setCorreo(datoCorreoTextField.getText());
            empresa.setTelefono(datoTelefonoTextField.getText());

            frame.dispose();
            new VentanaAccionExitosa();
        }
    }
}
