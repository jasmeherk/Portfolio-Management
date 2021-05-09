package project.models;

import java.sql.Timestamp;

public class Crypto {
    public String isin;
    public String symbol;
    public String name;
    public double volume;
    Timestamp timestamp;
    public double price;

    public Crypto(String isin, String symbol, String name, double volume, Timestamp timestamp, double price) {
        this.isin = isin;
        this.symbol = symbol;
        this.name = name;
        this.volume = volume;
        this.timestamp = timestamp;
        this.price = price;
    }

    public String getIsin() {
        return isin;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getName() {
        return name;
    }

    public double getVolume() {
        return volume;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Crypto{" +
                "isin='" + isin + '\'' +
                ", symbol='" + symbol + '\'' +
                ", name='" + name + '\'' +
                ", volume=" + volume +
                ", timestamp=" + timestamp +
                ", price=" + price +
                '}';
    }
}
