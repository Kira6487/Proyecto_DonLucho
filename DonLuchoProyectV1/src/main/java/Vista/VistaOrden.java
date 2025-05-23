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

public class VistaOrden extends JFrame {
    public JTextArea areaDetalle;
    public JButton botonAgregarProducto, botonEliminarProducto, botonEnviarOrden, botonDividirOrden;

    public VistaOrden() {
        setTitle("Crear Orden - Don Lucho");
        setSize(500, 400);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        areaDetalle = new JTextArea();
        JScrollPane scroll = new JScrollPane(areaDetalle);

        botonAgregarProducto = new JButton("Agregar Producto");
        botonEliminarProducto = new JButton("Eliminar Producto");
        botonEnviarOrden = new JButton("Enviar Orden");
        botonDividirOrden = new JButton("Dividir Orden");

        JPanel botones = new JPanel();
        botones.add(botonAgregarProducto);
        botones.add(botonEliminarProducto);
        botones.add(botonDividirOrden);
        botones.add(botonEnviarOrden);

        add(scroll, BorderLayout.CENTER);
        add(botones, BorderLayout.SOUTH);
        setVisible(true);
    }
}
