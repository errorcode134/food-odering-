package model;

import interfaces.StatusUpdatable;

public class Order implements StatusUpdatable {
    private String orderID;
    private String orderStatus;
    private double totalAmount;
    private String deliveryAddress;
    private Payment payment;

    public Order(String orderID, double totalAmount, String deliveryAddress) {
        this.orderID = orderID;
        this.totalAmount = totalAmount;
        this.deliveryAddress = deliveryAddress;
        this.orderStatus = "Received";
        this.payment = new Payment("PAY-" + orderID, totalAmount, "COD");
    }

    public String getOrderID() { return orderID; }
    public void setOrderID(String orderID) { this.orderID = orderID; }
    public String getOrderStatus() { return orderStatus; }
    public void setOrderStatus(String orderStatus) { this.orderStatus = orderStatus; }
    public double getTotalAmount() { return totalAmount; }
    public void setTotalAmount(double totalAmount) { this.totalAmount = totalAmount; }
    public String getDeliveryAddress() { return deliveryAddress; }
    public void setDeliveryAddress(String deliveryAddress) { this.deliveryAddress = deliveryAddress; }
    public Payment getPayment() { return payment; }

    public void confirmOrder() {
        orderStatus = "Confirmed";
        System.out.println("Order confirmed.");
    }

    public void cancelOrder() {
        if (orderStatus.equals("Received") || orderStatus.equals("Confirmed")) {
            orderStatus = "Cancelled";
            System.out.println("Order cancelled.");
        } else {
            System.out.println("This order can no longer be cancelled.");
        }
    }

    @Override
    public void updateStatus(String status) {
        orderStatus = status;
    }
}
