package com.company;

public class LoyaltyProgram {
    private int points;

    public void addPoints(int earnedPoints) {
        points += earnedPoints;
        System.out.println("You earned " + earnedPoints + " points! Total points: " + points);
    }

    public double redeemPoints() {
        if (points >= 50) {
            System.out.println("Redeeming 50 points for a $5 discount.");
            points -= 50;
            return 5.0;
        }
        System.out.println("Not enough points to redeem. Total points: " + points);
        return 0.0;
    }

    public int getPoints() {
        return points;
    }
}
