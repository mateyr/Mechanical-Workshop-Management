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
public class OrdenCompraGasto {
    private int id;//4
    private String numeroOrden;//6
    private String nombreMecanico;//50
    private String estado;//10
    //SIZE = 70

    public OrdenCompraGasto() {
    }

    public OrdenCompraGasto(String numeroOrden, String nombreMecanico, String estado) {
        this.numeroOrden = numeroOrden;
        this.nombreMecanico = nombreMecanico;
        this.estado = estado;
    }
    
    public int getId() {
        return id;
    }

    public String getNumeroOrden() {
        return numeroOrden;
    }

    public void setNumeroOrden(String numeroOrden) {
        this.numeroOrden = numeroOrden;
    }

    public String getNombreMecanico() {
        return nombreMecanico;
    }

    public void setNombreMecanico(String nombreMecanico) {
        this.nombreMecanico = nombreMecanico;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
}
