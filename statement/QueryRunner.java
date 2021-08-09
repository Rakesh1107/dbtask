package statement;

import java.io.IOException;
import java.sql.Connection;


public class QueryRunner {

    public static void runQuery(Connection connection, int option) throws IOException {
        switch (option) {
            case 1:
                Query.createNewUser(connection);
                break;
            case 2:
                Query.createNewAccount(connection);
                break;
            case 3:
                Query.checkBalance();
                break;
            case 4:
                Query.getAccounts();
                break;

            default:
                System.out.println("Enter valid option");
        }
    }



}
