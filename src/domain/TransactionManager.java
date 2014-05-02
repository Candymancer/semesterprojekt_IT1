package domain;

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

    public boolean writeTransactions(List<Transaction> transactionList) {
        throw new UnsupportedOperationException();
    }
}
