package com.company;

import java.util.ArrayList;
import java.util.List;

public class Order implements OrderStatusObserver {
    private List<Pizza> pizzas = new ArrayList<>();
    private Customer customer;
    private OrderState state;
    private static int orderCounter = 1;
    private int orderId;
    private String feedback;
    private double rating;

    public Order(Customer customer) {
        this.customer = customer;
        this.state = new PlacedState();
        this.orderId = orderCounter++;
    }

    public void addPizza(Pizza pizza) {
        pizzas.add(pizza);
    }

    public List<Pizza> getPizzas() {
        return pizzas;
    }

    public void setPizzas(List<Pizza> pizzas) {
        this.pizzas = pizzas;
    }

    public void provideFeedback(double rating, String feedback) {
        this.rating = rating;
        this.feedback = feedback;
        System.out.println("Thank you for your feedback!");
    }

    public String getOrderDetails() {
        StringBuilder details = new StringBuilder("\nOrder ID: " + orderId + "\n");
        details.append("Customer: ").append(customer.getDetails()).append("\n");
        details.append("Status: ").append(state.getStatus()).append("\n");
        details.append("Pizzas:\n");
        for (Pizza pizza : pizzas) {
            details.append("  - ").append(pizza.getDetails()).append("\n");
        }
        details.append("Status: ").append(state.getStatus()).append("\n");
        if (feedback != null) {
            details.append("Feedback: ").append(feedback).append(", Rating: ").append(rating).append("\n");
        }
        return details.toString();
    }

    public void setState(OrderState state) {
        this.state = state;
    }

    public void nextState() {
        state.next(this);
    }

    public void prevState() {
        state.prev(this);
    }

    public String getStatus() {
        return state.getStatus();
    }

    public String getInvoice() {
        double total = 0.0;
        StringBuilder invoice = new StringBuilder();
        invoice.append("\n======================== INVOICE ========================\n");
        invoice.append("Order ID: ").append(orderId).append("\n");
        invoice.append("Customer: ").append(customer.getDetails()).append("\n");
        invoice.append("---------------------------------------------------------\n");
        for (Pizza pizza : pizzas) {
            invoice.append(pizza.getDetails()).append("\n");
            total += 2500.00 * pizza.getQuantity();
        }
        invoice.append("---------------------------------------------------------\n");
        invoice.append("Total Price: Rs").append(String.format("%.2f", total)).append("\n");
        invoice.append("=========================================================\n");
        return invoice.toString();
    }

    @Override
    public void update(String status) {

    }
}
