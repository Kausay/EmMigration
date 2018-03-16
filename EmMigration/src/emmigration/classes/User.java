/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emmigration.classes;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Koen
 */
public class User {

      
    private String FirstName;
    private String SurName;
    private String DisplayName;
    private int PhoneNumber;
    private List<Mail> MailAddresses = new ArrayList<>();
    private List<NTFS> SecurityGroups = new ArrayList<>();
    
    public User(String FirstName,String SurName,String DisplayName,int PhoneNumber, List<Mail> MailAddresses){
        this.FirstName = FirstName;
        this.SurName = SurName;
        this.DisplayName = DisplayName;
        this.PhoneNumber = PhoneNumber;
        this.MailAddresses = MailAddresses;
    }
    
    /**
     * @return the FirstName
     */
    public String getFirstName() {
        return FirstName;
    }

    /**
     * @param FirstName the FirstName to set
     */
    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    /**
     * @return the SurName
     */
    public String getSurName() {
        return SurName;
    }

    /**
     * @param SurName the SurName to set
     */
    public void setSurName(String SurName) {
        this.SurName = SurName;
    }

    /**
     * @return the DisplayName
     */
    public String getDisplayName() {
        return DisplayName;
    }

    /**
     * @param DisplayName the DisplayName to set
     */
    public void setDisplayName(String DisplayName) {
        this.DisplayName = DisplayName;
    }

    /**
     * @return the PhoneNumber
     */
    public int getPhoneNumber() {
        return PhoneNumber;
    }

    /**
     * @param PhoneNumber the PhoneNumber to set
     */
    public void setPhoneNumber(int PhoneNumber) {
        this.PhoneNumber = PhoneNumber;
    }
    
    public String GetUser(User user){
        return user.getDisplayName();
    }
}
