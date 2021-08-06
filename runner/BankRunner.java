package runner;


import tester.Tester;

import java.io.IOException;
import java.sql.SQLException;

public class BankRunner {

    public void run() throws IOException, SQLException {
        Tester.tester();
    }
}
