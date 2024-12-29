package com.company;

public class ToppingsHandler extends OrderHandler {
    @Override
    public void handle(Order order) {
        System.out.println("Processing toppings selection...");
        if (nextHandler != null) {
            nextHandler.handle(order);
        }
    }
}
