package studybuddy;

public abstract class Person {
	protected String firstName;
	protected String lastName;
	protected String email;
	
	public String getEmail(){ return email; }
	
	public String getFirstName(){ return firstName; }

	public String getLastName(){ return lastName; }
	
	public void setEmail(String temp){ email = temp; }
	
	public void setFirstName(String name){ firstName = name; }
	
	public void setLastName(String name){ lastName = name;}
}
