/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package joptionpaneprogram;

import javax.swing.JOptionPane;

/**
 *
 * @author PE3
 */
public class JOptionPaneProgram {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String s;
        s= JOptionPane.showInputDialog("Give your name");
        int x;
        x=Integer.parseInt(JOptionPane.showInputDialog("Please give your "
                + "age: "));
        
        JOptionPane.showMessageDialog(null, "Your name is "+s
                + " and you need "
                + (65-x) + " years for your pension.");
        
    }
    
}
