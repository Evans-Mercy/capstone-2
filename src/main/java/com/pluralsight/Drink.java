package com.pluralsight;

public class Drink {
    private final String size;
    private final String flavor;

    public Drink(String size, String flavor) {
        this.size = size;
        this.flavor = flavor;
    }

    //getters
    public String getSize() {
        return size;
    }

    public String getFlavor() {
        return flavor;
    }

    //get drink price
    public double getPrice() {
        double price = 0;

        if (size.equalsIgnoreCase("Small")) {
            return 2.00;
        } else if (size.equalsIgnoreCase("Medium")) {
            return 2.50;
        } else if (size.equalsIgnoreCase("Large")) {
            return 3.00;
        } else
            return price;
    }

    //summary
    public String getSummary() {
        return size + " - " + flavor + " $" + getPrice();

    }

    //Display drink
    public void displayDrink() {
        System.out.println(getSummary());
    }
}

