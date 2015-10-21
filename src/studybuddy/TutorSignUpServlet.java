package studybuddy;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;


public class TutorSignUpServlet extends HttpServlet {
	
	/**
	 * Registers new tutor accounts in the DataStore. Must pass data: firstName, lastName, email,
	 * price (as a string). If any field is null or if the price is less than 0.00, the tutor
	 * will not be added to the DataStore. **NOTE: Will need to add subject to this function after 
	 * front end is done**.
	 */
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
	{
		Key tutorKey = KeyFactory.createKey("tutor", "def");
		Entity tutor = new Entity("tutor", tutorKey);
		String firstName = req.getParameter("firstName");
		String lastName = req.getParameter("lastName");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		String priceString = req.getParameter("price");
		double price = Double.parseDouble(priceString);
		
		Tutor profile = new Tutor();
		profile.setFirstName(firstName);
		profile.setLastName(lastName);
		profile.setEmail(email);
		profile.setPassword(password);
		profile.setPrice(price);
		tutor.setProperty("tutor", profile);
		DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
		if(firstName != null && lastName != null && email != null && password != null && price >= 0)
			datastore.put(tutor);
	}

}
