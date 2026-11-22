package model;

public class Administrator extends User {
    private String department;
    private String accessLevel;
    private int reportsGenerated;

    public Administrator(String id, String name, String email, String phone, String department) {
        super(id, name, email, phone);
        this.department = department;
        this.accessLevel = "Full";
        this.reportsGenerated = 0;
    }

    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }
    public String getAccessLevel() { return accessLevel; }
    public void setAccessLevel(String accessLevel) { this.accessLevel = accessLevel; }
    public int getReportsGenerated() { return reportsGenerated; }
    public void setReportsGenerated(int reportsGenerated) { this.reportsGenerated = reportsGenerated; }

    public void manageUserAccounts() {
        System.out.println("Administrator is managing user accounts.");
    }

    public Report generateSalesReport(double sales, int orderCount) {
        reportsGenerated++;
        return new Report("Sales Report", sales, orderCount);
    }

    @Override
    public String getRole() { return "Administrator"; }

    @Override
    public void displayProfile() {
        super.displayProfile();
        System.out.println("Role: " + getRole() + " | Department: " + department);
    }
}
