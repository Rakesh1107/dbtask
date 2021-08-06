package data;

import accounts.Account;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class DataCollector {
    static Map<Integer, HashMap<Integer, Account>> userAccounts = new HashMap<>();

    public static Account createAccount(ResultSet resultSet) throws SQLException {
        int accountNumber = resultSet.getInt(3);
        int balance = resultSet.getInt(4);
        String branch = resultSet.getString(5);

        Account account = new Account();
        account.setAccountNumber(accountNumber);
        account.setBalance(balance);
        account.setBranch(branch);

        return account;
    }
    public static void addAccount(ResultSet resultSet) throws SQLException {
        Account account = createAccount(resultSet);

        int userId = resultSet.getInt(2);
        int accountNumber = resultSet.getInt(3);

        if(userAccounts.containsKey(userId)) {
            Map<Integer, Account> newAccount = userAccounts.get(userId);
            newAccount.put(accountNumber, account);
        }

        else {
            userAccounts.put(userId, new HashMap<>());
            userAccounts.get(userId).put(accountNumber, account);
        }
    }

    public static Map<Integer, HashMap<Integer, Account>> getUserAccounts() {
        return userAccounts;
    }

    public static void addCustomer(ResultSet customers) throws SQLException {

        int userId = customers.getInt(1);

        DataStorage.getCustomers().add(userId);
    }
}
