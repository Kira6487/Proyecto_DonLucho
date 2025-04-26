/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author eduar
 */
// Usuario.java
package Modelo;

public class Usuario {
    private int idUsuario;
    private String nombreUsuario;
    private String codigoAcceso;
    private String rol;

    public Usuario(int idUsuario, String nombreUsuario, String codigoAcceso, String rol) {
        this.idUsuario = idUsuario;
        this.nombreUsuario = nombreUsuario;
        this.codigoAcceso = codigoAcceso;
        this.rol = rol;
    }

    public boolean login(String codigoIngresado) {
        return this.codigoAcceso.equals(codigoIngresado);
    }

    // Getters y Setters
    public int getIdUsuario() { return idUsuario; }
    public void setIdUsuario(int idUsuario) { this.idUsuario = idUsuario; }

    public String getNombreUsuario() { return nombreUsuario; }
    public void setNombreUsuario(String nombreUsuario) { this.nombreUsuario = nombreUsuario; }

    public String getCodigoAcceso() { return codigoAcceso; }
    public void setCodigoAcceso(String codigoAcceso) { this.codigoAcceso = codigoAcceso; }

    public String getRol() { return rol; }
    public void setRol(String rol) { this.rol = rol; }
}
