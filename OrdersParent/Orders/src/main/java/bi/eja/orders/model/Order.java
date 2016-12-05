package bi.eja.orders.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity(name = "CustOrder")
@Table(name = "ORDER_TAB")
@NamedQueries({
    @NamedQuery(name = "getOrders", query = "SELECT o FROM CustOrder o"),
    @NamedQuery(name = "ordersByCustomer", query = "SELECT o FROM CustOrder o WHERE o.customer.username=?1")
})
public class Order implements Serializable {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
    @ManyToOne
    private Customer customer;
    private int quantity;
    private Item item;

    public Order() {
    }

    public Order(Customer customer, Item polozka, int quantity) {
        this.customer = customer;
        this.item = polozka;
        this.quantity = quantity;
    }


    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @return the item
     */
    public Item getItem() {
        return item;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Order{" + "id=" + id + ", customerUsername=" + getCustomer() + ", item=" + item + '}';
    }

    /**
     * @param item the item to set
     */
    public void setItem(Item item) {
        this.item = item;
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
     * @return the customer
     */
    public Customer getCustomer() {
        return customer;
    }

    /**
     * @param customer the customer to set
     */
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }


}
