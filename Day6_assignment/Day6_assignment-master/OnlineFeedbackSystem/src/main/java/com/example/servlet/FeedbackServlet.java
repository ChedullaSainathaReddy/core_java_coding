package com.example.servlet;
import java.io.IOException;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
public class FeedbackServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String studentName = request.getParameter("studentName");
        String email = request.getParameter("email");
        String course = request.getParameter("course");
        String feedback = request.getParameter("feedback");
        if (studentName == null || email == null || course == null || feedback == null) {
            response.sendRedirect("feedback.jsp");
            return;
        }
        request.setAttribute("studentName", studentName);
        request.setAttribute("email", email);
        request.setAttribute("course", course);
        request.setAttribute("feedback", feedback);
        RequestDispatcher dispatcher = request.getRequestDispatcher("thankyou.jsp");
        dispatcher.forward(request, response);
    }
}