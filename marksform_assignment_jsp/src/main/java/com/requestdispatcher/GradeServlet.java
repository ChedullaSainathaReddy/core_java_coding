package com.requestdispatcher;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/grade")
public class GradeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String name = (String) request.getAttribute("studentName");
        int marks = (int) request.getAttribute("studentMarks");
        String grade;

        if (marks >= 90) {
            grade = "A+";
        } else if (marks >= 75) {
            grade = "A";
        } else if (marks >= 60) {
            grade = "B";
        } else if (marks >= 40) {
            grade = "C";
        } else {
            grade = "F (Fail)";
        }

        out.println("<html><body>");
        out.println("<h2>Grade Result</h2>");
        out.println("<p><strong>Name:</strong> " + name + "</p>");
        out.println("<p><strong>Marks:</strong> " + marks + "</p>");
        out.println("<p><strong>Grade:</strong> " + grade + "</p>");
        out.println("</body></html>");
    }
}
