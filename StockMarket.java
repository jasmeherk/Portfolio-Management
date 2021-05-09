package project.controllers;

import project.database.databaseConnection;
import project.delegates.LoginWindowDelegate;
import project.delegates.MainWindowDelegate;
import project.gui.*;
import project.models.Crypto;

public class StockMarket implements LoginWindowDelegate, MainWindowDelegate {
    private databaseConnection dbHandler = null;
    private LoginWindow loginWindow = null;

    public StockMarket() {
        dbHandler = new databaseConnection();
    }

    private void start() {
        loginWindow = new LoginWindow();
        loginWindow.showFrame(this);
    }


    public void login(String username, String password) {
       boolean didConnect = dbHandler.login(username, password);

        if (didConnect) {
            // Once connected, remove login window and start text transaction flow
            loginWindow.dispose();

            Gui ui = new Gui(dbHandler);
        } else {
            loginWindow.handleLoginFailed();

            if (loginWindow.hasReachedMaxLoginAttempts()) {
                loginWindow.dispose();
                System.out.println("You have exceeded your number of allowed attempts");
                System.exit(-1);
            }
        }

    }


    @Override
    public void doInsertCrypto(Crypto crypt) {
        dbHandler.doInsertCrypto(crypt);
    }

    public void deleteQuery(int del) {
        dbHandler.deleteQuery(del);
    }

    @Override
    public void updateQuery(int isin, String name) {
        dbHandler.updateQuery(isin, name);
    }

    public static void main(String[] args) {
        StockMarket market = new StockMarket();
        market.start();
    }

}

