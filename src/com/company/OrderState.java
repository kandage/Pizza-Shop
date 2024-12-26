package com.company;

public interface OrderState {
    void next(Order order);
    void prev(Order order);
    String getStatus();
}
