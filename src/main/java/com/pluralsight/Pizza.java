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
    }
}
