package com.company;

/**
 * author k2425199
 */

import java.util.ArrayList;
import java.util.List;

public class PizzaBuilder {
    private String crust;
    private String sauce;
    private String cheese;
    private List<String> toppings = new ArrayList<>();
    private int quantity;

    public PizzaBuilder setCrust(String crust) {
        this.crust = crust;
        return this;
    }

    public PizzaBuilder setSauce(String sauce) {
        this.sauce = sauce;
        return this;
    }

    public PizzaBuilder setCheese(String cheese) {
        this.cheese = cheese;
        return this;
    }

    public PizzaBuilder addToppings(List<String> toppings) {
        this.toppings.addAll(toppings);
        return this;
    }

    public PizzaBuilder setQuantity(int quantity) {
        this.quantity = quantity;
        return this;
    }

    public Pizza build() {
        return new Pizza(crust, sauce, cheese, toppings, quantity);
    }
}
