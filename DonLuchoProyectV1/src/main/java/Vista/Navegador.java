/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista;

/**
 *
 * @author eduar
 */

import Modelo.Mesa;
import Modelo.Orden;
import modelo.Usuario;
import controlador.*;
import javax.swing.JOptionPane;

public class Navegador {

    private Usuario usuarioActual;

    private VistaLogin vistaLogin;
    private VistaMesas vistaMesas;
    private VistaOrden vistaOrden;
    private VistaInventario vistaInventario;
    private VistaBoleta vistaBoleta;

    public Navegador() {
        // Inicializamos las vistas pasando el navegador para permitir navegación entre vistas
        vistaLogin = new VistaLogin(this);
        vistaMesas = new VistaMesas(this);
        vistaOrden = new VistaOrden(this);
        vistaInventario = new VistaInventario(this);
        vistaBoleta = new VistaBoleta(this);
        
        // Al iniciar, mostrar login
        mostrarVistaLogin();
    }

    public void mostrarVistaLogin() {
        vistaLogin.setVisible(true);
        vistaMesas.setVisible(false);
        vistaOrden.setVisible(false);
        vistaInventario.setVisible(false);
        vistaBoleta.setVisible(false);
    }

    public void mostrarVistaMesas() {
        vistaLogin.setVisible(false);
        vistaMesas.setVisible(true);
        vistaOrden.setVisible(false);
        vistaInventario.setVisible(false);
        vistaBoleta.setVisible(false);
    }

    public void mostrarVistaOrden(int idMesa) {
        vistaLogin.setVisible(false);
        vistaMesas.setVisible(false);
        vistaOrden.setVisible(true);
        vistaOrden.setMesaSeleccionada(idMesa); // método para asignar la mesa seleccionada en VistaOrden
        vistaInventario.setVisible(false);
        vistaBoleta.setVisible(false);
    }

    public void mostrarVistaInventario() {
        if (!usuarioActual.getRol().equalsIgnoreCase("Administrador")) {
            JOptionPane.showMessageDialog(null, "Acceso denegado. Solo administradores pueden acceder.");
            return;
        }
        vistaLogin.setVisible(false);
        vistaMesas.setVisible(false);
        vistaOrden.setVisible(false);
        vistaInventario.setVisible(true);
        vistaBoleta.setVisible(false);
    }

    public void mostrarVistaBoleta() {
        if (!usuarioActual.getRol().equalsIgnoreCase("Cajero")) {
            JOptionPane.showMessageDialog(null, "Acceso denegado. Solo cajeros pueden acceder.");
            return;
        }
        vistaLogin.setVisible(false);
        vistaMesas.setVisible(false);
        vistaOrden.setVisible(false);
        vistaInventario.setVisible(false);
        vistaBoleta.setVisible(true);
    }

    public void setUsuarioActual(Usuario usuario) {
        this.usuarioActual = usuario;
    }

    public Usuario getUsuarioActual() {
        return this.usuarioActual;
    }
}

