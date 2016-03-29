/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bi.eja.system.model;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author danecek
 */

@XmlRootElement
public class Objednavka {

    private Long id;
    private Long zakaznikId;
    private Polozka polozkaId;

    public Objednavka(Long zakaznikId, Polozka polozkaId) {
        this.zakaznikId = zakaznikId;
        this.polozkaId = polozkaId;
    }

    public Objednavka(Long id, Long zakaznikId, Polozka polozka) {
        this.id = id;
        this.zakaznikId = zakaznikId;
        this.polozkaId = polozka;
    }

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @return the zakaznikId
     */
    public Long getZakaznikId() {
        return zakaznikId;
    }

    /**
     * @return the polozkaId
     */
    public Polozka getPolozkaId() {
        return polozkaId;
    }
}
