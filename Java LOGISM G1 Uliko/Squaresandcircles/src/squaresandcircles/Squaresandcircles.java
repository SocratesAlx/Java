/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package squaresandcircles;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author PE3
 */
public class Squaresandcircles {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         String input = JOptionPane.showInputDialog("Enter 1 for rectangles\nEnter 2 for ovals");
        int choice = Integer.parseInt(input);
        Shapes panel= new Shapes(choice);
        JFrame application = new JFrame();
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        application.add(panel);
        application.setSize(500, 500);
        application.setVisible(true);
        
    }
    
}
