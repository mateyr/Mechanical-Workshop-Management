/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programacionii.mechanic_workshop_system.dao.implementation;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import programacionii.mechanic_workshop_system.dao.ClienteDao;
import programacionii.mechanic_workshop_system.pojo.Cliente;

/**
 *
 * @author navar
 */
public class JsonClienteDaoImpl extends RandomTemplate implements ClienteDao{
    private final int SIZE = 0;
    private Gson gson;

    public JsonClienteDaoImpl() {
        super(new File("Cliente.head"), new File("Cliente.dat"));
        this.gson = new Gson();
    }

    @Override
    public Cliente findById(int id) throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void create(Cliente t) throws IOException {
        getCustomRandom().getRafH().seek(0);
        
        int n = getCustomRandom().getRafH().readInt();
        int k = getCustomRandom().getRafH().readInt();
        
        long posD = k * SIZE;
        
        getCustomRandom().getRafD().seek(posD);
        
        getCustomRandom().getRafD().writeInt(++k);
        getCustomRandom().getRafD().writeUTF(t.getNombreCompleto());
        getCustomRandom().getRafD().writeUTF(t.getCedula());
        getCustomRandom().getRafD().writeUTF(t.getCelular());
        getCustomRandom().getRafD().writeUTF(t.getEmail());
        getCustomRandom().getRafD().writeUTF(t.getTelefono());
        getCustomRandom().getRafD().writeUTF(t.getDepartamento());
        getCustomRandom().getRafD().writeUTF(t.getMunicipio());
        getCustomRandom().getRafD().writeUTF(t.getBoOrColonia());
        getCustomRandom().getRafD().writeUTF(t.getDireccion());
        getCustomRandom().getRafD().writeUTF(t.getVehiculo().toString());
        
        long posH = 8 + (4 * k);
        
        getCustomRandom().getRafH().seek(0);
        getCustomRandom().getRafH().writeInt(++n);
        getCustomRandom().getRafH().writeInt(++k);
        
        getCustomRandom().getRafH().seek(posH);
        getCustomRandom().getRafH().writeInt(k);
        
        close();
    }

    @Override
    public int update(Cliente t) throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Cliente t) throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Collection<Cliente> getAll() throws IOException {
        List<Cliente> clientes = new ArrayList<>();
        Cliente cliente = null;
        
        getCustomRandom().getRafH().seek(0);
        int n = getCustomRandom().getRafH().readInt();
        
        for (int i = 0; i < n; i++) {
            long posH = 8 + (i * 8);
            getCustomRandom().getRafH().readInt();
            
            int id = getCustomRandom().getRafH().readInt();
            
            if(id <= 0) {
                continue;
            }
            
            long posD = (id - 1) * SIZE + 4;
            getCustomRandom().getRafD().seek(posD);
            cliente = gson.fromJson(getCustomRandom().getRafD().readUTF(), Cliente.class);
            
            clientes.add(cliente);
        }
        
        return clientes;
    }
    
}
