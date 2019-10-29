/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package writer;
import filemanager.*;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
/**
 *
 * @author Niteshkumar
 */
public class Writer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        FileOutputStream fout = new FileOutputStream("../filesystem.txt");
        ObjectOutputStream out = new ObjectOutputStream(fout);
        FileSystem fs = new FileSystem("C");
        Date date = new Date(1,1,1);
        fs.createDirectory(new Directory("home", date));
        out.writeObject(fs);
        
        FileInputStream fin = new FileInputStream("../filesystem.txt");
        ObjectInputStream in =new ObjectInputStream(fin);
        while(true){
            try{
                System.out.println(in.readObject());
            }
            catch(EOFException e){
                break;
            }
        }
    }
    
}
