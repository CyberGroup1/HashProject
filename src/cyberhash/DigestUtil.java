/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cyberhash;

/**
 *
 * @author quyen
 */
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.security.DigestInputStream;
import java.security.MessageDigest;
 
public class DigestUtil {
    public static final int BUFFER_SIZE = 2048;

    public static byte[] getDigest(InputStream in, String algorithm) throws Throwable {
        MessageDigest md = MessageDigest.getInstance(algorithm);
        try {
            DigestInputStream dis = new DigestInputStream(in, md);
            byte[] buffer = new byte[BUFFER_SIZE];
            while (dis.read(buffer) != -1) {
             //
            }
            dis.close();
        } finally {
            in.close();
        }
        return md.digest();
    }

    public static String getDigestString(InputStream in, String algorithm) throws Throwable {
        byte[] digest = getDigest(in, algorithm);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < digest.length; i++) {
            sb.append(String.format("%x", digest[i]));
        }
        return sb.toString();
    }

    public static void main(String[] args) throws Throwable {
        File f = new File("Readme.txt");
        System.out.println();
        System.out.println("SHA-256: " + getDigestString(new FileInputStream(f), "SHA-256"));
        System.out.println("SHA-1: " + getDigestString(new FileInputStream(f), "SHA-1"));
    }
}
