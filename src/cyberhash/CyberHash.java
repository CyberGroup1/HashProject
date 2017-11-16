/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cyberhash;

import Directories.Directories;
import java.util.Scanner;

/**
 *
 * @author LAPTOP
 */
public class CyberHash {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);        
       System.out.println("Please enter a directory to hash.");
       String path = scanner.nextLine();
       System.out.println("Type SHA-256 to use a more secure hash");
       String algo = scanner.nextLine();
       System.out.println("\n");
       Directories.run(path, algo);
    }
    
}
