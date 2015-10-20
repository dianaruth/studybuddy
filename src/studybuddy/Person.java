package studybuddy;

public abstract class Person {
	private String firstName;
	private String lastName;
	private String email;
	
	public String getEmail(){ return email; }
	
	public String getFirstName(){ return firstName; }

	public String getLastName(){ return lastName; }
	
	public void setEmail(String temp){ email = temp; }
	
	public void setFirstName(String name){ firstName = name; }
	
	public void setLastName(String name){ lastName = name;}
}
