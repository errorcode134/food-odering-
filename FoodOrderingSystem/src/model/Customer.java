package model;

public class Customer extends User {
    private String deliveryAddress;
    private int loyaltyPoints;
    private String preferredPayment;

    public Customer() {
        super();
        deliveryAddress = "";
        loyaltyPoints = 0;
        preferredPayment = "COD";
    }

    public Customer(String id, String name, String email, String phone,
                    String deliveryAddress, int loyaltyPoints) {
        super(id, name, email, phone);
        this.deliveryAddress = deliveryAddress;
        this.loyaltyPoints = loyaltyPoints;
        this.preferredPayment = "COD";
    }

    public String getDeliveryAddress() { return deliveryAddress; }
    public void setDeliveryAddress(String deliveryAddress) { this.deliveryAddress = deliveryAddress; }
    public int getLoyaltyPoints() { return loyaltyPoints; }
    public void setLoyaltyPoints(int loyaltyPoints) { this.loyaltyPoints = loyaltyPoints; }
    public String getPreferredPayment() { return preferredPayment; }
    public void setPreferredPayment(String preferredPayment) { this.preferredPayment = preferredPayment; }

    public Order placeOrder(Cart cart) {
        return new Order("ORD-" + System.currentTimeMillis(), cart.calculateTotal(), deliveryAddress);
    }

    public String trackOrder(String orderID) {
        return "Tracking request for order: " + orderID;
    }

    @Override
    public String getRole() {
        return "Customer";
    }

    @Override
    public void displayProfile() {
        super.displayProfile();
        System.out.println("Role: " + getRole() + " | Address: " + deliveryAddress);
    }
}
