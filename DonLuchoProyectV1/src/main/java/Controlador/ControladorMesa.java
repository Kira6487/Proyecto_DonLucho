/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

/**
 *
 * @author eduar
 */

import Modelo.Mesa;
import modelo.Usuario;

import java.util.ArrayList;
import java.util.List;

public class ControladorMesa {
    private List<Mesa> listaMesas;
    private Usuario usuarioActual;

    public ControladorMesa(Usuario usuario) {
        this.usuarioActual = usuario;
        this.listaMesas = new ArrayList<>();
        cargarMesasEjemplo();
    }

    private void cargarMesasEjemplo() {
        // Solo para prueba, reemplazar con lectura de archivo
        listaMesas.add(new Mesa(1, 1, 4, "Libre"));
        listaMesas.add(new Mesa(2, 2, 6, "Libre"));
        listaMesas.add(new Mesa(3, 3, 2, "Ocupada"));
        listaMesas.add(new Mesa(4, 4, 4, "Libre"));
    }

    public List<Mesa> obtenerMesasOrdenadasPorCapacidad() {
        List<Mesa> copia = new ArrayList<>(listaMesas);
        mergeSort(copia, 0, copia.size() - 1);
        return copia;
    }

    private void mergeSort(List<Mesa> lista, int inicio, int fin) {
        if (inicio < fin) {
            int medio = (inicio + fin) / 2;
            mergeSort(lista, inicio, medio);
            mergeSort(lista, medio + 1, fin);
            merge(lista, inicio, medio, fin);
        }
    }

    private void merge(List<Mesa> lista, int inicio, int medio, int fin) {
        List<Mesa> izquierda = new ArrayList<>(lista.subList(inicio, medio + 1));
        List<Mesa> derecha = new ArrayList<>(lista.subList(medio + 1, fin + 1));
        int i = 0, j = 0, k = inicio;

        while (i < izquierda.size() && j < derecha.size()) {
            if (izquierda.get(i).getCapacidad() <= derecha.get(j).getCapacidad()) {
                lista.set(k++, izquierda.get(i++));
            } else {
                lista.set(k++, derecha.get(j++));
            }
        }

        while (i < izquierda.size()) {
            lista.set(k++, izquierda.get(i++));
        }
        while (j < derecha.size()) {
            lista.set(k++, derecha.get(j++));
        }
    }

    public Mesa buscarMesaPorNumero(int numeroMesa) {
        for (Mesa mesa : listaMesas) {
            if (mesa.getNumeroMesa() == numeroMesa) {
                return mesa;
            }
        }
        return null;
    }

    public boolean ocuparMesa(int numeroMesa, int numeroPersonas) {
        Mesa mesa = buscarMesaPorNumero(numeroMesa);
        if (mesa != null && mesa.getEstado().equals("Libre")) {
            mesa.setEstado("Ocupada");
            mesa.setCapacidad(numeroPersonas);
            return true;
        }
        return false;
    }

    public boolean liberarMesa(int numeroMesa) {
        Mesa mesa = buscarMesaPorNumero(numeroMesa);
        if (mesa != null && mesa.getEstado().equals("Ocupada")) {
            mesa.setEstado("Libre");
            return true;
        }
        return false;
    }

    public List<Mesa> obtenerMesas() {
        return listaMesas;
    }
} 
