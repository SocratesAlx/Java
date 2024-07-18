/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package timologia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author PE3
 */
public class Timologia2 extends javax.swing.JFrame {
    public static String PK;
    private static final String USERNAME = "root";
    private static final String PASSWORD = "1234";
    private static final String CONN_STRING = 
                  "jdbc:mysql://localhost:3306/adventureworks";
    /**
     * Creates new form Timologia2
     */
    public Timologia2() {
        initComponents();
    }
    
    public Timologia2(String PK) {
        initComponents();
        this.PK = PK;
        fillallfields();
        filltable();
    }

    public  void fillallfields()
    {
         Connection conn = null;
        
           try
           {
              conn=DriverManager.getConnection(CONN_STRING,
                      USERNAME,PASSWORD);
              Statement stmt = (Statement) conn.createStatement(); 
              String st = "SELECT ifnull(`salesorderheader`.`SalesOrderID`,0)," +
"    ifnull(`salesorderheader`.`RevisionNumber`,0)," +
"    ifnull(`salesorderheader`.`OrderDate`,0)," +
"    ifnull(`salesorderheader`.`DueDate`,0)," +
"    ifnull(`salesorderheader`.`ShipDate`,0)," +
"    ifnull(`salesorderheader`.`Status`,0)," +
"    ifnull(`salesorderheader`.`OnlineOrderFlag`,0)," +
"    ifnull(`salesorderheader`.`SalesOrderNumber`,0)," +
"    ifnull(`salesorderheader`.`PurchaseOrderNumber`,0)," +
"    ifnull(`salesorderheader`.`AccountNumber`,0)," +
"    ifnull(`salesorderheader`.`CustomerID`,0)," +
"    ifnull(`salesorderheader`.`ContactID`,0)," +
"    ifnull(`salesorderheader`.`SalesPersonID`,0)," +
"    ifnull(`salesorderheader`.`TerritoryID`,0)," +
"    ifnull(`salesorderheader`.`BillToAddressID`,0)," +
"    ifnull(`salesorderheader`.`ShipToAddressID`,0)," +
"    ifnull(`salesorderheader`.`ShipMethodID`,0)," +
"    ifnull(`salesorderheader`.`CreditCardID`,0)," +
"    ifnull(`salesorderheader`.`CreditCardApprovalCode`,0)," +
"    ifnull(`salesorderheader`.`CurrencyRateID`,0)," +
"    ifnull(`salesorderheader`.`SubTotal`,0)," +
"    ifnull(`salesorderheader`.`TaxAmt`,0)," +
"    ifnull(`salesorderheader`.`Freight`,0)," +
"    ifnull(`salesorderheader`.`TotalDue`,0)," +
"    ifnull(`salesorderheader`.`Comment`,0)," +
"    ifnull(`salesorderheader`.`rowguid`,0)," +
"    ifnull(`salesorderheader`.`ModifiedDate`,0) " +
"FROM `adventureworks`.`salesorderheader`  "
                      + "where"
                      + " salesorderid = '"+PK+"'";
              ResultSet rs = stmt.executeQuery(st); 
              while (rs.next())
              {
                String RevisionNumber1 = rs.getObject(1).toString();
                String OrderDate1 = rs.getObject(2).toString();
                String DueDate1 = rs.getObject(3).toString();
                String ShipDate1 = rs.getObject(4).toString();
                String Status1 = rs.getObject(5).toString();
                String OnlineOrderFlag1 = rs.getObject(6).toString();
                String SalesOrderNumber1 = rs.getObject(7).toString();
                String PurchaseOrderNumber1 = rs.getObject(8).toString();
                String AccountNumber1 = rs.getObject(9).toString();
                String CustomerID1 = rs.getObject(10).toString();
                String ContactID1 = rs.getObject(11).toString();
                String SalesPersonID1 = rs.getObject(12).toString();
                String TerritoryID1 = rs.getObject(13).toString();
                String BillToAddressID1 = rs.getObject(14).toString();
                String ShipToAddressID1 = rs.getObject(15).toString();
                String ShipMethodID1 = rs.getObject(16).toString();
                String CreditCardID1 = rs.getObject(17).toString();
                String CreditCardApprovalCode1 = rs.getObject(18).toString();
                String CurrencyRateID1 = rs.getObject(19).toString();
                String SubTotal1 = rs.getObject(20).toString();
                String TaxAmt1 = rs.getObject(21).toString();
                String Freight1 = rs.getObject(22).toString();
                String TotalDue1 = rs.getObject(23).toString();
                String Comment1 = rs.getObject(24).toString();
                String rowguid1 = rs.getObject(25).toString();
                String ModifiedDate1 = rs.getObject(26).toString();
              RevisionNumber.setText(RevisionNumber1);
              OrderDate.setText(OrderDate1);
              DueDate.setText( DueDate1);
              ShipDate.setText( ShipDate1);
              Status.setText( Status1);
              OnlineOrderFlag.setText( OnlineOrderFlag1);
              SalesOrderNumber.setText( SalesOrderNumber1);
              PurchaseOrderNumber.setText( PurchaseOrderNumber1);
              AccountNumber.setText( AccountNumber1);
              CustomerID.setText( CustomerID1);
              ContactID.setText( ContactID1);
              SalesPersonID.setText( SalesPersonID1);
              TerritoryID.setText( TerritoryID1);
              BillToAddressID.setText( BillToAddressID1);
              ShipToAddressID.setText( ShipToAddressID1);
              ShipMethodID.setText( ShipMethodID1);
              CreditCardID.setText( CreditCardID1);
              CreditCardApprovalCode.setText( CreditCardApprovalCode1);
              CurrencyRateID.setText( CurrencyRateID1);
              SubTotal.setText( SubTotal1);
              TaxAmt.setText( TaxAmt1);
              Freight.setText( Freight1);
              TotalDue.setText( TotalDue1);
              Comment.setText( Comment1);
              rowguid.setText( rowguid1);
              ModifiedDate.setText( ModifiedDate1);
    
              }
              
              conn.close();
           }
           catch(SQLException e)
           {
               JOptionPane.showMessageDialog(null,e);
           }
    }
    
