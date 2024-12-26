package com.company;

public class PreparingState implements OrderState {
    @Override
    public void next(Order order) {
        order.setState(new OutForDeliveryState());
    }

    @Override
    public void prev(Order order) {
        order.setState(new PlacedState());
    }

    @Override
    public String getStatus() {
        return "Preparing";
    }
}
