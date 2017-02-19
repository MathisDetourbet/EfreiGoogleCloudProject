package com.efrei;

import java.io.IOException;
import javax.servlet.http.*;
import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;
import com.google.appengine.api.datastore.Transaction;


@SuppressWarnings("serial")
public class FormulaireServlet extends HttpServlet {
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String lastName = req.getParameter("last_name");
		String firstName = req.getParameter("first_name");
		
		if (lastName != null && firstName != null) {
			DatastoreService dataStore = DatastoreServiceFactory.getDatastoreService();
			
			Entity people = new Entity("People");
			people.setProperty("last_name", lastName);
			people.setProperty("first_name", firstName);
			dataStore.put(people);
			
			Query query = new Query("People");
			PreparedQuery pq = dataStore.prepare(query);
			
			for(Entity e: pq.asIterable()) {
				System.out.print("Last name people=" + e.getProperty("last_name"));
			}
			
			resp.sendRedirect("/traitement?last_name=" + lastName + "&first_name=" + firstName);
			
		} else {
			resp.sendRedirect("index.html");
		}
	}
}

