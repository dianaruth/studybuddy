package studybuddy;

import static com.googlecode.objectify.ObjectifyService.ofy;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.googlecode.objectify.ObjectifyService;

public class ChangePriceServlet extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException
	{
		ObjectifyService.register(Student.class);
		ObjectifyService.register(Tutor.class);
		List<Tutor> tutors = ObjectifyService.ofy().load().type(Tutor.class).list();
		String tutorEmail = (String) req.getParameter("email");
		String price = (String) req.getParameter("price");
		Tutor t = new Tutor();
		
		for (int i = 0; i < tutors.size(); i++) {
			if (tutors.get(i).getEmail().equals(tutorEmail))
			{
				t = tutors.get(i);
				break;
			}
		}
		Double price_num = Double.parseDouble(price);
		t.setPrice(price_num);
		ofy().save().entity(t).now();
		ServletContext sc = getServletContext();
		RequestDispatcher rd = sc.getRequestDispatcher("/settings");
		rd.forward(req, resp);
	}
}
