
import java.util.Objects;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Niteshkumar
 */
public class Owner {
    private String name;
    private String password;
    
    public Owner(String name,String password){
        this.name = name;
        this.password = password;
    }
    
    public String toString(){
        return "Owner : " + this.name;
    }
    
    @Override
    public boolean equals(Object o){
        if(o instanceof Owner){
            Owner temp = (Owner)o;
            return this.name.equals(temp.name) &&
                    this.password.equals(temp.password);
        }
        return false;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.name);
        hash = 79 * hash + Objects.hashCode(this.password);
        return hash;
    }
    
    public boolean changePassword(String newPassword){
        this.password = newPassword;
        return true;
    }
    
    public String getPassword(){
        return this.password;
    }
}
