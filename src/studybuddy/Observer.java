package studybuddy;

public interface Observer {
	public void update(String updateMessage);
	public void setSubject(Subject subject);
}
