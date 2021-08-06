package connection;

import data.DataCollector;

import result.Result;

import java.sql.*;

public class Connector {

    public static Connection connect() throws SQLException {
        Connection connection = ConnectionMaker.getConnection();
        ResultSet accounts = Result.getAccounts(connection);
        ResultSet customers = Result.getCustomers(connection);

        while (accounts.next()) {
            DataCollector.addAccount(accounts);
        }

        while (customers.next()) {
            DataCollector.addCustomer(customers);
        }

        return connection;
    }
}

