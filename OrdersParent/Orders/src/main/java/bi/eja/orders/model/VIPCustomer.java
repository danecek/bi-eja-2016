/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bi.eja.orders.model;

import java.util.List;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;

@Entity
public class VIPCustomer extends Customer {

    public VIPCustomer(String username, Address address) {
        super(username, address);
    }

    @ElementCollection
    List<Benefit> benefits;

    public VIPCustomer() {
    }

}
