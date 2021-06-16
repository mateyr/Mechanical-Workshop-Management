/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programacionii.mechanic_workshop_system.dao;

import java.io.IOException;
import programacionii.mechanic_workshop_system.pojo.Vehiculo;

/**
 *
 * @author navar
 */
public interface VehiculoDao extends Dao<Vehiculo>{
    Vehiculo findById(int id) throws IOException;
}
