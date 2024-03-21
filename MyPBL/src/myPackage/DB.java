package myPackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB {
    public static Connection conn=null;
    public static Connection dbConnect() throws SQLException{
        try {
            String url="jdbc:mysql://localhost:3306/data";
            String username="root";
            String password="Software_123";

            conn = DriverManager.getConnection(url, username, password);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
}
