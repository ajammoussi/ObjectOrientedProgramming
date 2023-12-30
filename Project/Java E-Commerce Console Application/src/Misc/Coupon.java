package Misc;

public class Coupon {
    private int code;
    private String name;
    private double discount;
    private String description;

    public Coupon(int code, String name, double discount, String description) {
        this.code = code;
        this.name = name;
        this.discount = discount;
        this.description = description;
    }

    public Coupon() {


    }

    public int getID() {
        return code;
    }

    public String getName() {
        return name;
    }

    public double getDiscount() {
        return discount;
    }

    public String getDescription() {
        return description;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setName(String name) {
        this.name = name;
    }

    //discount is a percentage
    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void couponInformation() {
        System.out.println("Coupon ID: " + code);
        System.out.println("Coupon Name: " + name);
        System.out.println("Coupon Discount: " + discount);
        System.out.println("Coupon Description: " + description);
        System.out.println("==============");
    }

}
