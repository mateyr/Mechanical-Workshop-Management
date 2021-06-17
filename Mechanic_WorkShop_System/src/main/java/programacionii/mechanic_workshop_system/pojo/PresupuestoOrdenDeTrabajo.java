/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programacionii.mechanic_workshop_system.pojo;

import java.util.Objects;

/**
 *
 * @author navar
 */
public class PresupuestoOrdenDeTrabajo {
    private int id;//4
    private int codigo;//4
    private String descripcion;//20
    private int cantidad;//4
    private double precio;//8
    private double subTotal;//8
    private double descuento;//8
    private double total;//8
    //SIZE = 64

    public PresupuestoOrdenDeTrabajo() {
    }

    public PresupuestoOrdenDeTrabajo(int codigo, String descripcion, int cantidad, double precio, double subTotal, double descuento, double total) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.precio = precio;
        this.subTotal = subTotal;
        this.descuento = descuento;
        this.total = total;
    }
    
    public int getId() {
        return id;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
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

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + this.id;
        hash = 97 * hash + this.codigo;
        hash = 97 * hash + Objects.hashCode(this.descripcion);
        hash = 97 * hash + this.cantidad;
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.precio) ^ (Double.doubleToLongBits(this.precio) >>> 32));
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.subTotal) ^ (Double.doubleToLongBits(this.subTotal) >>> 32));
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.descuento) ^ (Double.doubleToLongBits(this.descuento) >>> 32));
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.total) ^ (Double.doubleToLongBits(this.total) >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final PresupuestoOrdenDeTrabajo other = (PresupuestoOrdenDeTrabajo) obj;
        return true;
    }
    
    
    
}
