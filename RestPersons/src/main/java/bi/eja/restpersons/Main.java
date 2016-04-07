/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bi.eja.restpersons;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.cxf.endpoint.Server;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;

/**
 *
 * @author danecek
 */
public class Main {

    public static URI rootUri;

    static {
        try {
            rootUri = new URI("http://localhost:8080/persons");
        } catch (URISyntaxException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String[] args) throws Exception {
        Server server = startServer();

        System.out.println(Proxy.inst.get(1));
        System.out.println(Proxy.inst.getAll());

        server.stop();
        server.destroy();

    }

    private static Server startServer() throws Exception {
        JAXRSServerFactoryBean sf = new JAXRSServerFactoryBean();
        sf.setAddress(rootUri.toString());
        sf.setResourceClasses(PersonsResource.class);
        Server server = sf.create();
        server.start();
        return server;
    }
}
