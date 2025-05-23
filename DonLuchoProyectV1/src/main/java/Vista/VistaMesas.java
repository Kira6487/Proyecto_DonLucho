/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista;

import javax.swing.*;
import java.awt.*;
import Controlador.ControladorMesa;

public class VistaMesas extends JFrame {
    public JButton[] botonesMesas;
    private Navegador navegador;

    public VistaMesas(int cantidadMesas, Navegador navegador) {
        this.navegador = navegador; // se asigna el navegador
        setTitle("Seleccionar Mesa - Don Lucho");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(0, 5));
        setLocationRelativeTo(null);

        botonesMesas = new JButton[cantidadMesas];
        for (int i = 0; i < cantidadMesas; i++) {
            botonesMesas[i] = new JButton("Mesa " + (i + 1));
            final int mesaSeleccionada = i + 1;
            botonesMesas[i].addActionListener(e -> {
                // Aquí podrías llamar al navegador para mostrar la vista de orden:
                navegador.mostrarVistaOrden(mesaSeleccionada);
            });
            add(botonesMesas[i]);
        }

        setVisible(true);
    }
}

