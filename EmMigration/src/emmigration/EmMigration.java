/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emmigration;

import emmigration.classes.Mail;
import emmigration.classes.NTFS;
import emmigration.classes.User;
import java.io.IOException;
import java.io.OutputStreamWriter;
import static java.lang.System.out;
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
    public static void main(String[] args) throws IOException {
        // TODO code application logic here               
        List<Mail> MailAddresses = new ArrayList<>();
        List<User> users = new ArrayList<>();
        List<NTFS> SecurityGroups = new ArrayList<>();
        
        Mail mail = new Mail("vandewal.koen@gmail.com");
        MailAddresses.add(mail);
        
        User user = new User("Koen", "van de Wal", "Koen van de Wal",MailAddresses);
        System.out.println(user.getMailAddresses().get(0).getAddress());
    }
   
}
