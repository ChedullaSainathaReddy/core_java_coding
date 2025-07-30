package com.crudoperations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

//import com.vcube.com.crud2.Student;

public class StudentJDBC_DAO {
	 private String jdbcURL = "jdbc:mysql://localhost:3306/student_db";
	    private String jdbcUser = "root";
	    private String jdbcPass = "Sainath@123";

	    private Connection getConnection() throws Exception {
	        Class.forName("com.mysql.jdbc.Driver");
	        return DriverManager.getConnection(jdbcURL, jdbcUser, jdbcPass);
	    }

	    //READ
	    public List<Student> getAllStudents() throws Exception {
	        List<Student> list = new ArrayList<>();
	        Connection conn = getConnection();
	        PreparedStatement ps = conn.prepareStatement("SELECT * FROM students");
	        ResultSet rs = ps.executeQuery();

	        while (rs.next()) {
	            list.add(new Student(rs.getInt("id"), rs.getString("name"), rs.getString("email")));//ADDDING RECORDS INTO ARRAYLIST
	        }

	        conn.close();
	        return list;
	    }

	    //CREATE
	    public void insertStudent(Student s) throws Exception {
	        Connection conn = getConnection();
	        PreparedStatement ps = conn.prepareStatement("INSERT INTO students(name, email) VALUES (?, ?)");
	        ps.setString(1, s.getName());
	        ps.setString(2, s.getEmail());
	        ps.executeUpdate();
	        conn.close();
	    }

	    public Student getStudent(int id) throws Exception {
	        Connection conn = getConnection();
	        PreparedStatement ps = conn.prepareStatement("SELECT * FROM students WHERE id = ?");
	        ps.setInt(1, id);
	        ResultSet rs = ps.executeQuery();
	        Student s = null;
	        if (rs.next()) {
	            s = new Student(rs.getInt("id"), rs.getString("name"), rs.getString("email"));
	        }
	        conn.close();
	        return s;//SPECIFIC RECORD RETURNED
	    }
	    //UPDATE	
	    public void updateStudent(Student s) throws Exception {
	        Connection conn = getConnection();
	        PreparedStatement ps = conn.prepareStatement("UPDATE students SET name=?, email=? WHERE id=?");
	        ps.setString(1, s.getName());
	        ps.setString(2, s.getEmail());
	        ps.setInt(3, s.getId());
	        ps.executeUpdate();
	        conn.close();
	    }

	    //DELETE
	    public void deleteStudent(int id) throws Exception {
	        Connection conn = getConnection();
	        PreparedStatement ps = conn.prepareStatement("DELETE FROM students WHERE id=?");
	        ps.setInt(1, id);
	        ps.executeUpdate();
	        conn.close();
	    }

}



