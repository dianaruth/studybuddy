package studybuddy;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;


public class TutorSignupServlet extends HttpServlet {
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
	{
		Key tutorKey = KeyFactory.createKey("tutor", "def");
		Entity tutor = new Entity("tutor", tutorKey);
		String firstName = req.getParameter("firstName");
		String lastName = req.getParameter("lastName");
		String email = req.getParameter("email");
		String priceString = req.getParameter("price");
		double price = Double.parseDouble(priceString);
		
		Tutor temp = new Tutor();
		temp.setFirstName(firstName);
		temp.setLastName(lastName);
		temp.setEmail(email);
		temp.setPrice(price);
		tutor.setProperty("tutor", temp);
		DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
		if(firstName != null && lastName != null && email != null && price >= 0)
			datastore.put(tutor);
		
	}

}
