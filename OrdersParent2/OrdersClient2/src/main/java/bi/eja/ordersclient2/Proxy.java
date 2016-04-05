/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bi.eja.ordersclient2;

import bi.eja.orders2.model.Order;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

public class Proxy {

    public static Proxy instance = new Proxy();

    public Proxy() {
        Client c = ClientBuilder.newClient();
        WebTarget ordersResource = c.target("http://localhost/Orders2/orders");
    }

    Order[] getOrders() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
