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
import java.util.List;

public class ControladorBoleta {

    private static final double IGV = 0.18;

    public static String generarBoleta(Orden orden, List<DetalleOrden> detalles, String metodoPago, double propina, double montoPagado) {
        StringBuilder sb = new StringBuilder();

        double subtotal = 0.0;
        sb.append("\n=========== BOLETA DE VENTA ===========\n");
        sb.append("ID Orden: ").append(orden.getIdOrden()).append("\n");
        sb.append("Usuario: ").append(orden.getIdUsuario()).append("\n");
        sb.append("Mesa: ").append(orden.getIdMesa()).append("\n");
        sb.append("Fecha: ").append(orden.getFechaHora()).append("\n\n");

        sb.append(String.format("%-25s %-10s %-10s %-10s\n", "Producto", "Cantidad", "P. Unit", "Subtotal"));
        for (DetalleOrden detalle : detalles) {
            double sub = detalle.getCantidad() * detalle.getPrecio();
            subtotal += sub;
            sb.append(String.format("%-25s %-10d %-10.2f %-10.2f\n", detalle.getNombreProducto(), detalle.getCantidad(), detalle.getPrecio(), sub));
        }

        double igv = subtotal * IGV;
        double total = subtotal + igv + propina;
        double cambio = montoPagado - total;

        sb.append("\nSubtotal: S/ ").append(String.format("%.2f", subtotal));
        sb.append("\nIGV (18%): S/ ").append(String.format("%.2f", igv));
        sb.append("\nPropina: S/ ").append(String.format("%.2f", propina));
        sb.append("\nTOTAL A PAGAR: S/ ").append(String.format("%.2f", total));
        sb.append("\nMetodo de Pago: ").append(metodoPago);
        sb.append("\nMonto Pagado: S/ ").append(String.format("%.2f", montoPagado));
        sb.append("\nCambio: S/ ").append(String.format("%.2f", cambio));
        sb.append("\n=======================================\n");

        return sb.toString();
    }
}

