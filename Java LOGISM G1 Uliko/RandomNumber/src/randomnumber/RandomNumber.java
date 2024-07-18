/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package randomnumber;

import java.security.SecureRandom;

/**
 *
 * @author PE3
 */
public class RandomNumber {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SecureRandom r = new SecureRandom();
        System.out.println(r.nextInt(1,7));
    }
    
}
