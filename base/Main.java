package base;

import runner.BankRunner;

import java.io.IOException;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws IOException, SQLException {
	    BankRunner bankRunner = new BankRunner();
	    bankRunner.run();
    }
}
