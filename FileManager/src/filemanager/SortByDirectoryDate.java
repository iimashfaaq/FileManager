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

public class SortByDirectoryDate implements Runnable {
    private ArrayList<Directory> files = new ArrayList<>();
    
    public SortByDirectoryDate(FileSystem fs) {
        ArrayList<Directory> dirRef = fs.getDirectories();
        
        dirRef.forEach((dir) -> {
            this.files.add(dir);
        });
    }
    
    @Override
    public void run() {
        Collections.sort(this.files, new SortByDirDate());
    }
}

class SortByDirDate implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        Directory f1 = (Directory)o1;
        Directory f2 = (Directory)o2;
        
        return (f1.getModifiedDate().compareTo(f2.getModifiedDate()));
    }
}
