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
    private Navegador navegador;
    private int mesaSeleccionada;
    private JLabel labelMesa;
    private JTextArea areaDetalle;
    private JButton botonAgregarProducto;
    private JButton botonEliminarProducto;
    private JButton botonEnviarOrden;
    private JButton botonDividirOrden;

    public VistaOrden(Navegador navegador) {
        this.navegador = navegador;
        inicializarComponentes();
    }

    private void inicializarComponentes() {
        setTitle("Crear Orden - Don Lucho");
        setSize(500, 400);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        labelMesa = new JLabel("Mesa seleccionada: -");
        areaDetalle = new JTextArea();
        JScrollPane scroll = new JScrollPane(areaDetalle);

        botonAgregarProducto = new JButton("Agregar Producto");
        botonEliminarProducto = new JButton("Eliminar Producto");
        botonEnviarOrden = new JButton("Enviar Orden");
        botonDividirOrden = new JButton("Dividir Orden");

        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.add(labelMesa, BorderLayout.WEST);

        JPanel botones = new JPanel();
        botones.add(botonAgregarProducto);
        botones.add(botonEliminarProducto);
        botones.add(botonDividirOrden);
        botones.add(botonEnviarOrden);

        add(topPanel, BorderLayout.NORTH);
        add(scroll, BorderLayout.CENTER);
        add(botones, BorderLayout.SOUTH);

        setVisible(true);
    }

    public void setMesaSeleccionada(int idMesa) {
        this.mesaSeleccionada = idMesa;
        labelMesa.setText("Mesa seleccionada: " + idMesa);
    }
}    

