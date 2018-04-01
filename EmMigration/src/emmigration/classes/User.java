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

    
/*
Powershell command:
Get-ADGroupMember 'userspremium' | Get-ADUser -Properties * | select -Property GivenName, Surname, 
    DisplayName, UserPrincipalName, SamAccountName | Export-Csv C:\share\adusers.csv -Delimiter ';' -NoTypeInformation
    
    Later toevoegen: phoneNumber, primarySMTPAddress
*/
    
    private String firstName;
    private String surName;
    private String displayName;
    private String userPrincipalName;
    private String samAccountName;
    private int phoneNumber;
    private String OU = "OU=Users,OU=MyBusiness,OU=Domain Controllers,DC=internal,DC=koenvandewal,DC=nl";
    private List<Mail> mailAddresses = new ArrayList<>();
    private List<NTFS> securityGroups = new ArrayList<>();
    
    public User(String firstName,String surName,String displayName,String userPrincipalName, String samAccountName){
        this.firstName = firstName;
        this.surName = surName;
        this.displayName = displayName;
        this.userPrincipalName = userPrincipalName;
        this.samAccountName = samAccountName;
    }

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the surName
     */
    public String getSurName() {
        return surName;
    }

    /**
     * @param surName the surName to set
     */
    public void setSurName(String surName) {
        this.surName = surName;
    }

    /**
     * @return the displayName
     */
    public String getDisplayName() {
        return displayName;
    }

    /**
     * @param displayName the displayName to set
     */
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    /**
     * @return the userPrincipalName
     */
    public String getUserPrincipalName() {
        return userPrincipalName;
    }

    /**
     * @param userPrincipalName the userPrincipalName to set
     */
    public void setUserPrincipalName(String userPrincipalName) {
        this.userPrincipalName = userPrincipalName;
    }

    /**
     * @return the samAccountName
     */
    public String getSamAccountName() {
        return samAccountName;
    }

    /**
     * @param samAccountName the samAccountName to set
     */
    public void setSamAccountName(String samAccountName) {
        this.samAccountName = samAccountName;
    }

    /**
     * @return the phoneNumber
     */
    public int getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * @param phoneNumber the phoneNumber to set
     */
    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * @return the OU
     */
    public String getOU() {
        return OU;
    }

    /**
     * @param OU the OU to set
     */
    public void setOU(String OU) {
        this.OU = OU;
    }

    /**
     * @return the mailAddresses
     */
    public List<Mail> getMailAddresses() {
        return mailAddresses;
    }

    /**
     * @param mailAddresses the mailAddresses to set
     */
    public void setMailAddresses(List<Mail> mailAddresses) {
        this.mailAddresses = mailAddresses;
    }

    /**
     * @return the securityGroups
     */
    public List<NTFS> getSecurityGroups() {
        return securityGroups;
    }

    /**
     * @param securityGroups the securityGroups to set
     */
    public void setSecurityGroups(List<NTFS> securityGroups) {
        this.securityGroups = securityGroups;
    }
    
    

}
