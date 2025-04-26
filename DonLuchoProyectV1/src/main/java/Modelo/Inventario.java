/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author eduar
 */
// Inventario.java

public class Inventario {
    private int idInventario;
    private int idProducto;
    private String nombreProducto;
    private int cantidad;
    private String estado;

    public Inventario(int idInventario, int idProducto, String nombreProducto, int cantidad, String estado) {
        this.idInventario = idInventario;
        this.idProducto = idProducto;
        this.nombreProducto = nombreProducto;
        this.cantidad = cantidad;
        this.estado = estado;
    }

    public void ingresarItem(int cantidad) {
        this.cantidad += cantidad;
    }

    public void venderItem(int cantidad) {
        this.cantidad -= cantidad;
    }

    // Getters y Setters
    public int getIdInventario() { return idInventario; }
    public void setIdInventario(int idInventario) { this.idInventario = idInventario; }

    public int getIdProducto() { return idProducto; }
    public void setIdProducto(int idProducto) { this.idProducto = idProducto; }

    public String getNombreProducto() { return nombreProducto; }
    public void setNombreProducto(String nombreProducto) { this.nombreProducto = nombreProducto; }

    public int getCantidad() { return cantidad; }
    public void setCantidad(int cantidad) { this.cantidad = cantidad; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
}
