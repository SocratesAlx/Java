/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ergasiaproodou.employees;
import ergasiaproodou.finalsalaries.FinalSalaries;
import java.sql.CallableStatement;

import ergasiaproodou.utils.LoginData;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
 
/**
 *
 * @author koute
 */
public class Employee {
    
    
   
    private int month , year;
    private int type;
    private String afm;
    private String payment_date;
    private int final_salary;
    private int absences_health;
    private int abcenses;
    private int aneu;
    
    public Employee(String afm ) {
        
        this.month =  Integer.parseInt(FinalSalaries.getMonth()); 
        System.out.println("Month is : " + month);
        this.year = 2023;
        this.afm = afm;
       
        this.type = this.getType();
        System.out.println(this.type);
        
        this.payment_date = getPaymentDate();
        System.out.println(this.payment_date);
        
        
        this.final_salary = getFinalSalary();
        System.out.println( this.final_salary);
        
        this.absences_health = getHealthAbsences();
        
        System.out.println( this.absences_health);
        this.abcenses = getAbsences();
        
        System.out.println(this.abcenses);
        
        this.aneu = this.getAneu1();
        
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public String getAfm() {
        return afm;
    }

    public String getPayment_date() {
        return payment_date;
    }

    public int getFinal_salary() {
        return final_salary;
    }

    public int getAbsences_health() {
        return absences_health;
    }

    public int getAbcenses() {
        return abcenses;
    }

    public int getAneu() {
        return aneu;
    }
    
    
    
    
    
    private int getAneu1(){
          int aneu = 0;
        if (this.type != 0){
            
            // Default value in case of failure
    try (Connection connection = DriverManager.getConnection(LoginData.CONN_STRING, LoginData.USERNAME, LoginData.PASSWORD)) {
        String healthQuery = "SELECT total FROM aneu_apodoxon WHERE afm = ?";
        try (PreparedStatement healthStatement = connection.prepareStatement(healthQuery)) {
            healthStatement.setString(1, afm);
            try (ResultSet healthResultSet = healthStatement.executeQuery()) {
                if (healthResultSet.next()) {
                    aneu = healthResultSet.getInt("total");
                    System.out.println("Aneu: " + aneu);
                } else {
                    System.out.println("aaaaaaa");
                }
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    
        }
    return aneu;
 
   
        
    }
private int getType(){
    int employeeType = -1; // Default value in case of failure
    try (Connection connection = DriverManager.getConnection(LoginData.CONN_STRING, LoginData.USERNAME, LoginData.PASSWORD)) {
        String healthQuery = "SELECT employee_type FROM employees WHERE afm = ?";
        try (PreparedStatement healthStatement = connection.prepareStatement(healthQuery)) {
            healthStatement.setString(1, afm);
            try (ResultSet healthResultSet = healthStatement.executeQuery()) {
                if (healthResultSet.next()) {
                    employeeType = healthResultSet.getInt("employee_type");
                    System.out.println("Employee type: " + employeeType);
                } else {
                    System.out.println("No employee found with the specified AFM.");
                }
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return employeeType;
}

    
      private int getAbsences(){
        int durationDays = 0;
        try (Connection connection = DriverManager.getConnection(LoginData.CONN_STRING,LoginData.USERNAME,LoginData.PASSWORD)) {
            // Retrieve health history for the employee along with the duration in days
            String healthQuery = "SELECT start_date, end_date, DATEDIFF(end_date, start_date) AS duration_days FROM absence_history WHERE afm = ?";
            try (PreparedStatement healthStatement = connection.prepareStatement(healthQuery)) {
                healthStatement.setString(1, afm);
                try (ResultSet healthResultSet = healthStatement.executeQuery()) {
                    while (healthResultSet.next()) {
                        // Process health history data
                        String startDate = healthResultSet.getString("start_date");
                        String endDate = healthResultSet.getString("end_date");
                        durationDays = healthResultSet.getInt("duration_days");
                     
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
      return durationDays + 1;
      }
    
    
      private int getHealthAbsences(){
        int durationDays = 0;
        try (Connection connection = DriverManager.getConnection(LoginData.CONN_STRING,LoginData.USERNAME,LoginData.PASSWORD)) {
            // Retrieve health history for the employee along with the duration in days
            String healthQuery = "SELECT start_date, end_date, DATEDIFF(end_date, start_date) AS duration_days FROM health_history WHERE afm = ?";
            try (PreparedStatement healthStatement = connection.prepareStatement(healthQuery)) {
                healthStatement.setString(1, afm);
                try (ResultSet healthResultSet = healthStatement.executeQuery()) {
                    while (healthResultSet.next()) {
                        // Process health history data
                        String startDate = healthResultSet.getString("start_date");
                        String endDate = healthResultSet.getString("end_date");
                        durationDays = healthResultSet.getInt("duration_days");
                      
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
      return durationDays + 1;
      }
      
      private int CalculateSalary(int empid){
          int fiinal_salary = 0;
           int salary_month = month;
           try (Connection connection   =DriverManager.getConnection(LoginData.CONN_STRING,LoginData.USERNAME,LoginData.PASSWORD)) {
            // Create a CallableStatement to call the stored procedure
            String command =  "{call CalculateSalary"+ empid+"(?, ?, ?)}";
            
            try ( CallableStatement callableStatement = connection.prepareCall(command)) {
                // Set the input parameters
                callableStatement.setString(1, this.afm);
                callableStatement.setInt(2, salary_month);
                // Register the output parameter
                callableStatement.registerOutParameter(3, java.sql.Types.INTEGER);

                // Execute the stored procedure
                callableStatement.execute();

                // Get the output parameter value
                fiinal_salary = callableStatement.getInt(3);
}
        } catch (SQLException e) {
            e.printStackTrace();
        }
           return fiinal_salary;
      }
 
    
        private int getFinalSalary(){
          
        

        // Final salary variable
        int final_salary = CalculateSalary(this.type);
        
        
 
return final_salary;
    }
 
 
    
 
    
    
    
     private String getPaymentDate(){
            String sqlQuery = "SELECT end_date FROM salary_history WHERE afm = ? AND MONTH(end_date) = ? AND YEAR(end_date) = ?";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

   try (Connection connection =DriverManager.getConnection(LoginData.CONN_STRING,LoginData.USERNAME,LoginData.PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)) {

            preparedStatement.setString(1, afm);
            preparedStatement.setInt(2, month);
            preparedStatement.setInt(3, year);

          
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    java.sql.Date endDate = resultSet.getDate("end_date");
                    return sdf.format(endDate);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null; // Return null if no end date found
    }
}
