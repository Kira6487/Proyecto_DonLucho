/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista;

import Modelo.Orden;
import modelo.Usuario;
import javax.swing.*;

public class Navegador {

    private Usuario usuarioActual;

    private VistaLogin vistaLogin;
    private VistaMesas vistaMesas;
    private VistaOrden vistaOrden;
    private VistaInventario vistaInventario;
    private VistaBoleta vistaBoleta;
    private JFrame vistaActual;

    public Navegador() {
        mostrarLogin();
    }

    public void mostrarLogin() {
        vistaLogin = new VistaLogin(this);
        cambiarVista(vistaLogin);
    }

    public void mostrarVistaMesas() {
        vistaMesas = new VistaMesas(10, this); // 10 mesas como ejemplo
        cambiarVista(vistaMesas);
    }

    public void mostrarVistaOrden(int idMesa) {
        if (vistaOrden == null) {
            vistaOrden = new VistaOrden(this);
        }
        vistaOrden.setMesaSeleccionada(idMesa);
        cambiarVista(vistaOrden);
    }

    public void mostrarVistaInventario() {
        if (usuarioActual != null && usuarioActual.getRol().equalsIgnoreCase("admin")) {
            if (vistaInventario == null) {
                vistaInventario = new VistaInventario(this);
            }
            cambiarVista(vistaInventario);
        } else {
            JOptionPane.showMessageDialog(null, "Acceso denegado: solo administradores");
        }
    }

    public void mostrarVistaBoleta() {
        if (usuarioActual != null && usuarioActual.getRol().equalsIgnoreCase("cajero")) {
            if (vistaBoleta == null) {
                vistaBoleta = new VistaBoleta(this);
            }
            cambiarVista(vistaBoleta);
        } else {
            JOptionPane.showMessageDialog(null, "Acceso denegado: solo cajeros");
        }
    }

    private void cambiarVista(JFrame nuevaVista) {
        if (vistaActual != null) {
            vistaActual.dispose();
        }
        vistaActual = nuevaVista;
        vistaActual.setVisible(true);
    }

    public void setUsuarioActual(Usuario usuario) {
        this.usuarioActual = usuario;
    }

    public Usuario getUsuarioActual() {
        return usuarioActual;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Navegador::new);
    }
}


