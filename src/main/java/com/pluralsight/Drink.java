package com.pluralsight;

public class Drink extends Item {
    private final String size;
    private final String flavor;

    public Drink(String size, String flavor) {
        super("Drink", 0);
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
    @Override
    public String getSummary() {
        return size + " - " + flavor + " $" + getPrice();

    }
}

