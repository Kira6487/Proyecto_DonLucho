/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author eduar
 */
// Orden.java

import java.util.Date;

public class Orden {
    private int idOrden;
    private Date fechaHora;
    private int idUsuario;
    private int idMesa;
    private int numeroPersonas;
    private double total;

    public Orden(int idOrden, Date fechaHora, int idUsuario, int idMesa, int numeroPersonas, double total) {
        this.idOrden = idOrden;
        this.fechaHora = fechaHora;
        this.idUsuario = idUsuario;
        this.idMesa = idMesa;
        this.numeroPersonas = numeroPersonas;
        this.total = total;
    }

    public void enviarPedido() {
        System.out.println("Pedido enviado.");
    }

    public void cancelarPedido() {
        System.out.println("Pedido cancelado.");
    }

    // Getters y Setters
    public int getIdOrden() { return idOrden; }
    public void setIdOrden(int idOrden) { this.idOrden = idOrden; }

    public Date getFechaHora() { return fechaHora; }
    public void setFechaHora(Date fechaHora) { this.fechaHora = fechaHora; }

    public int getIdUsuario() { return idUsuario; }
    public void setIdUsuario(int idUsuario) { this.idUsuario = idUsuario; }

    public int getIdMesa() { return idMesa; }
    public void setIdMesa(int idMesa) { this.idMesa = idMesa; }

    public int getNumeroPersonas() { return numeroPersonas; }
    public void setNumeroPersonas(int numeroPersonas) { this.numeroPersonas = numeroPersonas; }

    public double getTotal() { return total; }
    public void setTotal(double total) { this.total = total; }
}

