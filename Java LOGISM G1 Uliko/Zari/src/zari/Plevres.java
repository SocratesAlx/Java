/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package zari;

import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author PE3
 */
public class Plevres extends JPanel
{
    
    private int choice;

    public Plevres(int choice) {
        this.choice = choice;
    }
    
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        int w = getWidth();
        int h = getHeight();
        
        switch(choice)
        {
            case 1: g.fillOval(w/2-40,h/2-40,80,80);break;
            case 6: g.fillOval(w/20,h/20,80,80);
                    g.fillOval(w-(w/20)-80,h/20,80,80);
                    g.fillOval(w/20,h-h/20-80,80,80);
                    g.fillOval(w-(w/20)-80,h-h/20-80,80,80);
                    g.fillOval(w/20,h/2-40,80,80);
                    g.fillOval(w-(w/20)-80,h/2-40,80,80);
                    break;
            case 5: g.fillOval(w/2-40,h/2-40,80,80);
                    g.fillOval(w/20,h/20,80,80);
                    g.fillOval(w-(w/20)-80,h/20,80,80);
                    g.fillOval(w/20,h-h/20-80,80,80);
                    g.fillOval(w-(w/20)-80,h-h/20-80,80,80);
                    break;
            case 3: g.fillOval(w/2-40,h/2-40,80,80);
                    g.fillOval(w/20,h/20,80,80);
                    g.fillOval(w-(w/20)-80,h-h/20-80,80,80);
                    break;
            case 2: g.fillOval(w/20,h/20,80,80);
                    g.fillOval(w-(w/20)-80,h-h/20-80,80,80);
                    break;
            case 4: g.fillOval(w/20,h/20,80,80);
                    g.fillOval(w-(w/20)-80,h/20,80,80);
                    g.fillOval(w/20,h-h/20-80,80,80);
                    g.fillOval(w-(w/20)-80,h-h/20-80,80,80);
                    break;
        }
        
    }
    
    
}
