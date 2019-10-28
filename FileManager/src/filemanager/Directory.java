/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filemanager;

import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author Ash
 * @author Prachi
 * @author Niti
 */
public class Directory {
    private String name;
    private Date modifiedDate;
    private ArrayList<File> files;
    private String path;
    
    public Directory(String nm, Date md) {
        this.name = nm;
        this.modifiedDate = md;
        this.files = new ArrayList<>();
    }
    
    public String getName() {
        return this.name;
    }
    
    public int noFiles() {
        return this.files.size();
    }
    
    public Date getDate() {
        return this.modifiedDate;
    }
    
    public String openDirectory() {
        String list = "";
        for(int i = 0; i < this.files.size();i++) {
            list += String.valueOf(this.files[i]) + "\n";
        }
        return (list);
    }
    
    public boolean createFile(File f) {
        this.files.add(f);
        //ADD FILE HANDLING AND EXCEPTIONS
        return true;
    }
    
    public boolean deleteFile(File f) {
        this.files.remove(f);
        //ADD FILE HANDLING AND EXCEPTIONS
        return true;
    }
    @Override
    public String toString() {
        return (this.name + " - " + this.files.size() + " - " + this.modifiedDate );
    }
    
    @Override
    public boolean equals(Object dir) {
        if(dir instanceof Directory) {
            Directory temp = (Directory)dir;
            if(this.name.equals(temp.getName()) && this.modifiedDate.equals(temp.getDate()) 
                    && this.noFiles() == temp.noFiles())
                return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.name);
        hash = 79 * hash + Objects.hashCode(this.modifiedDate);
        return hash;
    }
}
