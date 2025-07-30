package Inventorysys;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class Dbutilization {
    private static final String URL = "jdbc:mysql://localhost:3306/inventorydb";
    private static final String USER = "root";
    private static final String PASSWORD = "Guru@123";
    public static Connection getConnection() throws SQLException {
        Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
        System.out.println("Connected to the database");
        return conn;
    }
}