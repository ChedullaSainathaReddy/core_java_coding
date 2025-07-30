package Inventorysys;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;
public class Insertinventory {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in);
             Connection conn = Dbutilization.getConnection()) {
            System.out.print("Enter product ID:");
            int id = sc.nextInt();
            sc.nextLine();
            System.out.print("Enter product Name:");
            String name = sc.nextLine();
            System.out.print("Enter quantity:");
            int qty = sc.nextInt();
            System.out.print("Enter price:");
            double price = sc.nextDouble();
            String query = "INSERT INTO products VALUES (?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setInt(3, qty);
            ps.setDouble(4, price);
            int rows = ps.executeUpdate();
            System.out.println(rows > 0 ? "Product added":"Insertion failed.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}