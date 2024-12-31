package com.company;

/**
 * author k2425199
 */

public class DigitalWalletPayment implements PaymentStrategy {
    @Override
    public void pay(double amount) {
        System.out.println("Paid Rs" + amount + " using Digital Wallet.");
    }
}
