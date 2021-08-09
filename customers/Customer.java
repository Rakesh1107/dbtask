package customers;

import data.DataCollector;

public class Customer {

    private int userId;
    private String holderName;
    private int mobileNumber;
    private String address;

    public int getUserId() {
        return userId;
    }

    public String getHolderName() {
        return holderName;
    }

    public int getMobileNumber() {
        return mobileNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setHolderName(String holderName) {
        this.holderName = holderName;
    }

    public void setMobileNumber(int mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
