/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ergasiaproodou.finalsalaries;

 
import ergasiaproodou.employees.Employee;
import ergasiaproodou.guis.afmfinder.AfmFinder;
import ergasiaproodou.utils.LoginData;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
 


import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author koute
 */
public class FinalSalaries extends javax.swing.JFrame {

    
    
    ArrayList<Employee> e = new ArrayList();
    /**
     * Creates new form FinalSalaries
     */
    public FinalSalaries() {
            
        initComponents();
        deleteAll();
               jTextField1.setText("1");
        fillFinalSalaryTable();
 
           fillFST();
        
    }
    
     public FinalSalaries(String txt) {
            
        initComponents();
        deleteAll();
               jTextField1.setText(txt);
        fillFinalSalaryTable();
 
           fillFST();
        
    }
  
    
      public void fillFST()
    {
         DefaultTableModel model = (DefaultTableModel)jTable55.getModel();
           for(int x = 0; x<e.size();x++){
             Employee employee = e.get(x);
          model.setValueAt(employee.getAfm(), x, 0);
   model.setValueAt(employee.getFinal_salary(), x, 1);
       model.setValueAt(employee.getAbcenses(), x, 2);     
         model.setValueAt(employee.getAbsences_health(), x, 3);   
           model.setValueAt(employee.getAneu(), x, 4);   
             model.setValueAt(employee.getPayment_date(), x, 5);   
    }}
    
    private   String[] getAllAFM() {
        ArrayList<String> afmList = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(LoginData.CONN_STRING, LoginData.USERNAME, LoginData.PASSWORD)) {
            String query = "SELECT afm FROM employees";
            try (Statement statement = connection.createStatement();
                 ResultSet resultSet = statement.executeQuery(query)) {
                while (resultSet.next()) {
                    String afm = resultSet.getString("afm");
                    afmList.add(afm);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Convert ArrayList to array
        String[] afmArray = new String[afmList.size()];
        afmList.toArray(afmArray);

        return afmArray;
    }
    
    private void fillFinalSalaryTable(){
        for (int x=0 ; x<this.getAllAFM().length; x++){
             Employee emp = new Employee(this.getAllAFM()[x]);
             e.add(emp);
        }
        System.out.println("aaaaaaa" + e.size());
        for(Employee employee: e){
            System.out.println(employee.getAfm());
            addToTable(employee.getAfm(),employee.getPayment_date() , employee.getFinal_salary(),employee.getAbcenses() , employee.getAbsences_health(),employee.getAneu());
        }
        
    }
    
    
    public static void exportToExcel(String[][] data, String[] headers, String filePath) throws IOException {
        try (Workbook workbook = new XSSFWorkbook()) {
            Sheet sheet = workbook.createSheet("Sheet1");

            // Create header row
            Row headerRow = sheet.createRow(0);
            for (int i = 0; i < headers.length; i++) {
                Cell cell = headerRow.createCell(i);
                cell.setCellValue(headers[i]);
            }

            // Insert data rows
            for (int rowNum = 0; rowNum < data.length; rowNum++) {
                Row row = sheet.createRow(rowNum + 1);
                for (int colNum = 0; colNum < data[rowNum].length; colNum++) {
                    Cell cell = row.createCell(colNum);
                    cell.setCellValue(data[rowNum][colNum]);
                }
            }

            // Write the output to a file
            try (FileOutputStream fileOut = new FileOutputStream(filePath)) {
                workbook.write(fileOut);
            }
        }
    }
    
    private void deleteAll()  {
          try (Connection connection = DriverManager.getConnection(LoginData.CONN_STRING, LoginData.USERNAME, LoginData.PASSWORD)) {
             // Prepare the INSERT statement with placeholders for parameters
            String insertQuery = "delete   from final_salary;";
            try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
                
                 int rowsAffected = preparedStatement.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("Data inserted successfully.");
                } else {
                    System.out.println("Failed to delete data.");
                }
            }
          
    }   catch (SQLException ex) {
            Logger.getLogger(FinalSalaries.class.getName()).log(Level.SEVERE, null, ex);
        }}
    
