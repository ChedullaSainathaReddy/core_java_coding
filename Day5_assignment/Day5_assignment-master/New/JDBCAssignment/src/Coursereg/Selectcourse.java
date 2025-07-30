package Coursereg;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
public class Selectcourse {
    public static void main(String[] args) {
        try (Connection conn = Dbutilization.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM courses")) {
            System.out.println("Course List:");
            while (rs.next()) {
                System.out.println("ID:" + rs.getInt("course_id") +
                        ",Name:" + rs.getString("course_name") +
                        ",Faculty:" + rs.getString("faculty") +
                        ",Credits:" + rs.getInt("credits"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}