package studybuddy;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.googlecode.objectify.ObjectifyService;
import static com.googlecode.objectify.ObjectifyService.ofy;
import java.io.IOException;
import java.util.ArrayList;
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
		if(tutors.size() > 0 && email != null)
		{
			Tutor t = null;
			int i;
			for(i = 0; i < tutors.size(); i++)
			{
				if(!s.alreadyTried(tutors.get(i).getEmail()) && !s.getSubs().contains(tutors.get(i).getEmail()))
				{
					t = tutors.get(i);
					s.addTried(t.getEmail());
					ofy().save().entity(s).now();
					req.setAttribute("tutor_first_name", t.getFirstName());
					req.setAttribute("tutor_last_name", t.getLastName());
					req.setAttribute("tutor_price","$" + t.getPrice() + "/hr");
					req.setAttribute("tutor_email", t.getEmail());
					break;
				}
			}
			if(t == null)
			{
				s.clearTried();
				ofy().save().entity(s).now();
				req.setAttribute("tutor_first_name", "Out of tutors");
				req.setAttribute("tutor_last_name", " ");
				req.setAttribute("tutor_price", " ");
			}
		}
		ServletContext sc = getServletContext();
		RequestDispatcher rd = sc.getRequestDispatcher("/dashboard.jsp");
		rd.forward(req, resp);
	}
}