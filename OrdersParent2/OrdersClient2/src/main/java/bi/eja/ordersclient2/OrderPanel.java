/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bi.eja.ordersclient2;

import bi.eja.orders2.model.Order;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;

/**
 *
 * @author danecek
 */
public class OrderPanel extends ListView<Order> {
    
    ObservableList<Order> orders =  FXCollections.emptyObservableList();
    
    public OrderPanel() {
        setItems(orders);
    }
    
    public void refresh() {
        orders.clear();
        orders.addAll(Proxy.instance.getOrders());
    }
    
    
}
