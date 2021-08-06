package data;

import accounts.Account;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataStorage {

    static Map<Integer, HashMap<Integer, Account>> userAccounts = DataCollector.getUserAccounts();
    static List<Integer> customerIds = new ArrayList<>();

    public static long getBalance(Map<Integer, Account> accountDetailsMap) {
        long totalBalance = 0;

        for (Account accountDetails: accountDetailsMap.values()) {
            totalBalance+=accountDetails.getBalance();
        }

        return totalBalance;
    }

    public static void find(int userid) {
        if(userAccounts.containsKey(userid)) {
            Map<Integer, Account> account = userAccounts.get(userid);
            long balance = getBalance(account);
            System.out.println("Your total balance is " + balance);
        }

        else {
            System.out.println("User not found");
        }
    }

    public static List<Integer> getCustomers() {
        return customerIds;
    }


}
