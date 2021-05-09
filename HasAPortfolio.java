package project.models;

public class HasAPortfolio {
    public int portfolioID;
    public int transactionID;
    public double units;

    public HasAPortfolio(int portfolioID, int transactionID, double units) {
        this.portfolioID = portfolioID;
        this.transactionID = transactionID;
        this.units = units;
    }

    public int getPortfolioID() {
        return portfolioID;
    }

    public int getTransactionID() {
        return transactionID;
    }

    public double getUnits() {
        return units;
    }

    @Override
    public String toString() {
        return "HasAPortfolio{" +
                "portfolioID=" + portfolioID +
                ", transactionID=" + transactionID +
                ", units=" + units +
                '}';
    }
}
