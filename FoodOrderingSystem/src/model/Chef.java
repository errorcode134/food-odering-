package model;

public class Chef extends User {
    private String stationID;
    private String shift;
    private int preparedOrders;

    public Chef(String id, String name, String email, String phone, String stationID) {
        super(id, name, email, phone);
        this.stationID = stationID;
        this.shift = "Day";
        this.preparedOrders = 0;
    }

    public String getStationID() { return stationID; }
    public void setStationID(String stationID) { this.stationID = stationID; }
    public String getShift() { return shift; }
    public void setShift(String shift) { this.shift = shift; }
    public int getPreparedOrders() { return preparedOrders; }
    public void setPreparedOrders(int preparedOrders) { this.preparedOrders = preparedOrders; }

    public void acceptOrder(String orderID) {
        System.out.println("Chef accepted order " + orderID);
    }

    public void updatePreparationStatus(String orderID, String status) {
        System.out.println("Order " + orderID + " preparation status: " + status);
        if (status.equalsIgnoreCase("Ready")) preparedOrders++;
    }

    @Override
    public String getRole() { return "Chef"; }

    @Override
    public void displayProfile() {
        super.displayProfile();
        System.out.println("Role: " + getRole() + " | Station: " + stationID);
    }
}
