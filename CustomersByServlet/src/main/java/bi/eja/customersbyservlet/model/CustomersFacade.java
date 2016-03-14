/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bi.eja.customersbyservlet.model;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public final class CustomersFacade {

    public static CustomersFacade INST = new CustomersFacade();
    private long counter;
    private Map<Long, Customer> customers = new HashMap<>();

    public void add(Customer c) {
        c.setId(counter++);
        customers.put(c.getId(), c);
    }

    public Collection<Customer> getAll() {
        return customers.values();
    }

    private CustomersFacade() {
        add(new Customer("Tom"));
    }

}
