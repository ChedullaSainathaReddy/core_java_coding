package com.ServletSession;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class BalanceServlet extends HttpServlet{
	 protected void doGet(HttpServletRequest request, HttpServletResponse response)
		        throws ServletException, IOException {

		        HttpSession session = request.getSession(false);

		        response.setContentType("text/html");
		        PrintWriter out = response.getWriter();

		        if (session != null && session.getAttribute("name") != null) {
		            String name = (String) session.getAttribute("name");
		            double balance = (double) session.getAttribute("balance");

		            out.println("<h2>Welcome, " + name + "</h2>");
		            out.println("<p>Your account balance is: ₹" + balance + "</p>");
		            out.println("<a href='logout'>Logout</a>");
		        } else {
		            out.println("<h3>Session expired or not logged in. <a href='login.html'>Login again</a></h3>");
		        }
		    }

}
