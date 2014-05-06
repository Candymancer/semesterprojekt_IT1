package domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TransactionManager {

    public void deactivateTransaction() {
        throw new UnsupportedOperationException();
    }

    public void calculatePoints() {
        throw new UnsupportedOperationException();
    }

    public void checkExpiredTransactions() {
        throw new UnsupportedOperationException();
    }

    public List<Transaction> createNewTransactions(List<List<Object>> transactionList) {
        List<Transaction> l = null;
        for (List<Object> list : transactionList) {
            String type = (String) list.get(0);
            Date date = (Date) list.get(1);
            int transactionId = (int) list.get(2);
            double amount = (double) list.get(3);
            String store = (String) list.get(4);
            boolean active = (boolean) list.get(5);
            int userId = (int) list.get(6);

            Transaction t = new Transaction(type, date, transactionId, amount, store, active, userId);
            t.write();
            l.add(t);
        }
        return l;
    }

    public void writeTransactions(List<Transaction> transactionList) {
        for (Transaction transaction : transactionList) {
            transaction.write();
        }
    }

    public void setTransactionsNotActive(List<Transaction> transactionList) {
        for (Transaction transaction : transactionList) {
            transaction.setActive(false);
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

                Transaction transaction = new Transaction(type, date, transactionId, amount, store, active, userId);
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
