package com.pluralsight;

import java.util.ArrayList;

public class Pizza {
    private String size;
    private String crustType;
    private boolean stuffedCrust;
    private ArrayList<String> toppings;


    public Pizza(String size, String crustType, boolean stuffedCrust) {
        this.size = size;
        this.crustType = crustType;
        this.stuffedCrust = stuffedCrust;
        this.toppings = new ArrayList<>();
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

            //extra topping
            boolean extra = t.contains("extra");

            //meat toppings
            if (t.equalsIgnoreCase("pepperoni") || t.equalsIgnoreCase("sausage") || t.equalsIgnoreCase("ham") || t.equalsIgnoreCase("bacon") || t.equalsIgnoreCase("chicken") || t.equalsIgnoreCase("meatball")) {
                if (size.equals("8")) {
                    if (extra) {
                        price += 1.50;
                    } else {
                        price += 1.00; //regular
                    }
                } else if (size.equals("12")) {
                    if (extra) {
                        price += 3.00;
                    } else {
                        price += 2.00;
                    }
                } else if (size.equals("16")) {
                    if (extra) {
                        price += 4.50;
                    } else {
                        price += 3.00;
                    }
                }

                //cheese toppings
            } else if (t.equalsIgnoreCase("mozzarella") || t.equalsIgnoreCase("parmesan") || t.equalsIgnoreCase("ricotta") || t.equalsIgnoreCase("goat cheese") || t.equalsIgnoreCase("buffalo")) {
                if (size.equals("8")) {
                    if (extra) {
                        price += 0.30;
                    } else {
                        price += 0.75;
                    }
                } else if (size.equals("12")) {
                    if (extra) {
                        price += 0.60;
                    } else {
                        price += 1.50;
                    }
                } else if (size.equals("16")) {
                    if (extra) {
                        price += 0.90;
                    } else {
                        price += 2.25;
                    }
                }
            }
        }
        return price;
    }

    //base price for size
    public double getPrice(){
        double price = 0;

        if(size.equals("8")){
            price = 8.50;
        } else if (size.equals("12")) {
            price = 12.00;
        } else if (size.equals("16")) {
            price = 16.50;
        }

        //stuffed crust
        if (stuffedCrust) {
            price += 2.00;
        }

        //add toppings price
        price += getToppingsPrice();

     return price;
    }

    //pizza summary
    public String getSummary() {
        String summary = "Pizza Size: " + size + "\n" + "Crust Type: " + crustType + "\n" + "Stuffed Crust: ";
        if (stuffedCrust) {
            summary += "Yes\n";
        } else {
            summary += "No\n";
        }
        summary += "Toppings: " + toppings + "\n" + "Total Price: $" + getPrice();
        return summary;
    }
    //pizza details
    public void displayPizza() {
        System.out.println(getSummary());
    }
}
