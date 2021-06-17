/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programacionii.mechanic_workshop_system.pojo;

import programacionii.mechanic_workshop_system.enums.UserType;

/**
 *
 * @author MateyR
 */
public class User
{
    private int id;
    private String name;  // 16
    private String lastName; // 16 
    private String username;  //16
    private String password;   //16
    private int edad; // 4
    private UserType userType; // 12
    
    //SIZE = 140

    public User(int id, String name, String lastName, String username, String password, int edad, UserType userType)
    {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.edad = edad;
        this.userType = userType;
    }
        
    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public int getEdad()
    {
        return edad;
    }

    public void setEdad(int edad)
    {
        this.edad = edad;
    }

    public UserType getUserType()
    {
        return userType;
    }

    public void setUserType(UserType userType)
    {
        this.userType = userType;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    @Override
    public String toString()
    {
        return "User{" + "id=" + id + ", name=" + name + ", lastName=" + lastName + ", username=" + username + ", password=" + password + ", edad=" + edad + '}';
    }
    
    
    
    
}
