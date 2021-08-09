package data;

import accounts.Account;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataStorage {

    static Map<Integer, HashMap<Integer, Account>> userAccounts = new HashMap<>();
    static List<Integer> customerIds = new ArrayList<>();

    public static List<Integer> getCustomers() {
        return customerIds;
    }

    public static Map<Integer, HashMap<Integer, Account>> getAccounts() {
        return userAccounts;
    }


}
