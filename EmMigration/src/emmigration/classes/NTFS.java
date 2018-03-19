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
public class NTFS {
    
    /*
    Powershell command:
    
    */
    
    private String SecurityGroup;
    private List<User> users = new ArrayList<>();
    
    public NTFS(String SecurityGroup){
        this.SecurityGroup = SecurityGroup;
    }

    /**
     * @return the SecurityGroup
     */
    public String getSecurityGroup() {
        return SecurityGroup;
    }

    /**
     * @param SecurityGroup the SecurityGroup to set
     */
    public void setSecurityGroup(String SecurityGroup) {
        this.SecurityGroup = SecurityGroup;
    }

    /**
     * @return the users
     */
    public List<User> getUsers() {
        return users;
    }

    /**
     * @param users the users to set
     */
    public void setUsers(List<User> users) {
        this.users = users;
    }
    
}
