package model;

public abstract class User {
    private String userID;
    private String name;
    private String email;
    private String phone;

    public User() {
        this("U000", "Unknown", "unknown@email.com", "0000000000");
    }

    public User(String userID, String name, String email, String phone) {
        this.userID = userID;
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public String getUserID() { return userID; }
    public void setUserID(String userID) { this.userID = userID; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public boolean login() {
        return email != null && email.contains("@");
    }

    public boolean logout() {
        return true;
    }

    public void displayProfile() {
        System.out.println("ID: " + userID + " | Name: " + name + " | Email: " + email);
    }

    public abstract String getRole();
}
