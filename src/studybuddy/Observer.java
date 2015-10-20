package studybuddy;

/**
 * 
 * Observer.java
 * Interface class for observer 
 *implemented by all observer
 * 
 */
public interface Observer {
	public void update(String updateMessage);
	public void setSubject(Subject subject);
}
