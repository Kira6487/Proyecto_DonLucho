/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

/**
 *
 * @author eduar
 */
public class NodoVista {
    private String vista;
    private NodoVista siguiente;

    public NodoVista(String vista) {
        this.vista = vista;
        this.siguiente = null;
    }

    public String getVista() {
        return vista;
    }

    public NodoVista getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoVista siguiente) {
        this.siguiente = siguiente;
    }
}