    public void filltable()
    {
        DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
              model.setRowCount(0);
         //     model.setColumnCount(11);
             Connection conn1 = null;
           try
           {
              conn1=DriverManager.getConnection(CONN_STRING,
                      USERNAME,PASSWORD);
              
              Statement stmt = (Statement) conn1.createStatement(); 
              String st = "show columns from salesorderdetail;";
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
              
              conn = DriverManager.getConnection(CONN_STRING,USERNAME,PASSWORD);
              Statement stmt = (Statement) conn.createStatement();
              String st = "select * from salesorderdetail where salesorderid = '"+
                      PK+"'";
                 
              
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
                                      rs.getObject(11).toString()
                                      
                                      
                        });
              }
            conn.close();
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
        RevisionNumber = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        OrderDate = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        DueDate = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        ShipDate = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        Status = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        TaxAmt = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        Freight = new javax.swing.JTextField();
        SalesOrderNumber = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        PurchaseOrderNumber = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        SubTotal = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        AccountNumber = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        ModifiedDate = new javax.swing.JTextField();
        OnlineOrderFlag = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        ContactID = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        SalesPersonID = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        TerritoryID = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        BillToAddressID = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        rowguid = new javax.swing.JTextField();
        CustomerID = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        ShipMethodID = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        CreditCardID = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        CreditCardApprovalCode = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        CurrencyRateID = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        Comment = new javax.swing.JTextField();
        ShipToAddressID = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        TotalDue = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("RevisionNumber");

        jLabel2.setText("OrderDate");

        jLabel3.setText("DueDate");

        jLabel4.setText("ShipDate");

        jLabel5.setText("Status");

        jLabel6.setText("jLabel1");

        jTextField6.setText("jTextField1");

        jLabel7.setText("TaxAmt");

        jLabel8.setText("Freight");

        jLabel9.setText("PurchaseOrderNumber");

        jLabel10.setText("AccountNumber");

        jLabel11.setText("CustomerID");

        jLabel12.setText("ModifiedDate");

        jLabel13.setText("OnlineOrderFlag");

        jLabel14.setText("SalesOrderNumber");

        jLabel15.setText("TerritoryID");

        jLabel16.setText("BillToAddressID");

        jLabel17.setText("ShipToAddressID");

        jLabel18.setText("rowguid");

        jLabel19.setText("ContactID");

        jLabel20.setText("SalesPersonID");

        jLabel21.setText("CreditCardApprovalCode");

        jLabel22.setText("CurrencyRateID");

        jLabel23.setText("SubTotal");

        jLabel24.setText("Comment");

        jLabel25.setText("ShipMethodID");

        jLabel26.setText("CreditCardID");

        jLabel27.setText("TotalDue");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel2)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel4)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(6, 6, 6)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(Status, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel5)))))
                                    .addComponent(jLabel1)
                                    .addComponent(RevisionNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(OrderDate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(DueDate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(ShipDate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(SalesOrderNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel14)
                                    .addComponent(PurchaseOrderNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel10)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel11)
                                            .addComponent(AccountNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(6, 6, 6)
                                                .addComponent(CustomerID, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                            .addComponent(OnlineOrderFlag, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(66, 66, 66)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel19)
                            .addComponent(jLabel20)
                            .addComponent(SalesPersonID, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15)
                            .addComponent(TerritoryID, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16)
                            .addComponent(BillToAddressID, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel17))
                            .addComponent(ContactID, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ShipToAddressID, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(45, 45, 45)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel25)
                            .addComponent(jLabel26)
                            .addComponent(CreditCardID, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel21)
                            .addComponent(CreditCardApprovalCode, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel22)
                            .addComponent(CurrencyRateID, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(SubTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel23)
                            .addComponent(ShipMethodID, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(47, 47, 47)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Comment, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel24)
                            .addComponent(rowguid, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel18)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(TaxAmt, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7)
                                    .addComponent(Freight, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(jLabel8))
                                    .addComponent(TotalDue, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel27))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(ModifiedDate, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(88, 88, 88)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabel25)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ShipMethodID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel26)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(CreditCardID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(jLabel21)
                        .addGap(12, 12, 12)
                        .addComponent(CreditCardApprovalCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel22)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CurrencyRateID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel23)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(SubTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabel19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ContactID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel20)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(SalesPersonID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TerritoryID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BillToAddressID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ShipToAddressID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(RevisionNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(OrderDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(DueDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ShipDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Status, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(OnlineOrderFlag, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(SalesOrderNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PurchaseOrderNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(AccountNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CustomerID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(TaxAmt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Freight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel27)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TotalDue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel24)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Comment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel18)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rowguid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(ModifiedDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(141, 141, 141)))))
                .addGap(49, 49, 49)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(122, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(Timologia2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Timologia2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Timologia2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Timologia2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Timologia2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField AccountNumber;
    private javax.swing.JTextField BillToAddressID;
    private javax.swing.JTextField Comment;
    private javax.swing.JTextField ContactID;
    private javax.swing.JTextField CreditCardApprovalCode;
    private javax.swing.JTextField CreditCardID;
    private javax.swing.JTextField CurrencyRateID;
    private javax.swing.JTextField CustomerID;
    private javax.swing.JTextField DueDate;
    private javax.swing.JTextField Freight;
    private javax.swing.JTextField ModifiedDate;
    private javax.swing.JTextField OnlineOrderFlag;
    private javax.swing.JTextField OrderDate;
    private javax.swing.JTextField PurchaseOrderNumber;
    private javax.swing.JTextField RevisionNumber;
    private javax.swing.JTextField SalesOrderNumber;
    private javax.swing.JTextField SalesPersonID;
    private javax.swing.JTextField ShipDate;
    private javax.swing.JTextField ShipMethodID;
    private javax.swing.JTextField ShipToAddressID;
    private javax.swing.JTextField Status;
    private javax.swing.JTextField SubTotal;
    private javax.swing.JTextField TaxAmt;
    private javax.swing.JTextField TerritoryID;
    private javax.swing.JTextField TotalDue;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField rowguid;
    // End of variables declaration//GEN-END:variables
}
