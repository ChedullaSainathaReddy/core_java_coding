package Inventorysys;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
public class Selectinventory {
    public static void main(String[] args) {
        try (Connection conn = Dbutilization.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM products")) {
            System.out.println("---- Product Inventory ----");
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("product_id") +
                        ",Name:" + rs.getString("product_name") +
                        ",Quantity:" + rs.getInt("quantity") +
                        ",Price:" + rs.getDouble("price"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
