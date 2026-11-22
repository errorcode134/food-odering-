package model;

public class MenuItem {
    private String itemID;
    private String itemName;
    private double price;
    private String category;
    private boolean available;

    public MenuItem(String itemID, String itemName, double price, String category) {
        this.itemID = itemID;
        this.itemName = itemName;
        this.price = price;
        this.category = category;
        this.available = true;
    }

    public String getItemID() { return itemID; }
    public void setItemID(String itemID) { this.itemID = itemID; }
    public String getItemName() { return itemName; }
    public void setItemName(String itemName) { this.itemName = itemName; }
    public double getPrice() { return price; }
    public void setPrice(double price) { if (price >= 0) this.price = price; }
    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }
    public boolean isAvailable() { return available; }
    public void setAvailable(boolean available) { this.available = available; }

    public void updatePrice(double newPrice) {
        if (newPrice > 0) price = newPrice;
    }

    public boolean checkAvailability() {
        return available && price > 0;
    }

    @Override
    public String toString() {
        return itemID + " - " + itemName + " (" + category + ") Rs. " + price;
    }
}
