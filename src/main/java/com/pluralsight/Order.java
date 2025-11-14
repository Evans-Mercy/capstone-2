package com.pluralsight;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Order {
    private final ArrayList<Item> items = new ArrayList<>();

    public void addItem(Item item) {
        items.add(item);
    }

    //calculate total price
    public double getTotalPrice() {
        double total = 0;
        for (Item i : items) {
            total += i.getPrice();
        }
        return total;
    }

    //display order details
    public String getOrderSummary() {
        String summary = "--------------ORDER DETAILS--------------\n";
        for (Item i : items) {
            summary += i.getName() + " - " + i.getSummary() + "\n";
        }

        summary += "-----------------------------------------";
        summary += "Total Price: $" + String.format("%.2f", this.getTotalPrice());

        return summary;
    }

    //remove Item

    public void removeItem() {
        if (items.isEmpty()) {
            System.out.println("Your order is empty!");
            return;
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of the item to remove: ");
        for (int i = 0; i < items.size(); i++) {
            System.out.println((i + 1) + ". " + items.get(i).getName() + " - " + items.get(i).getSummary());
        }

        int choice = scanner.nextInt();
        if (choice < 1 || choice > items.size()) {
            System.out.println("Invalid choice.");
            return;
        }

        Item removed = items.remove(choice - 1);
        System.out.println(removed.getName() + " removed from order!");
    }

    //receipt
    public String generateReceipt() {
        StringBuilder receipt = new StringBuilder("--------------CHERRY'S PINEAPPLE PIZZA--------------\n");
        receipt.append("Order Items:\n");

        for (Item i : items) {
            receipt.append("- ").append(i.getName()).append(": ").append(i.getSummary());
            receipt.append(" ($").append(String.format("%.2f", i.getPrice())).append(")\n");
        }

        receipt.append("---------------------------------------------------------------------------\n");
        receipt.append("Total: $").append(String.format("%.2f", this.getTotalPrice())).append("\n");
        receipt.append("---------------------------------------------------------------------------\n");
        receipt.append("THANK YOU FOR YOUR ORDER! ENJOY AND PLEASE LEAVE A REVIEW. SEE YOU SOON :) \n");

        return receipt.toString();
    }

    //save receipt as a txt file
    public void saveReceipt() {
        String fileName = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss")) + ".txt";

        try {
            FileWriter writer = new FileWriter("src/main/resources/" + fileName);
            writer.write(generateReceipt());
            writer.close();
            System.out.println("Receipt saved to " + fileName + " successfully!");
        } catch (IOException e) {
            System.out.println("Error saving receipt: " + e.getMessage());
        }
    }

    public void saveOrderToCSV(String filename) {
        try {
            FileWriter writer = new FileWriter(filename);
            writer.write(String.format("%-15s | %-70s | %-10s%n", "Order Type", "Details", "Price"));
            writer.write("------------------------------------------------------------------------------\n");

            for (Item i : items) {
                writer.write(String.format("%-15s | %-70s | $%-10.2f%n", i.getName(), i.getSummary(), i.getPrice()));
            }

            writer.write("-------------------------------------------------------------------------------\n");
            writer.write(String.format("%-15s | %-70s | $%-10.2f%n", "Total", "", this.getTotalPrice()));

            writer.close();
            System.out.println("Order saved to " + filename + " successfully!");

        } catch (IOException e) {
            System.out.println("Error saving to file: " + e.getMessage());
        }
    }
}
