package com.pluralsight;

public class Main {
    public static void main(String[] args) {
        Pizza pizza1 = new Pizza("12\"", "Thin", true);

        pizza1.addTopping("Pepperoni");

        pizza1.displayPizza();

    }
}
