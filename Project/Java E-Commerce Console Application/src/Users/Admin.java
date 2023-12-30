package Users;

import java.util.ArrayList;
import java.util.Scanner;

import utils.*;
import Inventory.*;
import Misc.*;
import Products.*;

public class Admin extends Person {

    private static int nextProductID = 0;
    public Admin(int ID, String firstName, String lastName) {
        super(ID, firstName, lastName);
    }

    public Admin() {

    }

    public void viewProducts() {
        AppInventory.viewProducts();
    }

    public void viewOrders() {
        ArrayList<Order> orders = AppInventory.getCustomerOrders();
        for (Order order : orders) {
            order.orderInformation();
        }
    }

    public void viewFeedbacks() {
        ArrayList<Feedback> feedbacks = AppInventory.getFeedbacks();
        if (feedbacks == null) {
            System.out.println("Feedback list is empty");
            return;
        }
        for (Feedback feedback : feedbacks) {
            feedback.feedbackInformation();
        }
    }

    public void addProduct() {
        Product product = null;
        int choice;
        do {
        System.out.println("Enter the type of your product: ");
        System.out.println("1. Clothing");
        System.out.println("2. Electronic");
        System.out.println("3. Furniture");
        System.out.println("4. Exit");
        System.out.println("Enter your choice: ");
            choice = util.getUserChoice();
            switch (choice) {
                case 1:
                    product = new Clothing();
                    break;
                case 2:
                    product = new Electronic();
                    break;
                case 3:
                    product = new Furniture();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    return;
            }
        } while (choice < 0 || choice > 4);
        product.setID(generateProductID());
        System.out.println("Enter the name of the product you would like to add: ");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        product.setName(name);
        System.out.println("Enter the manufacturer of the product you would like to add: ");
        String manufacturer = scanner.nextLine();
        product.setManufacturer(manufacturer);
        System.out.println("Enter the price of the product you would like to add: ");
        double price = scanner.nextDouble();
        product.setPrice(price);
        System.out.println("Enter the quantity of the product you would like to add: ");
        int quantity = scanner.nextInt();
        product.setQuantity(quantity);
        AppInventory.addProduct(product);
        System.out.println("Product added successfully.");


    }

    public void removeProduct() {
        System.out.println("Enter the ID of the product you would like to remove: ");
        int ID = util.getUserChoice();
        Product product = AppInventory.searchProduct(ID);
        if (product == null) {
            System.out.println("Product not found. Please try again.");
            return;
        }
        System.out.println("Are you sure you want to remove this product? (Y/N)");
        Scanner scanner = new Scanner(System.in);
        String choice = scanner.nextLine();
        if (choice.equalsIgnoreCase("Y")) {
            AppInventory.removeProduct(product);
            System.out.println("Product removed successfully.");
        }
        else {
            System.out.println("Product not removed.");
        }
    }

    public void editProduct() {
        System.out.println("Enter the ID of the product you would like to modify: ");
        int ID = util.getUserChoice();
        Product product = AppInventory.searchProduct(ID);
        if (product == null) {
            System.out.println("Product not found. Please try again.");
            return;
        }
        product.productInformation();
        System.out.println("===============");
        System.out.println("What would you like to modify?");
        System.out.println("1. Product Name");
        System.out.println("2. Product Manufacturer");
        System.out.println("3. Product Price");
        System.out.println("4. Product Quantity");
        System.out.println("5. Exit");
        System.out.println("Enter your choice: ");
        int choice = util.getUserChoice();
        Scanner scanner = new Scanner(System.in);
        switch (choice) {
            case 1:
                System.out.println("Enter new product name: ");
                String newName = scanner.nextLine();
                product.setName(newName);
                break;
            case 2:
                System.out.println("Enter new product manufacturer: ");
                String newManufacturer = scanner.nextLine();
                product.setManufacturer(newManufacturer);
                break;
            case 3:
                System.out.println("Enter new product price: ");
                double newPrice = scanner.nextDouble();
                product.setPrice(newPrice);
                break;
            case 4:
                System.out.println("Enter new product quantity: ");
                int newQuantity = scanner.nextInt();
                product.setQuantity(newQuantity);
                break;
            case 5:
                return;
            default:
                System.out.println("Invalid choice. Please try again.");
                break;
        }
        System.out.println("Product modified successfully.");
    }

    public void loadProductsFromInventory() {
        System.out.println("Loading products from inventory...");
        AppInventory.loadInventoryProducts();
    }

    public void viewCustomers() {
        ArrayList<Customer> customers = AppInventory.getCustomers();
        if (customers == null) {
            System.out.println("Customer list is empty");
            return;
        }
        for (Customer customer : customers) {
            customer.customerInformationForAdmin();
        }
    }

    public void removeCustomer() {
        System.out.println("Enter the ID of the customer you would like to remove: ");
        int ID = util.getUserChoice();
        Customer customer = AppInventory.searchCustomer(ID);
        if (customer == null) {
            System.out.println("Customer not found. Please try again.");
            return;
        }
        AppInventory.removeCustomer(customer);
        System.out.println("Customer removed successfully.");
    }

    public void adminInformation() {
        System.out.println("Admin ID: " + ID);
        System.out.println("First Name: " + firstName);
        System.out.println("Last Name: " + lastName);
        System.out.println("Username: " + username);
        System.out.println("Password: " + password);
        System.out.println("===============");
    }

    private int generateProductID() {
        if (AppInventory.getProducts().isEmpty()) {
            return nextProductID++;
        } else {
            return AppInventory.getProducts().get(AppInventory.getProducts().size() - 1).getID() + 1;
        }
    }

    public void adminMenu() {
        Scanner scanner = new Scanner(System.in);
        int choice;
        System.out.println("Welcome, " + firstName + " " + lastName + "!");
        do {
            System.out.println("===== Admin Menu =====");
            System.out.println("1. View Products");
            System.out.println("2. Add Product");
            System.out.println("3. Remove Product");
            System.out.println("4. Edit Product");
            System.out.println("5. View Customers");
            System.out.println("6. Remove Customer");
            System.out.println("7. View Orders");
            System.out.println("8. View Feedbacks");
            System.out.println("9. Load Products from Inventory");
            System.out.println("10. Admin Information");
            System.out.println("0. Exit");

            System.out.println("Enter your choice: ");
            choice = util.getUserChoice();

            switch (choice) {
                case 1:
                    viewProducts();
                    break;
                case 2:
                    addProduct();
                    break;
                case 3:
                    removeProduct();
                    break;
                case 4:
                    editProduct();
                    break;
                case 5:
                    viewCustomers();
                    break;
                case 6:
                    removeCustomer();
                    break;
                case 7:
                    viewOrders();
                    break;
                case 8:
                    viewFeedbacks();
                    break;
                case 9:
                    loadProductsFromInventory();
                    break;
                case 10:
                    adminInformation();
                    break;
                case 0:
                    System.out.println("Exiting Admin Menu. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        } while (choice != 0);

    }

}
