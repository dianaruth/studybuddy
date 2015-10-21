package studybuddy;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.googlecode.objectify.ObjectifyService;
import studybuddy.Tutor;
import studybuddy.Student;

import static com.googlecode.objectify.ObjectifyService.ofy;

public class LoginServlet extends HttpServlet{
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException
	{
		ObjectifyService.register(Student.class);
		ObjectifyService.register(Tutor.class);
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		List<Student> students = ObjectifyService.ofy().load().type(Student.class).list();
    	List<Tutor> tutors = ObjectifyService.ofy().load().type(Tutor.class).list();
    	boolean found = false;
    	String cookieEmail = null;
    	Student s;
    	Tutor t;
    	for (int i = 0; i < students.size(); i++) {
    		s = students.get(i);
    		if (s.getEmail().equals(email) && s.getPassword().equals(password)) {
    			found = true;
    			cookieEmail = s.getEmail();
    			break;
    		}
    	}
    	if (!found) {
        	for (int i = 0; i < tutors.size(); i++) {
        		t = tutors.get(i);
        		if (t.getEmail().equals(email) && t.getPassword().equals(password)) {
        			found = true;
        			cookieEmail = t.getEmail();
        			break;
        		}
        	}
    	}
    	if (found) {
    		Cookie cookie = new Cookie("email", cookieEmail);
    		resp.addCookie(cookie);
    		resp.sendRedirect("/dashboard.jsp");
    	}
    	else {
    		resp.sendRedirect("/index.jsp");
    	}
	}

}
