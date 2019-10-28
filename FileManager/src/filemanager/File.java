package filemanager;


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

enum FileType{
    txt,
    bin,
    c,
    cpp,
    java
}

public class File {
    private String name;
    private Date modifiedDate;
    private Owner o;
    private boolean isProtected;
    private FileType type;
    private String content;
    
    public File(String name,Date modifiedDate,Owner o,boolean isProtected,FileType type) {
        this.name = name;
        this.modifiedDate = modifiedDate;
        this.o = o;
        this.isProtected = isProtected;
        this.type = type;
        this.content = "";
    }
    
    @Override
    public String toString(){
        return this.name + "." + this.type + " - " + 
                String.valueOf(o) + " - " + String.valueOf(modifiedDate);
    }
    
    @Override
    public boolean equals(Object o){
        if(o instanceof File){
            File temp = (File)o;
            return this.name.equals(temp.name) && this.type == temp.type && 
                    this.isProtected == temp.isProtected && this.modifiedDate.equals(temp.modifiedDate) &&
                    this.content.equals(temp.content);
        }
        return false;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.name);
        hash = 47 * hash + Objects.hashCode(this.modifiedDate);
        hash = 47 * hash + Objects.hashCode(this.o);
        hash = 47 * hash + (this.isProtected ? 1 : 0);
        hash = 47 * hash + Objects.hashCode(this.type);
        return hash;
    }
    
    public String getName(){
        return this.name;
    }
    
    public String getModifiedDate(){
        return this.modifiedDate;
    }
    
    public boolean write(String data){
        this.content = data;
        return true;
    }
    
    public boolean append(String data){
        this.content += data;
        return true;
    }
    
    public String open(){
        return this.content;
    }
}
