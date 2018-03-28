/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emmigration;

import Database.SQL;
import emmigration.classes.Mail;
import emmigration.classes.NTFS;
import emmigration.classes.User;
import java.io.IOException;
import java.io.OutputStreamWriter;
import static java.lang.System.out;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Koen
 */
public class EmMigration {

    
    
    /**
     * @param args the command line arguments
     */
    
    /*
    public static void main(String[] args) throws IOException, SQLException {
        // TODO code application logic here               
        List<Mail> MailAddresses = new ArrayList<>();
        List<User> users;
        List<NTFS> groups;
        
        SQL sql = new SQL();
        System.out.println(sql.getConnection());
        users = sql.getUsers();
        sql.firstRun();
       // groups = sql.getGroups();
    }
   */
}
