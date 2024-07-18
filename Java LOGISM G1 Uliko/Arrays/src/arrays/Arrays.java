/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package arrays;

import java.util.ArrayList;

/**
 *
 * @author PE3
 */
public class Arrays {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        int[] a = {10,20,30,40,50};
        
        for (int i=0;i<5;++i)
            System.out.print(a[i]+" ");
        System.out.println("");
        
        for (var mitsos: a)
            System.out.print(mitsos+" ");
        //vararg
        System.out.println("");
        ArrayList<String> myalist;
        myalist = new ArrayList<String>();
        
        myalist.add("Chris");
        myalist.add("John");
        myalist.add("Jack");
        myalist.add("Tom");
        
        System.out.println(myalist.contains("Jack"));
        System.out.println(myalist.contains("Peter"));
        
        myalist.remove(3);
        System.out.println(myalist.contains("Tom"));
        for(var ka:myalist)
            System.out.print(ka+" ");
        System.out.println("");
        
        
        
        
      
    }
    
}
