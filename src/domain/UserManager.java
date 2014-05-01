package domain;

import java.util.Date;
import java.util.List;

public class UserManager {

        public void addPointsToUsers(List<Transaction> transactions){
                for (Transaction transaction : transactions) {
                    int userId = transaction.getUserId();
                    User user = new User();
                    user.getUser(userId);
                    double amount = transaction.getAmount();
                    double points = amount*
                }
//                for (hvert transaktion i listen)
//                  hent bruger
//                  initialiser nyt bruger objekt
//                  tilføj point
//                  skriv bruger.
        }
    
	public void CheckUserLevel() {
		throw new UnsupportedOperationException();
	}

	public User createUser(int level, Date creationDate, Point pointBalance, double amountSpenThisYear, 
                String name, int userId, String macaddress, String email, String tlf, String address) {
		throw new UnsupportedOperationException();
	}

	public void updateUserLevel(int level) {
		throw new UnsupportedOperationException();
	}
}