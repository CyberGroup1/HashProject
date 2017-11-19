package Directories;

import cyberhash.DigestUtil;
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
                if(!algo.equals("SHA-256"))
                    algo = "MD5";
                
                FileOutput fo = new FileOutput();
                try {
                    //write hashes to file
                    findContents(startingPath, fo, algo);
                    fo.close();
                    //get hash for file that was created
                    File f = new File(fo.getPathname());
                    String dirHash = DigestUtil.getDigestString(f, algo);
                    String emptyMD5 = "d41d8cd98f0b24e980998ecf8427e";
                    String emptySHA = "e3b0c44298fc1c149afbf4c8996fb92427ae41e4649b934ca495991b7852b855";
                    if (dirHash.equals(emptyMD5) || dirHash.equals(emptySHA)){
                        System.out.println("Invalid Directory");
                    }
                    else{
                        System.out.println("The hash for your directory is : " + dirHash);
                    }
                } catch (Throwable ex) {
                    Logger.getLogger(Directories.class.getName()).log(Level.SEVERE, null, ex);
                }
                finally{
                    fo.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(Directories.class.getName()).log(Level.SEVERE, null, ex);
            }
            
    }
    
    
    // Recursive function that processes directories
    private static void findContents(String path, FileOutput fo, String algorithm) throws IOException, Throwable{
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
            fo.writeLine(path.toLowerCase());
            for (int x = 0 ; x < contents.length ; x++){
                file2 = new File(path + "\\" + contents[x]);
                if (file2.isFile()){
                    //DO THINGS WITH THE FILE HERE
                    fo.writeLine(contents[x] + " -- " + DigestUtil.getDigestString(file2, algorithm));
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
    
