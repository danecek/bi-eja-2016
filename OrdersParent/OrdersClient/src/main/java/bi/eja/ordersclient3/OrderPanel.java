/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bi.eja.ordersclient3;

import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;
import javafx.scene.layout.StackPane;
import bi.eja.orders.model.*;

/**
 *
 * @author danecek
 */
public final class OrderPanel extends StackPane {

    ObservableList<Order> orders;
    private final ListView<Order> lv;

    public OrderPanel()  {
        lv = new ListView<>(orders = FXCollections.observableArrayList());
        getChildren().add(lv);
        try {
            myRefresh();
        } catch (OrdersException ex) {
            MainApp.instance.alert(ex.toString());
        }
    }

    public void myRefresh() throws OrdersException {
        List<Order> os = Proxy.instance.getOrders(MainApp.instance.getUsername());
        orders.clear();
        orders.addAll(os);
    }


}
