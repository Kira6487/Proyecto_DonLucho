/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author eduar
 */
// Usuario.java
package modelo;

public class Usuario {
    private int idUsuario;
    private String nombreUsuario;
    private int codigoAcceso;
    private String rol;

    public Usuario(int idUsuario, String nombreUsuario, int codigoAcceso, String rol) {
        this.idUsuario = idUsuario;
        this.nombreUsuario = nombreUsuario;
        this.codigoAcceso = codigoAcceso;
        this.rol = rol;
    }

    public Usuario(String admin, String administrador, String admin0) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public int getCodigoAcceso() {
        return codigoAcceso;
    }

    public String getRol() {
        return rol;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public void setCodigoAcceso(int codigoAcceso) {
        this.codigoAcceso = codigoAcceso;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
}

