package model;

import interfaces.StatusUpdatable;

public class DeliveryRider extends User implements StatusUpdatable {
    private String vehicleNumber;
    private boolean available;
    private double cashCollected;

    public DeliveryRider(String id, String name, String email, String phone, String vehicleNumber) {
        super(id, name, email, phone);
        this.vehicleNumber = vehicleNumber;
        this.available = true;
        this.cashCollected = 0.0;
    }

    public String getVehicleNumber() { return vehicleNumber; }
    public void setVehicleNumber(String vehicleNumber) { this.vehicleNumber = vehicleNumber; }
    public boolean isAvailable() { return available; }
    public void setAvailable(boolean available) { this.available = available; }
    public double getCashCollected() { return cashCollected; }
    public void setCashCollected(double cashCollected) { this.cashCollected = cashCollected; }

    public void acceptAssignment(String orderID) {
        if (available) {
            available = false;
            System.out.println("Rider accepted delivery for " + orderID);
        } else {
            System.out.println("Rider is not available.");
        }
    }

    public void markDelivered(String orderID) {
        available = true;
        System.out.println("Order " + orderID + " has been delivered.");
    }

    @Override
    public void updateStatus(String status) {
        System.out.println("Rider status updated: " + status);
    }

    @Override
    public String getRole() { return "DeliveryRider"; }

    @Override
    public void displayProfile() {
        super.displayProfile();
        System.out.println("Role: " + getRole() + " | Vehicle: " + vehicleNumber);
    }
}
