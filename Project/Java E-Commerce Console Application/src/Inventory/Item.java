package Inventory;

import Products.Product;

public class Item {
    private int ID;
    private Product product;
    private int quantity;
    private double itemPrice;

    public Item(int ID, Product product, int quantity) {
        this.ID = ID;
        this.product = product;
        this.quantity = quantity;
        this.itemPrice = product.getPrice() * quantity;
    }

    public Item() {

    }

    public int getID() {
        return ID;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
        setItemPrice();
    }

    public void setItemPrice() {
        this.itemPrice = product.getPrice() * quantity;
    }

    public void itemInformation() {
        product.productInformation();
        System.out.println("Product Quantity: " + quantity);
        System.out.println("Item Price: " + itemPrice);
        System.out.println("==============");
    }
}
