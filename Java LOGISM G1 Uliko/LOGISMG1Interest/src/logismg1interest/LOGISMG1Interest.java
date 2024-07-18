/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package logismg1interest;

import java.util.Scanner;

/**
 *
 * @author PE3
 */
public class LOGISMG1Interest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        double poso;
        double epitokio;
        int years;
        double finalamount;
        Scanner in = new Scanner(System.in);
        System.out.print("Give the initial amount: ");
        poso = in.nextDouble();
        System.out.print("Give me the interest rate: ");
        epitokio =in.nextDouble();
        System.out.println("Give me the duration in years: ");
        years = in.nextInt();
        //double tokos = poso*epitokio/100;
        finalamount = poso;
        for (int i=0; i<years ; ++i)
        { 
          finalamount=finalamount+finalamount*epitokio/100; }
        
        System.out.printf("For the initial amount %.2f the interest is %.2f and "
                + "the total amount is %.2f"
                ,poso,finalamount-poso,finalamount);
        
        
    }
    
}
