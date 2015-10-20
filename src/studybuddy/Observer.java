package studybuddy;

/**
 * 
 * Observer.java
 * Interface class for observer 
 * Implemented by all observers
 * 
 */
public interface Observer {
	public void update(String updateMessage);
	public void setSubject(Subject subject);
}
