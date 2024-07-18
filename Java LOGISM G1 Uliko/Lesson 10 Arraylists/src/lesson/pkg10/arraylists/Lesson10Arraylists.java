/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lesson.pkg10.arraylists;

import java.util.ArrayList;

/**
 *
 * @author vorra
 */
public class Lesson10Arraylists {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<String> items = new ArrayList<String>();
        items.add("red");
        items.add(0, "yellow");
        System.out.print("Εμφανίζουμε την λίστα: ");
        for (int i=0; i<items.size(); i++)
            System.out.printf(" %s ",items.get(i));
        System.out.println("");
        display(items, "Εδώ χρησιμοποιούμε enhanced for ");
        items.add("green");
        items.add("yellow");
        display(items,"Λίστα με δύο έξτρα στοιχεία: ");
        items.remove("yellow");
        display(items,"Διαγράφω το πρώτο yellow ");
        items.remove(1);
        display(items,"Διαγράφω το δεύτερο στοιχείο δηλαδή το green: ");
        System.out.printf("Το \"red\" %sβρίσκεται στην λίστα.", 
                items.contains("red")?"":"not");
        System.out.printf("Το μέγεθος της λίστας είναι: %n",items.size());
    }
    
    public static void display (ArrayList<String> items, String header)
    {
        System.out.printf(header);
        for (String item: items)
            System.out.printf(" %s", item);
        System.out.println("");
    }
    
}
