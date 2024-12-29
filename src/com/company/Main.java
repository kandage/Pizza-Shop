package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final List<Customer> customers = new ArrayList<>();
    private static final List<Order> orders = new ArrayList<>();
    private static final FavoriteManager favoriteManager = new FavoriteManager();
    private static final OrderTrackingSystem orderTrackingSystem = new OrderTrackingSystem();
    private static final LoyaltyProgram loyaltyProgram = new LoyaltyProgram();
    private static final PromotionManager promotionManager = new PromotionManager();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Customer currentCustomer = null;
        boolean exit = false;

        promotionManager.addPromotion("Olives", 10.0);
        promotionManager.addPromotion("Cheese Burst", 15.0);

        while (!exit) {
            System.out.println("-------------------------------------------------------------------------");
            System.out.println("============================= Pizza Shop =============================");
            System.out.println("-------------------------------------------------------------------------");
            System.out.println("    1. Register");
            System.out.println("    2. Place Order");
            System.out.println("    3. View Order Details");
            System.out.println("    4. View Customer Details");
            System.out.println("    5. View Order Status");
            System.out.println("    6. Provide Feedback");
            System.out.println("    7. Add to Favorites");
            System.out.println("    8. View Favorites");
            System.out.println("    9. Exit");
            System.out.println("-------------------------------------------------------------------------");

            System.out.print("  Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> {
                    System.out.print("  Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("  Enter email: ");
                    String email = scanner.nextLine();
                    System.out.print("  Enter address: ");
                    String address = scanner.nextLine();
                    System.out.print("  Enter Mobile: ");
                    String mobile = scanner.nextLine();
                    currentCustomer = new Customer(name, email, address,mobile);
                    customers.add(currentCustomer);
                    System.out.println("Registration successful!");
                }
                case 2 -> {
                    if (currentCustomer == null) {
                        System.out.println("    Please register first.");
                        break;
                    }

                    OrderHandler crustHandler = new CrustHandler();
                    OrderHandler toppingsHandler = new ToppingsHandler();
                    crustHandler.setNextHandler(toppingsHandler);

                    Order order = new Order(currentCustomer);
                    PizzaBuilder builder = new PizzaBuilder();

                    System.out.println("\nAvailable Promotions:");
                    promotionManager.displayPromotions();

                    System.out.println("\n\tChoose your crust:");
                    System.out.println("\t\t1. Thin\n\t\t2. Thick\n\t\t3. Cheese Burst");
                    int crustChoice = scanner.nextInt();
                    String crust = crustChoice == 1 ? "Thin" : crustChoice == 2 ? "Thick" : "Cheese Burst";
                    builder.setCrust(crust);

                    double crustDiscount = promotionManager.getDiscount(crust);
                    if (crustDiscount > 0) {
                        System.out.println("Promotion applied to crust: " + crustDiscount + "% off");
                    }

                    System.out.println("\n\tChoose your sauce:");
                    System.out.println("\t\t1. Tomato\n\t\t2. BBQ\n\t\t3. White Garlic");
                    int sauceChoice = scanner.nextInt();
                    builder.setSauce(sauceChoice == 1 ? "Tomato" : sauceChoice == 2 ? "BBQ" : "White Garlic");

                    System.out.println("\n\tChoose your cheese:");
                    System.out.println("\t\t1. Mozzarella\n\t\t2. Cheddar\n\t\t3. Parmesan");
                    int cheeseChoice = scanner.nextInt();
                    builder.setCheese(cheeseChoice == 1 ? "Mozzarella" : cheeseChoice == 2 ? "Cheddar" : "Parmesan");

                    System.out.println("\n\tChoose your toppings (Enter numbers separated by spaces):");
                    System.out.println("\t\t1. Olives\n\t\t2. Mushrooms\n\t\t3. Pepperoni\n\t\t4. Jalapenos");
                    scanner.nextLine();
                    String[] toppingChoices = scanner.nextLine().split(" ");
                    List<String> selectedToppings = new ArrayList<>();
                    double toppingsDiscount = 0.0;
                    for (String choiceStr : toppingChoices) {
                        switch (Integer.parseInt(choiceStr)) {
                            case 1 -> selectedToppings.add("Olives");
                            case 2 -> selectedToppings.add("Mushrooms");
                            case 3 -> selectedToppings.add("Pepperoni");
                            case 4 -> selectedToppings.add("Jalapenos");
                            default -> System.out.println("Invalid topping choice: " + choiceStr);
                        }
                    }
                    builder.addToppings(selectedToppings);

                    for (String topping : selectedToppings) {
                        double discount = promotionManager.getDiscount(topping);
                        if (discount > 0) {
                            System.out.println("Promotion applied to topping (" + topping + "): " + discount + "% off");
                            toppingsDiscount += discount;
                        }
                    }

                    double totalDiscount = crustDiscount + toppingsDiscount;
                    System.out.println("\nTotal Discount Applied: " + totalDiscount + "%");

                    System.out.print("\n\tEnter the quantity of this pizza: ");
                    int quantity = scanner.nextInt();
                    builder.setQuantity(quantity);

                    Pizza pizza = builder.build();

                    double discount = 0.0;
                    for (String topping : selectedToppings) {
                        discount += promotionManager.getDiscount(topping);
                    }
                    if (promotionManager.getDiscount(crust) > 0) {
                        System.out.println("Promotion applied to crust: " + promotionManager.getDiscount(crust) + "% off");
                        discount += promotionManager.getDiscount(crust);
                    }
                    System.out.println("Total Discount Applied: " + discount + "%");

                    System.out.println("\n\tWould you like to add optional features?");
                    System.out.println("\t\t1. Extra Toppings\n\t\t2. Special Packaging\n\t\t3. None");
                    int decoratorChoice = scanner.nextInt();
                    if (decoratorChoice == 1) {
                        pizza = new ExtraToppingsDecorator(pizza);
                    } else if (decoratorChoice == 2) {
                        pizza = new SpecialPackagingDecorator(pizza);
                    }

                    order.addPizza(pizza);

                    orders.add(order);
                    orderTrackingSystem.addObserver(order);

                    System.out.println(order.getInvoice(toppingsDiscount,quantity));

                    int pointsEarned = (int) (2500 * quantity / 10);
                    loyaltyProgram.addPoints(pointsEarned);

                    double loyaltyDiscount = loyaltyProgram.redeemPoints();

                    double baseTotal =  (2500 * quantity) * ((100 - discount) / 100.0) - loyaltyDiscount;
                    double discountAmount = baseTotal * (totalDiscount / 100.0);
                    double finalTotal = baseTotal - discountAmount;

                    System.out.println("\n\tChoose payment method:");
                    System.out.println("\t\t1. Credit Card\n\t\t2. Digital Wallet");
                    int paymentChoice = scanner.nextInt();
                    PaymentStrategy paymentStrategy = paymentChoice == 1 ? new CreditCardPayment() : new DigitalWalletPayment();
                    paymentStrategy.pay(finalTotal);
                }

                case 3 -> orders.forEach(order -> System.out.println(order.getOrderDetails()));
                case 4 -> customers.forEach(customer -> System.out.println(customer.getDetails()));
                case 5 -> {
                    if (orders.isEmpty()) {
                        System.out.println("No orders found!");
                        break;
                    }
                    orders.forEach(order -> System.out.println(order.getStatus()));
                }
                case 6 -> {
                    System.out.print("Enter Order ID: ");
                    int orderId = scanner.nextInt();
                    Order order = orders.get(orderId - 1);
                    System.out.print("Rate this order (0-5): ");
                    double rating = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.print("Provide feedback: ");
                    String feedback = scanner.nextLine();
                    order.provideFeedback(rating, feedback);
                }
                case 7 -> {
                    System.out.print("Enter Order ID to add as favorite: ");
                    int orderId = scanner.nextInt();
                    Order order = orders.get(orderId - 1);
                    assert currentCustomer != null;
                    favoriteManager.addFavorite(order.getPizzas().get(0));
                }
                case 8 -> {
                    List<Pizza> favorites = favoriteManager.getFavorites();
                    if (favorites.isEmpty()) System.out.println("No favorites found.");
                    else favorites.forEach(pizza -> System.out.println(pizza.getDetails()));
                }
                case 9 -> exit = true;
                default -> System.out.println("Invalid choice.");
            }
        }
        scanner.close();
    }
}
