package controller;

import model.*;

public class OrderManagementController {
    private String sessionToken;
    private MenuItem[] menu;
    private Order[] orders;
    private int orderCount;

    public OrderManagementController() {
        sessionToken = "SESSION-001";
        menu = new MenuItem[] {
            new MenuItem("M01", "Zinger Burger", 450, "Fast Food"),
            new MenuItem("M02", "Chicken Pizza", 1200, "Pizza"),
            new MenuItem("M03", "Fries", 250, "Sides"),
            new MenuItem("M04", "Cold Drink", 100, "Drinks")
        };
        orders = new Order[100];
        orderCount = 0;
    }

    public String getSessionToken() { return sessionToken; }
    public void setSessionToken(String sessionToken) { this.sessionToken = sessionToken; }
    public MenuItem[] getMenu() { return menu; }

    public void displayMenu() {
        System.out.println("\\n----- FOOD MENU -----");
        for (int i = 0; i < menu.length; i++) System.out.println((i + 1) + ". " + menu[i]);
    }

    public MenuItem findMenuItem(int choice) {
        if (choice >= 1 && choice <= menu.length) return menu[choice - 1];
        return null;
    }

    public MenuItem[] handleMenuSearch(String keyword) {
        MenuItem[] found = new MenuItem[menu.length];
        int index = 0;
        for (int i = 0; i < menu.length; i++) {
            if (menu[i].getItemName().toLowerCase().contains(keyword.toLowerCase())) {
                found[index] = menu[i];
                index++;
            }
        }
        return found;
    }

    public Order executeOrderCheckout(Cart cart, PromoCode promo, String address, String method) {
        if (address == null || address.trim().isEmpty() || cart.getItemCount() == 0) {
            System.out.println("Error: Enter an address and add at least one item.");
            return null;
        }

        double total = cart.calculateTotal();
        if (promo != null && promo.validateCode()) total = promo.applyDiscount(total);

        Order order = new Order("ORD-" + (orderCount + 1), total, address);
        Payment payment = order.getPayment();
        payment.setAmount(total);
        payment.setMethod(method);

        if (method.equalsIgnoreCase("Online")) {
            if (!payment.processOnlinePayment()) {
                System.out.println("Payment failed.");
                return null;
            }
        } else {
            payment.processCOD();
        }

        order.confirmOrder();
        if (orderCount < orders.length) {
            orders[orderCount] = order;
            orderCount++;
        }
        System.out.println("Order placed successfully. Order ID: " + order.getOrderID());
        System.out.println("Final amount: Rs. " + total);
        return order;
    }

    public Order searchOrder(String orderID) {
        for (int i = 0; i < orderCount; i++) {
            if (orders[i].getOrderID().equalsIgnoreCase(orderID)) return orders[i];
        }
        return null;
    }

    public void displayOrderStatus(String orderID) {
        Order order = searchOrder(orderID);
        if (order != null) {
            System.out.println("Order: " + order.getOrderID() + " | Status: " + order.getOrderStatus()
                    + " | Amount: Rs. " + order.getTotalAmount());
        } else {
            System.out.println("Order not found.");
        }
    }

    public void cancelOrder(String orderID) {
        Order order = searchOrder(orderID);
        if (order != null) order.cancelOrder();
        else System.out.println("Order not found.");
    }

    public int countOrders(Order[] orderArray) {
        int count = 0;
        for (int i = 0; i < orderArray.length; i++) {
            if (orderArray[i] != null) count++;
        }
        return count;
    }

    public double calculateAverageOrderValue() {
        if (orderCount == 0) return 0;
        double total = 0;
        for (int i = 0; i < orderCount; i++) total += orders[i].getTotalAmount();
        return total / orderCount;
    }

    public Order[] getOrders() { return orders; }
    public int getOrderCount() { return orderCount; }
}
