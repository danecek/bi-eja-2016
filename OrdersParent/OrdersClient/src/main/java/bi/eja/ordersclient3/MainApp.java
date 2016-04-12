package bi.eja.ordersclient3;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainApp extends Application {

    public static MainApp instance;
    TextField username;

    public MainApp() {
        instance = this;
    }

    @Override
    public void start(Stage stage) {

        username = new TextField();
        Button addOrderBut = new Button("Add Order");
        addOrderBut.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    new AddOrderDialog().execute();
                } catch (OrdersException ex) {
                    alert(ex.getCause().toString());
                }
            }
        });
        Button refereshBut = new Button("Refresh");
        refereshBut.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                refresh();
            }

        });
        HBox buttonPanel = new HBox();
        buttonPanel.getChildren().addAll(addOrderBut, refereshBut);
        Parent root = new VBox(username, op=new OrderPanel(), buttonPanel);
        Scene scene = new Scene(root);

        stage.setTitle("Orders");
        stage.setScene(scene);
        stage.show();

    }
    
    OrderPanel op;

    void alert(String er) {
        new Alert(Alert.AlertType.ERROR, er, ButtonType.OK).show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    private void refresh() {
        try {
            op.myRefresh();
        } catch (OrdersException ex) {
            alert(ex.toString());
        }
    }

    String getUsername() {
        return username.getText();
    }

}
