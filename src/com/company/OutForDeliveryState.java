package com.company;

public class OutForDeliveryState implements OrderState {
    @Override
    public void next(Order order) {
        System.out.println("Order is already out for delivery.");
    }

    @Override
    public void prev(Order order) {
        order.setState(new PreparingState());
    }

    @Override
    public String getStatus() {
        return "Out for Delivery";
    }
}
