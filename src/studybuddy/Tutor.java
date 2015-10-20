package studybuddy;

import java.util.ArrayList;

public class Tutor extends Person implements Subject{
	
	private double price;
	private ArrayList<String> subjects = new ArrayList<String>();
	private ArrayList<Observer> subscribers = new ArrayList<Observer>();
	
	public void setPrice(double number){ 
		price = number;
		String msg = new String(firstName + " " + lastName + " has updates his price to " + number + ".");
		notifyObservers(msg);
	}
	
	public void addSubject(String subject){ subjects.add(subject);}
	
	public double getPrice(){ return price;}
	
	public ArrayList<String> getSubjects(){ return subjects;}
	
	public void registerObserver(Observer name){ subscribers.add(name);}
	
	public void removeObserver(Observer name){ 
		int index = subscribers.indexOf(name);
		subscribers.remove(index);
	}

	@Override
	public void notifyObservers(String msg) {
		for(int i = 0; i < subscribers.size(); i++)
		{
			subscribers.get(i).update();
		}
		
	}

	
	
	
}