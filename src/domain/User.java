package domain;

import java.util.Date;
import storage.DatabaseFacade;

public class User {

    private int level;
    private Date creationDate;
    private Point pointBalance;
    private double amountSpentThisYear;
    private String name;
    private int userId;
    private String macaddress;
    private String email;
    private String tlf;
    private String address;

    public User() {

    }

    public User(int level, Date creationDate, Point pointBalance, double amountSpentThisYear, String name,
            int userId, String macaddress, String email, String tlf, String address) {
        this.level = level;
        this.creationDate = creationDate;
        this.pointBalance = pointBalance;
        this.amountSpentThisYear = amountSpentThisYear;
        this.name = name;
        this.userId = userId;
        this.macaddress = macaddress;
        this.email = email;
        this.tlf = tlf;
        this.address = address;
    }

    public void getUser(int userId) {

    }

    public void write() {
        DatabaseFacade databaseFacade = new DatabaseFacade();
        databaseFacade.writeUser();
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTlf() {
        return this.tlf;
    }

    public void setTlf(String tlf) {
        this.tlf = tlf;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMacadresse() {
        return this.macaddress;
    }

    public void setMacadresse(String macadresse) {
        this.macaddress = macadresse;
    }

    public int getUserId() {
        return this.userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAmountSpentThisYear() {
        return this.amountSpentThisYear;
    }

    public void setAmountSpentThisYear(double amountSpentThisYear) {
        this.amountSpentThisYear = amountSpentThisYear;
    }

    public Point getPointBalance() {
        return this.pointBalance;
    }

    public void setPointBalance(Point pointBalance) {
        this.pointBalance = pointBalance;
    }

    public Date getCreationDate() {
        return this.creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public int getLevel() {
        return this.level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
