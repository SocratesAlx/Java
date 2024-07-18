/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package logismg1switch;

import java.util.Scanner;

/**
 *
 * @author PE3
 */
public class LOGISMG1Switch {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int month;
        Scanner in = new Scanner(System.in);
        month=in.nextInt();
        switch(month)
        {
            case 12: System.out.println("DEC");
                  //  break;
            case 1: System.out.println("JAN");
                   // break;
            case 2: System.out.println("FEB");
                   // break;        
            case 3: System.out.println("MAR");
                  //  break;
            case 4: System.out.println("APR");
                  //  break;
            case 5: System.out.println("MAY");
                  //  break;
            default: System.out.println("Not an applicable month.");
            case 6: System.out.println("JUN");
                  //  break;
            case 7: System.out.println("JUL");
                  //  break;
            case 8: System.out.println("AUG");
                  //  break;
            case 9: System.out.println("SEP");
                 //   break;
            case 10: System.out.println("OCT");
                  //  break;
            case 11: System.out.println("NOV");
                  //  break;
            
            
        }
        
        
    }
    
}
