package studybuddy;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import com.googlecode.objectify.ObjectifyService;

import static com.googlecode.objectify.ObjectifyService.ofy;

public class StudentSignUpServlet extends HttpServlet {
	/**
	 * Registers new student accounts in the DataStore. Must pass data: firstName, lastName, email.
	 * If any of these fields are null, the student will not be added to the DataStore.
	 */
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException
	{
		ObjectifyService.register(Student.class);
		String firstName = req.getParameter("firstName");
		String lastName = req.getParameter("lastName");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		
		Student profile = new Student();
		profile.setFirstName(firstName);
		profile.setLastName(lastName);
		profile.setEmail(email);
		profile.setPassword(password);
		profile.setIsTutor(false);
		ofy().save().entity(profile).now();
		Cookie cookie = new Cookie("email", email);
		resp.addCookie(cookie);
        resp.sendRedirect("/dashboard.jsp");
	}

}
