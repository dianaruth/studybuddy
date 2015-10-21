package studybuddy;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import com.googlecode.objectify.ObjectifyService;
import java.util.*;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

@SuppressWarnings("serial")
public class ForgotPasswordServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

		Properties props = new Properties();
		Session session = Session.getDefaultInstance(props, null);
		try {
			ObjectifyService.register(Student.class);
			ObjectifyService.register(Tutor.class);
			String email = req.getParameter("email");
        	List<Student> students = ObjectifyService.ofy().load().type(Student.class).list();
        	List<Tutor> tutors = ObjectifyService.ofy().load().type(Tutor.class).list();
        	boolean found = false;
        	String password = null;
        	Student s;
        	Tutor t;
        	for (int i = 0; i < students.size(); i++) {
        		s = students.get(i);
        		if (s.getEmail().equals(email)) {
        			found = true;
        			password = s.getPassword();
        			break;
        		}
        	}
        	if (!found) {
	        	for (int i = 0; i < tutors.size(); i++) {
	        		t = tutors.get(i);
	        		if (t.getEmail().equals(email)) {
	        			found = true;
	        			password = t.getPassword();
	        			break;
	        		}
	        	}
        	}
        	if (found) {
        		String msgBody = "Password for " + email + ":\n\n" + password;
        		Message msg = new MimeMessage(session);
			    msg.setFrom(new InternetAddress("forgotpassword@study-buddy-1105.appspotmail.com", "Study Buddy Password Service"));
        		msg.addRecipient(Message.RecipientType.TO, new InternetAddress(email, ""));
        		msg.setSubject("Forgot Password");
			    msg.setText(msgBody);
			    Transport.send(msg);
        	}
        	resp.sendRedirect("/index.jsp");
		}
		catch (AddressException e) {
		    e.printStackTrace();
		}
		catch (MessagingException e) {
		    e.printStackTrace();
		}
}

@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}