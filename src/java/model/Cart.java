/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author msi
 */
public class Cart {
    private Products product;
    private String price;
    private int quantity;
    private int cateId;

    public Cart(Products product, String price, int quantity, int cateId) {
        this.product = product;
        this.price = price;
        this.quantity = quantity;
        this.cateId = cateId;
    }
    
    

    public Cart(Products product, String price, int quantity) {
        this.product = product;
        this.price = price;
        this.quantity = quantity;
    }

    public Cart(Products product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }
    
    

    public Cart(Products product, String price) {
        this.product = product;
        this.price = price;
    }

    public Cart() {
    }

    public int getCateId() {
        return cateId;
    }

    public void setCateId(int cateId) {
        this.cateId = cateId;
    }
    

    public Products getProduct() {
        return product;
    }

    public void setProduct(Products product) {
        this.product = product;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    

}
