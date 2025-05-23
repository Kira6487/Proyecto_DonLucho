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
import java.awt.event.*;
import modelo.Usuario;

public class VistaMenuPrincipal extends JFrame {

    private JButton botonMesas;
    private JButton botonInventario;
    private JButton botonBoletas;
    private Navegador navegador;
    private Usuario usuario;

    public VistaMenuPrincipal(Navegador navegador, Usuario usuario) {
        this.navegador = navegador;
        this.usuario = usuario;

        setTitle("Menú Principal - Don Lucho");
        setSize(400, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JLabel bienvenida = new JLabel("Bienvenido, " + usuario.getNombreUsuario() + " (" + usuario.getRol() + ")");
        bienvenida.setHorizontalAlignment(SwingConstants.CENTER);

        botonMesas = new JButton("Ir a Vista Mesas");
        botonInventario = new JButton("Ir a Vista Inventario");
        botonBoletas = new JButton("Ir a Vista Boletas");

        JPanel panel = new JPanel(new GridLayout(4, 1, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        panel.add(bienvenida);
        panel.add(botonMesas);
        panel.add(botonInventario);
        panel.add(botonBoletas);

        add(panel);

        // Acción para ir a vista de mesas
        botonMesas.addActionListener(e -> {
            dispose();
            navegador.mostrarVistaMesas();
        });

        // Acción para ir a vista de inventario
        botonInventario.addActionListener(e -> {
            dispose();
            navegador.mostrarVistaInventario();
        });

        // Acción para ir a vista de boletas
        botonBoletas.addActionListener(e -> {
            dispose();
            navegador.mostrarVistaBoleta();
        });

        setVisible(true);
    }
}
