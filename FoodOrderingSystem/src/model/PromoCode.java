package model;

public class PromoCode {
    private String code;
    private double discountRate;
    private String expiryDate;
    private boolean active;

    public PromoCode(String code, double discountRate, String expiryDate) {
        this.code = code;
        this.discountRate = discountRate;
        this.expiryDate = expiryDate;
        this.active = true;
    }

    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }
    public double getDiscountRate() { return discountRate; }
    public void setDiscountRate(double discountRate) { this.discountRate = discountRate; }
    public String getExpiryDate() { return expiryDate; }
    public void setExpiryDate(String expiryDate) { this.expiryDate = expiryDate; }
    public boolean isActive() { return active; }
    public void setActive(boolean active) { this.active = active; }

    public boolean validateCode() {
        return active && discountRate > 0 && discountRate <= 1
                && code != null && code.length() > 0;
    }

    public double applyDiscount(double total) {
        if (validateCode()) return total - (total * discountRate);
        return total;
    }
}
