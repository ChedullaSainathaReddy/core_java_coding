package Coursereg;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;
public class Insertcourse {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in);
             Connection conn = Dbutilization.getConnection()) {
            System.out.print("Enter Course ID:");
            int id = sc.nextInt();
            sc.nextLine();
            System.out.print("Enter Course Name:");
            String name = sc.nextLine();
            System.out.print("Enter Faculty:");
            String faculty = sc.nextLine();
            System.out.print("Enter Credits:");
            int credits = sc.nextInt();
            String query = "INSERT INTO courses VALUES (?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setString(3, faculty);
            ps.setInt(4, credits);
            int rows = ps.executeUpdate();
            System.out.println(rows > 0 ? "Course inserted" : "Insertion failed.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
