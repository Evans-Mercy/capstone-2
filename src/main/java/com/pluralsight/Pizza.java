package com.pluralsight;

import java.util.ArrayList;

public class Pizza extends Item {
    private final String size;
    private final String crustType;
    private final boolean stuffedCrust;
    private final ArrayList<String> toppings;

    private final boolean hasPineapple;


    public Pizza(String size, String crustType, boolean stuffedCrust) {
        super("Pizza", 0);
        this.size = size;
        this.crustType = crustType;
        this.stuffedCrust = stuffedCrust;
        this.toppings = new ArrayList<>();

        this.hasPineapple = true;
        this.toppings.add("Pineapple");
    }

    public String getSize() {
        return size;
    }

    public String getCrustType() {
        return crustType;
    }

    public boolean isStuffedCrust() {
        return stuffedCrust;
    }

    public ArrayList<String> getToppings() {
        return toppings;
    }

    //add a topping
    public void addTopping(String topping) {
        if (!toppings.contains(topping)) {
            toppings.add(topping);
        } else {
            System.out.println(topping + " is already on your pizza.");
        }
    }

    //remove a topping
    public void removeTopping(String  topping) {
        if (topping.equalsIgnoreCase("Pineapple")) {
            System.out.println("Sorry, pineapple cannot be removed!");
            return;
        }
        topping = topping.trim();
        boolean removed = false;

        for (int i = 0; i < toppings.size(); i++) {
            if (toppings.get(i). equalsIgnoreCase(topping)) {
                toppings.remove(i);
                removed = true;
                System.out.println(topping + " removed from your pizza.");
                break;
            }
        }
        if (!removed) {
            System.out.println(topping + " isn't on your pizza.");
        }
    }

    //toppings price
    public double getToppingsPrice() {
        double price = 0;

        for (String t : toppings) {
            if(t.equalsIgnoreCase("Pineapple")) continue;

            //extra topping
            boolean extra = t.contains("extra");

            //meat toppings
            if (t.equalsIgnoreCase("pepperoni") || t.equalsIgnoreCase("sausage") || t.equalsIgnoreCase("ham") || t.equalsIgnoreCase("bacon") || t.equalsIgnoreCase("chicken") || t.equalsIgnoreCase("meatball")) {
                switch (size) {
                    case "8" -> {
                        if (extra) {
                            price += 1.50;
                        } else {
                            price += 1.00; //regular
                        }
                    }
                    case "12" -> {
                        if (extra) {
                            price += 3.00;
                        } else {
                            price += 2.00;
                        }
                    }
                    case "16" -> {
                        if (extra) {
                            price += 4.50;
                        } else {
                            price += 3.00;
                        }
                    }
                }

                //cheese toppings
            } else if (t.equalsIgnoreCase("mozzarella") || t.equalsIgnoreCase("parmesan") || t.equalsIgnoreCase("ricotta") || t.equalsIgnoreCase("goat cheese") || t.equalsIgnoreCase("buffalo")) {
                switch (size) {
                    case "8" -> {
                        if (extra) {
                            price += 0.30;
                        } else {
                            price += 0.75;
                        }
                    }
                    case "12" -> {
                        if (extra) {
                            price += 0.60;
                        } else {
                            price += 1.50;
                        }
                    }
                    case "16" -> {
                        if (extra) {
                            price += 0.90;
                        } else {
                            price += 2.25;
                        }
                    }
                }
            }
        }
        return price;
    }

    //base price for size
    @Override
    public double getPrice(){
        double price = switch (size) {
            case "8" -> 8.50;
            case "12" -> 12.00;
            case "16" -> 16.50;
            default -> 0;
        };

        //stuffed crust
        if (stuffedCrust) {
            price += 2.00;
        }

        //add toppings price
        price += getToppingsPrice();

     return price;
    }

    //pizza summary
    @Override
    public String getSummary() {
        String summary = "Size: " + size + "\"" + "\n" + "Crust Type: " + crustType + "\n" + "Stuffed Crust: ";
        if (stuffedCrust) {
            summary += "Yes\n";
        } else {
            summary += "No\n";
        }
        summary += "Toppings: " + toppings + "\n" + "Total Price: $" + getPrice() + "\n" + "Pineapple is always included!";
        return summary;
    }
    //pizza details
    public void displayPizza() {
        System.out.println(getSummary());
    }
}
