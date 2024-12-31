package com.company;

/**
 * author k2425199
 */

public abstract class PizzaDecorator extends Pizza {
    protected Pizza pizza;

    public PizzaDecorator(Pizza pizza) {
        super(pizza.getCrust(), pizza.getSauce(), pizza.getCheese(), pizza.getToppings(), pizza.getQuantity());
        this.pizza = pizza;
    }

    @Override
    public abstract String getDetails();
}
