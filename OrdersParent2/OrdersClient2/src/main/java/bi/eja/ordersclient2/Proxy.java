/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bi.eja.ordersclient2;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

/**
 *
 * @author danecek
 */
public class Proxy {

    public static Proxy instance = new Proxy();

    public Proxy() {
        Client c = ClientBuilder.newClient();
        WebTarget ordersResource = c.target("http://localhost/Orders2/orders");
    }

}
