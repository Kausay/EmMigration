/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import emmigration.classes.NTFS;
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

    public boolean Login(String username, String password) {

        try {
            prep = con.prepareStatement("SELECT userName, isAdmin FROM Em_sqlUser WHERE userName='" + username + "' AND password='" + password + "'");
            ResultSet result = prep.executeQuery();
            while (result.next()) {
                if (result.getString("userName").equals(username)) {
                    getUsers();
                    return true;
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }
    
    public void AddUser(User user){
        try{
            prep = con.prepareStatement("INSERT INTO Em_User VALUES(?,?,?,?,?)");
            prep.setString(1, user.getFirstName());
            prep.setString(2, user.getSurName());
            prep.setString(3, user.getDisplayName());
            prep.setString(4, user.getUserPrincipalName());
            prep.setString(5, user.getSamAccountName());
            prep.executeUpdate();
        }
        catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
    }
    
    public void AddGroup(NTFS group){
        
    }
    
    public void AddMembersToGroup(NTFS group, String user){
        
    }

    public List<User> getUsers() throws SQLException {
        users = new ArrayList<>();
        prep = con.prepareStatement("SELECT * FROM Em_User");
        ResultSet result = prep.executeQuery();

        while (result.next()) {
            String FirstName = result.getString("firstName");
            String SurName = result.getString("surName");
            String DisplayName = result.getString("displayName");
            String UserPrincipalName = result.getString("userPrincipalName");
            String SamAccountName = result.getString("samAccountName");
            users.add(new User(FirstName, SurName, DisplayName, UserPrincipalName, SamAccountName));
        }
        return users;
    }    

    public List<NTFS> getGroups() throws SQLException {

        List<NTFS> groups = new ArrayList<>();
        prep = con.prepareStatement("SELECT * FROM Em_NTFS");
        ResultSet result = prep.executeQuery();

        while (result.next()) {
            List<User> members = new ArrayList<>();
            String Group = result.getString("Group");
            String Member = result.getString("Member");
            NTFS group = new NTFS(Group);
            groups.add(group);
            String[] SplitMembers = Member.split(",");

            for (String m : SplitMembers) {
                for (User u : users) {
                    if (m.equals(u.getSamAccountName())) {
                        members.add(u);
                    }
                }
            }
            group.setUsers(members);
        }
        return groups;
    }
}
