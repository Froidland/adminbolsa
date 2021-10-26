package com.bolsa.menugrafico;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaPrincipal extends JFrame implements ActionListener {

    JButton botonNuevoPostulante;


    public VentanaPrincipal() {
        this.setTitle("si");
        this.setSize(500, 500);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(null);

        JLabel welcomeText = new JLabel();
        welcomeText.setFont(new Font("Arial", Font.BOLD, 20));
        welcomeText.setHorizontalAlignment(SwingConstants.CENTER);
        welcomeText.setVerticalAlignment(SwingConstants.TOP);
        welcomeText.setText("Bienvenido");

        botonNuevoPostulante = new JButton();
        botonNuevoPostulante.setBounds(25, 25, 125, 75);
        botonNuevoPostulante.setText("Añadir nuevo postulante");
        botonNuevoPostulante.addActionListener(this);


        this.add(welcomeText);
        this.add(botonNuevoPostulante);

        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == botonNuevoPostulante) {
            System.out.println("Hello");
        }
    }
}
