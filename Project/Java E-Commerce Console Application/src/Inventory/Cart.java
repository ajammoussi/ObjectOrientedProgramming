package Inventory;

import Misc.Coupon;
import Products.Product;

import java.util.ArrayList;
import java.util.Scanner;

public class Cart {
    private static int nextItemID = 1;
    private ArrayList<Item> cartItems;
    private double totalPrice;

    public Cart() {
        cartItems = new ArrayList<Item>();
        totalPrice = 0;
    }

    private int generateItemID() {
        return nextItemID++;
    }

    public void addItem(Product product, int quantity) {
        Item item = new Item(generateItemID(), product, quantity);
        cartItems.add(item);
        totalPrice += item.getItemPrice();
        System.out.println("Item added to cart");
    }

    public void updateItem() {
        Scanner scanner = new Scanner(System.in);
        Item i;
        System.out.println("Enter item ID: ");
        int itemID = scanner.nextInt();
        i = searchItem(itemID);
        if (i != null) {
            System.out.println("Enter new quantity: ");
            int newQuantity = scanner.nextInt();
            i.setQuantity(newQuantity);
            calculateTotal();
            System.out.println("Item updated successfully.");
        }
        else {
            System.out.println("Cannot update a non existing item.");
        }
    }

    private Item searchItem(int itemID) {
        if (cartItems == null) {
            System.out.println("Shopping cart is empty");
        }
        else {
            for (Item item : cartItems) {
                if (item.getID() == itemID) {
                    System.out.println("Item found");
                    return item;
                }
            }
            System.out.println("Item not found");
        }
        return null;
    }

    public void removeItem() {
        Scanner scanner = new Scanner(System.in);
        Item i;
        System.out.println("Enter item ID: ");
        int itemID = scanner.nextInt();
        i = searchItem(itemID);
        if (i != null) {
            cartItems.remove(i);
            calculateTotal();
            System.out.println("Item removed successfully.");
        }
        else {
            System.out.println("Cannot remove a non existing item.");
        }
    }
    public void calculateTotal() {
        double sum = 0;
        if (cartItems == null) {
            System.out.println("Shopping cart is empty");
            return;
        }
        for (Item item : cartItems) {
            sum += item.getItemPrice();
        }
        totalPrice = sum;
        System.out.println("Total price: " + totalPrice);
    }

    public void cartInformation() {
        if (cartItems == null) {
            System.out.println("Shopping cart is empty");
            return;
        }
        for (Item item : cartItems) {
            item.itemInformation();
        }
        System.out.println("==========================");
        System.out.println("Total price: " + totalPrice);
        System.out.println("==========================");
    }

    public void applyCoupon(Coupon coupon) {
        totalPrice -= totalPrice * coupon.getDiscount();
        System.out.println("Coupon applied. New total price: " + totalPrice);
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public ArrayList<Item> getCartItems() {
        return cartItems;
    }
}
