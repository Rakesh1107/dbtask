package tester;

import connection.Connector;
import statement.QueryRunner;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.SQLException;

public class Tester {
    static BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in));

    public static void tester() throws IOException, SQLException {
        Connection connection = Connector.connect();
        int option = getOption();
        QueryRunner.runQuery(connection, option);
        connection.close();
    }

    private static int getOption() throws IOException {
        System.out.println("dummy");
            System.out.println("1. New User? ->");
            System.out.println("2. Existing User? Create new account ->");
            System.out.println("3. Check Balance ->");
            int option = Integer.parseInt(inputReader.readLine());
            return option;
    }
}
