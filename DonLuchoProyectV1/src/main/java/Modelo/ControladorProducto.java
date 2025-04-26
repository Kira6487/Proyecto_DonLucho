/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author eduar
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ControladorProducto {

    private Producto[] productos;
    private int cantidadProductos;

    public ControladorProducto(String archivo) {
        productos = new Producto[300]; // capacidad estimada
        cantidadProductos = 0;
        cargarProductosDesdeArchivo(archivo);
        quickSort(productos, 0, cantidadProductos - 1);
    }

    private void cargarProductosDesdeArchivo(String archivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.trim().split("\\s{2,}");
                if (partes.length >= 6) {
                    int id = Integer.parseInt(partes[0]);
                    String nombre = partes[1];
                    int cantidad = Integer.parseInt(partes[2]);
                    double precio = Double.parseDouble(partes[3]);
                    String categoria = partes[4];
                    String condicion = partes[5];
                    productos[cantidadProductos++] = new Producto(id, nombre, cantidad, precio, categoria, condicion);
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    // Quick Sort por ID
    private void quickSort(Producto[] arr, int izquierda, int derecha) {
        if (izquierda < derecha) {
            int pivoteIndex = particionar(arr, izquierda, derecha);
            quickSort(arr, izquierda, pivoteIndex - 1);
            quickSort(arr, pivoteIndex + 1, derecha);
        }
    }

    private int particionar(Producto[] arr, int izquierda, int derecha) {
        Producto pivote = arr[derecha];
        int i = izquierda - 1;

        for (int j = izquierda; j < derecha; j++) {
            if (arr[j].getIdProducto() <= pivote.getIdProducto()) {
                i++;
                Producto temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        Producto temp = arr[i + 1];
        arr[i + 1] = arr[derecha];
        arr[derecha] = temp;

        return i + 1;
    }

    // Búsqueda binaria por ID
    public Producto buscarPorId(int idBuscado) {
        int izquierda = 0;
        int derecha = cantidadProductos - 1;

        while (izquierda <= derecha) {
            int medio = (izquierda + derecha) / 2;
            int idActual = productos[medio].getIdProducto();

            if (idActual == idBuscado) {
                return productos[medio];
            } else if (idActual < idBuscado) {
                izquierda = medio + 1;
            } else {
                derecha = medio - 1;
            }
        }
        return null;
    }

    // Mostrar todos los productos (opcional para debug)
    public void mostrarProductos() {
        for (int i = 0; i < cantidadProductos; i++) {
            System.out.println(productos[i]);
        }
    }

    // Obtener todos los productos (para la vista si se necesita)
    public Producto[] getProductos() {
        return productos;
    }

    public int getCantidadProductos() {
        return cantidadProductos;
    }
}
