/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

/**
 *
 * @author eduar
 */

import modelo.*;
import java.io.*;

public class ControladorLogin {
    private Usuario usuarioActual;

    public Usuario login(int codigoAcceso) {
        try (BufferedReader br = new BufferedReader(new FileReader("data/Datos_Usuario.txt"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split("\\s+");
                if (datos.length >= 4) {
                    int codigo = Integer.parseInt(datos[2]);
                    if (codigo == codigoAcceso) {
                        usuarioActual = new Usuario(
                            Integer.parseInt(datos[0]),
                            datos[1],
                            codigo,
                            datos[3]
                        );
                        return usuarioActual;
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo de usuarios: " + e.getMessage());
        }
        return null;
    }

    public Usuario getUsuarioActual() {
        return usuarioActual;
    }

    public boolean tienePermiso(String permisoRequerido) {
        if (usuarioActual == null) return false;
        switch (permisoRequerido) {
            case "Mezero":
                return usuarioActual.getRol().contains("Mezero");
            case "Cajero":
                return usuarioActual.getRol().equals("Cajero") || usuarioActual.getRol().equals("Administrador");
            case "Administrador":
                return usuarioActual.getRol().equals("Administrador");
            default:
                return false;
        }
    }

    public void setUsuarioActual(Usuario usuario) {
        this.usuarioActual = usuario;
    }
}


