/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import java.util.NoSuchElementException;

public class ListaVistas {
    private NodoVista actual;

    public ListaVistas() {
        this.actual = null;
    }

        public void agregarVista(String vista) {
        NodoVista nuevaVista = new NodoVista(vista);
        if (actual == null) {
            actual = nuevaVista;
        } else {
            NodoVista temp = actual;
            while (temp.getSiguiente() != null) {
                temp = temp.getSiguiente();
            }
            temp.setSiguiente(nuevaVista);
            nuevaVista.setAnterior(temp);
            // No mover el puntero actual aquí
        }
    }


    public void avanzarVista() {
        if (actual == null || actual.getSiguiente() == null) {
            throw new NoSuchElementException("No hay vistas para avanzar.");
        }
        actual = actual.getSiguiente();
    }

    public void retrocederVista() {
        if (actual == null || actual.getAnterior() == null) {
            throw new NoSuchElementException("No hay vistas anteriores.");
        }
        actual = actual.getAnterior();
    }

    public String getVistaActual() {
        if (actual == null) {
            return "No hay vistas disponibles";
        }
        return actual.getVista();
    }

    public void reiniciar() {
        actual = null;
    }

    public boolean hayMasVistas() {
        return actual != null && actual.getSiguiente() != null;
    }

    public boolean hayVistaAnterior() {
        return actual != null && actual.getAnterior() != null;
    }
}

