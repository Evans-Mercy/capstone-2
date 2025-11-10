package com.pluralsight;

public class GarlicKnots {
    private final double price = 1.50;

    public GarlicKnots() {
    }

    //get price
    public double getPrice(){
        return price;
    }

    //summary
    public String getSummary() {
        return "Garlic Knots - $" + getPrice();
    }

    //display
    public void displayGarlicKnots() {
        System.out.println(getSummary());
    }
}
