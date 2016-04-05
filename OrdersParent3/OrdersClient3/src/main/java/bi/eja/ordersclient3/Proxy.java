/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bi.eja.ordersclient3;

import bi.eja.orders.model.Order;
import java.util.List;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

public class Proxy {

    private final WebTarget ordersResource;
    
    static Proxy instance = new Proxy();

    public Proxy() {
        Client client = ClientBuilder.newClient();
        ordersResource = client.target("http://localhost/Orders/orders");
        ordersResource.register(new LoggingFilter());
    }
    
    List<Order> getOrders() {
        return ordersResource.queryParam("username", "Tom").request(MediaType.APPLICATION_XML).get(new GenericType<List<Order>>(){});
    }

         
    
    
}
