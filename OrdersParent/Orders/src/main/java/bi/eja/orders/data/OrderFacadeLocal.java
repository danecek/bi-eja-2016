/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bi.eja.orders.data;

import bi.eja.orders.model.Order;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author danecek
 */
@Local
public interface OrderFacadeLocal {

    void create(Order order);

    void edit(Order order);

    void remove(Order order);

    Order find(Object id);

    List<Order> findAll();

    List<Order> findRange(int[] range);

    int count();
    
}
