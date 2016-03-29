/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bi.eja.system.controller;

import bi.eja.system.data.Objednavky;
import bi.eja.system.model.Objednavka;
import bi.eja.system.model.Polozka;
import java.util.Collection;
import javax.ejb.Stateful;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;

@Stateful
@SessionScoped
public class PredbezneObjednavky {

    @Inject
    Objednavky objednavky;

    private Long idZakaznik;

    Collection<Polozka> objednanePolozky;

    public void predbezneObjednej(Polozka p) {
        objednanePolozky.add(p);
    }

    public void umistiPredbezneObjednavky() {
        for (Polozka p : objednanePolozky) {
            objednavky.vytorObjednavku(idZakaznik, p);
        }
    }

    public void setIdZakaznik(Long idZakaznik) {
        this.idZakaznik = idZakaznik;
    }

}
