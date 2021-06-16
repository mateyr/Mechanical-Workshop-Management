/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programacionii.mechanic_workshop_system.pojo;

import programacionii.mechanic_workshop_system.enums.MarcaVehiculo;
import programacionii.mechanic_workshop_system.enums.TipoVehiculo;

/**
 *
 * @author navar
 */
public class Vehiculo {
    private int id;//Codigo de vehiculo
    private int idCliente;//Codigo de dueño del vehiculo
    private String placa;
    private String motor;
    private String vin;
    private String chasis;
    private String year;
    private String kms;
    private String modelo;
    private String color;
    private MarcaVehiculo marcaVehiculo;
    private TipoVehiculo tipoVehiculo;

    public Vehiculo() {
    }

    public Vehiculo(String placa, String motor, String vin, String chasis, String year, String kms, String modelo, String color, MarcaVehiculo marcaVehiculo, TipoVehiculo tipoVehiculo) {
        this.placa = placa;
        this.motor = motor;
        this.vin = vin;
        this.chasis = chasis;
        this.year = year;
        this.kms = kms;
        this.modelo = modelo;
        this.color = color;
        this.marcaVehiculo = marcaVehiculo;
        this.tipoVehiculo = tipoVehiculo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMotor() {
        return motor;
    }

    public void setMotor(String motor) {
        this.motor = motor;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getChasis() {
        return chasis;
    }

    public void setChasis(String chasis) {
        this.chasis = chasis;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getKms() {
        return kms;
    }

    public void setKms(String kms) {
        this.kms = kms;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public MarcaVehiculo getMarcaVehiculo() {
        return marcaVehiculo;
    }

    public void setMarcaVehiculo(MarcaVehiculo marcaVehiculo) {
        this.marcaVehiculo = marcaVehiculo;
    }

    public TipoVehiculo getTipoVehiculo() {
        return tipoVehiculo;
    }

    public void setTipoVehiculo(TipoVehiculo tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }
    
}
