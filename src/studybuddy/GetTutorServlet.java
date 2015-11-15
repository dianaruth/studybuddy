package studybuddy;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.googlecode.objectify.ObjectifyService;
import static com.googlecode.objectify.ObjectifyService.ofy;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;



public class GetTutorServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException
	{
		ObjectifyService.register(Student.class);
		ObjectifyService.register(Tutor.class);
		List<Student> students = ObjectifyService.ofy().load().type(Student.class).list();
		List<Tutor> tutors = ObjectifyService.ofy().load().type(Tutor.class).list();
		String email = (String) req.getSession().getAttribute("email");
		Student s = null;
		for (int i = 0; i < students.size(); i++) {
			s = students.get(i);
			if (s.getEmail().equals(email)) {
				break;
			}
		}
		if(tutors.size() > 0)
		{
			int i = 0;
			while(i < tutors.size() && s.alreadyTried(tutors.get(i).getEmail()))
				i++;
			if(i == tutors.size())
			{
				s.clearTried();
				i = 0;
				s.addTried(tutors.get(i).getEmail());
				ofy().save().entity(s).now();
			}
			else
			{
				s.addTried(tutors.get(i).getEmail());
				ofy().save().entity(s).now();
			}
			if(tutors.get(i) != null)
			{
				req.setAttribute("tutor_first_name", tutors.get(i).getFirstName());
				req.setAttribute("tutor_last_name", tutors.get(i).getLastName());
			}
		}
		ServletContext sc = getServletContext();
		RequestDispatcher rd = sc.getRequestDispatcher("/dashboard.jsp");
		rd.forward(req, resp);
	}
}