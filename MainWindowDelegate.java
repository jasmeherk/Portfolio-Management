package project.delegates;

import project.models.Crypto;

public interface MainWindowDelegate {
    public void doInsertCrypto(Crypto crypt);
    public void deleteQuery(int del);
    public void updateQuery(int isin, String name);
}
