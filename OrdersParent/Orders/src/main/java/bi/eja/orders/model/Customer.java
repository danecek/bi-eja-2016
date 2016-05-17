/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bi.eja.orders.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
@Table(name = "CUST_TABLE")
@NamedQuery(name = "getCustomers", query = "SELECT c FROM Customer c")
public class Customer implements Serializable {

    public Customer() {
    }

    @Id 
    private String username;
    
    Address address;
    
    @OneToMany(mappedBy = "customer")
    private List<Order> orders;

    public Customer(String username, Address address) {
        this.username = username;
        this.address = address;
    }


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
     * @return the orders
     */
    public List<Order> getOrders() {
        return orders;
    }

    /**
     * @param orders the orders to set
     */
    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

}
