/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bi.eja.orders.data;

import bi.eja.orders.model.Customer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Singleton;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

@Singleton
@ApplicationScoped
@Named
public class CustomerDAO {

    private final Map<String, Customer> customers = new HashMap<>();

    @PostConstruct
    void init() {
        createCustomer(new Customer("Tom"));
        createCustomer(new Customer("John"));
    }

    public boolean contains(String username) {
        return customers.keySet().contains(username);
    }

    @Lock(LockType.READ)
    public Customer find(String username) {
        return customers.get(username);
    }

    @Lock(LockType.READ)
    public List<Customer> getCustomers() {
        return new ArrayList(customers.values());
    }

    public void createCustomer(Customer cust) {
        customers.put(cust.getUsername(), cust);
    }

    public void delete(String customerUsername) {
        customers.remove(customerUsername);
    }

    @Lock(LockType.READ)
    public boolean exists(String customerUsername) {
        return customers.containsKey(customerUsername);
    }

}
