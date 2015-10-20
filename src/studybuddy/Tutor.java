package studybuddy;

import java.util.ArrayList;

import javax.persistence.metamodel.Entity;

public class Tutor extends Person implements Subject{
	
	private double price;
	private ArrayList<String> subjects = new ArrayList<String>();
	private ArrayList<Observer> subscribers = new ArrayList<Observer>();
	
	public void setPrice(double number){ 
		price = number;
		String msg = new String(firstName + " " + lastName + " has updated their price to " + number + ".");
		notifyObservers(msg);
	}
	
	public void addSubject(String subject){
		subjects.add(subject);
		notifyObservers(firstName + " " + lastName + " has added the subject " + subject + ".");
	}
	
	public void removeSubject(String subject)
	{
		int i = subjects.indexOf(subject);
		subjects.remove(i);
		notifyObservers(firstName + " " + lastName + " has removed the following subject from their list of tutored subjects: " + subject + ".");
		
	}
	
	public double getPrice(){ return price;}
	
	public ArrayList<String> getSubjects(){ return subjects;}
	
	public void registerObserver(Student name){ subscribers.add(name);}
	
	public void removeObserver(Student name){ 
		int index = subscribers.indexOf(name);
		subscribers.remove(index);
	}

	public void notifyObservers(String msg) {
		for(int i = 0; i < subscribers.size(); i++)
		{
			subscribers.get(i).update(msg);
		}
		
	}

	
}