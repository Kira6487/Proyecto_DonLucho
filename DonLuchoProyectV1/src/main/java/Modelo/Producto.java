/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author eduar
 */
// Producto.java

public class Producto {
    private int idProducto;
    private String nombreProducto;
    private int cantidad;
    private double precio;
    private String categoria;
    private String condicion;

    public Producto(int idProducto, String nombreProducto, int cantidad, double precio, String categoria, String condicion) {
        this.idProducto = idProducto;
        this.nombreProducto = nombreProducto;
        this.cantidad = cantidad;
        this.precio = precio;
        this.categoria = categoria;
        this.condicion = condicion;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public String getCategoria() {
        return categoria;
    }

    public String getCondicion() {
        return condicion;
    }

    public String toString() {
        return idProducto + " - " + nombreProducto + " - " + precio + " - " + categoria + " - " + condicion;
    }
}