    private void addToTable(String afm , String date , int salary, int ta , int tha , int  taneu)  {
          try (Connection connection = DriverManager.getConnection(LoginData.CONN_STRING, LoginData.USERNAME, LoginData.PASSWORD)) {
           
        
            // Prepare the INSERT statement with placeholders for parameters
            String insertQuery1 = "INSERT INTO final_salary (afm, dateOfPayment, salary, totalAbsences, totalHealthAbsences, totalAneu) VALUES (?, ?, ?, ?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery1)) {
                // Set the values for the placeholders
// Define a date format
        SimpleDateFormat dateFormat = new SimpleDateFormat("yy-mm-dd");
               // Parse the date string to obtain a java.util.Date object
              // Parse the date string to obtain a java.util.Date object
            java.util.Date utilDate = null;
                try {
                    utilDate = dateFormat.parse(date);
                } catch (ParseException ex) {
                    Logger.getLogger(FinalSalaries.class.getName()).log(Level.SEVERE, null, ex);
                }

            // Convert the java.util.Date object to a java.sql.Date object
            Date sqlDate = new Date(utilDate.getTime());
                preparedStatement.setString(1, afm); // AFM
                preparedStatement.setDate(2, sqlDate); // dateOfPayment
                preparedStatement.setInt(3, salary); // salary
                preparedStatement.setInt(4, ta); // totalAbsences
                preparedStatement.setInt(5, tha); // totalHealthAbsences
                preparedStatement.setInt(6, taneu); // totalAneu
                
                 
              // Execute the INSERT statement
                int rowsAffected = preparedStatement.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("Data inserted successfully.");
                } else {
                    System.out.println("Failed to insert data.");
                }}
        } catch (SQLException e) {
            e.printStackTrace();
        }
   
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
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable55 = new javax.swing.JTable();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        Search = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("Final Salaries");

        jTable55.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "AFM", "Final Salary", "Koninikes Adies", "Adies Asthenias", "Adies Aneu Apodoxon", "Date Of Payment"
            }
        ));
        jScrollPane5.setViewportView(jTable55);

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jLabel2.setText("Month");

        Search.setText("Search");
        Search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchActionPerformed(evt);
            }
        });

        jButton1.setText("Export to excel");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(182, 182, 182)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Search, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 612, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(266, 266, 266)
                        .addComponent(jButton1)))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(Search))
                .addGap(38, 38, 38)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addComponent(jButton1)
                .addGap(0, 136, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void SearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchActionPerformed
           FinalSalaries viewGui = new FinalSalaries(jTextField1.getText());
           viewGui.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
           viewGui.setVisible(true);
    }//GEN-LAST:event_SearchActionPerformed

    
    public static String[][] convertJTableToArray(JTable table) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        int rowCount = model.getRowCount();
        int columnCount = model.getColumnCount();
        
        String[][] data = new String[rowCount][columnCount];
        
        for (int row = 0; row < rowCount; row++) {
            for (int column = 0; column < columnCount; column++) {
                // Convert the cell value to a String
                Object cellValue = model.getValueAt(row, column);
                String stringValue = (cellValue == null) ? "" : cellValue.toString();
                data[row][column] = stringValue;
            }
        }
        
        return data;
    }
     
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String[][] data = convertJTableToArray(this.jTable55);
        String[] headers = {"AFM", "Final Salary", "Kanonikes Adies" , "Adies Asteneias"  , "Adies Aneu Apodoxon" , "Date of Payment"};
        String filePath = "output.xlsx";

        try {
            exportToExcel(data, headers, filePath);
            System.out.println("Exported data to " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
 
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(FinalSalaries.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FinalSalaries.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FinalSalaries.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FinalSalaries.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FinalSalaries().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Search;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable jTable55;
    public static javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
public static String getMonth() {
    // Access jTextField1 without using the static keyword
    String month = jTextField1.getText();
    return month;
}
     
}
