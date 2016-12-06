/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bi.eja.ordersclient3;

import bi.eja.orders.model.Item;
import bi.eja.orders.model.Order;
import java.net.URI;
import java.util.List;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class Proxy {

    private final WebTarget ordersResource;

    public static Proxy instance = new Proxy();
    Client client;

    public Proxy() {
        client = ClientBuilder.newClient();
        ordersResource = client.target("http://localhost:8080/Orders/orders");
        ordersResource.register(new LoggingFilter());
    }

    List<Order> getOrders(String username) throws OrdersException {
        try {
            return ordersResource.queryParam("username", username).
                    request(MediaType.APPLICATION_XML).
                    get(new GenericType<List<Order>>() { });
        } catch (RuntimeException ex) {
            throw new OrdersException(ex);
        }
    }

    public void create(String username, Item item, int quantity) throws OrdersException {
        try {
            Response r = ordersResource.queryParam("username", username).request().put(null);
            URI newOrderUri = r.getLocation();
            Order o = null;// !!!!!! new Order(username, item, quantity);
            client.target(newOrderUri).request(MediaType.APPLICATION_XML).put(Entity.xml(o));
        } catch (RuntimeException ex) {
            throw new OrdersException(ex);
        }
    }

}
