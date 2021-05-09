package project.models;

public class Owns {
    public int customerID;
    public int accountNum;

    public Owns(int customerID, int accountNum) {
        this.customerID = customerID;
        this.accountNum = accountNum;
    }

    public int getCustomerID() {
        return customerID;
    }

    public int getAccountNum() {
        return accountNum;
    }

    @Override
    public String toString() {
        return "Owns{" +
                "customerID=" + customerID +
                ", accountNum=" + accountNum +
                '}';
    }
}
