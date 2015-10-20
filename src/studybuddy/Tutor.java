package studybuddy;

import java.util.ArrayList;

public class Tutor extends Person implements Subject{
	
	private double price;
	private ArrayList<String> subjects = new ArrayList<String>();
	private ArrayList<Student> subscribers = new ArrayList<Student>();
	
	public void setPrice(double number){ price = number;}
	
	public void addSubject(String subject){ subjects.add(subject);}
	
	public double getPrice(){ return price;}
	
	public ArrayList<String> getSubjects(){ return subjects;}
	
	public void registerObserver(Student name){ subscribers.add(name);}
	
	public void removeObserver(Student name){ 
		int index = subscribers.indexOf(name);
		subscribers.remove(index);
	}

	public void notifyObservers() {
		
	}

	public Object getUpdate() {
		return null;
	}
}