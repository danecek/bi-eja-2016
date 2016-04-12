/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bi.eja.ordersclient3;

import bi.eja.orders.model.Item;
import java.util.Optional;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

/**
 *
 * @author danecek
 */
class AddOrderDialog extends Dialog<ButtonType>{
    
    TextField quantity = new TextField();

    public AddOrderDialog() {
        getDialogPane().getButtonTypes().addAll(ButtonType.CANCEL, ButtonType.OK);
        GridPane gp = new GridPane();
        gp.add(new Label("Quantity"), 0, 0);
        gp.add(quantity, 1, 0);
        getDialogPane().getChildren().addAll(gp);
    }
    
    void execute() throws OrdersException {
        Optional<ButtonType> o = showAndWait();
        if (o.get().getButtonData().isCancelButton()) return;
        Proxy.instance.create(MainApp.instance.getUsername(), Item.A, Integer.parseInt(quantity.getText()));
    }
    
}
