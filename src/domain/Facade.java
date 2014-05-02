package domain;

import Parser.TransactionParser;
import java.util.List;

public class Facade {
	public TransactionParser sender_transaktioner;

	public void recieveTransactions(List<List<Object>> transactionList) {
                System system = new System();
                system.receiveTransactions(transactionList);
	}

	public void checkExpiredTransactions() {
		System system = new System();
                system.checkExpiredTransactions();
	}
}