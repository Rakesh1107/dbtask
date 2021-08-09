package statement;

import accounts.Account;
import data.DataStorage;
import generator.Generator;
import output.Finder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.HashMap;
import java.util.Map;

public class Query {

    static BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in));

    static void createNewUser(Connection connection) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into customers (userid, name, mobile, address) values(?,?,?,?)");

            int userId = Generator.generateUserId();
            preparedStatement.setInt(1, userId);
            System.out.println("Enter your name: ");
            String name = inputReader.readLine();
            preparedStatement.setString(2, name);
            System.out.println("Enter your mobile number: ");
            int mobileNumber = Integer.parseInt(inputReader.readLine());
            preparedStatement.setInt(3, mobileNumber);
            System.out.println("Enter your address: ");
            String address = inputReader.readLine();
            preparedStatement.setString(4, address);
            preparedStatement.executeUpdate();
            System.out.println("Hi " + name + ", Thanks for joining our community. New User id created");
            System.out.println("Your user id is " + userId + ". You can start creating accounts with us!");

            addToUsers(userId);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void createNewAccount(Connection connection) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into accounts (userid, acc_no, balance, branch) values(?,?,?,?)");
            System.out.println("Enter user id: ");
            int userId = Integer.parseInt(inputReader.readLine());

            if(DataStorage.getCustomers().contains(userId)) {
                preparedStatement.setInt(1, userId);
                long accountNumber = Generator.generateAccountNumber();
                preparedStatement.setLong(2, accountNumber);
                preparedStatement.setLong(3, 0);
                System.out.println("Enter branch: ");
                String branch = inputReader.readLine();
                preparedStatement.setString(4, branch);
                preparedStatement.executeUpdate();
                System.out.println("Created a new account for " + userId + " at branch " + branch);
                System.out.println("Your new account number is " + accountNumber);

                addToAccounts(userId, accountNumber, branch);

            }
            else {
                System.out.println("User id doesn't exist");
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void checkBalance() throws IOException {
        System.out.println("Enter your user id: ");
        int userId = Integer.parseInt(inputReader.readLine());
        Finder.find(userId);
    }

    static void getAccounts() throws IOException {
        System.out.println("Enter your user id");
        int userId = Integer.parseInt(inputReader.readLine());
        if(DataStorage.getCustomers().contains(userId)) {
            if(DataStorage.getAccounts().containsKey(userId)) {
                for(Account account: DataStorage.getAccounts().get(userId).values()) {

                    System.out.println(account);
                }
            }
            else {
                System.out.println("You don't have an account");
            }
        }
        else {
            System.out.println("User id doesn't exist");
        }
    }

    // Adding to DataStorage class on successful addition of records to database

    private static void addToAccounts(int userId, long accountNumber, String branch) {
        Map<Integer, Account> accounts = DataStorage.getAccounts().getOrDefault(userId, new HashMap<>());

        Account account = new Account();
        account.setUserId(userId);
        account.setAccountNumber(accountNumber);
        account.setBranch(branch);

        accounts.put(userId, account);
    }

    private static void addToUsers(int userId) {
        DataStorage.getCustomers().add(userId);
    }

}
