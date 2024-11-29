/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author Cetecom
 */
public class Cliente {
    private int idCliente;
    private String rut;
    private String nombreCliente;
    private String numeroContacto;
    private String direccion;
    private String tipoCliente;

    public Cliente() {
    }

    public Cliente(int idCliente, String rut, String nombreCliente, String numeroContacto, String direccion, String tipoCliente) {
        this.idCliente = idCliente;
        this.rut = rut;
        this.nombreCliente = nombreCliente;
        this.numeroContacto = numeroContacto;
        this.direccion = direccion;
        this.tipoCliente = tipoCliente;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getNumeroContacto() {
        return numeroContacto;
    }

    public void setNumeroContacto(String numeroContacto) {
        this.numeroContacto = numeroContacto;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(String tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

    @Override
    public String toString() {
        return "Cliente{" + "idCliente=" + idCliente + ", rut=" + rut + ", nombreCliente=" + nombreCliente + ", numeroContacto=" + numeroContacto + ", direccion=" + direccion + ", tipoCliente=" + tipoCliente + '}';
    }
}
