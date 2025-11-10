package com.pluralsight;

import java.util.ArrayList;

public class Order {
    private ArrayList<Pizza> pizzas;
    private ArrayList<Drink> drinks;
    private ArrayList<GarlicKnots> garlicKnots;

    public Order() {
        this.pizzas = new ArrayList<>();
        this.drinks = new ArrayList<>();
        this.garlicKnots = new ArrayList<>();
    }

    public Order(ArrayList<Pizza> pizzas, ArrayList<Drink> drinks, ArrayList<GarlicKnots> garlicKnots) {
        this.pizzas = new ArrayList<>();
        this.drinks = new ArrayList<>();
        this.garlicKnots = new ArrayList<>();
    }

    //add pizza
    public void addPizza(Pizza pizza){
        pizzas.add(pizza);
    }

    //add drink
    public void addDrink(Drink drink){
        drinks.add(drink);
    }

    //add garlic knots
    public void addGarlicKnots(GarlicKnots garlicKnot){
        garlicKnots.add(garlicKnot);
    }

    //calculate total price
    public double getPrice(){
        double total = 0;
        for(Pizza p : pizzas) {
            total += p.getPrice();
        }
        for(Drink d : drinks) {
            total += d.getPrice();
        }
        for(GarlicKnots gk : garlicKnots) {
            total += gk.getPrice();
        }
        return total;
    }

    //display order details
    public void displayOrder(){
        System.out.println("--------------ORDER DETAILS--------------");
        for (Pizza p : pizzas) {
            p.displayPizza();
        }
        for (Drink d : drinks) {
            d.displayDrink();
        }
        for (GarlicKnots gk: garlicKnots) {
            gk.displayGarlicKnots();
        }
        System.out.println("-----------------------------------------");
        System.out.println("Total Price: " + this.getPrice());
    }
}
