package Directories;

import java.io.File;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author LAPTOP
 */
public class Directories {
    //Main Driver 
    public static void main(String[] args) {
        String path = "C:\\Users\\LAPTOP\\TestDir";
        String path2 = "C:\\Users\\LAPTOP";
        start(path);
    }
    
    // Recursive function that processes directories
    public static void start(String path){
        //create file object for the path passed in
        File file = new File(path);
        //get the contents of the file
        String[] contents = file.list();
        //Create a List to hold the directories;
        ArrayList<String> directories = new ArrayList<String>();
        
        System.out.println("\n" + path);
        //if directory has contents process them
        if(contents != null && contents.length > 0){
            for (int x = 0 ; x < contents.length ; x++){
                File file2 = new File(path + "\\" + contents[x]);
                if (file2.isFile()){
                    System.out.println(contents[x]);
                }
                else if(file2.isDirectory()){
                    directories.add(path + "\\" + contents[x]);
                }
            }
            for (int y = 0 ; y < directories.size() ; ++y){
                start(directories.get(y));
            }
        }
        
    }//end of start()
}//end of class
    
