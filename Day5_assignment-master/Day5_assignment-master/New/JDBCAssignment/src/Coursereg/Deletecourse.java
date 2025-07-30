package Coursereg;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;
public class Deletecourse {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in);
             Connection conn = Dbutilization.getConnection()) {
            System.out.print("Enter Course ID to delete: ");
            int id = sc.nextInt();
            String query = "DELETE FROM courses WHERE course_id=?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            int rows = ps.executeUpdate();
            System.out.println(rows > 0 ? "Course deleted successfully.":"No course found with given ID.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
