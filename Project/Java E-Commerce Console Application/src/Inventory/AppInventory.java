package Inventory;

import java.util.ArrayList;
import Users.*;
import Misc.*;
import Products.*;

public class AppInventory {
    private static ArrayList<Product> products;
    private static ArrayList<Customer> customers;
    private static Admin admin;
    private static ArrayList<Order> customerOrders;
    private static ArrayList<Feedback> feedbacks;
    private static int nb_loads = 0;

    public AppInventory() {
        products = new ArrayList<Product>();
        customers = new ArrayList<Customer>();
        admin = new Admin(0, "Java", "Lord");
        admin.setUsername("admin");
        admin.setPassword("adminos258");
        customerOrders = new ArrayList<Order>();
        feedbacks = new ArrayList<Feedback>();
    }

    public static ArrayList<Product> getProducts() {
        return products;
    }

    public static ArrayList<Customer> getCustomers() {
        return customers;
    }

    public static Admin getAdmin() {
        return admin;
    }

    public static ArrayList<Order> getCustomerOrders() {
        return customerOrders;
    }

    public static ArrayList<Feedback> getFeedbacks() {
        return feedbacks;
    }

    public static void addFeedback(Feedback feedback) {
        feedbacks.add(feedback);
    }

    public static void viewProducts() {
        if (products == null) {
            System.out.println("Product list is empty");
            return;
        }
        for (Product product : products) {
            product.productInformation();
        }
        System.out.println("==========================");
    }

    public static Product searchProduct(int ID) {
        if (products == null) {
            System.out.println("Product list is empty");
        }
        else {
            for (Product product : products) {
                if (product.getID() == ID) {
                    System.out.println("Product found");
                    return product;
                }
            }
            System.out.println("Product not found");
        }
        return null;
    }

    public static void loadInventoryProducts() {
        if (nb_loads != 1) {
            AppInventory.addProduct(new Furniture(0, "Sofa", "FurnitureCo", 299.99, 10));
            AppInventory.addProduct(new Furniture(1, "Dining Table", "WoodWorks", 499.99, 5));
            AppInventory.addProduct(new Clothing(2, "T-Shirt", "FashionBrand", 19.99, 50));
            AppInventory.addProduct(new Clothing(3, "Jeans", "DenimCo", 39.99, 40));
            AppInventory.addProduct(new Clothing(4, "Jacket", "OutdoorGear", 89.99, 30));
            AppInventory.addProduct(new Electronic(5, "Smartphone", "TechBrand", 699.99, 20));
            AppInventory.addProduct(new Electronic(6, "Laptop", "CompTech", 999.99, 15));
            AppInventory.addProduct(new Electronic(7, "Smart TV", "ElectroGoods", 1299.99, 10));
            AppInventory.addProduct(new Electronic(8, "Headphones", "SoundMaster", 59.99, 25));
            AppInventory.addProduct(new Electronic(19, "Gaming Console", "GameTech", 399.99, 18));
            AppInventory.addProduct(new Furniture(10, "Bookshelf", "ReadersHaven", 120.99, 15));
            AppInventory.addProduct(new Furniture(11, "Office Chair", "ComfortSeating", 210.50, 20));
            AppInventory.addProduct(new Clothing(12, "Summer Dress", "SunnyFashion", 49.99, 30));
            AppInventory.addProduct(new Clothing(13, "Baseball Cap", "SportsTrend", 15.99, 60));
            AppInventory.addProduct(new Clothing(14, "Running Shoes", "FastTrack", 110.00, 25));
            AppInventory.addProduct(new Electronic(15, "Bluetooth Speaker", "SoundWave", 89.99, 40));
            AppInventory.addProduct(new Electronic(16, "E-Reader", "BookTech", 129.99, 30));
            AppInventory.addProduct(new Electronic(17, "Fitness Tracker", "HealthSync", 59.99, 50));
            AppInventory.addProduct(new Electronic(18, "Digital Camera", "PhotoPro", 450.99, 15));
            AppInventory.addProduct(new Electronic(19, "Portable Charger", "PowerPlus", 29.99, 100));
            AppInventory.addProduct(new Furniture(20,  "Nightstand", "HomeLux", 75.99, 25));
            AppInventory.addProduct(new Furniture(21, "Garden Bench", "OutdoorLiving", 150.00, 10));
            AppInventory.addProduct(new Clothing(22, "Woolen Scarf", "WarmThreads", 25.99, 40));
            AppInventory.addProduct(new Clothing(23, "Raincoat", "WeatherWear", 60.00, 35));
            AppInventory.addProduct(new Clothing(24, "Swim Shorts", "BeachLife", 29.99, 50));
            AppInventory.addProduct(new Electronic(25, "Wireless Mouse", "TechEase", 35.99, 45));
            AppInventory.addProduct(new Electronic(26, "VR Headset", "VirtualSpace", 299.99, 20));
            AppInventory.addProduct(new Electronic(27, "Drone", "SkyHigh", 350.00, 15));
            AppInventory.addProduct(new Electronic(28, "Action Camera", "AdventureCam", 119.99, 30));
            AppInventory.addProduct(new Electronic(29, "Smart Thermostat", "EcoTemp", 199.99, 22));
            nb_loads++;
            System.out.println("Products loaded successfully.");
        } else {
            System.out.println("Sorry, you can't load the inventory twice.");
        }
    }

    public static void addProduct(Product product) {
        products.add(product);
    }

    public static void removeProduct(Product product) {
        products.remove(product);
    }

    public static void removeCustomer(Customer customer) {
        customers.remove(customer);
    }

    public static Customer searchCustomer(int id) {
        if (customers == null) {
            System.out.println("Customer list is empty");
        }
        else {
            for (Customer customer : customers) {
                if (customer.getID() == id) {
                    System.out.println("Customer found");
                    return customer;
                }
            }
            System.out.println("Customer not found");
        }
        return null;
    }

    public static void addOrder(Order order) {
        customerOrders.add(order);
    }

    public static Customer searchCustomerByUsername(String enteredUsername) {
        for (Customer customer : customers) {
            if (customer.getUsername().equals(enteredUsername)) {
                return customer;
            }
        }
        return null;
    }

}
