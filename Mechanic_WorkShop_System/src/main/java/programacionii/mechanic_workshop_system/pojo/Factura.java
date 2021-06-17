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
public class Factura {
    private int id;//4//Numero de factura
    private String descripcionProducto;//20
    private int cantidadProducto;//4
    private double descuentoProducto;//8
    private double precioProducto;//8
    private double subTotalProducto;//8
    private double manoDeObra;//8
    private double subTotal;//8
    private double descuento;//8
    private double subTotalNeto;//8
    private double iva;//8
    private double total;//8
    //SIZE = 100

    public Factura() {
    }

    public Factura(String descripcionProducto, int cantidadProducto, double descuentoProducto, double precioProducto, double subTotalProducto, double manoDeObra, double subTotal, double descuento, double subTotalNeto, double iva, double total) {
        this.descripcionProducto = descripcionProducto;
        this.cantidadProducto = cantidadProducto;
        this.descuentoProducto = descuentoProducto;
        this.precioProducto = precioProducto;
        this.subTotalProducto = subTotalProducto;
        this.manoDeObra = manoDeObra;
        this.subTotal = subTotal;
        this.descuento = descuento;
        this.subTotalNeto = subTotalNeto;
        this.iva = iva;
        this.total = total;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcionProducto() {
        return descripcionProducto;
    }

    public void setDescripcionProducto(String descripcionProducto) {
        this.descripcionProducto = descripcionProducto;
    }

    public int getCantidadProducto() {
        return cantidadProducto;
    }

    public void setCantidadProducto(int cantidadProducto) {
        this.cantidadProducto = cantidadProducto;
    }

    public double getDescuentoProducto() {
        return descuentoProducto;
    }

    public void setDescuentoProducto(double descuentoProducto) {
        this.descuentoProducto = descuentoProducto;
    }

    public double getPrecioProducto() {
        return precioProducto;
    }

    public void setPrecioProducto(double precioProducto) {
        this.precioProducto = precioProducto;
    }

    public double getSubTotalProducto() {
        return subTotalProducto;
    }

    public void setSubTotalProducto(double subTotalProducto) {
        this.subTotalProducto = subTotalProducto;
    }

    public double getManoDeObra() {
        return manoDeObra;
    }

    public void setManoDeObra(double manoDeObra) {
        this.manoDeObra = manoDeObra;
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

    public double getSubTotalNeto() {
        return subTotalNeto;
    }

    public void setSubTotalNeto(double subTotalNeto) {
        this.subTotalNeto = subTotalNeto;
    }

    public double getIva() {
        return iva;
    }

    public void setIva(double iva) {
        this.iva = iva;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    
}
