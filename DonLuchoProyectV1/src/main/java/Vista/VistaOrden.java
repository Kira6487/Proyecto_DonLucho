/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
// VistaOrden.java
package Vista;

import Modelo.Producto;
import Modelo.DetalleOrden;
import Controlador.ListaVistas;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.LinkedList;

public class VistaOrden extends JFrame {
    private JTextField txtBuscar;
    private JComboBox<String> comboCondicion;
    private JTextArea areaOrden;
    private LinkedList<Producto> productos;
    private LinkedList<DetalleOrden> detalles;
    private int idDetalle = 1;
    private int idMesaSeleccionada = -1;
    private ListaVistas historial;
    private JLabel lblVistaActual;


    public VistaOrden() {
        this(null, -1);
    }

    public VistaOrden(Navegador nav, int idMesa) {
        setTitle("Orden - Don Lucho");
        setSize(800, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        historial = new ListaVistas();
        historial.agregarVista("VistaOrden");


        this.idMesaSeleccionada = idMesa;
        productos = cargarProductosDesdeRecurso();
        detalles = new LinkedList<>();

        // Panel de ingreso de productos
        JPanel panelDerecho = new JPanel(new GridLayout(4, 1, 5, 5));
        panelDerecho.setBorder(BorderFactory.createTitledBorder("Agregar Producto"));

        txtBuscar = new JTextField();
        comboCondicion = new JComboBox<>(new String[]{"Local", "Llevar"});
        JButton btnAgregar = new JButton("Agregar a Orden");

        panelDerecho.add(new JLabel("Nombre o ID:"));
        panelDerecho.add(txtBuscar);
        panelDerecho.add(new JLabel("Condición:"));
        panelDerecho.add(comboCondicion);
        panelDerecho.add(btnAgregar);

        // Panel de orden (izquierdo)
        areaOrden = new JTextArea();
        areaOrden.setEditable(false);
        JScrollPane scroll = new JScrollPane(areaOrden);
        scroll.setBorder(BorderFactory.createTitledBorder("Orden Actual"));

        add(scroll, BorderLayout.CENTER);
        add(panelDerecho, BorderLayout.EAST);

        btnAgregar.addActionListener(e -> agregarProducto());
        
        // Panel de navegación de vistas
        JPanel panelNavegacion = new JPanel(new FlowLayout());

        JButton btnAtras = new JButton("← Atrás");
        JButton btnAdelante = new JButton("Adelante →");

        lblVistaActual = new JLabel("Vista actual: " + historial.getVistaActual());

        panelNavegacion.add(btnAtras);
        panelNavegacion.add(btnAdelante);
        panelNavegacion.add(lblVistaActual);
        add(panelNavegacion, BorderLayout.SOUTH);

        setVisible(true);
        
                btnAtras.addActionListener(e -> {
            try {
                historial.retrocederVista();
                lblVistaActual.setText("Vista actual: " + historial.getVistaActual());
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "No hay vistas anteriores.");
            }
        });

        btnAdelante.addActionListener(e -> {
            try {
                historial.avanzarVista();
                lblVistaActual.setText("Vista actual: " + historial.getVistaActual());
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "No hay más vistas.");
            }
        });

    }

    private LinkedList<Producto> cargarProductosDesdeRecurso() {
        LinkedList<Producto> lista = new LinkedList<>();
        try (InputStream is = getClass().getClassLoader().getResourceAsStream("data/BD_DonLucho.txt");
             BufferedReader br = new BufferedReader(new InputStreamReader(is))) {

            String linea = br.readLine(); // Saltar encabezado
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.trim().split("\\s{2,}");
                if (datos.length == 6) {
                    int id = Integer.parseInt(datos[0]);
                    String nombre = datos[1];
                    int cantidad = Integer.parseInt(datos[2]);
                    double precio = Double.parseDouble(datos[3]);
                    String categoria = datos[4];
                    String condicion = datos[5];
                    lista.add(new Producto(id, nombre, cantidad, precio, categoria, condicion));
                }
            }
        } catch (IOException | NullPointerException e) {
            JOptionPane.showMessageDialog(this, "Error al leer archivo de productos: " + e.getMessage());
        }
        return lista;
    }

    private void agregarProducto() {
        String texto = txtBuscar.getText().trim().toLowerCase();
        String condicion = comboCondicion.getSelectedItem().toString();

        for (Producto p : productos) {
            boolean coincideNombre = p.getNombreProducto().toLowerCase().contains(texto);
            boolean coincideID = String.valueOf(p.getIdProducto()).equals(texto);
            boolean coincideCondicion = p.getCondicion().equalsIgnoreCase(condicion);

            if ((coincideNombre || coincideID) && coincideCondicion) {
                DetalleOrden detalle = new DetalleOrden(idDetalle++, idMesaSeleccionada, p.getIdProducto(),
                        p.getNombreProducto(), 1, p.getPrecio());
                detalles.add(detalle);
                actualizarVistaOrden();
                txtBuscar.setText("");
                return;
            }
        }
        JOptionPane.showMessageDialog(this, "Producto no encontrado con esa condición.");
    }

    private void actualizarVistaOrden() {
        areaOrden.setText("");
        for (DetalleOrden d : detalles) {
            areaOrden.append("[" + d.getIdDetalle() + "] " + d.getNombreProducto() +
                    " x" + d.getCantidad() + " = S/" + d.getSubtotal() + "\n");
        }
    }

    public void setMesaSeleccionada(int idMesa) {
        this.idMesaSeleccionada = idMesa;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(VistaOrden::new);
    }
}
