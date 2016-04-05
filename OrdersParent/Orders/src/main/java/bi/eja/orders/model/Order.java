package bi.eja.orders.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Order {

    private Integer id;
    private String customerUsername;
    private int quantity;
    private Item item;

    public Order() {
    }

    public Order(String customerUsername, Item polozka, int quantity) {
        this.customerUsername = customerUsername;
        this.item = polozka;
        this.quantity = quantity;
    }

    public Order(Integer id, String customerUsername, Item polozka, int quantity) {
        this(customerUsername, polozka, quantity);
        this.id = id;
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
        return "Order{" + "id=" + id + ", customerUsername=" + getCustomerUsername() + ", item=" + item + '}';
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
     * @return the customerUsername
     */
    public String getCustomerUsername() {
        return customerUsername;
    }

    /**
     * @param customerUsername the customerUsername to set
     */
    public void setCustomerUsername(String customerUsername) {
        this.customerUsername = customerUsername;
    }
}
