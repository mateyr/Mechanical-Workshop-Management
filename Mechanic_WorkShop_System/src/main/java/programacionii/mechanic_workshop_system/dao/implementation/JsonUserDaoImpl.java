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
import programacionii.mechanic_workshop_system.dao.UserDao;
import programacionii.mechanic_workshop_system.enums.UserType;
import programacionii.mechanic_workshop_system.pojo.User;

/**
 *
 * @author MateyR
 */
public class JsonUserDaoImpl extends RandomTemplate implements UserDao
{
    private final int SIZE = 140;
    private Gson gson;

    public JsonUserDaoImpl()
    {
       super(new File("User.head"), new File("User.dat"));
       gson = new Gson();
    }

    @Override
    public void create(User t) throws IOException
    {
        
        getCustomRandom().getRafH().seek(0);
        int n = getCustomRandom().getRafH().readInt();
        int k = getCustomRandom().getRafH().readInt();
        
        long posD = k * SIZE;
        
        getCustomRandom().getRafD().seek(posD);
        
        getCustomRandom().getRafD().writeInt(++k);//id
        getCustomRandom().getRafD().writeUTF(gson.toJson(t));
        
        long posH = 8 + (n * 8);
        getCustomRandom().getRafH().seek(posH);
        
        getCustomRandom().getRafH().writeInt(k);
        getCustomRandom().getRafH().write(t.getId());
        
        getCustomRandom().getRafH().seek(0);
        getCustomRandom().getRafH().writeInt(++n);
        getCustomRandom().getRafH().writeInt(k);
        
        close();
      
    }

    @Override
    public int update(User t) throws IOException
    {
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
    public boolean delete(User t) throws IOException
    {
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
    public Collection<User> getAll() throws IOException
    {       
        List<User> users = new ArrayList<>();
        User user = null;
        
        getCustomRandom().getRafH().seek(0);
        int n = getCustomRandom().getRafH().readInt();
        
        for (int i = 0; i < n; i++) {
            long posH = 8 + (i * 8);
            getCustomRandom().getRafH().seek(posH);
            
            int id = getCustomRandom().getRafH().readInt();
            
            if(id <= 0) {
                continue;
            }
            
            long posD = (id - 1) * SIZE + 4;
            getCustomRandom().getRafD().seek(posD);
            user = gson.fromJson(getCustomRandom().getRafD().readUTF(), User.class);
            
            users.add(user);
        }
      return  users;
    }
    
    
}
