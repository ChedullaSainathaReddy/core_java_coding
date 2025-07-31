package com.requestdispatcher;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/input")
public class InputServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        
        String name = request.getParameter("name");
        String marks = request.getParameter("marks");

        request.setAttribute("studentName", name);
        request.setAttribute("studentMarks", Integer.parseInt(marks));

        // Forward request to GradeServlet
        RequestDispatcher dispatcher = request.getRequestDispatcher("grade");
        dispatcher.forward(request, response);
    }
}
