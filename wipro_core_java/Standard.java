package com.wiprojava;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Standard {
	private List<Student> students;

    public Standard() {
        students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    // 1. Ascending order by Roll No
    public void displayByRollNo() {
        students.stream()
                .sorted(Comparator.comparingInt(Student::getRollNo))
                .forEach(s -> System.out.println("Roll No: " + s.getRollNo() + ", Name: " + s.getStudName()));
    }

    // 2. Highest Percentage
    public void displayHighestPercentageStudent() {
        Student topStudent = Collections.max(students, Comparator.comparingDouble(Student::getPercentage));
        System.out.println("Topper (Percentage): Roll No: " + topStudent.getRollNo() + ", Name: " + topStudent.getStudName());
    }

    // 3. Highest Marks in Maths
    public void displayHighestMathsMarkStudent() {
        Student mathTopper = Collections.max(students, Comparator.comparingInt(Student::getMarksInMaths));
        System.out.println("Maths Topper: Roll No: " + mathTopper.getRollNo() + ", Name: " + mathTopper.getStudName());
    }

    // 4. Ascending order by Total of Maths + Science
    public void displayByMathsScienceTotal() {
        students.stream()
                .sorted(Comparator.comparingInt(s -> s.getMarksInMaths() + s.getMarksInScience()))
                .forEach(s -> System.out.println("Roll No: " + s.getRollNo() + ", Name: " + s.getStudName()));
    }

    // 5. Descending Order of Rank (Rank based on total marks)
    public void displayRankList() {
        List<Student> sortedList = new ArrayList<>(students);
        sortedList.sort(Comparator.comparingInt(Student::getTotalMarks).reversed());

        int rank = 1;
        for (Student s : sortedList) {
            System.out.println("Rank: " + rank++ + ", Roll No: " + s.getRollNo() +
                    ", Name: " + s.getStudName() +
                    ", Total: " + s.getTotalMarks() +
                    ", Percentage: " + String.format("%.2f", s.getPercentage()));
        }
    }

}
