/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bi.eja.orders.backing;

import bi.eja.orders.data.OrderDAO;
import bi.eja.orders.model.Order;
import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

@Model
public class DeleteOrder {

    @Inject
    OrderDAO orderDAO;

    private Order order;

    @PostConstruct
    void init() {
        HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        Integer id = Integer.parseInt(req.getParameter("orderId"));
        order = orderDAO.find(id);
    }

    public Order getOrder() {
        return order;
    }

    /**
     * @param order the order to set
     */
    public void setOrder(Order order) {
        this.order = order;
    }

    public String delete() {
        orderDAO.remove(order);
        return "orders";
    }

}
