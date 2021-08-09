package data;

import accounts.Account;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class DataCollector {

    public static void addAccount(ResultSet resultSet) throws SQLException {
        Account account = createAccount(resultSet);
        int userId = resultSet.getInt(2);
        int accountNumber = resultSet.getInt(3);

        if(DataStorage.getAccounts().containsKey(userId)) {
            Map<Integer, Account> newAccount = DataStorage.getAccounts().get(userId);
            newAccount.put(accountNumber, account);
        }
        else {
            DataStorage.getAccounts().put(userId, new HashMap<>());
            DataStorage.getAccounts().get(userId).put(accountNumber, account);
        }
    }

    public static void addCustomer(ResultSet customers) throws SQLException {
        int userId = customers.getInt(1);
        DataStorage.getCustomers().add(userId);
    }

    // helper method
    public static Account createAccount(ResultSet resultSet) throws SQLException {
        int userId = resultSet.getInt(2);
        int accountNumber = resultSet.getInt(3);
        int balance = resultSet.getInt(4);
        String branch = resultSet.getString(5);

        Account account = new Account();
        account.setUserId(userId);
        account.setAccountNumber(accountNumber);
        account.setBalance(balance);
        account.setBranch(branch);

        return account;
    }
}
