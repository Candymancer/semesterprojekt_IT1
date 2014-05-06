package domain;

import domain.userLevel.Bronze;
import domain.userLevel.Gold;
import domain.userLevel.Silver;
import java.util.Date;
import java.util.List;

public class UserManager {

    public void addPointsToUsers(List<Transaction> transactions) {
        for (Transaction transaction : transactions) {
            int userId = transaction.getUserId();
            User user = new User();
            user.getUser(userId);
            double amount = transaction.getAmount();
            double conversionRate = user.getLevel().getConversionRate();
            double points = amount * conversionRate;
            double userPoints = user.getPointBalance();
            double userAmount = user.getAmountSpentThisYear();
            user.setAmountSpentThisYear(userAmount+amount);
            user.setPointBalance(userPoints + points);
            if (user.getAmountSpentThisYear() > user.getLevel().getUpperLimit()) {
                if (user.getLevel() instanceof Bronze) {
                    user.setLevel(new Silver());
                } else if (user.getLevel() instanceof Silver) {
                    user.setLevel(new Gold());
                }
            }
            user.write();
        }
    }

    public void subtractPointsFromUsers(List<Transaction> transactions) {
        for (Transaction transaction : transactions) {
            int userId = transaction.getUserId();
            User user = new User();
            user.getUser(userId);
            double amount = transaction.getAmount();
            double userAmount = user.getAmountSpentThisYear();
            user.setAmountSpentThisYear(userAmount-amount);
            if (user.getAmountSpentThisYear() < user.getLevel().getLowerLimit()) {
                if (user.getLevel() instanceof Gold) {
                    user.setLevel(new Silver());
                } else if (user.getLevel() instanceof Silver) {
                    user.setLevel(new Bronze());
                }
            }
            user.write();
        }
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
