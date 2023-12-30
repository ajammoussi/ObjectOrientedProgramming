package Users;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


import utils.*;
import Inventory.*;
import Misc.*;
import Products.*;

public class Customer extends Person {
    private String creditCardName;
    private String creditCardNumber;
    private String creditCardExpirationDate;
    private String creditCardSecurityCode;
    private Cart shoppingCart;
    private OrderHistory orderHistory;
    private ArrayList<Coupon> coupons;

    private static int nextOrderID = 1;
    private static int nextRatingID = 1;

    public Customer(int ID, String firstName, String lastName, String creditCardName, String creditCardNumber, String creditCardExpirationDate, String creditCardSecurityCode) {
        super(ID, firstName, lastName);
        this.creditCardName = creditCardName;
        this.creditCardNumber = creditCardNumber;
        this.creditCardExpirationDate = creditCardExpirationDate;
        this.creditCardSecurityCode = creditCardSecurityCode;
        shoppingCart = new Cart();
        orderHistory = new OrderHistory();
        coupons = new ArrayList<Coupon>(Arrays.asList(new Coupon(532578, "5OFF", 0.05, "Starter Coupon: 5% off"), new Coupon(854789, "10OFF", 0.1, "Starter Coupon: 10% off"), new Coupon(987456, "20OFF", 0.2, "Starter Coupon: 20% off")));
    }

    public Customer() {
        shoppingCart = new Cart();
        orderHistory = new OrderHistory();
        coupons = new ArrayList<Coupon>(Arrays.asList(new Coupon(532578, "5OFF", 0.05, "Starter Coupon: 5% off"), new Coupon(854789, "10OFF", 0.1, "Starter Coupon: 10% off"), new Coupon(987456, "20OFF", 0.2, "Starter Coupon: 20% off")));
    }

    public String getCreditCardName() {
        return creditCardName;
    }

    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    public String getCreditCardExpirationDate() {
        return creditCardExpirationDate;
    }

    public String getCreditCardSecurityCode() {
        return creditCardSecurityCode;
    }

    public void setCreditCardName(String creditCardName) {
        this.creditCardName = creditCardName;
    }

    public void setCreditCardNumber(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    public void setCreditCardExpirationDate(String creditCardExpirationDate) {
        this.creditCardExpirationDate = creditCardExpirationDate;
    }

    public void setCreditCardSecurityCode(String creditCardSecurityCode) {
        this.creditCardSecurityCode = creditCardSecurityCode;
    }

    public void addProductToCart() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter product ID: ");
        int productID = input.nextInt();
        if (productID < 0 || productID >= AppInventory.getProducts().size()) {
            System.out.println("Invalid product ID. Please try again.");
            return;
        }
        Product selectedProduct = AppInventory.getProducts().get(productID);
        if (selectedProduct == null) {
            System.out.println("Product not found. Please try again.");
            return;
        }
        System.out.println("Enter quantity: ");
        int quantity = input.nextInt();
        shoppingCart.addItem(selectedProduct, quantity);
    }

    public void checkout() {
        System.out.println("Proceeding to checkout...");
        System.out.println("Your cart: ");
        shoppingCart.cartInformation();
        System.out.println("You have " + coupons.size() + " coupons. Would you like to use one? (Y/N)");
        Scanner scanner = new Scanner(System.in);
        String choice = scanner.nextLine();
        if (choice.equalsIgnoreCase("Y")) {
            System.out.println("Enter coupon code: (a 6-digit number)");
            int couponCode = scanner.nextInt();
            Coupon coupon = couponExists(couponCode);
            if (coupon != null) {
                shoppingCart.applyCoupon(coupon);
                coupons.remove(coupon);
            }
            else {
                System.out.println("Invalid coupon code. Please try again.");
            }
        }
        System.out.println("Total price: " + shoppingCart.getTotalPrice());
        System.out.println("Confirm checkout? (Y/N)");
        scanner = new Scanner(System.in);
        choice = scanner.nextLine();
        if (choice.equalsIgnoreCase("Y")) {
            System.out.println("Order confirmed.");
            System.out.println("===============");
            while (payment() == 1) {
                System.out.println("===============");
            }
        }
        else {
            System.out.println("Order cancelled.");
        }

    }

