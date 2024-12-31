package com.company;

/**
 * author k2425199
 */

import java.util.ArrayList;
import java.util.List;

public class OrderTrackingSystem {
    private List<OrderStatusObserver> observers = new ArrayList<>();
    private String status;

    public void addObserver(OrderStatusObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(OrderStatusObserver observer) {
        observers.remove(observer);
    }

    public void setStatus(String status) {
        this.status = status;
        notifyObservers();
    }

    private void notifyObservers() {
        for (OrderStatusObserver observer : observers) {
            observer.update(status);
        }
    }
}
