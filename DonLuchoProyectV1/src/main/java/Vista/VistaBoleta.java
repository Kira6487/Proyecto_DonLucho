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
    public JButton botonImprimir;
    public JButton botonCerrar;

    public VistaBoleta() {
        setTitle("Boleta - Don Lucho");
        setSize(400, 300);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        areaBoleta = new JTextArea();
        areaBoleta.setEditable(false);
        JScrollPane scroll = new JScrollPane(areaBoleta);

        botonImprimir = new JButton("Imprimir");
        botonCerrar = new JButton("Cerrar");

        JPanel panelBotones = new JPanel();
        panelBotones.add(botonImprimir);
        panelBotones.add(botonCerrar);

        add(scroll, BorderLayout.CENTER);
        add(panelBotones, BorderLayout.SOUTH);
        setVisible(true);
    }

    VistaBoleta(Navegador aThis) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
