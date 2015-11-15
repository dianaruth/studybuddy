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
			Tutor t = null;
			int i;
			for(i = 0; i < tutors.size(); i++)
			{
				if(!s.alreadyTried(tutors.get(i).getEmail()) && !s.getSubs().contains(tutors.get(i)))
				{
					t = tutors.get(i);
					req.setAttribute("tutor_first_name", t.getFirstName());
					req.setAttribute("tutor_last_name", t.getLastName());
					req.setAttribute("tutor_price","$" + t.getPrice());
					s.addTried(t.getEmail());
					ofy().save().entity(s).now();
					break;
				}
			}
			if(t == null)
			{
				req.setAttribute("tutor_first_name", "Out of tutors");
				req.setAttribute("tutor_last_name", " ");
				req.setAttribute("tutor_price", " ");
				s.clearTried();
				ofy().save().entity(s).now();
			}
		}
		ServletContext sc = getServletContext();
		RequestDispatcher rd = sc.getRequestDispatcher("/dashboard.jsp");
		rd.forward(req, resp);
	}
}