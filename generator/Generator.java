package generator;

import data.DataStorage;

public class Generator {
    public static int generateAccountNumber() {
        int newAccountNumber = (int) ((Math.random()*99999999) + 10000000);

        while(DataStorage.getAccounts().containsKey(newAccountNumber)) {
            newAccountNumber = (int) ((Math.random()*99999999) + 10000000);
        }
        return newAccountNumber;
    }

    public static int generateUserId() {
        int newUserId = (int) ((Math.random()*99999999) + 10000000);
        while(DataStorage.getAccounts().containsKey(newUserId)) {
            newUserId = (int) ((Math.random()*99999999) + 10000000);
        }
        return newUserId;
    }
}
