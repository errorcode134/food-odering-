package model;

public class Report {
    private String reportName;
    private double totalSales;
    private int orderCount;

    public Report(String reportName, double totalSales, int orderCount) {
        this.reportName = reportName;
        this.totalSales = totalSales;
        this.orderCount = orderCount;
    }

    public String getReportName() { return reportName; }
    public void setReportName(String reportName) { this.reportName = reportName; }
    public double getTotalSales() { return totalSales; }
    public void setTotalSales(double totalSales) { this.totalSales = totalSales; }
    public int getOrderCount() { return orderCount; }
    public void setOrderCount(int orderCount) { this.orderCount = orderCount; }

    public void displayReport() {
        System.out.println(reportName + ": " + orderCount + " orders, total sales Rs. " + totalSales);
    }
}
