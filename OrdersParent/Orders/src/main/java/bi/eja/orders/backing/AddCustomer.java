/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bi.eja.orders.backing;

import bi.eja.orders.data.CustomerDAO;
import bi.eja.orders.model.Address;
import bi.eja.orders.model.Customer;
import bi.eja.orders.model.VIPCustomer;
import javax.enterprise.inject.Model;
import javax.inject.Inject;

@Model
public class AddCustomer {

    public AddCustomer() {
    }

    private String username;
    private String town;
    private boolean vip;
    @Inject
    CustomerDAO customerDAO;

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
     * @return the address
     */
    public String getTown() {
        return town;
    }

    /**
     * @param town the address to set
     */
    public void setTown(String town) {
        this.town = town;
    }

    public String add() {
        if (vip) {
            customerDAO.create(new VIPCustomer(username, new Address(town)));
        } else {
            customerDAO.create(new Customer(username, new Address(town)));
        }
        return "customers";

    }

    public boolean getVip() {
        return vip;
    }

    /**
     * @param vip the vip to set
     */
    public void setVip(boolean vip) {
        this.vip = vip;
    }
}
