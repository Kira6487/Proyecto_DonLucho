/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

/**
 *
 * @author eduar
 */

import Modelo.Producto;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ControladorProducto {
    private Producto[] productos;
    private int cantidad;

    public ControladorProducto() {
        productos = new Producto[300]; // ajusta si hay más productos
        cantidad = 0;
        cargarProductos();
        quickSort(productos, 0, cantidad - 1);
    }

    private void cargarProductos() {
        try (BufferedReader br = new BufferedReader(new FileReader("BD_DonLucho.txt"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                if (linea.trim().isEmpty() || linea.startsWith("ID")) continue;
                String[] datos = linea.split("\\s{2,}");
                if (datos.length == 6) {
                    Producto p = new Producto(
                        Integer.parseInt(datos[0].trim()),
                        datos[1].trim(),
                        Integer.parseInt(datos[2].trim()),
                        Double.parseDouble(datos[3].trim()),
                        datos[4].trim(),
                        datos[5].trim()
                    );
                    productos[cantidad++] = p;
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer la base de datos: " + e.getMessage());
        }
    }

    public Producto buscarProductoPorID(int id) {
        int index = busquedaBinaria(productos, 0, cantidad - 1, id);
        if (index != -1) {
            return productos[index];
        }
        return null;
    }

    private int busquedaBinaria(Producto[] arr, int izq, int der, int id) {
        while (izq <= der) {
            int mid = izq + (der - izq) / 2;
            if (arr[mid].getIdProducto() == id) return mid;
            if (arr[mid].getIdProducto() < id) izq = mid + 1;
            else der = mid - 1;
        }
        return -1;
    }

    private void quickSort(Producto[] arr, int izq, int der) {
        if (izq < der) {
            int pi = particion(arr, izq, der);
            quickSort(arr, izq, pi - 1);
            quickSort(arr, pi + 1, der);
        }
    }

    private int particion(Producto[] arr, int izq, int der) {
        int pivote = arr[der].getIdProducto();
        int i = (izq - 1);
        for (int j = izq; j < der; j++) {
            if (arr[j].getIdProducto() <= pivote) {
                i++;
                Producto temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        Producto temp = arr[i + 1];
        arr[i + 1] = arr[der];
        arr[der] = temp;
        return i + 1;
    }

    public Producto[] getProductos() {
        return productos;
    }

    public int getCantidad() {
        return cantidad;
    }
}
