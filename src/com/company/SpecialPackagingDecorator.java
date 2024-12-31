package com.company;

/**
 * author k2425199
 */

public class SpecialPackagingDecorator extends PizzaDecorator {
    public SpecialPackagingDecorator(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String getDetails() {
        return pizza.getDetails() + ", Special Packaging Included";
    }
}
