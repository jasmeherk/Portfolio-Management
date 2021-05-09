package project.models;

//import oracle.sql.TIMESTAMP;

import java.sql.Timestamp;

public class Forex {
    public String id;
    public String fromCurrency;
    public String fromCurrCode;
    public String toCurrency;
    public String toCurrCode;
    public Timestamp timestamp;
    public double price;

    public Forex(String id, String fromCurrency, String fromCurrCode, String toCurrency, String toCurrCode, Timestamp timestamp, double price) {
        this.id = id;
        this.fromCurrency = fromCurrency;
        this.fromCurrCode = fromCurrCode;
        this.toCurrency = toCurrency;
        this.toCurrCode = toCurrCode;
        this.timestamp = timestamp;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public String getFromCurrency() {
        return fromCurrency;
    }

    public String getFromCurrCode() {
        return fromCurrCode;
    }

    public String getToCurrency() {
        return toCurrency;
    }

    public String getToCurrCode() {
        return toCurrCode;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Forex{" +
                "id='" + id + '\'' +
                ", fromCurrency='" + fromCurrency + '\'' +
                ", fromCurrCode='" + fromCurrCode + '\'' +
                ", toCurrency='" + toCurrency + '\'' +
                ", toCurrCode='" + toCurrCode + '\'' +
                ", timestamp=" + timestamp +
                ", price=" + price +
                '}';
    }
}
