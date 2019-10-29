/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filemanager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * @author Ash
 * @author Prachi
 * @author Niti
 */
public class SortByFileDate implements Runnable {
    private ArrayList<File> files = new ArrayList<>();
    
    public SortByFileDate(Directory dir) {
        ArrayList<File> fileRef = dir.getFiles();
        
        fileRef.forEach((f) -> {
            this.files.add(f);
        });
    }
    
    @Override
    public void run() {
        Collections.sort(this.files, new SortByName());
    }
}

class SortByDate implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        File f1 = (File)o1;
        File f2 = (File)o2;
        
        return (f1.getModifiedDate().compareTo(f2.getModifiedDate()));
    }
}