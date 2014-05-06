package storage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Calendar;
import javax.swing.JOptionPane;

public class DatabaseFacade {

    private final String db = "emilfrisk";
    private final String user = "emilfrisk";
    private final String password = "";

    public void createTransaction() {
        throw new UnsupportedOperationException();
    }

    public void writeUser() {
        throw new UnsupportedOperationException();
    }

    public void writeTransaction() {
        throw new UnsupportedOperationException();
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
                + "  users.user_id = "+userId+";";

        ResultSet rs = executeQuery(query);

        if (rs == null) {
            return null;
        }

        return rs;
    }
}
