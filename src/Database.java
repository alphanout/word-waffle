package src;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {
    Connection conn;
    Statement stmt = null;
    PreparedStatement prepState;

    Database() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        Class.forName("com.mysql.jdbc.Driver").getClassLoader();
        conn = Conn.getInstance();
        // prepState = conn.prepareStatement(sql);
    }

    public ResultSet query(String query) throws SQLException {
        stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        stmt.close();
        return rs;
    }

}
