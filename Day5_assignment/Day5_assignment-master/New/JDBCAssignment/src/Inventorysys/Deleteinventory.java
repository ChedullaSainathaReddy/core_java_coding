package Inventorysys;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;
public class Deleteinventory {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in);
             Connection conn = Dbutilization.getConnection()) {
            System.out.print("Enter Product ID to delete: ");
            int id = sc.nextInt();
            String query = "DELETE FROM products WHERE product_id = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            int rows = ps.executeUpdate();
            System.out.println(rows > 0 ? "Product deleted" : "Product not found");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}