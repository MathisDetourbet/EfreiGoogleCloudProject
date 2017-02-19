package com.efrei;

import java.io.IOException;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class TraitementServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String lastName = req.getParameter("last_name");
		String firstName = req.getParameter("first_name");
		
		resp.setContentType("text/plain");
		resp.getWriter().println("Your last name is: " + lastName + " and your first name is: " + firstName);
	}
}
