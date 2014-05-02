package domain;

import java.sql.ResultSet;
import java.util.List;

public class System {
        
	public void receiveTransactions(List<List<Object>> transactionList) {
                //instantiere en transaction manager
		TransactionManager transactionManager = new TransactionManager();
                //Parser vores transactionList til til transactionmanageren og får 
                //en List<Transaction> tilbage med transaktions objekterne. Samtidigt med at listen
                //er blevet formateret fra List<String> til List<Transaction> er transactions objekterne
                //også blevet skrevet til databasen.
                List<Transaction> newTransactions = null;
                newTransactions = transactionManager.createNewTransactions(transactionList);
                
                
	}

	public void checkExpiredTransactions() {
		throw new UnsupportedOperationException();
	}

	public boolean addPointsToUsersInTransactions(List<Transaction> transactionList) {
		throw new UnsupportedOperationException();
	}

	public List<Transaction> processTransactions(ResultSet rs) {
		throw new UnsupportedOperationException();
	}

	public List<User> processUsers(ResultSet rs) {
		throw new UnsupportedOperationException();
	}

	public boolean subtractPointsToUsersInTransactions(List<Transaction> transactionList) {
		throw new UnsupportedOperationException();
	}

	public void deactivateTransactions() {
		throw new UnsupportedOperationException();
	}
}