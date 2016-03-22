/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bi.eja.itemmanager.controller;

import bi.eja.itemmanager.model.Item;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Singleton;

@Singleton
@SynInterceptorBinding
public class ItemsDAO {

    Map<Integer, Item> items = new HashMap<>();

    public Item byId(Integer id) {
        return items.get(id);
    }

    void create(Item u) {
        items.put(u.getId(), u);

    }

    void delete(Item u) {
        items.remove(u.getId());
    }

    public List<Item> all() {
        return new ArrayList<>(items.values());
    }

}
