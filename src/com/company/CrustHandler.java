package com.company;

public class CrustHandler extends OrderHandler {
    @Override
    public void handle(Order order) {
        System.out.println("Processing crust selection...");
        if (nextHandler != null) {
            nextHandler.handle(order);
        }
    }
}
