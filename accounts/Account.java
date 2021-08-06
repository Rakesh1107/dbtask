package accounts;

import data.DataCollector;


public class Account {

    private long accountNumber;
    private int userId;
    private long balance;
    private String branch;

    public static int generateAccountNumber() {
        int newAccountNumber = (int) ((Math.random()*99999999) + 10000000);

        while(DataCollector.getUserAccounts().containsKey(newAccountNumber)) {
            newAccountNumber = (int) ((Math.random()*99999999) + 10000000);
        }

        return newAccountNumber;
    }
    public long getAccountNumber() {
        return accountNumber;
    }

    public int getUserId() {
        return userId;
    }

    public long getBalance() {
        return balance;
    }

    public String getBranch() {
        return branch;
    }


    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String toString() {
        return getUserId() + " " + getAccountNumber() + " " + getBalance() + " " + getBranch();
    }
}
