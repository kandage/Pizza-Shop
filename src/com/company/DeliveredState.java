package com.company;

public class DeliveredState implements OrderState {
    @Override
    public void next(Order order) {
        System.out.println("The order has already been delivered. No further transitions.");
    }

    @Override
    public void prev(Order order) {
        order.setState(new OutForDeliveryState());
        System.out.println("The order has been reverted to the 'Out for Delivery' state.");
    }

    @Override
    public String getStatus() {
        return "Delivered";
    }
}
