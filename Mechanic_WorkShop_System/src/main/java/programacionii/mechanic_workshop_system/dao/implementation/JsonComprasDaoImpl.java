/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programacionii.mechanic_workshop_system.dao.implementation;

import com.google.gson.Gson;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import programacionii.mechanic_workshop_system.dao.ComprasDao;
import programacionii.mechanic_workshop_system.pojo.Compras;

/**
 *
 * @author navar
 */
public class JsonComprasDaoImpl extends RandomTemplate implements ComprasDao{
    private final int SIZE = 60;
    private Gson gson;

    public JsonComprasDaoImpl() {
        super(new File("Compras.head"), new File("Compras.dat"));
        this.gson = new Gson();
    }
    
    @Override
    public Compras findById(int id) throws IOException {
        Compras c = null;
        
        getCustomRandom().getRafD().seek(0);
        int n = getCustomRandom().getRafD().readInt();
        
        if(id <= 0 || id > n) {
            return null;
        }
        
        long pos = 8 + (id - 1) * SIZE;
        
        getCustomRandom().getRafD().seek(pos);
        int code = getCustomRandom().getRafD().readInt();
        
        if(id == code) {
            c = gson.fromJson(getCustomRandom().getRafD().readUTF(), Compras.class);
        }
        
        close();
        return c;
    }

    @Override
    public void create(Compras t) throws IOException {
        getCustomRandom().getRafH().seek(0);
        
        int n = getCustomRandom().getRafH().readInt();
        int k = getCustomRandom().getRafH().readInt();
        
        long posD = k * SIZE;
        
        getCustomRandom().getRafD().seek(posD);
        
        getCustomRandom().getRafD().writeInt(++k);
        getCustomRandom().getRafD().writeUTF(gson.toJson(t));
        
        long posH = 8 + (4 * k);
        
        getCustomRandom().getRafH().seek(0);
        getCustomRandom().getRafH().writeInt(++n);
        getCustomRandom().getRafH().writeInt(++k);
        
        getCustomRandom().getRafH().seek(posH);
        getCustomRandom().getRafH().writeInt(k);
        
        close();
    }

    @Override
    public int update(Compras t) throws IOException {
        getCustomRandom().getRafH().seek(0);
        int n = getCustomRandom().getRafH().readInt();
        
        for (int i = 0; i < n; i++) {
            long posH = 8 + (i * 8);
            getCustomRandom().getRafH().seek(posH);
            
            int id = getCustomRandom().getRafH().readInt();
            
            if(id <= 0) {
                continue;
            }
            
            if(id == t.getId()) {
                long posD = getCustomRandom().getRafD().readInt();
                getCustomRandom().getRafD().seek(posD);
                getCustomRandom().getRafD().writeUTF(gson.toJson(t));
                return 0;
            }
        }
        
        close();
        return -1;
    }

    @Override
    public boolean delete(Compras t) throws IOException {
        getCustomRandom().getRafH().seek(0);
        int n = getCustomRandom().getRafH().readInt();
        
        for (int i = 0; i < n; i++) {
            long posH = 8 + (i * 8);
            getCustomRandom().getRafH().seek(posH);
            
            int id = getCustomRandom().getRafH().readInt();
            
            if(id <= 0) {
                continue;
            }
            
            if(id == t.getId()) {
                getCustomRandom().getRafH().seek(posH);
                getCustomRandom().getRafH().writeInt(-1);
                return true;
            }
        }
        
        close();
        return false;
    }

    @Override
    public Collection<Compras> getAll() throws IOException {
        List<Compras> compras = new ArrayList<>();
        Compras compra = null;
        
        getCustomRandom().getRafH().seek(0);
        int n = getCustomRandom().getRafH().readInt();
        
        for (int i = 0; i < n; i++) {
            long posH = 8 + (i * 8);
            getCustomRandom().getRafH().seek(posH);
            //getCustomRandom().getRafH().readInt();
            
            int id = getCustomRandom().getRafH().readInt();
            
            if(id <= 0) {
                continue;
            }
            
            long posD = (id - 1) * SIZE + 4;
            getCustomRandom().getRafD().seek(posD);
            compra = gson.fromJson(getCustomRandom().getRafD().readUTF(), Compras.class);
            
            compras.add(compra);
        }
        
        close();
        return compras;
    }
    
}
