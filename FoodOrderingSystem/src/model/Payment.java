package model;

public class Payment {
    private String paymentID;
    private double amount;
    private String method;
    private String status;

    public Payment(String paymentID, double amount, String method) {
        this.paymentID = paymentID;
        this.amount = amount;
        this.method = method;
        this.status = "Pending";
    }

    public String getPaymentID() { return paymentID; }
    public void setPaymentID(String paymentID) { this.paymentID = paymentID; }
    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }
    public String getMethod() { return method; }
    public void setMethod(String method) { this.method = method; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public boolean processOnlinePayment() {
        if (amount > 0) {
            status = "Paid";
            System.out.println("Online payment successful.");
            return true;
        }
        status = "Failed";
        return false;
    }

    public void processCOD() {
        status = "Pay on Delivery";
        System.out.println("Cash on Delivery selected.");
    }

    public boolean refundPayment() {
        if (status.equals("Paid")) {
            status = "Refunded";
            return true;
        }
        return false;
    }
}
