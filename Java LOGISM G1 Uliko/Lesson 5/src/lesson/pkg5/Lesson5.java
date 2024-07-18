/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lesson.pkg5;

import javax.swing.JFrame;

/**
 *
 * @author vorra
 */


public class Lesson5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        DrawPanel panel = new DrawPanel();
        JFrame application = new JFrame();
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        application.add(panel);
        application.setSize(250, 250);
        application.setVisible(true);
        
        
        
    }
    
}