    public void rateUs() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("How would you rate our services? (1-5)");
        int rating = scanner.nextInt();
        if (rating < 1 || rating > 5) {
            System.out.println("Invalid rating. Please try again.");
            return;
        }
        System.out.println("Enter your feedback: ");
        scanner = new Scanner(System.in);
        String feedback = scanner.nextLine();
        Feedback newFeedback = new Feedback(generateRatingID(), ID, rating, feedback);
        AppInventory.addFeedback(newFeedback);
        System.out.println("Thank you for your feedback!");
    }

    private int generateRatingID() {
        return nextRatingID++;
    }


    public int payment() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Proceeding to payment...");
        System.out.println("Enter credit card name: ");
        String enteredCreditCardName = scanner.nextLine();
        System.out.println("Enter credit card number: ");
        String enteredCreditCardNumber = scanner.nextLine();
        System.out.println("Enter credit card expiration date: ");
        String enteredCreditCardExpirationDate = scanner.nextLine();
        System.out.println("Enter credit card security code: ");
        String enteredCreditCardSecurityCode = scanner.nextLine();
        if (enteredCreditCardName.equals(creditCardName) && enteredCreditCardNumber.equals(creditCardNumber) && enteredCreditCardExpirationDate.equals(creditCardExpirationDate) && enteredCreditCardSecurityCode.equals(creditCardSecurityCode)) {
            System.out.println("Payment successful.");
            System.out.println("===============");
            System.out.println("Proceeding to order confirmation...");
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String cryptedCardNumber = creditCardNumber.substring(0, 4) + "********" + creditCardNumber.substring(creditCardNumber.length() - 4);
            Order order = new Order(generateOrderID(), (String) dateFormat.format(System.currentTimeMillis()), cryptedCardNumber, ID, shoppingCart.getCartItems(), shoppingCart.getTotalPrice());
            AppInventory.addOrder(order);
            System.out.println("Order confirmed.");
            System.out.println("===============");
            System.out.println("Your order information: ");
            order.orderInformation();
            System.out.println("Proceeding to order history...");
            orderHistory.addOrder(order);
            System.out.println("Order added to order history.");
            System.out.println("===============");
            System.out.println("Proceeding to inventory...");
            for (Item item : shoppingCart.getCartItems()) {
                Product product = AppInventory.getProducts().get(item.getID());
                product.setQuantity(product.getQuantity() - item.getQuantity());
            }
            System.out.println("Inventory updated.");
            System.out.println("===============");
            shoppingCart = new Cart();
            System.out.println("Would you like to rate us? (Y/N)");
            String choice = scanner.nextLine();
            if (choice.equalsIgnoreCase("Y")) {
                rateUs();
            }
            System.out.println("===============");
            System.out.println("Thank you for shopping with us!");
            System.out.println("===============");
            return 0;
        }
        else {
            System.out.println("Payment failed. Please try again.");
            return 1;
        }
    }

    void suggestProductByCategory(String typeProduct) {
        System.out.println("Here are some" + typeProduct + " products that you might like: ");
        ArrayList<Product> products = AppInventory.getProducts();
        ArrayList<Product> randomProducts = new ArrayList<Product>();
        int randomIndex;
        for (int i = 0; i < 3; i++) {
            Product p;
            do {
                randomIndex = (int) (Math.random() * products.size());
                p = AppInventory.getProducts().get(randomIndex);
            } while (!p.getClass().getName().equals(typeProduct));
            randomProducts.add(p);
        }
        for (Product product : randomProducts) {
            product.productInformation();
        }
        System.out.println("========");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Would you like to add one of these products to your cart? (Y/N)");
        String choice = scanner.nextLine();
        if (choice.equalsIgnoreCase("Y")) {
            addProductToCart();
        }
        System.out.println("Would you like to see other suggestions? (Y/N)");
        choice = scanner.nextLine();
        if (choice.equalsIgnoreCase("Y")) {
            suggestProductByCategory(typeProduct);
        }
        else {
            return;
        }

    }

    void searchProductByName(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the name of the product you would like to search: ");
        String name = scanner.nextLine();
        ArrayList<Product> products = AppInventory.getProducts();
        for (Product product : products) {
            if (product.getName().equalsIgnoreCase(name)) {
                product.productInformation();
                addProductToCart();
                System.out.println("Would you like to search for another product? (Y/N)");
                String choice = scanner.nextLine();
                if (choice.equalsIgnoreCase("Y")) {
                    searchProductByName();
                }
                else {
                    return;
                }
            }
        }
        System.out.println("Product not found. Please try again.");
    }

    public void dynamicSearchProducts(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the type of your product: ");
        System.out.println("1. Clothing");
        System.out.println("2. Electronic");
        System.out.println("3. Furniture");
        System.out.println("4. Exit");
        System.out.println("Enter your choice: ");
        int choice = util.getUserChoice();
        switch (choice) {
            case 1:
                suggestProductByCategory("Clothing");
                System.out.println("Would you like to search for a product by name? (Y/N)");
                String choice2 = scanner.nextLine();
                if (choice2.equalsIgnoreCase("Y")) {
                    searchProductByName();
                }
                break;
            case 2:
                suggestProductByCategory("Electronic");
                System.out.println("Would you like to search for a product by name? (Y/N)");
                String choice3= scanner.nextLine();
                if (choice3.equalsIgnoreCase("Y")) {
                    searchProductByName();
                }
                break;
            case 3:
                suggestProductByCategory("Furniture");
                System.out.println("Would you like to search for a product by name? (Y/N)");
                String choice4 = scanner.nextLine();
                if (choice4.equalsIgnoreCase("Y")) {
                    searchProductByName();
                }
                break;
            case 4:
                return;
            default:
                System.out.println("Invalid choice. Please try again.");
                break;
        }
    }

    private int generateOrderID() {
        return nextOrderID++;
    }

    public Coupon couponExists(int couponCode) {
        for (Coupon coupon : coupons) {
            if (coupon.getID() == couponCode) {
                return coupon;
            }
        }
        return null;
    }

    public void viewCoupons() {
        if (coupons.isEmpty()) {
            System.out.println("No coupons available.");
            return;
        }
        for (Coupon coupon : coupons) {
            coupon.couponInformation();
        }
    }

    public void customerInformationForAdmin() {
        System.out.println("Customer ID: " + ID);
        System.out.println("Username: " + username);
        System.out.println("Password: " + password);
        System.out.println("First Name: " + firstName);
        System.out.println("Last Name: " + lastName);
        System.out.println("Credit Card Number: " + creditCardNumber);
        System.out.println("Credit Card Expiration Date: " + creditCardExpirationDate);
        System.out.println("Credit Card Security Code: " + creditCardSecurityCode);
        System.out.println("Credit Card Name: " + creditCardName);
        System.out.println("Orders History: ");
        orderHistory.viewOrderHistory();
        System.out.println("coupons: ");
        for (Coupon coupon : coupons) {
            System.out.println(coupon.getID());
        }
        System.out.println("===============");
    }

    public void customerInformationForCustomer() {
        System.out.println("Username: " + username);
        System.out.println("First Name: " + firstName);
        System.out.println("Last Name: " + lastName);
        System.out.println("Credit Card Number: " + creditCardNumber.substring(0, 4) + "********" + creditCardNumber.substring(creditCardNumber.length() - 4));
        System.out.println("Credit Card Name: " + creditCardName);
        System.out.println("===============");
    }

    public void customerMenu() {
        Scanner scanner = new Scanner(System.in);
        int choice;
        System.out.println("Welcome, " + firstName + " " + lastName + "!");
        do {
            System.out.println("===== Customer Menu =====");
            System.out.println("1. Search Products");
            System.out.println("2. Add Product to Cart");
            System.out.println("3. View Cart");
            System.out.println("4. Checkout");
            System.out.println("5. View Orders History");
            System.out.println("6. View Coupons");
            System.out.println("7. Customer Information");
            System.out.println("8. Rate Us");
            System.out.println("0. Exit");

            System.out.println("Enter your choice: ");
            choice = util.getUserChoice();

            switch (choice) {
                case 1:
                    dynamicSearchProducts();
                    break;
                case 2:
                    addProductToCart();
                    break;
                case 3:
                    shoppingCart.cartInformation();
                    break;
                case 4:
                    checkout();
                    break;
                case 5:
                    orderHistory.viewOrderHistory();
                    break;
                case 6:
                    viewCoupons();
                    break;
                case 7:
                    customerInformationForCustomer();
                    break;
                case 8:
                    rateUs();
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        } while (choice != 0);
    }
}
