package Coursereg;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;
public class Updatecourse {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in);
             Connection conn = Dbutilization.getConnection()) {
            System.out.print("Enter Course ID to update:");
            int id = sc.nextInt();
            sc.nextLine();
            System.out.print("Enter new Faculty:");
            String faculty = sc.nextLine();
            System.out.print("Enter new Credits:");
            int credits = sc.nextInt();
            String query = "UPDATE courses SET faculty=?,credits=? WHERE course_id=?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1,faculty);
            ps.setInt(2,credits);
            ps.setInt(3,id);
            int rows = ps.executeUpdate();
            System.out.println(rows > 0 ? "Course updated successfully.":"No course found with given ID.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
