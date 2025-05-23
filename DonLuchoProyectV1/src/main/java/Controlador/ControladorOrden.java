/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

/**
 *
 * @author eduar
 */


import Modelo.DetalleOrden;
import Modelo.Orden;
import Modelo.Producto;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ControladorOrden {

    private NodoOrden inicio;

    private class NodoOrden {
        Orden orden;
        List<DetalleOrden> detalles;
        NodoOrden siguiente;

        public NodoOrden(Orden orden) {
            this.orden = orden;
            this.detalles = new ArrayList<>();
            this.siguiente = null;
        }
    }
    
        public boolean agregarProductoAOrden(int idOrden, Producto producto, int cantidad) {
        if (producto == null || cantidad <= 0) return false;

        DetalleOrden detalle = new DetalleOrden(
            generarIdDetalle(), idOrden,
            producto.getIdProducto(), producto.getNombreProducto(),
            cantidad, producto.getPrecio()
        );
        return agregarDetalleAOrden(idOrden, detalle);
    }

        // Generador simple de ID para DetalleOrden
            private int generarIdDetalle() {
            return new Random().nextInt(9000) + 1000;
        }


    public void agregarOrden(Orden nuevaOrden) {
        NodoOrden nuevoNodo = new NodoOrden(nuevaOrden);
        if (inicio == null) {
            inicio = nuevoNodo;
        } else {
            NodoOrden actual = inicio;
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = nuevoNodo;
        }
    }

    public boolean eliminarOrden(int idOrden) {
        NodoOrden actual = inicio;
        NodoOrden anterior = null;

        while (actual != null && actual.orden.getIdOrden() != idOrden) {
            anterior = actual;
            actual = actual.siguiente;
        }

        if (actual == null) {
            return false;
        }

        if (anterior == null) {
            inicio = actual.siguiente;
        } else {
            anterior.siguiente = actual.siguiente;
        }
        return true;
    }

    public Orden buscarOrden(int idOrden) {
        NodoOrden actual = inicio;
        while (actual != null) {
            if (actual.orden.getIdOrden() == idOrden) {
                return actual.orden;
            }
            actual = actual.siguiente;
        }
        return null;
    }

    public boolean agregarDetalleAOrden(int idOrden, DetalleOrden detalle) {
        NodoOrden actual = inicio;
        while (actual != null) {
            if (actual.orden.getIdOrden() == idOrden) {
                actual.detalles.add(detalle);
                double nuevoTotal = actual.orden.getTotal() + detalle.getSubtotal();
                actual.orden.setTotal(nuevoTotal);
                return true;
            }
            actual = actual.siguiente;
        }
        return false;
    }

    public boolean quitarDetalleDeOrden(int idOrden, int idDetalle) {
        NodoOrden actual = inicio;
        while (actual != null) {
            if (actual.orden.getIdOrden() == idOrden) {
                for (DetalleOrden d : actual.detalles) {
                    if (d.getIdDetalle() == idDetalle) {
                        actual.detalles.remove(d);
                        actual.orden.setTotal(actual.orden.getTotal() - d.getSubtotal());
                        return true;
                    }
                }
            }
            actual = actual.siguiente;
        }
        return false;
    }

    public List<DetalleOrden> obtenerDetalles(int idOrden) {
        NodoOrden actual = inicio;
        while (actual != null) {
            if (actual.orden.getIdOrden() == idOrden) {
                return actual.detalles;
            }
            actual = actual.siguiente;
        }
        return null;
    }

    public void imprimirOrdenes() {
        NodoOrden actual = inicio;
        while (actual != null) {
            Orden o = actual.orden;
            System.out.println("Orden ID: " + o.getIdOrden() + ", Mesa: " + o.getIdMesa() + ", Total: " + o.getTotal());
            for (DetalleOrden d : actual.detalles) {
                System.out.println(" - Producto: " + d.getNombreProducto() + ", Cantidad: " + d.getCantidad() + ", Subtotal: " + d.getSubtotal());
            }
            actual = actual.siguiente;
        }
    }

    // Método para dividir orden en dos
    public boolean dividirOrden(int idOrden, List<Integer> idsDetallesParaSeparar, Orden nuevaOrden) {
        NodoOrden actual = inicio;
        while (actual != null) {
            if (actual.orden.getIdOrden() == idOrden) {
                NodoOrden nueva = new NodoOrden(nuevaOrden);
                double nuevoTotal = 0;
                List<DetalleOrden> aEliminar = new ArrayList<>();
                for (DetalleOrden d : actual.detalles) {
                    if (idsDetallesParaSeparar.contains(d.getIdDetalle())) {
                        nueva.detalles.add(d);
                        nuevoTotal += d.getSubtotal();
                        aEliminar.add(d);
                    }
                }
                nueva.orden.setTotal(nuevoTotal);
                actual.detalles.removeAll(aEliminar);
                actual.orden.setTotal(actual.orden.getTotal() - nuevoTotal);

                nueva.siguiente = actual.siguiente;
                actual.siguiente = nueva;
                return true;
            }
            actual = actual.siguiente;
        }
        return false;
    }
}

