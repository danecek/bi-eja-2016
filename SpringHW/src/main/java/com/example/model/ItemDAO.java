/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author danecek
 */
public class ItemDAO {
    
    private List<Item> items;

    public ItemDAO() {
        items = new ArrayList<>();
        Collections.addAll(items, new Item("TV", 10), new Item("RC", 30));
    }

    /**
     * @return the items
     */
    public List<Item> getItems() {
        return items;
    }
    
    
    
}
