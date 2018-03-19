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
public class Mail {

       
    private String address;
    private List<String> secondary = new ArrayList<>();
    private List<NTFS> MailboxSecurityGroups = new ArrayList<>();
    
    public Mail(String address){
        this.address = address;
    }
    
    public Mail(String address,List<String> secondary)
    {
        this.address = address;
        this.secondary = secondary;
    }
    
    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return the secondary
     */
    public List<String> getSecondary() {
        return secondary;
    }

    /**
     * @param secondary the secondary to set
     */
    public void setSecondary(List<String> secondary) {
        this.secondary = secondary;
    }

    /**
     * @return the MailboxSecurityGroups
     */
    public List<NTFS> getMailboxSecurityGroups() {
        return MailboxSecurityGroups;
    }

    /**
     * @param MailboxSecurityGroups the MailboxSecurityGroups to set
     */
    public void setMailboxSecurityGroups(List<NTFS> MailboxSecurityGroups) {
        this.MailboxSecurityGroups = MailboxSecurityGroups;
    }
    
}
