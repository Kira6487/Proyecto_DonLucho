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

public class VistaInventario extends JFrame {
    public JTextArea areaInventario;
    public JButton botonAgregar, botonEliminar;

    public VistaInventario() {
        setTitle("Administrar Inventario - Don Lucho");
        setSize(500, 400);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        areaInventario = new JTextArea();
        JScrollPane scroll = new JScrollPane(areaInventario);

        botonAgregar = new JButton("Agregar Producto");
        botonEliminar = new JButton("Eliminar Producto");

        JPanel botones = new JPanel();
        botones.add(botonAgregar);
        botones.add(botonEliminar);

        add(scroll, BorderLayout.CENTER);
        add(botones, BorderLayout.SOUTH);
        setVisible(true);
    }
}
