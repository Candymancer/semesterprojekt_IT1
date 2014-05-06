package domain;

import java.util.List;

public class Facade {

	public void recieveTransactions(List<Transaction> transactionList) {
                System_ system = new System_();
                system.receiveTransactions(transactionList);
	}

	public void checkExpiredTransactions() {
		System_ system = new System_();
                system.checkExpiredTransactions();
	}
}