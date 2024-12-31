package com.company;

/**
 * author k2425199
 */

public interface OrderState {
    void next(Order order);
    void prev(Order order);
    String getStatus();
}
