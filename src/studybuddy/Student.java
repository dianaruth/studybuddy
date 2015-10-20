package studybuddy;

import java.util.ArrayList;

import javax.persistence.metamodel.Entity;

public class Student extends Person implements Observer {
	
	private Subject tutorSubject;
	private ArrayList<Tutor> subs = new ArrayList<Tutor>();
	
	public void subscribe(Tutor tutor) {
		tutor.registerObserver(this);
		subs.add(tutor);
	}
	
	public void unsubscribe(Tutor tutor){
		tutor.removeObserver(this);
		subs.remove(tutor);
	}
	
	public void update(String updateMessage){
		sendEmailUpdate(updateMessage);
	}
	
	public void setSubject(Subject subject) {
		this.tutorSubject = subject;
	}
	
	public ArrayList<Tutor> getSubs(){return subs;}
	
	private void sendEmailUpdate(String updateMessage){
		EmailServlet email = new EmailServlet(this);
		email.sendEmail(updateMessage);
	}

}