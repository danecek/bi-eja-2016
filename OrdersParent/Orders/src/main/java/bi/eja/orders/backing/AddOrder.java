/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bi.eja.orders.backing;

import bi.eja.orders.data.OrderDAO;
import bi.eja.orders.model.Item;
import bi.eja.orders.model.Order;
import java.util.Arrays;
import java.util.List;
import javax.enterprise.inject.Model;
import javax.inject.Inject;

@Model
public class AddOrder {

    @Inject
    OrderDAO orderDAO;

    private String username;
    private int quantity;
    private Item item;

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * @param quantity the quantity to set
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * @return the item
     */
    public Item getItem() {
        return item;
    }

    /**
     * @param item the item to set
     */
    public void setItem(Item item) {
        this.item = item;
    }

    public String add() {
        orderDAO.create(new Order(username, item, quantity));
        return "orders";
    }
    
    public List<Item> getItems() {
        return Arrays.asList(Item.values());
    }

}
