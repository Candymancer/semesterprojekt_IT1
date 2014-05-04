package domain;

import java.util.List;

public class Facade {

	public void recieveTransactions(List<Transaction> transactionList) {
                System system = new System();
                system.receiveTransactions(transactionList);
	}

	public void checkExpiredTransactions() {
		System system = new System();
                system.checkExpiredTransactions();
	}
}