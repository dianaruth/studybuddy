package studybuddy;

public class Student extends Person implements Observer {
	
	private Subject tutorSubject;
	
	public void subscribe(Tutor tutor) {
		tutor.registerObserver(this);
	}
	
	public void unsubscribe(Tutor tutor){
		tutor.removeObserver(this);
	}
	
	public void update(String updateMessage){
		sendEmailUpdate(updateMessage);
	}
	
	public void setSubject(Subject subject) {
		this.tutorSubject = subject;
	}
	
	public void sendEmailUpdate(String updateMessage){
		
	}
}