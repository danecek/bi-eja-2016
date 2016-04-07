/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bi.eja.restpersons;

import java.util.List;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author danecek
 */
public class Proxy {

    public static final Proxy inst = new Proxy();

    private final WebTarget personsResource;

    private Proxy() {
        Client c = ClientBuilder.newClient();
        WebTarget root = c.target(Main.rootUri);
        personsResource = root.path("persons");
    }

    public Person get(int id) {
        WebTarget personResource = personsResource.path(Integer.toString(id));
        return personResource.request(MediaType.APPLICATION_XML).buildGet().invoke(Person.class);
    }

    public List<Person> getAll() {
        return personsResource.request(MediaType.APPLICATION_XML).buildGet().invoke(new GenericType<List<Person>>() {
        });

    }

}
