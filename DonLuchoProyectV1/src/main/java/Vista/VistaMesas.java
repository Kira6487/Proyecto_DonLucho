/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import Vista.Navegador;


public class VistaMesas extends JFrame {

    public JButton[] botonesMesas;
    private Navegador navegador;

    public VistaMesas(Navegador navegador, int cantidadMesas) {
        this.navegador = navegador;

        setTitle("Seleccionar Mesa - Don Lucho");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(0, 5, 10, 10)); // 5 columnas, filas automáticas, con espacios
        setLocationRelativeTo(null);

        botonesMesas = new JButton[cantidadMesas];
        for (int i = 0; i < cantidadMesas; i++) {
            botonesMesas[i] = new JButton("Mesa " + (i + 1));
            botonesMesas[i].setActionCommand(String.valueOf(i + 1)); // Identificador mesa
            add(botonesMesas[i]);

            botonesMesas[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int idMesa = Integer.parseInt(e.getActionCommand());
                    // Aquí llamamos al navegador para mostrar vista de orden para la mesa seleccionada
                    navegador.mostrarVistaOrden(idMesa);
                }
            });
        }
        setVisible(true);
    }
}

