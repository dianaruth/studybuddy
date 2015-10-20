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
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
	{
		Key studentKey = KeyFactory.createKey("student", "def");
		Entity student = new Entity("student", studentKey);
		String firstName = req.getParameter("firstName");
		String lastName = req.getParameter("lastName");
		String email = req.getParameter("email");
		
		Student temp = new Student();
		temp.setFirstName(firstName);
		temp.setLastName(lastName);
		temp.setEmail(email);
		student.setProperty("student", temp);
		DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
		if(firstName != null && lastName != null && email != null)
			datastore.put(student);
		
	}

}
