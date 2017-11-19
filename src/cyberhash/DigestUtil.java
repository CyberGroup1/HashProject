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

    public static String getDigestString(File file, String algorithm) throws Throwable {
        InputStream in = new FileInputStream(file);
        byte[] digest = getDigest(in, algorithm);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < digest.length; i++) {
            sb.append(String.format("%x", digest[i]));
        }
        return sb.toString();
    }
}
