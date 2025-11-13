package com.pluralsight;

public class GarlicKnots extends Item{
    private final double price = 1.50;

    public GarlicKnots() {
        super("Garlic Knots", 1.50);
    }

    //get price
    @Override
    public double getPrice(){
        return price;
    }

    //summary
    @Override
    public String getSummary() {
        return "Garlic Knots - $" + getPrice();
    }

    //display
    public void displayGarlicKnots() {
        System.out.println(getSummary());
    }

}
