package Inventory;

import java.util.ArrayList;

public class OrderHistory {
    private ArrayList<Order> orders;

    public OrderHistory() {
        orders = new ArrayList<Order>();
    }

    public ArrayList<Order> getOrders() {
        return orders;
    }

    public void addOrder(Order order) {
        orders.add(order);
    }

    public void viewOrderHistory() {
        if (orders == null || orders.isEmpty()) {
            System.out.println("Order list is empty");
            return;
        }
        for (Order order : orders) {
            order.orderInformation();
        }
        System.out.println("==========================");
    }

}
