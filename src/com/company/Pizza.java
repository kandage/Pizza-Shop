package com.company;

/**
 * author k2425199
 */

import java.util.List;

public class Pizza {
    private String crust;
    private String sauce;
    private String cheese;
    private List<String> toppings;
    private int quantity;
    private double rating;
    private String name;

    public Pizza(String crust, String sauce, String cheese, List<String> toppings, int quantity) {
        this.crust = crust;
        this.sauce = sauce;
        this.cheese = cheese;
        this.toppings = toppings;
        this.quantity = quantity;
        this.rating = 0.0;
    }

    public String getDetails() {
        return "Crust: " + crust +
                ", Sauce: " + sauce +
                ", Cheese: " + cheese +
                ", Toppings: " + toppings +
                ", Quantity: " + quantity +
                ", Rating: " + (rating > 0 ? rating : "No ratings yet") +
                (name != null ? ", Name: " + name : "");
    }

    public int getQuantity() {
        return quantity;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public double getRating() {
        return rating;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getCrust() {
        return crust;
    }

    public void setCrust(String crust) {
        this.crust = crust;
    }

    public String getSauce() {
        return sauce;
    }

    public void setSauce(String sauce) {
        this.sauce = sauce;
    }

    public String getCheese() {
        return cheese;
    }

    public void setCheese(String cheese) {
        this.cheese = cheese;
    }

    public List<String> getToppings() {
        return toppings;
    }

    public void setToppings(List<String> toppings) {
        this.toppings = toppings;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
