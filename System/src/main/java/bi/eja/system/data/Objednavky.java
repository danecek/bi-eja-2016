/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bi.eja.system.data;

import bi.eja.system.model.Objednavka;
import bi.eja.system.model.Polozka;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Singleton;

@Singleton
public class Objednavky {

    private Map<Long, Objednavka> objednavky = new HashMap<>();

    public void vytorObjednavku(Long zakaznikId, Polozka po) {
        Objednavka o = new Objednavka(zakaznikId, po);
        objednavky.put(o.getId(), o);
    }

    @Lock(LockType.READ)
    public List<Objednavka> all() {
        return new ArrayList<Objednavka>(objednavky.values());
    }

}
