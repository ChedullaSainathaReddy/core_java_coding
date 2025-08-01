package com.ShoppingCart;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AddToCartServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {

	        String item = request.getParameter("item");

	        
	        Cookie cookie = new Cookie("item_" + System.currentTimeMillis(), item);
	        cookie.setMaxAge(60 * 60);
	        response.addCookie(cookie);

	        response.setContentType("text/html");
	        response.getWriter().println("<h3>Item added to cart: " + item + "</h3>");
	        response.getWriter().println("<a href='items.html'>Add More</a> | <a href='viewcart'>View Cart</a>");
	    }

}
