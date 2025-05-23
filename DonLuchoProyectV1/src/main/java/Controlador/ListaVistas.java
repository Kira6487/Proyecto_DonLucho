/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

/**
 *
 * @author eduar
 */

import java.util.NoSuchElementException;

public class ListaVistas {
    private NodoVista cabeza;

    public ListaVistas() {
        this.cabeza = null;
    }

    // Agrega una nueva vista al final de la lista
    public void agregarVista(String vista) {
        NodoVista nuevo = new NodoVista(vista);
        if (cabeza == null) {
            cabeza = nuevo;
        } else {
            NodoVista actual = cabeza;
            while (actual.getSiguiente() != null) {
                actual = actual.getSiguiente();
            }
            actual.setSiguiente(nuevo);
        }
    }

    // Elimina la primera vista (navega a la siguiente)
    public void avanzarVista() {
        if (cabeza == null) {
            throw new NoSuchElementException("No hay vistas para avanzar.");
        }
        cabeza = cabeza.getSiguiente();
    }

    // Obtiene la vista actual
    public String getVistaActual() {
        if (cabeza == null) {
            return "No hay vistas disponibles";
        }
        return cabeza.getVista();
    }

    // Reinicia la lista de vistas
    public void reiniciar() {
        cabeza = null;
    }

    // Verifica si hay más vistas por recorrer
    public boolean hayMasVistas() {
        return cabeza != null;
    }
}

