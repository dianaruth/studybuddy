package studybuddy;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.googlecode.objectify.ObjectifyService;

public class GetTutorServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException
	{
		ObjectifyService.register(Tutor.class);
		ObjectifyService.register(Student.class);
		List<Student> students = ObjectifyService.ofy().load().type(Student.class).list();
       	List<Tutor> tutors = ObjectifyService.ofy().load().type(Tutor.class).list();
		String email = (String) req.getSession().getAttribute("student_email");
		Student s = new Student();;
		for(int i = 0; i < students.size(); i ++)
		{
			if(students.get(i).getEmail().equals(email))
				s = students.get(i);
		}
		
		int i = 0;
		while(i < tutors.size() && s.alreadyTried(i))
			i++;
		if(i < tutors.size())
		{
			req.setAttribute("tutor_first_name", tutors.get(i).getFirstName());
			req.setAttribute("tutor_last_name", tutors.get(i).getLastName());
		}
		else
		{
			s.clearTried();
			i = 0;
			req.setAttribute("tutor_first_name", tutors.get(i).getFirstName());
			req.setAttribute("tutor_last_name", tutors.get(i).getLastName());
		}
		resp.sendRedirect("/dashboard.jsp");
	}

}
