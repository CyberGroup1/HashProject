/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Directories;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author LAPTOP
 */
public class FileOutput {
    File file = null;
    private FileWriter fw = null;
    private BufferedWriter bw = null;
    
    //Constructor for FileOutput
    public FileOutput() throws IOException {
        this.file = new File("hashFile.txt");
        this.fw = new FileWriter(this.file);
        this.bw = new BufferedWriter(fw);
    }
    public void writeLine(String str1) throws IOException{
        bw.write(str1);
        bw.newLine();
    }
    public String getPathname(){
        return this.file.getAbsolutePath();
    }
    public File getFile(){
        return this.file;
    }
    public void close() throws IOException{
        if(bw != null)
            bw.close();
        if(fw != null)
            fw.close();
    }
    
}
