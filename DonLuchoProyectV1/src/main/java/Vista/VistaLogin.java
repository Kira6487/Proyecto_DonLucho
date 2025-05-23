/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import Vista.Navegador;

public class VistaLogin extends JFrame {

    public JTextField campoCodigo;
    public JButton botonIngresar;

    private Navegador navegador;

    public VistaLogin(Navegador navegador) {
        this.navegador = navegador;

        setTitle("Login - Don Lucho");
        setSize(300, 150);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(2, 2, 5, 5));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        panel.add(new JLabel("Código de Acceso:"));
        campoCodigo = new JTextField();
        panel.add(campoCodigo);

        // Añadimos un espacio vacío para alinear el botón mejor
        panel.add(new JLabel(""));
        botonIngresar = new JButton("Ingresar");
        panel.add(botonIngresar);

        add(panel);

        // Listener para el botón Ingresar
        botonIngresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String codigo = campoCodigo.getText().trim();
                if (codigo.isEmpty()) {
                    JOptionPane.showMessageDialog(VistaLogin.this, "Por favor ingresa un código de acceso.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Aquí se debería llamar al controlador para validar el usuario
                // Por ejemplo:
                // Usuario usuario = ControladorUsuario.validarCodigo(codigo);
                // if(usuario != null) { 
                //     navegador.setUsuarioActual(usuario);
                //     navegador.mostrarVistaMesas();
                // } else {
                //     JOptionPane.showMessageDialog(VistaLogin.this, "Código de acceso inválido.", "Error", JOptionPane.ERROR_MESSAGE);
                // }

                // Por ahora simulamos acceso válido si el código es "admin"
                if (codigo.equalsIgnoreCase("admin")) {
                    // Simular creación usuario administrador
                    JOptionPane.showMessageDialog(VistaLogin.this, "Login exitoso como Administrador.");
                    navegador.mostrarVistaMesas();
                } else if (codigo.equalsIgnoreCase("cajero")) {
                    JOptionPane.showMessageDialog(VistaLogin.this, "Login exitoso como Cajero.");
                    navegador.mostrarVistaMesas();
                } else if (codigo.equalsIgnoreCase("mesero")) {
                    JOptionPane.showMessageDialog(VistaLogin.this, "Login exitoso como Mesero.");
                    navegador.mostrarVistaMesas();
                } else {
                    JOptionPane.showMessageDialog(VistaLogin.this, "Código de acceso inválido.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        setVisible(true);
    }
}

