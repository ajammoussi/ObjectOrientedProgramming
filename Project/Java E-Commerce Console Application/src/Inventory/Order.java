package Inventory;

import java.util.ArrayList;

public class Order {
    private int orderID;
    private String orderDate;
    private String cardNumber;
    private int userID;
    private ArrayList<Item> items;
    private double totalPrice;

    public Order(int orderID, String orderDate, String cardNumber, int userID, ArrayList<Item> items, double totalPrice) {
        this.orderID = orderID;
        this.orderDate = orderDate;
        this.cardNumber = cardNumber;
        this.userID = userID;
        this.items = items;
        this.totalPrice = totalPrice;
    }

    public int getOrderID() {
        return orderID;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public int getUserID() {
        return userID;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void orderInformation() {
        System.out.println("Order ID: " + orderID);
        System.out.println("Order Date: " + orderDate);
        System.out.println("Card Number: " + cardNumber);
        System.out.println("User ID: " + userID);
        System.out.println("Items: ");
        for (Item item : items) {
            item.itemInformation();
        }
        System.out.println("Total Price: " + totalPrice);
        System.out.println("==========================");
    }
}
