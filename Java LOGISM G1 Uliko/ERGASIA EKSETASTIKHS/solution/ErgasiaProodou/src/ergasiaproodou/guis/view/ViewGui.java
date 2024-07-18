/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ergasiaproodou.guis.view;

import ergasiaproodou.finalsalaries.FinalSalaries;
import ergasiaproodou.guis.afmfinder.AfmFinder;
import ergasiaproodou.guis.view.absence.AddAbsence;
import ergasiaproodou.guis.view.emails.AddEmail;
import ergasiaproodou.guis.view.health.AddHealth;
import ergasiaproodou.guis.view.salaries.AddSalaries;
import ergasiaproodou.guis.view.telephones.TelephonesGui;
import ergasiaproodou.utils.LoginData;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author koute
 */
public class ViewGui extends javax.swing.JFrame {

    private String afm;

    /**
     * Creates new form ViewGui
     */
    public ViewGui() {
        initComponents();
          fillSalaryTable(null);
        fillEmployeeTable(null);
         fillEmailsTable(null);
         fillTelephonesTable(null);
          fillAbsenceTable(null);
          fillHealthTable(null);
        
    }
    
    
    
    
    
    
    public ViewGui(String afm) {
        this.afm = afm;
        initComponents();
          fillSalaryTable(afm);
        fillEmployeeTable(afm);
         fillEmailsTable(afm);
         fillTelephonesTable(afm);
             fillAbsenceTable(afm);
             fillHealthTable(afm);
    }
    
    public String  getAFMSearch(){
        return this.afm;
    }
    
      public void fillHealthTable(String afm)
    {
       DefaultTableModel model = (DefaultTableModel)jTable6.getModel();
       
              model.setRowCount(0);
         //     model.setColumnCount(11);
             Connection conn1 = null;
           try
           {
              conn1 = DriverManager.getConnection(LoginData.CONN_STRING,LoginData.USERNAME,LoginData.PASSWORD);
            
              
              Statement stmt = (Statement) conn1.createStatement(); 
              String st = "show columns from health_history;";
              ResultSet rs = stmt.executeQuery(st); 
              while (rs.next())
              {
                  String col = rs.getObject(1).toString();
                  model.addColumn(col);
                  
                 
              }
                  
           }
           catch(SQLException e)
           {
               JOptionPane.showMessageDialog(null,e);
           } 
              Connection conn = null;
            
            try{
              
              conn  = DriverManager.getConnection(LoginData.CONN_STRING,LoginData.USERNAME,LoginData.PASSWORD);
            
               Statement stmt = (Statement) conn.createStatement();
              String st;
              if (afm == null){
                st = "select * from health_history";
              } else{
                   st = "select * from health_history where AFM like '" + this.getAFMSearch() + "%'";   
              }
                 
              
              ResultSet rs= stmt.executeQuery(st);
              
              while (rs.next())
              { model.insertRow(model.getRowCount(),
                        new Object[] {rs.getObject(1).toString(),
                                      rs.getObject(2).toString(),
									  rs.getObject(3).toString() ,
									   rs.getObject(4).toString() 
							 
                                      
                                    
                         
                        });
              }
            conn.close();
            
             model.addTableModelListener(new TableModelListener() {
        @Override
        public void tableChanged(TableModelEvent e) {
            if (e.getType() == TableModelEvent.UPDATE) {
                int row = e.getFirstRow();
                int column = e.getColumn();

                // Check if a specific cell has been edited (change the condition based on your needs)
             
                    saveEditedCell5(row, column, model);
                }
            }
         
    });
        }catch(SQLException e)
        {System.err.println(e);}
 
            
    }
       
