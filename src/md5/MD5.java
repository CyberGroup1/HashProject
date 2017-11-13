/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package md5;

/**
 *
 * @author jedis
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException; 
import java.security.DigestInputStream;



public class MD5 {
    public static byte[] getDigest(InputStream in) throws NoSuchAlgorithmException, IOException {
       //MD5 Code here  
       MessageDigest md = MessageDigest.getInstance("MD5"); 
       DigestInputStream dis = new DigestInputStream (in, md);
       byte[] buffer = new byte[1024];
       int nread = 0; 
       while ((nread = dis.read(buffer)) != -1) {
            md.update(buffer, 0, nread);
        }
       
       return md.digest(); 
       //return md.digest(); 
    }
    
    public static String toHex(InputStream in) throws NoSuchAlgorithmException, IOException {
        byte[] mdBytes = getDigest(in);
        StringBuilder hexString = new StringBuilder(); 
        for (int i = 0; i < mdBytes.length; i++) {
            String hex = Integer.toHexString(0xff & mdBytes[i]); 
            if (hex.length() == i) {
                hexString.append('0'); 
            }
            hexString.append(hex);
        }
        return hexString.toString(); 
    }

    public static void main(String[] args) throws NoSuchAlgorithmException, FileNotFoundException, IOException {
        File f = new File("Readme.txt");
        System.out.println();
        System.out.println("MD5: " + toHex(new FileInputStream(f)));              
    }
}
