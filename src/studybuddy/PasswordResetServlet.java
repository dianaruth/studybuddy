package studybuddy;

import java.io.IOException;
import java.util.List;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.googlecode.objectify.ObjectifyService;

public class PasswordResetServlet extends HttpServlet {
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException
	{
		ObjectifyService.register(Student.class);
		ObjectifyService.register(Tutor.class);
		String email = (String) req.getSession().getAttribute("email");
		String changeCodeString = (String)req.getSession().getAttribute("number");;
		String newPassword = req.getParameter("password");
		int changeCode = Integer.parseInt(changeCodeString);
       	List<Student> students = ObjectifyService.ofy().load().type(Student.class).list();
       	List<Tutor> tutors = ObjectifyService.ofy().load().type(Tutor.class).list();
       	boolean found = false;
       	Person p = new Student();
       	for (int i = 0; i < students.size(); i++) {
       		p = students.get(i);
       		if (p.getEmail().equals(email)) {
      			found = true;
       			break;
       		}
       	}
       	if (!found) {
        	for (int i = 0; i < tutors.size(); i++) {
        		p = tutors.get(i);
        		if (p.getEmail().equals(email)) {
        			found = true;
        			break;
        		}
        	}
       	}
       	if (found && p.getPassChange() && changeCode == p.getChangeCode()) {
       		p.setPassword(newPassword);
       		p.resetPassChange();
       		p.setChangeCode(0);
       	}
      	resp.sendRedirect("/index.jsp");
	}

}
