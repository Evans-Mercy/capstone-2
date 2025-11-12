package com.pluralsight;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Order order = new Order();

        System.out.println("Cherry's Pineapple Pizza House!");
        System.out.println("Welcome to the only Pineapple pizza shop in Texas! Let's get you a pineapple pizza!!");

        boolean running = true;

        while (running) {
            //Home Screen
            System.out.println("\nHome Menu:");
            System.out.println("1) New Order");
            System.out.println("0) Exit");
            System.out.println("Enter choice: ");
            String choice = scanner.nextLine();

            if (choice.equals("1")) {
                boolean ordering = true;

                while (ordering) {
                    //Order menu
                    System.out.println("\nOrder Menu");
                    System.out.println("1) Add Pizza");
                    System.out.println("2) Add Drink");
                    System.out.println("3) Add Garlic Knots");
                    System.out.println("4) Checkout");
                    System.out.println("0) Cancel order");
                    System.out.println("Enter choice: ");
                    String orderChoice = scanner.nextLine();

                    if (orderChoice.equals("1")) {
                        //Pizza size
                        System.out.println("Enter pizza size (8\", 12\", 16\"): ");
                        String size = scanner.nextLine();

                        //Crust type
                        System.out.println("Enter crust type (Thin, Regular, Thick, Cauliflower): ");
                        String crust = scanner.nextLine();

                        //Stuffed
                        System.out.println("Would you like stuffed crust? (yes/no): ");
                        boolean stuffed = scanner.nextLine().equalsIgnoreCase("yes");

                        Pizza pizza = new Pizza(size, crust, stuffed);

                        //ask for toppings
                        System.out.println("Would you like to add toppings? (yes/no): ");
                        String addToppings = scanner.nextLine();

                        if (addToppings.equalsIgnoreCase("yes")){
                            boolean addingToppings = true;

                            System.out.println("\n Toppings Menu:");
                            System.out.println("Meats - Pepperoni, Sausage, Ham, Bacon, Chicken, Meatball");
                            System.out.println("Cheese - Mozzarella, Parmesan, Ricotta, Goat Cheese, Buffalo");

                            while (addingToppings) {
                                System.out.println("Enter topping: ");
                                String topping =
                            }
                        }


                        order.addPizza(pizza);
                        System.out.println("Pizza added successfully!");

                    } else if (orderChoice.equals("2")) {
                        //add a drink
                        System.out.println("Enter drink size (Small, Medium, Large): ");
                        String drinkSize = scanner.nextLine();

                        System.out.println("Enter drink flavor: ");
                        String drinkFlavor = scanner.nextLine();

                        Drink drink = new Drink(drinkSize, drinkFlavor);
                        order.addDrink(drink);
                        System.out.println("Drink added successfully!");

                    } else if (orderChoice.equals("3")) {
                        //add garlic knots
                        System.out.println("Would you like to add Garlic Knots? (Yes/No): ");
                        String addKnots = scanner.nextLine();

                        if (addKnots.equalsIgnoreCase("yes")) {
                            GarlicKnots gk = new GarlicKnots();
                            order.addGarlicKnots(gk);
                            System.out.println("Garlic Knots added successfully!");
                        }
                    } else if (orderChoice.equals("4")){
                        //checkout
                        System.out.println("\n Please confirm your order:");
                        order.displayOrder();
                        ordering = false;

                    } else if (orderChoice.equals("0")) {
                        //cancel order
                        System.out.println("Order cancelled.");
                        ordering = false;

                    } else {
                        System.out.println("Invalid choice, try again.");
                    }

                    }
                } else if (choice.equals("0")) {
                System.out.println("Thank you for visiting Cherry's Pineapple Pizza House. Enjoy and please leave a review:) See you soon!");
                running = false;

            } else {
                System.out.println("Invalid choice, try again.");
            }
        }
    }
}
