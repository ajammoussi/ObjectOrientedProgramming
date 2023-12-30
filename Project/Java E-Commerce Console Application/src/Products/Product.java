package Products;

public abstract class Product {
    protected int ID;
    protected String name;
    protected double price;
    protected String manufacturer;
    protected int quantity;

    public Product(int ID, String name, String manufacturer, double price, int quantity) {
        this.ID = ID;
        this.name = name;
        this.manufacturer = manufacturer;
        this.price = price;
        this.quantity = quantity;
    }

    public Product() {

    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void productInformation(){
        System.out.println("Product ID: " + ID);
        System.out.println("Product Name: " + name);
        System.out.println("Product Manufacturer: " + manufacturer);
        System.out.println("Product Price: " + price);
        System.out.println("Product Quantity In Inventory: " + quantity);
        System.out.println("===============");
    }

}
