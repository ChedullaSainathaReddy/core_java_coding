package com.ServletSession;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {
	 protected void doPost(HttpServletRequest request, HttpServletResponse response)
		        throws ServletException, IOException {

		        String accno = request.getParameter("accno");
		        String password = request.getParameter("password");

		        
		        if ("12345".equals(accno) && "pass123".equals(password)) {
		            HttpSession session = request.getSession();
		            session.setAttribute("name", "John Doe");
		            session.setAttribute("balance", 12500.75);

		            response.sendRedirect("balance");
		        } else {
		            response.setContentType("text/html");
		            response.getWriter().println("<h3>Invalid credentials. <a href='login.html'>Try again</a></h3>");
		        }
		    }
		}


