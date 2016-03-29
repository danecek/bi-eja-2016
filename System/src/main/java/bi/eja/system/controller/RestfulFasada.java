/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bi.eja.system.controller;

import bi.eja.system.data.Objednavky;
import bi.eja.system.model.Objednavka;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;


@Stateless
@Path("/system")
public class RestfulFasada extends Fasada {
    
   @Inject
   Objednavky objednavky;
      
   @GET
   List<Objednavka> get() {
     return objednavky.all();
   }

}
