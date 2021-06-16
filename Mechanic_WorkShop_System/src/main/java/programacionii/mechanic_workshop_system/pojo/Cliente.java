/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programacionii.mechanic_workshop_system.pojo;

/**
 *
 * @author navar
 */
public class Cliente {
    private int id;
    private String nombreCompleto;
    private String cedula;
    private String celular;
    private String email;
    private String telefono;
    private String departamento;
    private String municipio;
    private String BoOrColonia;
    private String direccion;
    private Vehiculo vehiculo;

    public Cliente() {
    }

    public Cliente(String nombreCompleto, String cedula, String celular, String email, String telefono, String departamento, String municipio, String BoOrColonia, String direccion, Vehiculo vehiculo) {
        this.nombreCompleto = nombreCompleto;
        this.cedula = cedula;
        this.celular = celular;
        this.email = email;
        this.telefono = telefono;
        this.departamento = departamento;
        this.municipio = municipio;
        this.BoOrColonia = BoOrColonia;
        this.direccion = direccion;
        this.vehiculo = vehiculo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getBoOrColonia() {
        return BoOrColonia;
    }

    public void setBoOrColonia(String BoOrColonia) {
        this.BoOrColonia = BoOrColonia;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }
       
}
