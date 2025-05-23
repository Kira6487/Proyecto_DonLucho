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

import java.io.*;
import java.util.*;

public class ControladorProducto {
    private List<Producto> productos;

    public ControladorProducto() {
        productos = new ArrayList<>();
        cargarProductosDesdeArchivo("D:\\NetBeansProyects\\Proyecto_DonLucho\\DonLuchoProyectV1\\src\\main\\java\\data\\BD_DonLucho.txt");
    }

    private void cargarProductosDesdeArchivo(String ruta) {
        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
            String linea = br.readLine(); // Saltar encabezado
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.trim().split("\\s{2,}"); // Separador: dos o más espacios
                if (partes.length == 6) {
                    int id = Integer.parseInt(partes[0]);
                    String nombre = partes[1];
                    int cantidad = Integer.parseInt(partes[2]);
                    double precio = Double.parseDouble(partes[3]);
                    String categoria = partes[4];
                    String condicion = partes[5];
                    productos.add(new Producto(id, nombre, cantidad, precio, categoria, condicion));
                }
            }
        } catch (IOException e) {
            System.err.println("Error leyendo archivo: " + e.getMessage());
        }
    }

    public Producto buscarPorId(int id) {
        for (Producto p : productos) {
            if (p.getIdProducto() == id) return p;
        }
        return null;
    }

    public Producto buscarPorNombreYCondicion(String nombre, String condicion) {
        for (Producto p : productos) {
            if (p.getNombreProducto().equalsIgnoreCase(nombre) &&
                p.getCondicion().equalsIgnoreCase(condicion)) {
                return p;
            }
        }
        return null;
    }

    public List<Producto> getTodos() {
        return productos;
    }
}
