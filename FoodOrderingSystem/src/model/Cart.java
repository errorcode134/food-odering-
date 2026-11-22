package model;

public class Cart {
    private String cartID;
    private MenuItem[] items;
    private int itemCount;

    public Cart(String cartID) {
        this.cartID = cartID;
        items = new MenuItem[20];
        itemCount = 0;
    }

    public String getCartID() { return cartID; }
    public void setCartID(String cartID) { this.cartID = cartID; }
    public int getItemCount() { return itemCount; }
    public MenuItem[] getItems() { return items; }

    public void addItem(MenuItem item) {
        if (item != null && item.checkAvailability() && itemCount < items.length) {
            items[itemCount] = item;
            itemCount++;
            System.out.println(item.getItemName() + " added to cart.");
        } else {
            System.out.println("Item cannot be added.");
        }
    }

    public void addItem(MenuItem item, int quantity) {
        if (quantity > 0) {
            for (int i = 0; i < quantity && itemCount < items.length; i++) addItem(item);
        }
    }

    public void removeItem(MenuItem item) {
        for (int i = 0; i < itemCount; i++) {
            if (items[i] == item) {
                for (int j = i; j < itemCount - 1; j++) items[j] = items[j + 1];
                items[itemCount - 1] = null;
                itemCount--;
                return;
            }
        }
    }

    public double calculateTotal() {
        double total = 0;
        for (int i = 0; i < itemCount; i++) total = total + items[i].getPrice();
        return total;
    }

    public int countAvailable(MenuItem[] menu) {
        int count = 0;
        for (int i = 0; i < menu.length; i++) {
            if (menu[i] != null && menu[i].checkAvailability()) count++;
        }
        return count;
    }

    public void displayCart() {
        if (itemCount == 0) System.out.println("Your cart is empty.");
        for (int i = 0; i < itemCount; i++) System.out.println((i + 1) + ". " + items[i]);
        System.out.println("Cart total: Rs. " + calculateTotal());
    }
}
