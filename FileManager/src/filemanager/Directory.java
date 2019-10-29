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
 * @author Ash
 * @author Prachi
 * @author Niti
 */

class FileAlreadyExists extends RuntimeException {
    public FileAlreadyExists(File file) {
        super(file.getName() + " already exists...\n");
    }
}

class FileNotFound extends RuntimeException {
    public FileNotFound(File file) {
        super(file.getName() + " does not exist...\n");
    }
}

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
    
    public Date getModifiedDate() {
        return this.modifiedDate;
    }
    
    public ArrayList getFiles() {
        return this.files;
    }
    
    public String openDirectory() {
        String list = "";
        for (File file : this.files) {
            list += String.valueOf(file) + "\n";
        }
        return (list);
    }
    
    public boolean createFile(File f) {
        if(this.files.contains(f)) {
            throw new FileAlreadyExists(f);
        }
        
        this.files.add(f);
        return true;
    }
    
    public boolean deleteFile(File f) {
        if(this.files.contains(f)) {
            this.files.remove(f);
            return true;
        }
        throw new FileNotFound(f);
    }
    
    @Override
    public String toString() {
        return (this.name + " - " + this.files.size() + " - " + this.modifiedDate );
    }
    
    @Override
    public boolean equals(Object o) {
        if(o instanceof Directory) {
            Directory dir = (Directory)o;
            return (this.name.equals(dir.name) && this.modifiedDate.equals(dir.modifiedDate) 
                    && this.noFiles() == dir.noFiles());
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
