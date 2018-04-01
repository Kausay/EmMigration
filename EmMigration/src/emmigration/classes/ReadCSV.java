/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emmigration.classes;

import Database.SQL;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JFileChooser;

/**
 *
 * @author Koen
 */
public class ReadCSV {

    private SQL sql = new SQL();
    private BufferedReader br;
    private String line;

    public ReadCSV() {

    }

    public void readUsersAndSendToDatabase(File file) throws FileNotFoundException, IOException {

        br = new BufferedReader(new FileReader(file));
        br.readLine();
        while ((line = br.readLine()) != null) {
            String[] userCSV = line.split(";");
            User user = new User(userCSV[0], userCSV[1], userCSV[2], userCSV[3], userCSV[4]);
            sql.AddUser(user);
            System.out.println(userCSV[0] + ", " + userCSV[1] + ", " + userCSV[2] + ", " + userCSV[3] + ", " + userCSV[4]);

        }

    }

    public void readSecurityGroupsAndSendToDatabase(File file) throws FileNotFoundException, IOException {

        br = new BufferedReader(new FileReader(file));
        br.readLine();
        while ((line = br.readLine()) != null) {
            String[] secGroup = line.split(";");
            NTFS securityGroup = new NTFS(secGroup[0]);
            sql.AddGroup(securityGroup);
            String[] members = secGroup[1].split(",");
            for(String member : members)
            {
                sql.AddMembersToGroup(securityGroup, member.replaceAll("\"", ""));
            }
        }
    }

}
