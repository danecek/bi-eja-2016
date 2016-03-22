package bi.eja.itemmanager.model;

import javax.enterprise.inject.Produces;

public class Item {


    @Override
    public String toString() {
        return "Item{" + "id=" + getId() + ", descr=" + getDescr() + '}';
    }

    private Integer id;
    private String descr;

    public Item(Integer id, String descr) {
        this.id = id;
        this.descr = descr;
    }

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @return the descr
     */
    public String getDescr() {
        return descr;
    }

}
