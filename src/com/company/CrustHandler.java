package com.company;

/**
 * author k2425199
 */

public class CrustHandler extends OrderHandler {
    @Override
    public void handle(Order order) {
        System.out.println("Processing crust selection...");
        if (nextHandler != null) {
            nextHandler.handle(order);
        }
    }
}
