/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bi.eja.orders.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;


@Embeddable
public class Address implements Serializable {

    public Address() {
    }

    public Address(String town) {
        this.town = town;
    }
    
    @Column(name = "ADDR_TOWN")
    String town;
    
    
}
