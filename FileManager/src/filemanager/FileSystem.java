/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filemanager;

import java.util.ArrayList;
import java.util.Objects;

/**
 * @author Ash
 * @author Prachi
 * @author Niti
 */

class DirectoryAlreadyExists extends RuntimeException {
    public DirectoryAlreadyExists(Directory dir) {
        super(dir.getName() + " already exists...\n");
    }
}

class DirectoryNotFound extends RuntimeException {
    public DirectoryNotFound(Directory dir) {
        super(dir.getName() + " does not exist...\n");
    }
}

public class FileSystem {
    private String name;
    private ArrayList<Directory> directories;
    
    public FileSystem(String nm) {
        this.name = nm;
        this.directories = new ArrayList<>();
    }
    
    public String openDirectory() {
        String list = "";
        for (Directory file : this.directories) {
            list += String.valueOf(file) + "\n";
        }
        return (list);
    }
    
    public boolean createDirectory(Directory dir) {
        if(this.directories.contains(dir)) {
            throw new DirectoryAlreadyExists(dir);
        }
        
        this.directories.add(dir);
        return true;
    }
    
    public boolean deleteDirectory(Directory dir) {
        if(this.directories.contains(dir)) {
            this.directories.remove(dir);
            return true;
        }
        throw new DirectoryNotFound(dir);
    }
    
    
    public ArrayList getDirectories() {
        return this.directories;
    }
    
    @Override
    public String toString() {
        return (this.name + " - " + String.valueOf(this.directories));
    }
    
    public String openFileSystem() {
        String list = "";
        for (Directory dir : this.directories) {
            list += String.valueOf(dir) + "\n";
        }
        return (list);
    }
    
    @Override
    public boolean equals(Object o) {
        if(o instanceof FileSystem) {
            FileSystem fs = (FileSystem)o;
            return (this.name.equals(fs.name));
        }
        return false;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + Objects.hashCode(this.name);
        return hash;
    }
    
    
}
