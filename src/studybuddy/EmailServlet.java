package studybuddy;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.FetchOptions;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.api.datastore.Query;

public class EmailServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
		Key emailKey = KeyFactory.createKey("emailbook", "Def");
		Query query = new Query("email", emailKey);
		Query gq = new Query("Greeting", guestbookKey);
		Query unsubQuery = new Query("email", unsubKey);
				 
				 List<Entity> greetings = datastore.prepare(gq).asList(FetchOptions.Builder.withOffset(0));
				 List<Entity> emails = datastore.prepare(query).asList(FetchOptions.Builder.withOffset(0));
				 List<Entity> unsubEmails = datastore.prepare(unsubQuery).asList(FetchOptions.Builder.withOffset(0));
				 
				 Date current = new Date();
			StringBuilder mesg = new StringBuilder();
			mesg.append("Here are all of the new posts on My Life as Chris Gill made in the last 24 hours! \n");
			for(int i = 0; i < greetings.size(); i ++)
			{
				Date post = (Date)greetings.get(i).getProperty("date");
				Entity temp = greetings.get(i);
				if(current.getTime() - post.getTime() <= 86400000)
				{
					mesg.append(temp.getProperty("user") + " ");
					mesg.append(temp.getProperty("date") + "\n");
					mesg.append(temp.getProperty("name") + "\n");
					mesg.append(temp.getProperty("content") + "\n\n");
				}
			}
				
			// Sender's email ID needs to be mentioned
			String from = "jshahan17@gmail.com";
			
			// Assuming you are sending email from localhost
			String host = "localhost";
			
			// Get system properties
			Properties properties = System.getProperties();
			
			// Setup mail server
			properties.setProperty("mail.smtp.host", host);
			
			// Get the default Session object.
			Session session = Session.getDefaultInstance(properties);
			
			// Set response content type
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			if(!(mesg.toString().isEmpty()))
			{
				try{
				  // Create a default MimeMessage object.
				  MimeMessage message = new MimeMessage(session);
				  // Set From: header field of the header.
				  message.setFrom(new InternetAddress(from));
				  // Set To: header field of the header.
				  for(int i = 0; i < emails.size(); i += 1)
					{	
					  if(isSubscribed(emails.get(i), unsubEmails))
					  {
					  	message.addRecipient(Message.RecipientType.TO,
				                         		new InternetAddress(emails.get(i).getProperty("email").toString()));
					  }
					}
				  
				  // Set Subject: header field
				  message.setSubject("Daily Email Update from My Life as Chris Gill");
				  // Now set the actual message
				  message.setText(mesg.toString());
				  // Send message
				  Transport.send(message);
				  String title = "Send Email";
				  String res = "Sent message successfully....";
				  String docType =
				  "<!doctype html public \"-//w3c//dtd html 4.0 " +
				  "transitional//en\">\n";
				  out.println(docType +
				  "<html>\n" +
				  "<head><title>" + title + "</title></head>\n" +
				  "<body bgcolor=\"#f0f0f0\">\n" +
				  "<h1 align=\"center\">" + title + "</h1>\n" +
				  "<p align=\"center\">" + res + "</p>\n" +
				  "</body></html>");
				}catch (MessagingException mex) {
				  mex.printStackTrace();
				}
			}
		}
}
