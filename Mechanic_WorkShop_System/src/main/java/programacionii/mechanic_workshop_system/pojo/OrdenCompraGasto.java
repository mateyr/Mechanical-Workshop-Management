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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + this.id;
        hash = 41 * hash + Objects.hashCode(this.numeroOrden);
        hash = 41 * hash + Objects.hashCode(this.nombreMecanico);
        hash = 41 * hash + Objects.hashCode(this.estado);
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
        final OrdenCompraGasto other = (OrdenCompraGasto) obj;
        return true;
    }
    
    
    
}
