package studybuddy;

public class Student extends Person implements Observer {
	
	public void subscribe(Tutor tutor) {
		tutor.subscribe(this);
	}
	
	public void unsubscribe(Tutor tutor){
		tutor.unsubscribe(this);
	}
	public void update(Tutor tutor)
	{
		
	}
	
	
}