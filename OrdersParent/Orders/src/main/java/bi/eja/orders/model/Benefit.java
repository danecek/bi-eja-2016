/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bi.eja.orders.model;

import java.io.Serializable;
import javax.persistence.Embeddable;

@Embeddable
class Benefit implements Serializable {

    public Benefit() {
    }

    public Benefit(String desc) {
        this.desc = desc;
    }
    private String desc;

    @Override
    public String toString() {
        return "Benefit{" + "desc=" + desc + '}';
    }

    /**
     * @return the desc
     */
    public String getDesc() {
        return desc;
    }

    /**
     * @param desc the desc to set
     */
    public void setDesc(String desc) {
        this.desc = desc;
    }
}
