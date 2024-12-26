package com.company;

public class ExtraToppingsDecorator extends PizzaDecorator {
    public ExtraToppingsDecorator(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String getDetails() {
        return pizza.getDetails() + ", Extra Toppings Added";
    }
}
