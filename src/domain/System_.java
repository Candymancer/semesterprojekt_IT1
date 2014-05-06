package domain;

import java.sql.ResultSet;
import java.util.List;
import storage.DatabaseFacade;

public class System_ {
    private DatabaseFacade databaseFacade = new DatabaseFacade();
    private TransactionManager transactionManager = new TransactionManager();
    private UserManager userManager = new UserManager();
    
    public void receiveTransactions(List<Transaction> transactionList) {
        transactionManager.writeTransactions(transactionList);
        userManager.addPointsToUsers(transactionList);
    }

    public void checkExpiredTransactions() {
        List<Transaction> transactionList = null;
        
        ResultSet rs = databaseFacade.getExpiredTransactions();
        
        transactionList = transactionManager.processResultSet(rs);
        
        userManager.subtractPointsFromUsers(transactionList);
        
        transactionManager.setTransactionsNotActive(transactionList);
        
        transactionManager.writeTransactions(transactionList);
    }
}
