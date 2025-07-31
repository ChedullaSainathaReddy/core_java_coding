package com.example;

import com.example.dao.StudentDao;
import com.example.model.Student;

public class App {
    public static void main(String[] args) {
        StudentDao dao = new StudentDao();

        Student s1 = new Student();
        s1.setName("John Doe");
        s1.setEmail("john@example.com");
        dao.saveStudent(s1);

        Student s2 = dao.getStudent(1);
        System.out.println("Student: " + s2.getName() + ", " + s2.getEmail());

        s2.setEmail("john.doe@example.com");
        dao.updateStudent(s2);

        dao.deleteStudent(1);
    }
}
