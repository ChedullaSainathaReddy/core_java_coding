package com.ShoppingCart;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ViewCartServlet extends HttpServlet{
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {

	        Cookie[] cookies = request.getCookies();

	        response.setContentType("text/html");
	        response.getWriter().println("<h2>Your Shopping Cart</h2>");

	        if (cookies != null) {
	            boolean hasItems = false;
	            for (Cookie c : cookies) {
	                if (c.getName().startsWith("item_")) {
	                    response.getWriter().println("<p>" + c.getValue() + "</p>");
	                    hasItems = true;
	                }
	            }
	            if (!hasItems) {
	                response.getWriter().println("<p>Your cart is empty.</p>");
	            }
	        } else {
	            response.getWriter().println("<p>Your cart is empty.</p>");
	        }

	        response.getWriter().println("<br><a href='items.html'>Back to Shop</a>");
	    }

}
