package com.pluralsight;

public class Drink {
    private final String size;
    private final String flavor;

    public Drink(String size, String flavor) {
        this.size = size;
        this.flavor = flavor;
    }

    //get drink price
    public double getPrice() {
        if (size.equals("Small")) {
            return 2.00;
        } else if (size.equals("Medium")) {
            return 2.50;
        } else if (size.equals("Large")) {
            return 3.00;
        } else
            return 0;
    }

    public void displayDrink() {
        System.out.println(size + " - " + flavor + " $" + getPrice());
    }
}

