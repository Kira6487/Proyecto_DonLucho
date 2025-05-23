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
    public JTable tablaInventario;
    public JButton botonAgregar;
    public JButton botonEliminar;

    public VistaInventario() {
        setTitle("Inventario - Don Lucho");
        setSize(600, 400);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        String[] columnas = {"ID", "Nombre", "Cantidad", "Precio"};
        Object[][] datos = {}; // Datos vacíos por ahora

        tablaInventario = new JTable(datos, columnas);
        JScrollPane scroll = new JScrollPane(tablaInventario);

        botonAgregar = new JButton("Agregar Producto");
        botonEliminar = new JButton("Eliminar Producto");

        JPanel panelBotones = new JPanel();
        panelBotones.add(botonAgregar);
        panelBotones.add(botonEliminar);

        add(scroll, BorderLayout.CENTER);
        add(panelBotones, BorderLayout.SOUTH);
        setVisible(true);
    }

    VistaInventario(Navegador aThis) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

