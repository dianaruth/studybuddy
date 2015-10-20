package studybuddy;

import java.util.ArrayList;

import javax.persistence.metamodel.Entity;
/**
 * 
 * This is the student class. It extends the person class and implements Observer.
 * It contains the student's first and last name, their email, and a list of the tutors they
 *  are subscribed to.
 *
 */
public class Student extends Person implements Observer {
	
	private Subject tutorSubject;
	private ArrayList<Tutor> subs = new ArrayList<Tutor>();
	
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
	public void update(String updateMessage){
		sendEmailUpdate(updateMessage);
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