package com.pluralsight;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Order {
    private final ArrayList<Pizza> pizzas;
    private final ArrayList<Drink> drinks;
    private final ArrayList<GarlicKnots> garlicKnots;

    public Order() {
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
        summary += "Total Price: $" + String.format("%.2f", this.getTotalPrice());

        return summary;
    }

    //receipt
    public String generateReceipt(){
        String receipt = "--------------CHERRY'S PINEAPPLE PIZZA--------------\n";
        receipt += "Order Items:\n";

        for (Pizza p : pizzas) {
            receipt += "-Pizza: " + p.getSummary() + "\n";
        }
        for (Drink d : drinks) {
            receipt += "-Drink: " + d.getSummary() + "\n";

        }
        for (GarlicKnots gk: garlicKnots) {
            receipt += "Garlic Knots: " + gk.getSummary() + "\n";
        }
        receipt += "-----------------------------------------\n";
        receipt += "Total: $" + String.format("%.2f", this.getTotalPrice()) + "\n";
        receipt += "-----------------------------------------\n";
        receipt += "THANK YOU FOR YOUR ORDER!\n";



        return receipt;
    }

    //save receipt as a txt file
    public void saveReceipt(){
        String fileName = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss")) + ".txt";
        try{
            FileWriter writer = new FileWriter(fileName);
            writer.write(generateReceipt());
            writer.close();
            System.out.println("Receipt saved to " + fileName + " successfully!");
        } catch (Exception e) {
            System.out.println("Error saving receipt: " + e.getMessage());
        }
    }

    public void saveOrderToCSV(String filename) {
        try {
            FileWriter writer = new FileWriter(filename);
            writer.write("Order Type, Details, Price\n");

            //pizza
            for (Pizza p: pizzas) {
                writer.write(("Pizza,\"" + p.getSummary().replace("\n", "") + "\",") + p.getPrice() + "\n");
            }

            //drinks
            for (Drink d: drinks) {
                writer.write(("Drink,\"" + d.getSummary().replace("\n", "") + "\",") + d.getPrice()+ "\n");
            }

            //garlic knots
            for (GarlicKnots gk: garlicKnots) {
                writer.write(("Garlic Knots,\"" + gk.getSummary().replace("\n", "") + "\",") + gk.getPrice()+ "\n");
            }

            //total
            writer.write(("Total," + this.getTotalPrice() + "\n"));
            writer.close();
            System.out.println("Order saved to " + filename + " successfully!");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
