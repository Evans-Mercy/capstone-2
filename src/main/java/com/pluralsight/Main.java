package com.pluralsight;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

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

                    if (orderChoice.equals("1")) {
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

                    } else if (orderChoice.equals("2")) {
                        //add a drink
                        System.out.println("Enter drink size (Small, Medium, Large): ");
                        String drinkSize = scanner.nextLine();

                        System.out.println("Enter drink flavor: ");
                        String drinkFlavor = scanner.nextLine();

                        Drink drink = new Drink(drinkSize, drinkFlavor);
                        order.addItem(drink);
                        System.out.println("Drink added successfully!");

                    } else if (orderChoice.equals("3")) {
                        //add garlic knots
                        System.out.println("Would you like to add Garlic Knots? (Yes/No): ");

                        if (scanner.nextLine().equalsIgnoreCase("yes")) {
                            GarlicKnots gk = new GarlicKnots();
                            order.addItem(gk);
                            System.out.println("Garlic Knots added successfully!");

                        } else if (orderChoice.equals("4")) {
                            order.removeItem();
                        }
                    } else if (orderChoice.equals("5")) {
                        //checkout
                        System.out.println("\n Please confirm your order:");
                        System.out.println(order.generateReceipt());
                        order.saveReceipt();
                        order.saveOrderToCSV("resources/order.csv");
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
                String meat = "";
                if (meatChoice.equals("1")) meat = "Pepperoni";
                else if (meatChoice.equals("2")) meat = "Sausage";
                else if (meatChoice.equals("3")) meat = "Ham";
                else if (meatChoice.equals("4")) meat = "Bacon";
                else if (meatChoice.equals("5")) meat = "Chicken";
                else if (meatChoice.equals("6")) meat = "Meatball";
                else {
                    System.out.println("Invalid choice, try again.");
                    continue;
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
                String cheese = "";
                if (cheeseChoice.equals("1")) cheese = "Mozzarella";
                else if (cheeseChoice.equals("2")) cheese = "Parmesan";
                else if (cheeseChoice.equals("3")) cheese = "Ricotta";
                else if (cheeseChoice.equals("4")) cheese = "Goat Cheese";
                else if (cheeseChoice.equals("5")) cheese = "Buffalo Cheese";
                else {
                    System.out.println("Invalid choice, try again.");
                    continue;
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
                String veggie = "";
                if (veggieChoice.equals("1")) veggie = "Onions";
                else if (veggieChoice.equals("2")) veggie = "Mushroom";
                else if (veggieChoice.equals("3")) veggie = "Bell Peppers";
                else if (veggieChoice.equals("4")) veggie = "Olives";
                else if (veggieChoice.equals("5")) veggie = "Tomatoes";
                else if (veggieChoice.equals("6")) veggie = "Spinach";
                else if (veggieChoice.equals("7")) veggie = "Basil";
                else if (veggieChoice.equals("8")) veggie = "Pineapple";
                else if (veggieChoice.equals("9")) veggie = "Anchovies";
                else {
                    System.out.println("Invalid choice, try again.");
                    continue;
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
                String sauce = "";
                if (sauceChoice.equals("1")) sauce = "Marinara";
                else if (sauceChoice.equals("2")) sauce = "Alfredo";
                else if (sauceChoice.equals("3")) sauce = "Pesto";
                else if (sauceChoice.equals("4")) sauce = "BBQ";
                else if (sauceChoice.equals("5")) sauce = "Buffalo";
                else if (sauceChoice.equals("6")) sauce = "Olive Oil";
                else {
                    System.out.println("Invalid choice, try again.");
                    continue;
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
                String side = "";
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

