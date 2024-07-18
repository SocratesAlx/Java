/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication9;

import java.sql.*;
import java.util.ArrayList;


/**
 *
 * @author PST2
 */
public class JavaApplication9 {

    private static String USERNAME = "root";
    private static String PASSWORD = "pst2";
    private static String CONN_STRING = "jdbc:mysql://localhost:3307/adventureworks";
    public static void main(String[] args) {
        int count=1;
        ArrayList<Employee> em = new ArrayList<Employee>();
       while (count<countemp())
{
        Connection conn = null;
        try{
              
              conn = DriverManager.getConnection(CONN_STRING,USERNAME,PASSWORD);
              Statement stmt = (Statement) conn.createStatement();
              String st = "select firstname,lastname from contactmr"
               + " where row_num = '"+count+"'";
                   
              ResultSet rs= stmt.executeQuery(st);
              
              while (rs.next())
              { 
                   em.add(new Employee(rs.getObject(1).toString(),
                                   rs.getObject(2).toString()));
               count++;
                    
              }

        }catch(SQLException e)
        {System.err.println(e);} 
}
        for(Employee e: em)
           System.out.println(e.toString());
           

   }  

private static int countemp()
{
Connection conn = null;
int size=0;
        try{
              
              conn = DriverManager.getConnection(CONN_STRING,USERNAME,PASSWORD);
              Statement stmt = (Statement) conn.createStatement();
              String st = "select count(*) from contactmr";
              
                   
              ResultSet rs= stmt.executeQuery(st);
              
              while (rs.next())
              { 
                   
                  size = rs.getInt(1);
              }

        }catch(SQLException e)
        {System.err.println(e);} 
   return size;
} 
}
