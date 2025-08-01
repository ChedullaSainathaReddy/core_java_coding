package com.ServletSession;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class LogoutServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {

	        HttpSession session = request.getSession(false);
	        if (session != null) {
	            session.invalidate();
	        }

	        response.setContentType("text/html");
	        response.getWriter().println("<h3>You have been logged out. <a href='login.html'>Login again</a></h3>");
	    }

}
