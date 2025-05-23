/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import modelo.Usuario;
import Controlador.ControladorLogin;
import Vista.Navegador;

public class VistaLogin extends JFrame {

    private JTextField campoCodigo;
    private JButton botonIngresar;
    private Navegador navegador;
    private ControladorLogin controlador;

    public VistaLogin(Navegador navegador) {
        this.navegador = navegador;
        this.controlador = new ControladorLogin();

        setTitle("Login - Don Lucho");
        setSize(300, 150);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(2, 2, 5, 5));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        panel.add(new JLabel("Código de Acceso:"));
        campoCodigo = new JTextField();
        panel.add(campoCodigo);

        panel.add(new JLabel(""));
        botonIngresar = new JButton("Ingresar");
        panel.add(botonIngresar);

        add(panel);

        // Listener para botón Ingresar
        botonIngresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String codigoTexto = campoCodigo.getText().trim();
                if (codigoTexto.isEmpty()) {
                    JOptionPane.showMessageDialog(VistaLogin.this, "Por favor ingresa un código de acceso.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                int codigoAcceso = 0;
                try {
                    codigoAcceso = Integer.parseInt(codigoTexto);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(VistaLogin.this, "El código debe ser numérico.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                Usuario usuario = controlador.login(codigoAcceso);

                if (usuario != null) {
                    navegador.setUsuarioActual(usuario);
                    JOptionPane.showMessageDialog(VistaLogin.this, "Login exitoso como " + usuario.getRol() + ".");
                    navegador.mostrarVistaMesas();
                } else {
                    JOptionPane.showMessageDialog(VistaLogin.this, "Código de acceso inválido.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
}


