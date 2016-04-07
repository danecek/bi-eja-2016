/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bi.eja.restpersons;

import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Produces(MediaType.APPLICATION_XML)
public class PersonSubresource {
    
    int id;

    public PersonSubresource(int id) {
        this.id = id;
    }
    
    @GET
    public Person get() {
       return PersonsDAO.inst.get(id);
    }
    
}
