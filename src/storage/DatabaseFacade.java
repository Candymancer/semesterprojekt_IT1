package storage;

import domain.User;
import domain.userLevel.UserLevel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;

public class DatabaseFacade {

    private final String db = "emilfrisk";
    private final String user = "emilfrisk";
    private final String password = "";

    public void writeUser(User user) {
        UserLevel level = user.getLevel();
        Date creationDate = user.getCreationDate();
        Timestamp creationDateTimestamp = new Timestamp(creationDate.getTime());
        double pointBalance = user.getPointBalance();
        double amountSpentThisYear = user.getAmountSpentThisYear();
        String name = user.getName();
        int userId = user.getUserId();
        String macaddress = user.getMacadresse();
        String email = user.getEmail();
        String tlf = user.getTlf();
        String address = user.getAddress();

        String query = "insert into users (level, creation_date, point_balance, amount_spent,"
                + " name, user_id, mac_address, email, tlf, address) values (\n"
                + "	'" + level.toString() + "',\n"
                + "	'" + creationDateTimestamp.toString() + "',\n"
                + "	" + pointBalance + ",\n"
                + "	" + amountSpentThisYear + ",\n"
                + "	'" + name + "',\n"
                + "	" + userId + ",\n"
                + "	'" + macaddress + "',\n"
                + "     '" + email + "',"
                + "     '" + tlf + "',"
                + "     '" + address + "'"
                + "     );\n"
                + "	";

        ResultSet rs = executeQuery(query);

    }

    public void writeTransaction() {
        String query = "insert into transactions values (\n"
                + "	'type',\n"
                + "	timestamp,\n"
                + "	transaction_id,\n"
                + "	amount,\n"
                + "	'store',\n"
                + "	active,\n"
                + "	userid\n"
                + "	);\n"
                + "	";
    }

    private ResultSet executeQuery(String query) {
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;

        String url = "jdbc:postgresql://localhost/" + db;

        try {
            con = DriverManager.getConnection(url, user, password);
            st = con.createStatement();
            rs = st.executeQuery("" + query);

        } catch (SQLException e) {
            if (e != null) {
                JOptionPane.showMessageDialog(null, "Fejl"); // lav popup
            }
        } finally {
            try {
                if (con != null) {
                    con.close();
                }

            } catch (SQLException ex) {
                System.out.println("Problemer med database forbindelsen");
            }
        }
        return rs;
    }

    public ResultSet getExpiredTransactions() {

        Calendar calendar = Calendar.getInstance();

        int day = (24 * 60 * 60 + 1) * 1000;

        long time = calendar.getTimeInMillis() - day;

        Timestamp timestamp = new Timestamp(time);

        String query = "SELECT \n"
                + "  transactions.date\n"
                + "FROM \n"
                + "  public.transaction\n"
                + "WHERE \n"
                + "  transaction.date >= '" + timestamp + "'\n"
                + "	AND transaction.date <= '" + timestamp + day + "';";

        ResultSet rs = executeQuery(query);

        if (rs == null) {
            return null;
        }

        return rs;
    }

    public ResultSet findUser(int userId) {
        String query = "SELECT \n"
                + "  users.user_id\n"
                + "FROM \n"
                + "  public.users\n"
                + "WHERE \n"
                + "  users.user_id = " + userId + ";";

        ResultSet rs = executeQuery(query);

        if (rs == null) {
            return null;
        }

        return rs;
    }
}
