package com.pluralsight;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Order order = new Order();
        System.out.println("Welcome to my Pizza shop");

        //add a Pizza
        System.out.println("Enter pizza size (8\", 12\", 16\"): ");
        String size = scanner.nextLine();

        System.out.println("Enter crust type (Thin, Regular, Thick, Cauliflower): ");
        String crust = scanner.nextLine();

        System.out.println("Would you like stuffed crust? (yes/no): ");
        boolean stuffed = scanner.nextLine().equalsIgnoreCase("yes");

        Pizza pizza = new Pizza(size, crust, stuffed);

        //ask for toppings
        System.out.println("Would you like to add toppings? (yes/no): ");
        String addToppings = scanner.nextLine();

        if (addToppings.equalsIgnoreCase("yes")){
            System.out.println("Enter toppings:" );

            String toppingsInput = scanner.nextLine();
            String[] toppings = toppingsInput.split(",");
            for (String topping : toppings) {
                pizza.addTopping(topping);
            }
        }

        order.addPizza(pizza);
        System.out.println("Pizza added successfully!");

        //add a drink
        System.out.println("Enter drink size (Small, Medium, Large): ");
        String drinkSize = scanner.nextLine();

        System.out.println("Enter drink flavor: ");
        String drinkFlavor = scanner.nextLine();

        Drink drink = new Drink(drinkSize, drinkFlavor);
        order.addDrink(drink);
        System.out.println("Drink added successfully!");

        //add garlic knots
        System.out.println("Would you like to add Garlic Knots? (Yes/No): ");
        String addKnots = scanner.nextLine();

        if (addKnots.equalsIgnoreCase("yes")) {
           GarlicKnots gk = new GarlicKnots();
           order.addGarlicKnots(gk);
            System.out.println("Garlic Knots added successfully!");
        }

        order.displayOrder();

    }
}
