/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package zari;

import javax.swing.JFrame;

/**
 *
 * @author PE3
 */
public class Zari {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        JFrame application = new JFrame();
        Plevres p = new Plevres(4);
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        application.add(p);
        application.setSize(500, 500);
        application.setVisible(true);
    }
    
}
