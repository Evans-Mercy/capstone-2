package com.pluralsight;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Cherry's Pineapple Pizza House!");
        System.out.println("Every pizza comes with pineapple. No exceptions!!");

        boolean running = true;

        while (running) {
            //Home Screen
            System.out.println("\nHome Menu:");
            System.out.println("1) New Order");
            System.out.println("0) Exit");
            System.out.println("Enter choice: ");
            String choice = scanner.nextLine();

            if (choice.equals("1")) {
                Order order = new Order();
                boolean ordering = true;

                while (ordering) {
                    //Order menu
                    System.out.println("\nOrder Menu");
                    System.out.println("1) Add Pizza");
                    System.out.println("2) Add Drink");
                    System.out.println("3) Add Garlic Knots");
                    System.out.println("4) Remove an Item");
                    System.out.println("5) Checkout");
                    System.out.println("0) Cancel order");
                    System.out.println("Enter choice: ");
                    String orderChoice = scanner.nextLine();

                    switch (orderChoice) {
                        case "1" -> {
                            //Pizza size
                            System.out.println("Enter pizza size (8, 12, 16): ");
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

                            if (scanner.nextLine().equalsIgnoreCase("yes")) {
                                boolean customizing = true;
                                while (customizing) {
                                    System.out.println("\nToppings Menu:");
                                    System.out.println("1) Add meat");
                                    System.out.println("2) Add cheese");
                                    System.out.println("3) Add veggie");
                                    System.out.println("4) Add sauce");
                                    System.out.println("5) Add sides");
                                    System.out.println("6) Remove a topping");
                                    System.out.println("7) View Pizza");
                                    System.out.println("8) Done with toppings");
                                    System.out.println("Enter choice: ");
                                    String toppingChoice = scanner.nextLine();


                                    switch (toppingChoice) {
                                        case "1":
                                            addMeatToppings(scanner, pizza);
                                            break;
                                        case "2":
                                            addCheeseToppings(scanner, pizza);
                                            break;
                                        case "3":
                                            addVeggieToppings(scanner, pizza);
                                            break;
                                        case "4":
                                            addSauces(scanner, pizza);
                                            break;
                                        case "5":
                                            addSides(scanner, pizza);
                                            break;
                                        case "6":
                                            pizza.displayPizza();
                                            System.out.println("Enter the exact topping to name to remove:");
                                            pizza.removeTopping(scanner.nextLine().trim());
                                            break;
                                        case "7":
                                            pizza.displayPizza();
                                            break;
                                        case "8":
                                            customizing = false;
                                            break;
                                        default:
                                            System.out.println("Invalid choice, try again.");
                                    }
                                }
                            }

                            order.addItem(pizza);
                            System.out.println("Pizza added successfully!");
                        }
                        case "2" -> {
                            //add a drink
                            System.out.println("Enter drink size (Small, Medium, Large): ");
                            String drinkSize = scanner.nextLine();

                            System.out.println("Enter drink flavor: ");
                            String drinkFlavor = scanner.nextLine();

                            Drink drink = new Drink(drinkSize, drinkFlavor);
                            order.addItem(drink);
                            System.out.println("Drink added successfully!");
                        }
                        case "3" -> {
                            //add garlic knots
                            System.out.println("Would you like to add Garlic Knots? (Yes/No): ");

                            if (scanner.nextLine().equalsIgnoreCase("yes")) {
                                GarlicKnots gk = new GarlicKnots();
                                order.addItem(gk);
                                System.out.println("Garlic Knots added successfully!");

                            }
                        }
                        case "4" -> order.removeItem();
                        case "5" -> {
                            //checkout
                            System.out.println("\n Please confirm your order:");
                            System.out.println(order.generateReceipt());
                            order.saveReceipt();
                            order.saveOrderToCSV("src/main/resources/order.csv");
                            ordering = false;
                        }
                        case "0" -> {
                            //cancel order
                            System.out.println("Order cancelled.");
                            ordering = false;
                        }
                        default -> System.out.println("Invalid choice, try again.");
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

    //add meat toppings
    private static void addMeatToppings(Scanner scanner, Pizza pizza) {
        boolean addingMeats = true;
        while (addingMeats) {
            System.out.println("\nMeat toppings:");
            System.out.println("1) Pepperoni");
            System.out.println("2) Sausage");
            System.out.println("3) Ham");
            System.out.println("4) Bacon");
            System.out.println("5) Chicken");
            System.out.println("6) Meatball");
            System.out.println("0) Done");

            System.out.println("Choose a meat: ");
            String meatChoice = scanner.nextLine();

            if (meatChoice.equals("0")) {
                addingMeats = false;
            } else {
                String meat;
                switch (meatChoice) {
                    case "1" -> meat = "Pepperoni";
                    case "2" -> meat = "Sausage";
                    case "3" -> meat = "Ham";
                    case "4" -> meat = "Bacon";
                    case "5" -> meat = "Chicken";
                    case "6" -> meat = "Meatball";
                    default -> {
                        System.out.println("Invalid choice, try again.");
                        continue;
                    }
                }

                System.out.println("Extra " + meat + "? (yes/no): ");
                String extra = scanner.nextLine();
                if (extra.equalsIgnoreCase("yes")) {
                    pizza.addTopping("extra " + meat);
                } else {
                    pizza.addTopping(meat);
                }
            }
        }
    }

    //cheese toppings
    private static void addCheeseToppings(Scanner scanner, Pizza pizza) {
        boolean addingCheese = true;
        while (addingCheese) {
            System.out.println("\nCheese toppings:");
            System.out.println("1) Mozzarella");
            System.out.println("2) Parmesan");
            System.out.println("3) Ricotta");
            System.out.println("4) Goat Cheese");
            System.out.println("5) Buffalo Cheese");
            System.out.println("0) Done");

            System.out.println("Choose a cheese: ");
            String cheeseChoice = scanner.nextLine();

            if (cheeseChoice.equals("0")) {
                addingCheese = false;
            } else {
                String cheese;
                switch (cheeseChoice) {
                    case "1" -> cheese = "Mozzarella";
                    case "2" -> cheese = "Parmesan";
                    case "3" -> cheese = "Ricotta";
                    case "4" -> cheese = "Goat Cheese";
                    case "5" -> cheese = "Buffalo Cheese";
                    default -> {
                        System.out.println("Invalid choice, try again.");
                        continue;
                    }
                }

                System.out.println("Extra " + cheese + "? (yes/no): ");
                String extra = scanner.nextLine();
                if (extra.equalsIgnoreCase("yes")) {
                    pizza.addTopping("extra " + cheese);
                } else {
                    pizza.addTopping(cheese);
                }
            }
        }
    }

    //veggie toppings
    private static void addVeggieToppings(Scanner scanner, Pizza pizza) {
        boolean addingVeggie = true;
        while (addingVeggie) {
            System.out.println("\nVeggie toppings:");
            System.out.println("1) Onions");
            System.out.println("2) Mushroom");
            System.out.println("3) Bell Peppers");
            System.out.println("4) Olives");
            System.out.println("5) Tomatoes");
            System.out.println("6) Spinach");
            System.out.println("7) Basil");
            System.out.println("8) Pineapple");
            System.out.println("9) Anchovies");
            System.out.println("0) Done");

            System.out.println("Choose a veggie: ");
            String veggieChoice = scanner.nextLine();

            if (veggieChoice.equals("0")) {
                addingVeggie = false;
            } else {
                String veggie;
                switch (veggieChoice) {
                    case "1" -> veggie = "Onions";
                    case "2" -> veggie = "Mushroom";
                    case "3" -> veggie = "Bell Peppers";
                    case "4" -> veggie = "Olives";
                    case "5" -> veggie = "Tomatoes";
                    case "6" -> veggie = "Spinach";
                    case "7" -> veggie = "Basil";
                    case "8" -> veggie = "Pineapple";
                    case "9" -> veggie = "Anchovies";
                    default -> {
                        System.out.println("Invalid choice, try again.");
                        continue;
                    }
                }
                pizza.addTopping(veggie);
            }
        }
    }

    private static void addSauces(Scanner scanner, Pizza pizza) {
        boolean addingSauces = true;
        while (addingSauces) {
            System.out.println("\nSauces:");
            System.out.println("1) Marinara");
            System.out.println("2) Alfredo");
            System.out.println("3) Pesto");
            System.out.println("4) BBQ");
            System.out.println("5) Buffalo");
            System.out.println("6) Olive Oil");
            System.out.println("0) Done");

            System.out.println("Choose a sauce: ");
            String sauceChoice = scanner.nextLine();

            if (sauceChoice.equals("0")) {
                addingSauces = false;
            } else {
                String sauce;
                switch (sauceChoice) {
                    case "1" -> sauce = "Marinara";
                    case "2" -> sauce = "Alfredo";
                    case "3" -> sauce = "Pesto";
                    case "4" -> sauce = "BBQ";
                    case "5" -> sauce = "Buffalo";
                    case "6" -> sauce = "Olive Oil";
                    default -> {
                        System.out.println("Invalid choice, try again.");
                        continue;
                    }
                }
                pizza.addTopping(sauce);
            }
        }
    }

    //sides
    private static void addSides(Scanner scanner, Pizza pizza) {
        boolean addingSides = true;
        while (addingSides) {
            System.out.println("\nSides Menu:");
            System.out.println("1) Red Pepper");
            System.out.println("2) Parmesan");
            System.out.println("0) Done");
            System.out.println("Choose a side:");
            String sideChoice = scanner.nextLine();

            if (sideChoice.equals("0")) {
                addingSides = false;
            } else {
                String side;
                if (sideChoice.equals(("1"))) {
                    side = "Red Pepper";
                } else if (sideChoice.equals("2")) {
                    side = "Parmesan";
                } else {
                    System.out.println("Invalid choice, try again.");
                    continue;
                }

                pizza.addTopping(side);
            }
        }
    }
}

