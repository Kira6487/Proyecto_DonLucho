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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginVista extends JFrame {
    private JTextField txtCodigo;
    private JButton btnIngresar;

    private final String[] codigosPermitidos = {"123", "456", "789"}; // Códigos de acceso permitidos

    public LoginVista() {
        setTitle("Login - Don Lucho");
        setSize(300, 150);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(3, 1));

        JLabel lbl = new JLabel("Ingrese su código de acceso:", SwingConstants.CENTER);
        add(lbl);

        txtCodigo = new JTextField();
        add(txtCodigo);

        btnIngresar = new JButton("Ingresar");
        add(btnIngresar);

        btnIngresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String codigo = txtCodigo.getText();
                if (codigoValido(codigo)) {
                    dispose();
                    JOptionPane.showMessageDialog(null, "Bienvenido, código aceptado.");
                    // Aquí se puede llamar a la vista principal más adelante.
                } else {
                    JOptionPane.showMessageDialog(null, "Código incorrecto. Intenta nuevamente.");
                }
            }
        });
    }

    private boolean codigoValido(String codigo) {
        for (String c : codigosPermitidos) {
            if (c.equals(codigo)) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new LoginVista().setVisible(true));
    }
}
