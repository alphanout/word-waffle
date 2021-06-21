

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conn {
    static Connection conn = null;

    private Conn() {

    }

    public static Connection getInstance() {
        try {
            if (conn == null)
                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/word_waffle","admin","root");

        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        return conn;
    }
}

