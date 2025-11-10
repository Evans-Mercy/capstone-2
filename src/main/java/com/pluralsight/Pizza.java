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
    public void addTopping(String topping){
        toppings.add(topping);
    }

    //toppings price
    public double getToppingsPrice() {
        double price = 0;

        for (String t : toppings) {

            //extra topping
            boolean extra = t.contains("extra");

            //meat
            if (t.equalsIgnoreCase("pepperoni") || t.equalsIgnoreCase("sausage") || t.equalsIgnoreCase("ham") || t.equalsIgnoreCase("bacon") || t.equalsIgnoreCase("chicken") || t.equalsIgnoreCase("meatball")) {
                if (size.equals("8\"")) {
                    if (extra) {
                        price += 1.50;
                    } else {
                        price += 1.00;
                    }
                } else if (size.equals("12\"")) {
                    if (extra) {
                        price += 3.00;
                    } else {
                        price += 2.00;
                    }
                } else if (size.equals("16\"")) {
                    if (extra) {
                        price += 4.50;
                    } else {
                        price += 3.00;
                    }
                }

                //cheese
            } else if (t.equalsIgnoreCase("mozzarella") || t.equalsIgnoreCase("parmesan") || t.equalsIgnoreCase("ricotta") || t.equalsIgnoreCase("goat cheese") || t.equalsIgnoreCase("buffalo")) {
                if (size.equals("8\"")) {
                    if (extra) {
                        price += 0.60;
                    } else {
                        price += 0.75;
                    }
                } else if (size.equals("12\"")) {
                    if (extra) {
                        price += 1.20;
                    } else {
                        price += 1.50;
                    }
                } else if (size.equals("16\"")) {
                    if (extra) {
                        price += 1.80;
                    } else {
                        price += 2.25;
                    }
                }
            }
        }
        return price;
    }

    //base price for size
    public double getBasePrice(){
        double price = 0;

        if(size.equals("8\"")){
            price = 8.50;
        } else if (size.equals("12\"")) {
            price = 12.00;
        } else if (size.equals("16\"")) {
            price = 16.50;
        }

        //stuffed crust
        if (stuffedCrust) {
            price += 2.00;
        }

        //add toppings price
        price= price + getToppingsPrice();

     return price;
    }

    //pizza details
    public void displayPizza() {
        System.out.println("Pizza Size: " + size);
        System.out.println("Crust Type: " + crustType);
        if (stuffedCrust) {
            System.out.println("Stuffed Crust: Yes");
        } else {
            System.out.println("Stuffed Crust: No");
        }
        System.out.println("Toppings: " + toppings);

        System.out.println("Total price: $" + getBasePrice());
    }
}
