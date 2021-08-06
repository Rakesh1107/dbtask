package statement;

import accounts.Account;
import customers.Customer;
import data.DataStorage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class QueryRunner {

    static BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in));

    public static void createNewAccount(Connection connection) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into accounts (userid, acc_no, balance, branch) values(?,?,?,?)");
            System.out.println("Enter user id: ");
            int userId = Integer.parseInt(inputReader.readLine());

            if(DataStorage.getCustomers().contains(userId)) {
                preparedStatement.setInt(1, userId);
                long accountNumber = Account.generateAccountNumber();
                preparedStatement.setLong(2, accountNumber);
                preparedStatement.setLong(3, 0);
                System.out.println("Enter branch: ");
                String branch = inputReader.readLine();
                preparedStatement.setString(4, branch);
                preparedStatement.executeUpdate();
                System.out.println("Created a new account for " + userId + " at branch " + branch);
                System.out.println("Your new account number is " + accountNumber);
            }
            else {
                System.out.println("User id doesn't exist");
            }

        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void runQuery(Connection connection, int option) throws  IOException {
        if(option == 1) {
            createNewUser(connection);
        }
        else if(option == 2) {
            createNewAccount(connection);
        }
        else if(option == 3) {
            checkBalance();
        }

    }

    private static void checkBalance() throws IOException {
        System.out.println("Enter your user id: ");
        int userId = Integer.parseInt(inputReader.readLine());
        DataStorage.find(userId);
    }

    private static void createNewUser(Connection connection) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into customers (userid, name, mobile, address) values(?,?,?,?)");

            int userId = Customer.generateUserId();
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
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }


}
