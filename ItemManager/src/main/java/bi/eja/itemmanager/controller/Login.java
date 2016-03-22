/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bi.eja.itemmanager.controller;

import bi.eja.itemmanager.model.User;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;

@SessionScoped
@SynInterceptorBinding
public class Login implements Serializable {

    @Inject
    transient UsersDAO usersDAO;
    private User logged;

    public void login(String username) {
        logged = usersDAO.byName(username);

    }

    public User getLogged() {
        return logged;
    }

}
