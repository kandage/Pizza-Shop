package com.company;

/**
 * author k2425199
 */

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
