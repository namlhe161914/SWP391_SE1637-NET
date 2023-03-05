/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author msi
 */
public class Item {
    private Products products;
    private int quantity;
    private String price;

    public Item(Products products, int quantity, String price) {
        this.products = products;
        this.quantity = quantity;
        this.price = price;
    }

    public Item() {
    }

    @Override
    public String toString() {
        return "Item{" +
                "products=" + products +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }

    public Products getProducts() {
        return products;
    }

    public void setProducts(Products products) {
        this.products = products;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}