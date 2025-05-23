/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista;

/**
 *
 * @author eduar
 */

import javax.swing.*;
import java.awt.*;

public class VistaBoleta extends JFrame {
    public JTextArea areaBoleta;
    public JButton botonGenerarBoleta;

    public VistaBoleta() {
        setTitle("Generar Boleta - Don Lucho");
        setSize(400, 300);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        areaBoleta = new JTextArea();
        JScrollPane scroll = new JScrollPane(areaBoleta);

        botonGenerarBoleta = new JButton("Generar Boleta");

        add(scroll, BorderLayout.CENTER);
        add(botonGenerarBoleta, BorderLayout.SOUTH);
        setVisible(true);
    }
}