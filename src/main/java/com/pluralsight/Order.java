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

    //getters
    public ArrayList<Pizza> getPizzas() {
        return pizzas;
    }

    public ArrayList<Drink> getDrinks() {
        return drinks;
    }

    public ArrayList<GarlicKnots> getGarlicKnots() {
        return garlicKnots;
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
    public double getTotalPrice(){
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
    public String getOrderSummary(){
        String summary = "--------------ORDER DETAILS--------------\n";
        for (Pizza p : pizzas) {
            summary += p.getSummary() + "\n\n";
        }
        for (Drink d : drinks) {
            summary += d.getSummary() + "\n\n";

        }
        for (GarlicKnots gk: garlicKnots) {
            summary += gk.getSummary() + "\n\n";
        }
        summary += "-----------------------------------------";
        summary += "Total Price: " + this.getTotalPrice();

        return summary;
    }

    //display order
    public void  displayOrder() {
        System.out.println(getOrderSummary());
    }
}
