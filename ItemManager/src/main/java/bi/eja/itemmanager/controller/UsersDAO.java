/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bi.eja.itemmanager.controller;

import bi.eja.itemmanager.model.User;
import java.util.HashMap;
import java.util.Map;
import javax.inject.Singleton;


@Singleton
@SynInterceptorBinding
public class UsersDAO {

    Map<String, User> users = new HashMap<>();

    public User byName(String name) {
        return users.get(name);
    }

    void create(User u) {
        users.put(u.getUsername(), u);

    }

    void delete(User u) {
        users.remove(u.getUsername());
    }

    
}
