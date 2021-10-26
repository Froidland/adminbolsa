package com.bolsa;

import javax.swing.*;
import java.awt.*;

public class MenuGrafico extends JFrame {
    JFrame mainWindow = new JFrame();

    public MenuGrafico() {
        JButton button1 = new JButton("click");
        button1.setBounds(280, 400, 100, 40);
        mainWindow.setLayeredPane(new JLayeredPane());

        mainWindow.getLayeredPane().add(button1);

        mainWindow.setSize(400, 500);
        mainWindow.setVisible(true);
    }
}
