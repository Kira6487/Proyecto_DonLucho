/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

/**
 *
 * @author eduar
 */

import Modelo.Inventario;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

public class ControladorInventario {
    private List<Inventario> listaInventario;

    public ControladorInventario() {
        this.listaInventario = new ArrayList<>();
    }

    // Agregar producto al inventario
    public void agregarProducto(Inventario producto) {
        listaInventario.add(producto);
    }

    // Eliminar producto del inventario por ID
    public boolean eliminarProducto(int idProducto) {
        Iterator<Inventario> it = listaInventario.iterator();
        while (it.hasNext()) {
            Inventario p = it.next();
            if (p.getIdProducto() == idProducto) {
                it.remove();
                return true;
            }
        }
        return false;
    }

    // Buscar producto por ID (búsqueda secuencial)
    public Inventario buscarProductoPorId(int idProducto) {
        for (Inventario p : listaInventario) {
            if (p.getIdProducto() == idProducto) {
                return p;
            }
        }
        return null;
    }

    // Ordenar productos por nombre usando QuickSort
    public void ordenarPorNombre() {
        quickSortNombre(0, listaInventario.size() - 1);
    }

    private void quickSortNombre(int inicio, int fin) {
        if (inicio < fin) {
            int indiceParticion = particionar(inicio, fin);
            quickSortNombre(inicio, indiceParticion - 1);
            quickSortNombre(indiceParticion + 1, fin);
        }
    }

    private int particionar(int inicio, int fin) {
        String pivote = listaInventario.get(fin).getNombreProducto();
        int i = inicio - 1;
        for (int j = inicio; j < fin; j++) {
            if (listaInventario.get(j).getNombreProducto().compareToIgnoreCase(pivote) <= 0) {
                i++;
                Inventario temp = listaInventario.get(i);
                listaInventario.set(i, listaInventario.get(j));
                listaInventario.set(j, temp);
            }
        }
        Inventario temp = listaInventario.get(i + 1);
        listaInventario.set(i + 1, listaInventario.get(fin));
        listaInventario.set(fin, temp);
        return i + 1;
    }

    // Obtener lista de productos
    public List<Inventario> getListaInventario() {
        return listaInventario;
    }

    // Mostrar productos (para depuración o vista de consola)
    public void imprimirInventario() {
        for (Inventario p : listaInventario) {
            System.out.println(p.getIdProducto() + ", " + p.getNombreProducto() + ", " + p.getCantidad() + ", " + p.getEstado());
        }
    }
}
