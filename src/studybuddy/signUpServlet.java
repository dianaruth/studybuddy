package studybuddy;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

public class signUpServlet extends HttpServlet {
	/**
	 * Registers new student accounts in the DataStore. Must pass data: firstName, lastName, email.
	 * If any of these fields are null, the student will not be added to the DataStore.
	 */
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
	{
		Key studentKey = KeyFactory.createKey("student", "def");
		Entity student = new Entity("student", studentKey);
		String firstName = req.getParameter("firstName");
		String lastName = req.getParameter("lastName");
		String email = req.getParameter("email");
		
		Student profile = new Student();
		profile.setFirstName(firstName);
		profile.setLastName(lastName);
		profile.setEmail(email);
		student.setProperty("student", profile);
		DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
		if(firstName != null && lastName != null && email != null)
			datastore.put(student);
		
	}

}
