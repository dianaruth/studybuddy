package studybuddy;

import java.util.ArrayList;
import java.util.Date;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

/**
 * 
 * This is the student class. It extends the person class and implements Observer.
 * It contains the student's first and last name, their email, and a list of the tutors they
 *  are subscribed to. Add code here if it belongs to students but should not affect tutors.
 *
 */

@Entity

public class Student extends Person implements Observer {
	
	@Id Long id;
	private Subject tutorSubject;
	
	private ArrayList<Tutor> subs = new ArrayList<Tutor>();
	private ArrayList<Action> actions = new ArrayList<Action>();
	private ArrayList<Integer> tried = new ArrayList<Integer>();
	
	/**
	 * 
	 * @param tutor: The tutor object that the student will be subscribed to
	 * This method adds the student to the tutors subscriber list so that the student will receive
	 * any updates about the tutor.
	 * The method also adds the tutor to the students sub list to make deletion of student accounts
	 * easier.
	 */
	public void subscribe(Tutor tutor) {
		tutor.registerObserver(this);
		subs.add(tutor);
	}
	
	public void addTried(int attempt){ tried.add(attempt);}
	
	public boolean alreadyTried(int attempt){ return tried.contains(attempt);}
	
	public void clearTried(){tried = new ArrayList<Integer>();}
	
	/**
	 * 
	 * @param tutor: The tutor that the student will be unsubscribed from.
	 * This method will remove the student from the tutor's subscribers list and it will
	 * remove the tutor from the student's sub list.
	 */
	public void unsubscribe(Tutor tutor){
		tutor.removeObserver(this);
		subs.remove(tutor);
	}
	
	/**
	 * @param updateMeddage: The information about the update performed by the tutor to be sent in the email
	 *
	 * This method is called any time a tutor that the student is subscribed to 
	 * updates prices or subjects. It then sends the student an email with the update info.
	 */
	public void update(Action action){
		sendEmailUpdate(action.getAction());
		
	}
	
	public void addAction(Action action)
	{
		actions.add(action);
	}
	
	/**
	 * 
	 * @return subs: The list of all tutors that this student is subscribed to.
	 *  Used for when the student deletes their account and we need to delete them from 
	 *  every tutor subscribers list.
	 */
	public ArrayList<Tutor> getSubs(){return subs;}
	
	/**
	 * Takes care of actually sending the email to the student when an update occurs in a
	 * tutor that the student is subscribed to.
	 * 
	 * @param updateMessage The message to be sent to the student in the email.
	 */
	private void sendEmailUpdate(String updateMessage){
		EmailServlet email = new EmailServlet(this);
		email.sendEmail(updateMessage);
	}

}