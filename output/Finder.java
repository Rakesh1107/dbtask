package output;

import accounts.Account;
import data.DataStorage;

import java.util.Map;

public class Finder {
    public static long getBalance(Map<Integer, Account> accountDetailsMap) {
        long totalBalance = 0;

        for (Account accountDetails: accountDetailsMap.values()) {
            totalBalance+=accountDetails.getBalance();
        }

        return totalBalance;
    }

    public static void find(int userid) {
        if(DataStorage.getCustomers().contains(userid)) {
            if(DataStorage.getAccounts().containsKey(userid)) {
                Map<Integer, Account> account = DataStorage.getAccounts().get(userid);
                long balance = getBalance(account);
                System.out.println("Your total balance is " + balance);
            }
            else {
                System.out.println("You don't have an account");
            }
        }

        else {
            System.out.println("User not found");
        }
    }
}
