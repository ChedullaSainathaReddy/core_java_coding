package com.HiddenForm;

import java.io.IOException;
import java.io.PrintWriter;

public class QuantityFormServlet extends HttpServlet {
	 protected void doPost(HttpServletRequest request, HttpServletResponse response)
		        throws ServletException, IOException {
		        
		        response.setContentType("text/html");
		        PrintWriter out = response.getWriter();

		        String[] productData = request.getParameter("product").split(",");
		        String productName = productData[0];
		        int price = Integer.parseInt(productData[1]);

		        out.println("<html><body>");
		        out.println("<h2>Enter Quantity</h2>");
		        out.println("<form action='TotalBillServlet' method='post'>");
		        out.println("Quantity: <input type='number' name='quantity' required><br><br>");

		        // Hidden fields
		        out.println("<input type='hidden' name='productName' value='" + productName + "'>");
		        out.println("<input type='hidden' name='price' value='" + price + "'>");

		        out.println("<input type='submit' value='Calculate Total'>");
		        out.println("</form>");
		        out.println("</body></html>");
		    }
}
	

