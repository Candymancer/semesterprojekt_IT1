package domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TransactionManager {

    Transaction transaction = null;
    
    public void writeTransactions(List<Transaction> transactionList) {
        for (Transaction t : transactionList) {
            t.write();
        }
    }

    public void setTransactionsNotActive(List<Transaction> transactionList) {
        for (Transaction t : transactionList) {
            t.setActive(false);
        }
    }

    public List<Transaction> processResultSet(ResultSet rs) {
        List<Transaction> transactionList = new ArrayList<>();
        try {
            while (rs.next()) {
                String type = rs.getString("type");
                Date date = rs.getDate("date");
                int transactionId = rs.getInt("transaction_id");
                double amount = rs.getDouble("amount");
                String store = rs.getString("store");
                boolean active = rs.getBoolean("active");
                int userId = rs.getInt("userid");

                transaction = new Transaction(type, date, transactionId, amount, store, active, userId);
                transactionList.add(transaction);
            }
        } catch (SQLException e) {
            System.out.println("Fejl med forbindelsen");
        } finally {
            try {
                rs.close();
            } catch (SQLException e) {
                System.out.println("Fejl med lukning af forbindelsen");
            }
        }

        return transactionList;
    }
}
