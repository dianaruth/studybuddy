package studybuddy;

import java.util.ArrayList;
import java.util.Date;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

/**
 * The class extends Person and implements Subject. It should be made when a tutor account is opened. It contains all of the information
 * needed to keep tutors and student subscribers up to date.
 * Add code here if it belongs to Tutor but should not affect Student.
 */

@Entity

public class Tutor extends Person implements Subject{
	
	@Id Long id;
	private double price;
	private ArrayList<String> subjects = new ArrayList<String>();
	private ArrayList<Observer> subscribers = new ArrayList<Observer>();
	
	/**
	 * Sets a price for this tutor and notifies all subscribers of the change.
	 * @param number: The new price for this tutor.
	 */
	public void setPrice(double number){ 
		price = number;
		String msg = new String(firstName + " " + lastName + " has updated their price to " + number + ".");
		notifyObservers(msg);
	}
	
	/** 
	 * Adds a subject and notifies all of the subscribers of the change.
	 * @param subject: The subject to add to the tutor's list of subjects.
	 */
	public void addSubject(String subject){
		subjects.add(subject);
		notifyObservers(firstName + " " + lastName + " has added the subject " + subject + ".");
	}
	
	/**
	 * Removes a subject and notifies all subscribers of the change.
	 * @param subject: The subject to remove from the tutor's list of subjects.
	 */
	public void removeSubject(String subject)
	{
		int i = subjects.indexOf(subject);
		subjects.remove(i);
		notifyObservers(firstName + " " + lastName + " has removed the following subject from their list of tutored subjects: " + subject + ".");
		
	}
	
	/**
	 * 
	 * @return The price of the tutor.
	 */
	public double getPrice(){ return price;}
	
	/**
	 * 
	 * @return The list of subjects that this tutor handles.
	 */
	public ArrayList<String> getSubjects(){ return subjects;}
	
	/**
	 * Adds a student to the list of this tutor's subscribers.
	 */
	public void registerObserver(Student name){ subscribers.add(name);}
	
	/**
	 * Removes a student from this tutor's list of subscribers.
	 */
	public void removeObserver(Student name){ 
		int index = subscribers.indexOf(name);
		subscribers.remove(index);
	}

	/**
	 * Notifies all of this tutor's subscribers of any change to the tutor's price or subjects.
	 */
	public void notifyObservers(String msg) {
		Date date = new Date();
		for(int i = 0; i < subscribers.size(); i++)
		{
			subscribers.get(i).update(new Action(this, date, msg));
		}
		
	}

	
}