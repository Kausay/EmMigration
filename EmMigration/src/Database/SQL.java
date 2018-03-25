/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import emmigration.classes.User;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Koen
 */
public class SQL {
    
    private static String url = "jdbc:sqlserver://192.168.0.40:1433;databaseName=EmMigration";    
    private static String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";   
    private static String username = "dbuser";   
    private static String password = "Pam2im01";
    private static Connection con;
    private static PreparedStatement prep;
    
    private List<User> users;

    public String getConnection() {
        try {
            Class.forName(driverName);
            try {
                con = DriverManager.getConnection(url, username, password);
            } catch (SQLException ex) {
                // log an exception. fro example:
                System.out.println("Failed to create the database connection."); 
            }
        } catch (ClassNotFoundException ex) {
            // log an exception. for example:
            System.out.println("Driver not found."); 
        }
        String succeeded = "Connected to database";
        return succeeded;
    }
    
    public List<User> getUsers() throws SQLException{
        users = new ArrayList<>();
        prep = con.prepareStatement("SELECT * FROM Em_Users");
        ResultSet result = prep.executeQuery();
        
        while(result.next()){
        String FirstName = result.getString("FirstName");
        String SurName = result.getString("SurName");
        String DisplayName = result.getString("DisplayName");
        String SamAccountName = result.getString("SamAccountName");
        users.add(new User(FirstName, SurName, DisplayName, SamAccountName));
        }
        return users;
    }
}
