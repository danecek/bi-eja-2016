/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bi.eja.orders2.controller;

import bi.eja.orders2.data.OrderDAO;
import bi.eja.orders2.model.Order;
import javax.ws.rs.PUT;

public class ItemSubresource {

    private final OrderDAO orderDAO;

    public ItemSubresource(OrderDAO orders) {
        this.orderDAO = orders;
    }

    @PUT
    public void update(Order order) {
        orderDAO.update(order);
    }

}
