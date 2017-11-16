package Directories;

import java.io.File;
import java.io.IOException;
import static java.lang.System.exit;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    
    public static void run(String startingPath, String algo){
        try {
            //set algorithm
            if(algo.equals("SHA-256"))
                algo = "SHA-256";
            else
                algo = "MD5";
            
            FileOutput fo = new FileOutput();
            findContents(startingPath, fo, algo);
            System.out.println("\n\nThe path of the file is: " + fo.getPathname());
            fo.close();
        } catch (IOException ex) {
            Logger.getLogger(Directories.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    // Recursive function that processes directories
    private static void findContents(String path, FileOutput fo, String algorithm) throws IOException{
        //create file object for the path passed in
        File file = new File(path);
        //get the contents of the file
        String[] contents = file.list();
        //Create a List to hold the directories;
        ArrayList<String> directories = new ArrayList<String>();

        //if directory has contents process them
        File file2 = null;
        if(contents != null && contents.length > 0){
            //System.out.println(path);
            fo.writeLine(path);
            for (int x = 0 ; x < contents.length ; x++){
                file2 = new File(path + "\\" + contents[x]);
                if (file2.isFile()){
                    //DO THINGS WITH THE FILE HERE
                    //System.out.println(contents[x]);
                    fo.writeLine(contents[x]);
                }
                else if(file2.isDirectory()){
                    //ADD DIRECTORIES TO LIST TO PROCESS RECURSIVELY
                    directories.add(path + "\\" + contents[x]);
                }
            }
            fo.writeLine("");
            //System.out.println("");
            //PROCESS DIRECTORIES RECURSIVELY
            for (int y = 0 ; y < directories.size() ; ++y){
                findContents(directories.get(y), fo, algorithm);
            }
        }
        
    }//end of findContents()
}//end of class
    
