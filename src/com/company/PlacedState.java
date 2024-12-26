package com.company;

public class PlacedState implements OrderState {
    @Override
    public void next(Order order) {
        order.setState(new PreparingState());
    }

    @Override
    public void prev(Order order) {
        System.out.println("Order is already in the Placed state.");
    }

    @Override
    public String getStatus() {
        return "Placed";
    }
}
