/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filemanager;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

/**
 * @author Ash
 * @author Prachi
 * @author Niti
 */
public class FileManager {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        Scanner in = new Scanner(System.in);
        FileSystem fs;
        FileInputStream fin = new FileInputStream("../filesystem.txt");
        ObjectInputStream oin =new ObjectInputStream(fin);    
        int option = 1;
        String dirname;
        boolean check;
        while(true){
            fs = (FileSystem) oin.readObject();
            System.out.println(fs);
            System.out.print(" ___________________________________________________________________________________\n");
            System.out.print("|                                                                                   |\n");
            System.out.print("|1) CreateDir         2) DelDir       3)CreateFile      4) DelFile.|\n");
            System.out.print("|___________________________________________________________________________________|\n");
            option = in.nextInt();
            switch(option){
            case 1:
                System.out.println("\nPlease give the directory name : ");
                dirname = in.nextLine();
                check = fs.createDirectory(new Directory(dirname, new Date(1,1,1)));
                if(check == true){
                    System.out.println("Directory " + dirname + " created successfully.");
                }
                break;
            case 2:
                System.out.println("\nPlease give the directory name : ");
                dirname = in.nextLine();
                check = fs.createDirectory(new Directory(dirname, new Date(1,1,1)));
                if(check == true){
                    System.out.println("Directory " + dirname + " Deleted successfully.");
                }
                break;
            case 3:
                System.out.println("\nPlease give the file name : ");
                dirname = in.nextLine();
                check = fs.createDirectory(new Directory(dirname, new Date(1,1,1)));
                if(check == true){
                    System.out.println("Directory " + dirname + " Deleted successfully.");
                }
                break;
            }
            if(option == -9)
                break;
        }
        FileOutputStream fout = new FileOutputStream("../filesystem.txt");
        ObjectOutputStream out = new ObjectOutputStream(fout);
        out.writeObject(fs);
    }
}
