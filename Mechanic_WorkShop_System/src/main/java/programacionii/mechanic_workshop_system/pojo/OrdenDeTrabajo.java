/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programacionii.mechanic_workshop_system.pojo;

import programacionii.mechanic_workshop_system.pojo.PresupuestoOrdenDeTrabajo;

/**
 *
 * @author navar
 */
public class OrdenDeTrabajo {
    private int id;//Numero de orden
    private int codCliente;
    private int codVehiculo;
    private String revision;
    private double presupuesto;
    private PresupuestoOrdenDeTrabajo presupuestoOrdenDeTrabajo;

    public OrdenDeTrabajo() {
    }

    public OrdenDeTrabajo(int codCliente, int codVehiculo, String revision, double presupuesto, PresupuestoOrdenDeTrabajo presupuestoOrdenDeTrabajo) {
        this.codCliente = codCliente;
        this.codVehiculo = codVehiculo;
        this.revision = revision;
        this.presupuesto = presupuesto;
        this.presupuestoOrdenDeTrabajo = presupuestoOrdenDeTrabajo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(int codCliente) {
        this.codCliente = codCliente;
    }

    public int getCodVehiculo() {
        return codVehiculo;
    }

    public void setCodVehiculo(int codVehiculo) {
        this.codVehiculo = codVehiculo;
    }

    public String getRevision() {
        return revision;
    }

    public void setRevision(String revision) {
        this.revision = revision;
    }

    public double getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(double presupuesto) {
        this.presupuesto = presupuesto;
    }

    public PresupuestoOrdenDeTrabajo getPresupuestoOrdenDeTrabajo() {
        return presupuestoOrdenDeTrabajo;
    }

    public void setPresupuestoOrdenDeTrabajo(PresupuestoOrdenDeTrabajo presupuestoOrdenDeTrabajo) {
        this.presupuestoOrdenDeTrabajo = presupuestoOrdenDeTrabajo;
    }
    
}
