/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bi.eja.orders.backing;

import bi.eja.orders.data.OrderDAO;
import bi.eja.orders.model.Order;
import java.util.List;
import javax.enterprise.inject.Model;
import javax.inject.Inject;

@Model
public class Orders {

    @Inject
    OrderDAO orderDAO;


    public List<Order> getOrders() {
        return orderDAO.getOrders();
    }

}
