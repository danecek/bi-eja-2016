/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bi.eja.itemmanager.model;

import java.io.Serializable;

/**
 *
 * @author danecek
 */
public class User implements Serializable {

    private String username;
    private Role role;

    public User(String username, Role role) {
        this.username = username;
        this.role = role;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @return the role
     */
    public Role getRole() {
        return role;
    }

}
