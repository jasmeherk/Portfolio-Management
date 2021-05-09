package project.models;

public class CreatesTransaction {
    public int id;
    public String type;
    public double amount;
    public int accountNum;
    public String transactionType;
    public String status;
    public String country;
    public String exchange;
    public double units;

    public CreatesTransaction(int id, String type, double amount, int accountNum, String transactionType, String status, String country, String exchange, double units) {
        this.id = id;
        this.type = type;
        this.amount = amount;
        this.accountNum = accountNum;
        this.transactionType = transactionType;
        this.status = status;
        this.country = country;
        this.exchange = exchange;
        this.units = units;
    }

    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }

    public int getAccountNum() {
        return accountNum;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public String getStatus() {
        return status;
    }

    public String getCountry() {
        return country;
    }

    public String getExchange() {
        return exchange;
    }

    public double getUnits() {
        return units;
    }

    @Override
    public String toString() {
        return "CreatesTransaction{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", amount=" + amount +
                ", accountNum=" + accountNum +
                ", transactionType='" + transactionType + '\'' +
                ", status='" + status + '\'' +
                ", country='" + country + '\'' +
                ", exchange='" + exchange + '\'' +
                ", units=" + units +
                '}';
    }
}
