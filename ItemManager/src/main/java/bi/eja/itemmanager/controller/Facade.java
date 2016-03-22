/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bi.eja.itemmanager.controller;

import bi.eja.itemmanager.model.Item;
import java.util.List;
import javax.enterprise.inject.Model;
import javax.inject.Inject;

@Model
public class Facade {

    @Inject
    UsersDAO usersDAO;

    @Inject
    ItemsDAO itemsDAO;

    public void create(Item i) {
        itemsDAO.create(i);
    }

    public List<Item> allItems() {
        return itemsDAO.all();
    }

}