       private void saveEditedCell5(int row, int column, DefaultTableModel model) {
    Connection conn = null;

    try {
        conn = DriverManager.getConnection(LoginData.CONN_STRING, LoginData.USERNAME, LoginData.PASSWORD);
        Statement stmt = (Statement) conn.createStatement();

        String columnName = model.getColumnName(column);
   
        String newValue = model.getValueAt(row, column).toString();
     
        String id = model.getValueAt(row, 0).toString(); // Assuming 'afm' is the primary key
   
        String updateQuery = "UPDATE health_history SET " + columnName + " = '" + newValue + "' WHERE id =  " + id + ";";
        System.out.println(updateQuery);
        stmt.executeUpdate(updateQuery);
        JOptionPane.showMessageDialog(null, "Cell data saved successfully.");
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error while saving cell data: " + e.getMessage());
    } finally {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
      public void fillAbsenceTable(String afm)
    {
       DefaultTableModel model = (DefaultTableModel)jTable5.getModel();
       
              model.setRowCount(0);
         //     model.setColumnCount(11);
             Connection conn1 = null;
           try
           {
              conn1 = DriverManager.getConnection(LoginData.CONN_STRING,LoginData.USERNAME,LoginData.PASSWORD);
                Statement stmt = (Statement) conn1.createStatement(); 
              String st = "show columns from  absence_history;";
              ResultSet rs = stmt.executeQuery(st); 
               while (rs.next())
              {
                  String col = rs.getObject(1).toString();
                  
                  model.addColumn(col);
                  
                  
              }
                  
           }
            
           catch(SQLException e)
           {
               JOptionPane.showMessageDialog(null,e);
           } 
              Connection conn = null;
            
            try{
              
              conn  = DriverManager.getConnection(LoginData.CONN_STRING,LoginData.USERNAME,LoginData.PASSWORD);
            
               Statement stmt = (Statement) conn.createStatement();
              String st;
              if (afm == null){
                st = "select * from absence_history";
              } else{
                   st = "select * from absence_history where AFM like '" + this.getAFMSearch() + "%'";   
              }
                 
              
              ResultSet rs= stmt.executeQuery(st);
              
              while (rs.next())
              { model.insertRow(model.getRowCount(),
                        new Object[] {rs.getObject(1).toString(),
                                      rs.getObject(2).toString(),
									  rs.getObject(3).toString() ,
                                                                           rs.getObject(4).toString() 
							 
                                      
                                    
                         
                        });
              }
            conn.close();
            
             model.addTableModelListener(new TableModelListener() {
        @Override
        public void tableChanged(TableModelEvent e) {
            if (e.getType() == TableModelEvent.UPDATE) {
                int row = e.getFirstRow();
                int column = e.getColumn();

                // Check if a specific cell has been edited (change the condition based on your needs)
             
                    saveEditedCell4(row, column, model);
                }
            }
         
    });
        }catch(SQLException e)
        {System.err.println(e);}
 
            
    }
       
       private void saveEditedCell4(int row, int column, DefaultTableModel model) {
    Connection conn = null;

    try {
        conn = DriverManager.getConnection(LoginData.CONN_STRING, LoginData.USERNAME, LoginData.PASSWORD);
        Statement stmt = (Statement) conn.createStatement();

        String columnName = model.getColumnName(column);
   
        String newValue = model.getValueAt(row, column).toString();
     
        String id = model.getValueAt(row, 0).toString(); // Assuming 'afm' is the primary key
        System.out.println(id);
        String updateQuery = "UPDATE absence_history SET " + columnName + " = '" + newValue + "' WHERE id =  " + id + ";";
        System.out.println(updateQuery);
        stmt.executeUpdate(updateQuery);
        JOptionPane.showMessageDialog(null, "Cell data saved successfully.");
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error while saving cell data: " + e.getMessage());
    } finally {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
    
      public void fillSalaryTable(String afm)
    {
       DefaultTableModel model = (DefaultTableModel)jTable4.getModel();
       
              model.setRowCount(0);
         //     model.setColumnCount(11);
             Connection conn1 = null;
           try
           {
              conn1 = DriverManager.getConnection(LoginData.CONN_STRING,LoginData.USERNAME,LoginData.PASSWORD);
            
              
              Statement stmt = (Statement) conn1.createStatement(); 
              String st = "show columns from salary_history;";
              ResultSet rs = stmt.executeQuery(st); 
               while (rs.next())
              {
                  String col = rs.getObject(1).toString();
                  
                  model.addColumn(col);
                  
                  
              }
                  
           }
           catch(SQLException e)
           {
               JOptionPane.showMessageDialog(null,e);
           } 
              Connection conn = null;
            
            try{
              
              conn  = DriverManager.getConnection(LoginData.CONN_STRING,LoginData.USERNAME,LoginData.PASSWORD);
            
            Statement stmt = (Statement) conn.createStatement();
              String st;
              if (afm == null){
                st = "select * from salary_history";
              } else{
                   st = "select * from salary_history where AFM like '" + this.getAFMSearch() + "%'";   
              }
                 
              
              ResultSet rs= stmt.executeQuery(st);
              
              while (rs.next())
              { model.insertRow(model.getRowCount(),
                        new Object[] {rs.getObject(1).toString(),
                                      rs.getObject(2).toString(),
									  rs.getObject(3).toString(),
									  rs.getObject(4).toString(),
									  rs.getObject(5).toString()
                                      
                                    
                         
                        });
              }
            conn.close();
            
             model.addTableModelListener(new TableModelListener() {
        @Override
        public void tableChanged(TableModelEvent e) {
            if (e.getType() == TableModelEvent.UPDATE) {
                int row = e.getFirstRow();
                int column = e.getColumn();

                // Check if a specific cell has been edited (change the condition based on your needs)
             
                    saveEditedCell3(row, column, model);
                }
            }
         
    });
        }catch(SQLException e)
        {System.err.println(e);}
 
            
    }
       
       private void saveEditedCell3(int row, int column, DefaultTableModel model) {
    Connection conn = null;

    try {
        conn = DriverManager.getConnection(LoginData.CONN_STRING, LoginData.USERNAME, LoginData.PASSWORD);
        Statement stmt = (Statement) conn.createStatement();

        String columnName = model.getColumnName(column);
   
        String newValue = model.getValueAt(row, column).toString();
     
        String afm = model.getValueAt(row, 0).toString(); // Assuming 'afm' is the primary key
   
        String updateQuery = "UPDATE salary_history SET " + columnName + " = '" + newValue + "' WHERE id = '" + afm + "';";
        System.out.println(updateQuery);
        stmt.executeUpdate(updateQuery);
        JOptionPane.showMessageDialog(null, "Cell data saved successfully.");
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error while saving cell data: " + e.getMessage());
    } finally {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
    
     public void fillTelephonesTable(String afm)
    {
       DefaultTableModel model = (DefaultTableModel)jTable3.getModel();
       
              model.setRowCount(0);
         //     model.setColumnCount(11);
             Connection conn1 = null;
           try
           {
              conn1 = DriverManager.getConnection(LoginData.CONN_STRING,LoginData.USERNAME,LoginData.PASSWORD);
            
              
              Statement stmt = (Statement) conn1.createStatement(); 
              String st = "show columns from telephones;";
              ResultSet rs = stmt.executeQuery(st); 
               while (rs.next())
              {
                  String col = rs.getObject(1).toString();
                  
                  model.addColumn(col);
                  
                  
              }
                  
           }
           catch(SQLException e)
           {
               JOptionPane.showMessageDialog(null,e);
           } 
              Connection conn = null;
            
            try{
              
              conn  = DriverManager.getConnection(LoginData.CONN_STRING,LoginData.USERNAME,LoginData.PASSWORD);
            
            Statement stmt = (Statement) conn.createStatement();
              String st;
              if (afm == null){
                st = "select * from telephones";
              } else{
                   st = "select * from telephones where AFM like '" + this.getAFMSearch() + "%'";   
              }
                 
              
              ResultSet rs= stmt.executeQuery(st);
              
              while (rs.next())
              { model.insertRow(model.getRowCount(),
                        new Object[] {rs.getObject(1).toString(),
                                      rs.getObject(2).toString(),
									  rs.getObject(3).toString() 
								 
					 
                                      
                                    
                         
                        });
              }
            conn.close();
            
             model.addTableModelListener(new TableModelListener() {
        @Override
        public void tableChanged(TableModelEvent e) {
            if (e.getType() == TableModelEvent.UPDATE) {
                int row = e.getFirstRow();
                int column = e.getColumn();

                // Check if a specific cell has been edited (change the condition based on your needs)
             
                    saveEditedCell2(row, column, model);
                }
            }
         
    });
        }catch(SQLException e)
        {System.err.println(e);}
 
            
    }
       
       private void saveEditedCell2(int row, int column, DefaultTableModel model) {
    Connection conn = null;

    try {
        conn = DriverManager.getConnection(LoginData.CONN_STRING, LoginData.USERNAME, LoginData.PASSWORD);
        Statement stmt = (Statement) conn.createStatement();

        String columnName = model.getColumnName(column);
   
        String newValue = model.getValueAt(row, column).toString();
        
        String afm = model.getValueAt(row, 0).toString(); // Assuming 'afm' is the primary key
   
       String updateQuery = "UPDATE telephones SET " + columnName + " = '" + newValue + "' WHERE id = '" + afm + "';";
     
        
        
        
        stmt.executeUpdate(updateQuery);
        JOptionPane.showMessageDialog(null, "Cell data saved successfully.");
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error while saving cell data: " + e.getMessage());
    } finally {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
    
    
    
      public void fillEmailsTable(String afm)
    {
       DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
       
              model.setRowCount(0);
         //     model.setColumnCount(11);
             Connection conn1 = null;
           try
           {
              conn1 = DriverManager.getConnection(LoginData.CONN_STRING,LoginData.USERNAME,LoginData.PASSWORD);
            
              
              Statement stmt = (Statement) conn1.createStatement(); 
              String st = "show columns from emails;";
              ResultSet rs = stmt.executeQuery(st); 
              while (rs.next())
              {
                  String col = rs.getObject(1).toString();
                  model.addColumn(col);
                  
                  
              }
                  
           }
           catch(SQLException e)
           {
               JOptionPane.showMessageDialog(null,e);
           } 
              Connection conn = null;
            
            try{
              
              conn  = DriverManager.getConnection(LoginData.CONN_STRING,LoginData.USERNAME,LoginData.PASSWORD);
            
              Statement stmt = (Statement) conn.createStatement();
                String st;
              if (afm == null){
                st = "select * from emails";
              } else{
                   st = "select * from emails where AFM like '" + this.getAFMSearch() + "%'";   
              }
              
              ResultSet rs= stmt.executeQuery(st);
              
              while (rs.next())
              { model.insertRow(model.getRowCount(),
                        new Object[] {rs.getObject(1).toString(),
                                      rs.getObject(2).toString(),
                                      rs.getObject(3) ,
                                      rs.getObject(4) 
                                    
                         
                        });
              }
            conn.close();
            
             model.addTableModelListener(new TableModelListener() {
        @Override
        public void tableChanged(TableModelEvent e) {
            if (e.getType() == TableModelEvent.UPDATE) {
                int row = e.getFirstRow();
                int column = e.getColumn();
                
                    saveEditedCell1(row, column, model);
                }
            }
         
    });
        }catch(SQLException e)
        {System.err.println(e);}
 
            
    }
       
       private void saveEditedCell1(int row, int column, DefaultTableModel model) {
    Connection conn = null;

    try {
        conn = DriverManager.getConnection(LoginData.CONN_STRING, LoginData.USERNAME, LoginData.PASSWORD);
        Statement stmt = (Statement) conn.createStatement();

        String columnName = model.getColumnName(column);
 
        String newValue = model.getValueAt(row, column).toString();
        System.out.println(newValue);
        String afm = model.getValueAt(row, 0).toString(); // Assuming 'afm' is the primary key
        System.out.println(afm);
        String updateQuery = "UPDATE emails SET " + columnName + " = '" + newValue + "' WHERE id = '" + afm + "';";
     
        stmt.executeUpdate(updateQuery);
        JOptionPane.showMessageDialog(null, "Cell data saved successfully.");
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error while saving cell data: " + e.getMessage());
    } finally {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
       
        private void saveEditedCell(int row, int column, DefaultTableModel model) {
    Connection conn = null;

    try {
        conn = DriverManager.getConnection(LoginData.CONN_STRING, LoginData.USERNAME, LoginData.PASSWORD);
        Statement stmt = (Statement) conn.createStatement();

        String columnName = model.getColumnName(column);
         
        String newValue = model.getValueAt(row, column).toString();
        
        String afm = model.getValueAt(row, 0).toString(); // Assuming 'afm' is the primary key
  
        String updateQuery = "UPDATE employees SET " + columnName + " = '" + newValue + "' WHERE id = '" + afm + "';";
        System.out.println(updateQuery);
        stmt.executeUpdate(updateQuery);
        JOptionPane.showMessageDialog(null, "Cell data saved successfully.");
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error while saving cell data: " + e.getMessage());
    } finally {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
    
       public void fillEmployeeTable(String afm)
    {
       DefaultTableModel model = (DefaultTableModel)jTable2.getModel();
       
              model.setRowCount(0);
         //     model.setColumnCount(11);
             Connection conn1 = null;
           try
           {
              conn1 = DriverManager.getConnection(LoginData.CONN_STRING,LoginData.USERNAME,LoginData.PASSWORD);
            
              
              Statement stmt = (Statement) conn1.createStatement(); 
              String st = "show columns from employees;";
              ResultSet rs = stmt.executeQuery(st); 
              while (rs.next())
              {
                  String col = rs.getObject(1).toString();
                  model.addColumn(col);
                  
                  
              }
                  
           }
           catch(SQLException e)
           {
               JOptionPane.showMessageDialog(null,e);
           } 
              Connection conn = null;
            
            try{
              
              conn  = DriverManager.getConnection(LoginData.CONN_STRING,LoginData.USERNAME,LoginData.PASSWORD);
            
              Statement stmt = (Statement) conn.createStatement();
              String st;
              if (afm == null){
                st = "select * from employees";
              } else{
                   st = "select * from employees where AFM like '" + this.getAFMSearch() + "%'";   
              }
              
              ResultSet rs= stmt.executeQuery(st);
              
              while (rs.next())
              { model.insertRow(model.getRowCount(),
                        new Object[] {rs.getObject(1).toString(),
                                      rs.getObject(2).toString(),
                                      rs.getObject(3).toString(),
                                      rs.getObject(4).toString(),
                                      rs.getObject(5).toString(),
                                      rs.getObject(6).toString(),
                                      rs.getObject(7).toString(),
                                      rs.getObject(8).toString(),
                                      rs.getObject(9).toString(),
                                      rs.getObject(10).toString(),
                                      rs.getObject(11).toString(),
                                      rs.getObject(12).toString(),
                                      rs.getObject(13).toString(),
                                      rs.getObject(14).toString(),
                                      rs.getObject(15).toString(),
                                      rs.getObject(16),
                                      rs.getObject(17).toString() ,
                                      rs.getObject(18).toString() 
                         
                        });
              }
            conn.close();
            
             model.addTableModelListener(new TableModelListener() {
        @Override
        public void tableChanged(TableModelEvent e) {
            if (e.getType() == TableModelEvent.UPDATE) {
                int row = e.getFirstRow();
                int column = e.getColumn();

                   saveEditedCell(row, column, model);
                
                }
            }
         
    });
        }catch(SQLException e)
        {System.err.println(e);}
 
            
    }
       
       
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        Emails = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        telephones = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        salary = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        dEmails = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable5 = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        Emails1 = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTable6 = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        Emails2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        afmfinder = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel1.setText("VIEW / EDIT");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(jTable2);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("Emails");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("Employees");

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane3.setViewportView(jTable3);

        Emails.setText("Add Emails");
        Emails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EmailsActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setText("Telephones");

        telephones.setText("Add Telephones");
        telephones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                telephonesActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel6.setText("Salary History");

        salary.setText("Add Salary");
        salary.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salaryActionPerformed(evt);
            }
        });

        jTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane4.setViewportView(jTable4);

        jButton1.setText("REFRESH");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jButton2.setText("Search By AFM");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        dEmails.setText("Delete Selected Row");
        dEmails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dEmailsActionPerformed(evt);
            }
        });

        jButton4.setText("Delete Selected Row");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jTable5.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane5.setViewportView(jTable5);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setText("Absence History");

        Emails1.setText("Add Absence");
        Emails1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Emails1ActionPerformed(evt);
            }
        });

        jTable6.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane6.setViewportView(jTable6);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel7.setText("Health History");

        Emails2.setText("Add Absence");
        Emails2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Emails2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jButton3.setText("Final Salaries");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        afmfinder.setText("AFM Finder");
        afmfinder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                afmfinderActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(70, 70, 70)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(34, 34, 34)
                                .addComponent(jButton2)
                                .addGap(50, 50, 50)
                                .addComponent(afmfinder)
                                .addGap(344, 344, 344)
                                .addComponent(jLabel1))
                            .addComponent(jLabel3))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Emails)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(dEmails))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(26, 26, 26)
                                .addComponent(Emails1))
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(71, 71, 71)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(16, 16, 16)
                                        .addComponent(jLabel7)
                                        .addGap(26, 26, 26)
                                        .addComponent(Emails2))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(100, 100, 100)
                                        .addComponent(jButton3)))
                                .addGap(0, 479, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(telephones)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButton4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)))
                                .addGap(72, 72, 72)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 372, Short.MAX_VALUE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addGap(18, 18, 18)
                                        .addComponent(salary)
                                        .addGap(0, 159, Short.MAX_VALUE)))
                                .addGap(327, 327, 327))))))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(24, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1598, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(20, 20, 20)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(13, 13, 13))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2)
                            .addComponent(afmfinder))
                        .addGap(18, 18, 18)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(salary))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(telephones)
                            .addComponent(jButton4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(98, 98, 98)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(Emails)
                            .addComponent(dEmails))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(Emails1)
                    .addComponent(jLabel7)
                    .addComponent(Emails2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addComponent(jButton3))
                .addContainerGap(72, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(88, 88, 88)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(375, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void EmailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EmailsActionPerformed
        AddEmail  ae = new AddEmail();
        ae.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ae.setVisible(true);
    }//GEN-LAST:event_EmailsActionPerformed

    private void telephonesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_telephonesActionPerformed
          TelephonesGui  tg = new TelephonesGui();
        tg.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        tg.setVisible(true);
    }//GEN-LAST:event_telephonesActionPerformed

    private void salaryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salaryActionPerformed
            AddSalaries  as = new AddSalaries();
        as.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        as.setVisible(true);
                            
    }//GEN-LAST:event_salaryActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
            ViewGui viewGui = new ViewGui();
           viewGui.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
           viewGui.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        String afm =    this.jTextField1.getText();
        System.out.println(afm);
        this.dispose();
            ViewGui viewGui = new ViewGui(afm);
           viewGui.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
           viewGui.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void dEmailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dEmailsActionPerformed
        ArrayList<String> values = new ArrayList() ;
        int row = jTable1.getSelectedRow();
                for (int x =0; x<4;x++){
                    values.add(jTable1.getModel().getValueAt(row, x).toString());
                }
               
                System.out.println(values);
               Connection conn = null;

    try {
        conn = DriverManager.getConnection(LoginData.CONN_STRING, LoginData.USERNAME, LoginData.PASSWORD);
        Statement stmt = (Statement) conn.createStatement();

         
        String afm = String.valueOf(values.get(1));
        System.out.println(afm);
         String e1 = String.valueOf(values.get(2));
          String e2 = String.valueOf(values.get(3));
        String updateQuery = "DELETE FROM emails WHERE afm = '" + afm + "' AND email1 = '" + e1 + "' and email2 = '" + e2 +"';";
        System.out.println(updateQuery);
        stmt.executeUpdate(updateQuery);
        JOptionPane.showMessageDialog(null, "Deleted selected row successfully.");
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error while deleting cell data: " + e.getMessage());
    } finally {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }}
    }//GEN-LAST:event_dEmailsActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
           ArrayList<String> values = new ArrayList() ;
        int row = jTable3.getSelectedRow();
                for (int x =0; x<3;x++){
                    values.add(jTable3.getModel().getValueAt(row, x).toString());
                }
               
                System.out.println(values);
                
                          Connection conn = null;

    try {
        conn = DriverManager.getConnection(LoginData.CONN_STRING, LoginData.USERNAME, LoginData.PASSWORD);
        Statement stmt = (Statement) conn.createStatement();

         
        String id = String.valueOf(values.get(0));
        System.out.println(id);
     
        String updateQuery = "DELETE FROM telephones WHERE id = '" + id + "';";
        System.out.println(updateQuery);
        stmt.executeUpdate(updateQuery);
        JOptionPane.showMessageDialog(null, "Deleted selected row successfully.");
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error while deleting cell data: " + e.getMessage());
    } finally {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }}
    }//GEN-LAST:event_jButton4ActionPerformed

    private void Emails1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Emails1ActionPerformed
              AddAbsence  ae = new AddAbsence();
        ae.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ae.setVisible(true);
    }//GEN-LAST:event_Emails1ActionPerformed

    private void Emails2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Emails2ActionPerformed
            AddHealth  ae = new AddHealth();
        ae.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ae.setVisible(true);
    }//GEN-LAST:event_Emails2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
             FinalSalaries  ae = new FinalSalaries();
        ae.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ae.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void afmfinderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_afmfinderActionPerformed
              AfmFinder  ae = new AfmFinder();
        ae.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ae.setVisible(true);
    }//GEN-LAST:event_afmfinderActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ViewGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewGui().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Emails;
    private javax.swing.JButton Emails1;
    private javax.swing.JButton Emails2;
    private javax.swing.JButton afmfinder;
    private javax.swing.JButton dEmails;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTable4;
    private javax.swing.JTable jTable5;
    private javax.swing.JTable jTable6;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JButton salary;
    private javax.swing.JButton telephones;
    // End of variables declaration//GEN-END:variables
}
