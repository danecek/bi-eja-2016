/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bi.eja.ordersclient2;

import bi.eja.orders2.model.Item;
import bi.eja.orders2.model.Order;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;
import javafx.scene.layout.StackPane;

/**
 *
 * @author danecek
 */
public class OrderPanel extends StackPane {

    ObservableList<Order> orders = FXCollections.observableArrayList();

    public OrderPanel() {
        orders.add(new Order("sssss", Item.A, 0));
        ListView<Order> lv = new ListView<Order>(orders);
        getChildren().add(lv);
    }

    public void refresh() {
        orders.clear();
        orders.addAll(Proxy.instance.getOrders());
    }

}
