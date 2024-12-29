package com.company;

import java.util.HashMap;
import java.util.Map;

public class PromotionManager {
    private Map<String, Double> discounts = new HashMap<>();

    public void addPromotion(String item, double discountPercentage) {
        discounts.put(item, discountPercentage);
    }

    public double getDiscount(String item) {
        return discounts.getOrDefault(item, 0.0);
    }

    public void displayPromotions() {
        System.out.println("\nCurrent Promotions:");
        discounts.forEach((item, discount) -> System.out.println(item + ": " + discount + "% off"));
    }
}
