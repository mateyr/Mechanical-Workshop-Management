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
public class Compras {
    private int id;//4
    private String descripcion;//20
    private int cantidad;//4
    private double precio;//8
    private double descuento;//8
    private double subTotal;//8
    private double total;//8
    //SIZE = 60

    public Compras() {
    }

    public Compras(String descripcion, int cantidad, double precio, double descuento, double subTotal, double total) {
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.precio = precio;
        this.descuento = descuento;
        this.subTotal = subTotal;
        this.total = total;
    }
    
    public int getId() {
        return id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    
}
