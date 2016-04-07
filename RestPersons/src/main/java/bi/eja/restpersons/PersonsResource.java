/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bi.eja.restpersons;

import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("persons")
@Produces(MediaType.APPLICATION_XML)
public class PersonsResource {

    @GET
    public List<Person> get() {
        return PersonsDAO.inst.getAll();
    }
    
    @Path("{id}")
    public PersonSubresource sub(@PathParam("id") int id) {
        return new PersonSubresource(id);
        
    }

}
