package accounts;

public class Account {

    private long accountNumber;
    private int userId;
    private long balance;
    private String branch;

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
        return "User id: " + getUserId() +
                "\nAccount Number: " + getAccountNumber() +
                "\nTotal Balance: " + getBalance() +
                "\nBranch: " + getBranch() +
                "\n-------------------------------------";
    }
}
