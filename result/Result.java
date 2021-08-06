package result;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Result {
    public static ResultSet getAccounts(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from accounts");
        return resultSet;
    }

    public static ResultSet getCustomers(Connection connection) throws  SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from customers");
        return resultSet;
    }
}
