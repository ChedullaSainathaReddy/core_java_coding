package Inventorysys;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;
public class Updateinventory {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in);
             Connection conn = Dbutilization.getConnection()) {
            System.out.print("Enter product ID to update quantity: ");
            int id = sc.nextInt();
            System.out.print("Enter New Quantity: ");
            int qty = sc.nextInt();
            String query = "UPDATE products SET quantity = ? WHERE product_id = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, qty);
            ps.setInt(2, id);
            int rows = ps.executeUpdate();
            System.out.println(rows > 0 ? "Quantity updated!":"Product not found.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}