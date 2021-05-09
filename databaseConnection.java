package project.database;

import project.models.*;

import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class databaseConnection {
    // Use this version of the ORACLE_URL if you are running the code off of the server
//	private static final String ORACLE_URL = "jdbc:oracle:thin:@dbhost.students.cs.ubc.ca:1522:stu";
    // Use this version of the ORACLE_URL if you are tunneling into the undergrad servers
    private static final String ORACLE_URL = "jdbc:oracle:thin:@localhost:1522:stu";
    private static final String EXCEPTION_TAG = "[EXCEPTION]";
    private static final String WARNING_TAG = "[WARNING]";

    private Connection connection = null;

    public databaseConnection() {
        try {
            // Load the Oracle JDBC driver
            // Note that the path could change for new drivers
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
        } catch (SQLException e) {
            System.out.println(EXCEPTION_TAG + " " + e.getMessage());
        }
    }

    public void close() {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            System.out.println(EXCEPTION_TAG + " " + e.getMessage());
        }
    }



    public CreatesTransaction[] getCreatesTransaction() {
        ArrayList<CreatesTransaction> result = new ArrayList<CreatesTransaction>();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM CreatesTransaction");


            while(rs.next()) {
                //CreatesTransaction model = new CreatesTransaction();
                //result.add(model); //uncommented when SQL queries are completed
            }

            rs.close();
            stmt.close();
        } catch (SQLException e) {
            System.out.println(EXCEPTION_TAG + " " + e.getMessage());
        }

        return result.toArray(new CreatesTransaction[result.size()]);
    }

    public int getNextUserID(){
        int custID = 0;
        try{
            Statement stmt = connection.createStatement();
            String sql = "SELECT MAX(customerID) FROM UserAccount";
            ResultSet rs = stmt.executeQuery(sql);
            //int rs = stmt.executeUpdate(sql);

            while(rs.next()){
                custID = rs.getInt("MAX(customerID)");
            }
        } catch (SQLException e){
            System.out.println("Error occurredtest" + e.getMessage());
        }
        return (custID + 1);
    }

    public void doInsertCrypto(Crypto crypt){
        try{
            PreparedStatement ps = connection.prepareStatement("INSERT INTO crypto VALUES (?,?,?,?,?,?)");
            ps.setString(1, crypt.getIsin());
            ps.setString(2, crypt.getName());
            ps.setString(3, crypt.getSymbol());
            ps.setDouble(4, crypt.getPrice());
            ps.setTimestamp(5,crypt.getTimestamp());
            ps.setDouble(6,crypt.getVolume());
            ps.executeUpdate();
            connection.commit();

            ps.close();
        } catch (SQLException e) {
            System.out.println(EXCEPTION_TAG + " " + e.getMessage());
            rollbackConnection();
        }

    }
    public void doInsertUserAccount(UserAccount user){
        try{
            PreparedStatement ps = connection.prepareStatement("INSERT INTO UserAccount VALUES (?,?,?,?,?,?,?,?,?)");
            ps.setInt(1, user.getCustomerID());
            ps.setInt(2, user.getSin());
            ps.setString(3, user.getIDType());
            ps.setString(4, user.getIDNum());
            ps.setString(5, user.getName());
            ps.setString(6, user.getAddress());
            ps.setString(7, user.getPhone());
            ps.setString(8, user.getEmail());
            ps.setString(9, user.getPassword());

            ps.executeUpdate();
            connection.commit();

            ps.close();
        } catch (SQLException e) {
            System.out.println(EXCEPTION_TAG + " " + e.getMessage());
            rollbackConnection();
        }

    }
    public void deleteQuery(int del){
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement("DELETE FROM branch WHERE branch_id = ?");
            ps.setInt(1, del);
            int rowCount = ps.executeUpdate();
            if (rowCount == 0) {
                System.out.println(WARNING_TAG + " Branch " + del + " does not exist!");
            }
            connection.commit();

            ps.close();
        } catch (SQLException e) {
            System.out.println(EXCEPTION_TAG + " " + e.getMessage());
            rollbackConnection();
        }

    }
    public void updateQuery(int isin, String name) {
        try {
            PreparedStatement ps = connection.prepareStatement("UPDATE branch SET branch_name = ? WHERE branch_id = ?");
            ps.setString(1, name);
            ps.setInt(2, isin);

            int rowCount = ps.executeUpdate();
            if (rowCount == 0) {
                System.out.println(WARNING_TAG + " Branch " + isin + " does not exist!");
            }

            connection.commit();

            ps.close();
        } catch (SQLException e) {
            System.out.println(EXCEPTION_TAG + " " + e.getMessage());
            rollbackConnection();
        }
    }

    public void doUserAddUpdate(int custID, String newAdd) {
        try {
            PreparedStatement ps = connection.prepareStatement("UPDATE UserAccount SET address = ? WHERE customerID = ?");
            ps.setString(1, newAdd);
            ps.setInt(2, custID);

            int rowCount = ps.executeUpdate();
            if (rowCount == 0) {
                System.out.println(WARNING_TAG + " Customer with ID " + custID + " does not exist!");
            }

            connection.commit();

            ps.close();
        } catch (SQLException e) {
            System.out.println(EXCEPTION_TAG + " " + e.getMessage());
            rollbackConnection();
        }
    }

    public TradingAccount[] doMinBalSelection(int minBal) {
        ArrayList<TradingAccount> result = new ArrayList<TradingAccount>();

        try {

            Statement stmt = connection.createStatement();
            String sql = "SELECT * FROM TradingAccount"; //" WHERE T.balance >= " + minBal;
            ResultSet rs = stmt.executeQuery(sql);



            while(rs.next()) {
                TradingAccount model = new TradingAccount(rs.getInt("accountNum"),
                        rs.getDouble("balance"));
                result.add(model);
            }

            rs.close();
            stmt.close();
        } catch (SQLException e) {
            System.out.println(EXCEPTION_TAG + " " + e.getMessage());
        }
        return result.toArray(new TradingAccount[result.size()]);
    }
    public String[] doProjectSelection(String table, String column) {
        ArrayList<String> result = new ArrayList<String>();

        try {
            String sql = "SELECT " + column + " FROM " + table;
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);



            while(rs.next()) {
                result.add(rs.getString(column));
            }

            rs.close();
            stmt.close();
        } catch (SQLException e) {
            System.out.println(EXCEPTION_TAG + " " + e.getMessage());
        }

        return result.toArray(new String[result.size()]);
    }

    public String[][] doJoinUserTrade(int minBal) {
        ArrayList<String> resultName = new ArrayList<String>();
        ArrayList<String> resultEmail = new ArrayList<String>();
        ArrayList<String> resultPhone = new ArrayList<String>();

        try {
            String sql = "SELECT name, email, phone " +
                    "FROM UserAccount U, TradingAccount T, Owns O " +
                    "WHERE O.customerID = U.customerID AND O.accountNum = T.accountNum AND T.balance > " + minBal;
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);



            while(rs.next()) {
                resultName.add(rs.getString("name"));
                resultEmail.add(rs.getString("email"));
                resultPhone.add(rs.getString("phone"));
            }

            rs.close();
            stmt.close();
        } catch (SQLException e) {
            System.out.println(EXCEPTION_TAG + " " + e.getMessage());
        }
        String[][] result = new String[3][];
        result[0] = resultName.toArray(new String[resultName.size()]);
        result[1] = resultEmail.toArray(new String[resultEmail.size()]);
        result[2] = resultPhone.toArray(new String[resultPhone.size()]);

        return result;
    }

    public String[][] doAggregationDerivatives() {
        ArrayList<String> result1 = new ArrayList<String>();
        ArrayList<String> result2 = new ArrayList<String>();

        try {
            String sql = "SELECT underlyingAssetType,ROUND(MAX(underlyingAssetValue),2)" +
                    "FROM Derivatives " +
                    "GROUP BY underlyingAssetType";
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);



            while(rs.next()) {
                result1.add(rs.getString("underlyingAssetType"));
                result2.add(rs.getString("ROUND(MAX(underlyingAssetValue),2)"));
            }

            rs.close();
            stmt.close();
        } catch (SQLException e) {
            System.out.println(EXCEPTION_TAG + " " + e.getMessage());
        }
        String[][] result = new String[2][];
        result[0] = result1.toArray(new String[result1.size()]);
        result[1] = result2.toArray(new String[result2.size()]);

        return result;
    }

    public String[][] doAggregationDerivativesHaving() {
        ArrayList<String> result1 = new ArrayList<String>();
        ArrayList<String> result2 = new ArrayList<String>();

        try {
            String sql = "SELECT underlyingAssetType,ROUND(MAX(underlyingAssetValue),2)" +
                    "FROM Derivatives " +
                    "GROUP BY underlyingAssetType " +
                    "HAVING COUNT(*) > 1";
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);



            while(rs.next()) {
                result1.add(rs.getString("underlyingAssetType"));
                result2.add(rs.getString("ROUND(MAX(underlyingAssetValue),2)"));
            }

            rs.close();
            stmt.close();
        } catch (SQLException e) {
            System.out.println(EXCEPTION_TAG + " " + e.getMessage());
        }
        String[][] result = new String[2][];
        result[0] = result1.toArray(new String[result1.size()]);
        result[1] = result2.toArray(new String[result2.size()]);

        return result;
    }

    public boolean login(String username, String password) {
        try {
            if (connection != null) {
                connection.close();
            }

            connection = DriverManager.getConnection(ORACLE_URL, username, password);
            connection.setAutoCommit(false);

            System.out.println("\nConnected to Oracle!");
            return true;
        } catch (SQLException e) {
            System.out.println(EXCEPTION_TAG + " " + e.getMessage());
            return false;
        }
    }

    private void rollbackConnection() {
        try  {
            connection.rollback();
        } catch (SQLException e) {
            System.out.println(EXCEPTION_TAG + " " + e.getMessage());
        }
    }

}
