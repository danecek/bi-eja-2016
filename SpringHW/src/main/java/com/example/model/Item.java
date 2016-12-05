/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.model;


public class Item {

    public Item(String name, Integer price) {
        this.name = name;
        this.price = price;
    }

    private String name;
    private Integer price;

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the price
     */
    public Integer getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(Integer price) {
        this.price = price;
    }
}
