/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bi.eja.system.controller;

import bi.eja.system.data.Objednavky;
import bi.eja.system.model.Polozka;
import javax.ejb.Stateless;
import javax.inject.Inject;


@Stateless
public class WebFasada extends Fasada {
    
    @Inject
    PredbezneObjednavky po;
    @Inject
    Objednavky objednavky;
    Long idZakaznik;
    
    public void vytvorPredbeznou(Long idZakaznik, Polozka pol) {
        this.idZakaznik = idZakaznik;
        po.predbezneObjednej(pol);        
    }
    
    public void umisti() {
        po.umistiPredbezneObjednavky();
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
