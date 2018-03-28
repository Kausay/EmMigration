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
            prep = con.prepareStatement("SELECT sqlUserName, isAdmin FROM Em_sqlUsers WHERE sqlUserName='" + username + "' AND sqlPassword='" + password + "'");
            ResultSet result = prep.executeQuery();
            while (result.next()) {
                if (result.getString("sqlUserName").equals(username)) {
                    return true;
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }

    public List<User> getUsers() throws SQLException {
        users = new ArrayList<>();
        prep = con.prepareStatement("SELECT * FROM Em_Users");
        ResultSet result = prep.executeQuery();

        while (result.next()) {
            String FirstName = result.getString("FirstName");
            String SurName = result.getString("SurName");
            String DisplayName = result.getString("DisplayName");
            String SamAccountName = result.getString("SamAccountName");
            users.add(new User(FirstName, SurName, DisplayName, SamAccountName));
        }
        return users;
    }

    public void firstRun() throws SQLException {
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

            if (SplitMembers.length >= 1) {
                for (String m : SplitMembers) {
                    for (User u : users) {
                        if (m.equals(u.getSamAccountName())) {
                            members.add(u);
                        }
                    }
                }
                group.setUsers(members);
            }
        }

        prep = con.prepareStatement("DELETE FROM Em_NTFS");
        prep.executeUpdate();

        prep = con.prepareStatement("INSERT INTO Em_NTFS VALUES(?,?)");
        for (NTFS g : groups) {
            if (!g.getUsers().isEmpty()) {
                for (User u : g.getUsers()) {
                    prep.setString(1, g.getSecurityGroup());
                    prep.setString(2, u.getSamAccountName());
                    prep.executeUpdate();
                }
            } else {
                prep.setString(1, g.getSecurityGroup());
                prep.setString(2, "null");
                prep.executeUpdate();
            }

        }
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
