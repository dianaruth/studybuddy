package studybuddy;
import static com.googlecode.objectify.ObjectifyService.ofy;

import java.io.IOException;

import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.AddressException;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.googlecode.objectify.ObjectifyService;

import java.util.*;

public class ChangeSubjectServlet extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

		Properties props = new Properties();
		Session session = Session.getDefaultInstance(props, null);
		try {
			ObjectifyService.register(Student.class);
			ObjectifyService.register(Tutor.class);
			List<Student> students = ObjectifyService.ofy().load().type(Student.class).list();
			List<Tutor> tutors = ObjectifyService.ofy().load().type(Tutor.class).list();
			String email = (String) req.getSession().getAttribute("email");
			Tutor t = new Tutor();
			for(int i = 0; i < tutors.size(); i += 1) {
				t = tutors.get(i);
        		if (t.getEmail().equals(email)) {
        			break;
        		}
			}
			
			
		}
		catch (AddressException e) {
		    e.printStackTrace();
		}
		catch (MessagingException e) {
		    e.printStackTrace();
		}
}
