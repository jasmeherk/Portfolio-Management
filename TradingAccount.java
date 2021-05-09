package project.models;

public class TradingAccount {
    public int accountNum;
    public double balance;

    public TradingAccount(int accountNum, double balance) {
        this.accountNum = accountNum;
        this.balance = balance;
    }

    public int getAccountNum() {
        return accountNum;
    }

    public double getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        return "TradingAccount{" +
                "accountNum=" + accountNum +
                ", balance=" + balance +
                '}';
    }
}
