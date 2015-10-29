package studybuddy;

/** 
* Person class defines a user and it is extended by tutor and student. This is where all of the code goes that should be
* shared between student and tutor class. 
* Includes basic information of any type of user
* This class can be extended to define more specific users
*/
public class Person {
	protected String firstName;
	protected String lastName;
	protected String email;
	protected String password;
	protected boolean passChange;
	protected int changeCode;
	protected boolean isTutor;
	
	/** 
	 * @return email of person
	 */
	public String getEmail(){ return email; }
	
	/**
	 * 
	 * @param number: The random number generated when a user requests a password change. This number is used to validate the user's id.
	 */
	public void setChangeCode(int number){ changeCode = number; }
	
	/** 
	 * 
	 * @return the random integer that was generated during the password reset request. Used for security.
	 */
	public int getChangeCode(){ return changeCode; }
	
	/**
	 * Sets the boolean passChange to true. Used when a user requests a password change.
	 */
	public void setPassChange(){ passChange = true;}
	
	/**
	 * Sets the passChange to false so that the user's password cannot be changed.
	 */
	public void resetPassChange(){ passChange = false; }
	
	/**
	 * 
	 * @return passChange. If this boolean is not true, the user's password should not be changed.
	 */
	
	public boolean getPassChange(){ return passChange; }
	
	/**
	 * @return password of person
	 */
	
	public String getPassword() { return password; }
	
	/** 
	 * @return first name of person
	 */
	public String getFirstName(){ return firstName; }
	
	
	/** 
	 * @return last name of person
	 */
	public String getLastName(){ return lastName; }
	
	/**
	 * @return whether or not the person is a tutor
	 */
	public boolean getIsTutor() { return isTutor;}
	
	/** 
	 * @param email address of person
	 */
	public void setEmail(String email){ this.email = email; }
	
	/**
	 * @param password
	 */
	public void setPassword(String password){ this.password = password; }
	
	/** 
	 * @param first name of person
	 */
	public void setFirstName(String name){ firstName = name; }
	
	/** 
	 * @param last name of person
	 */
	public void setLastName(String name){ lastName = name;}
	
	/** 
	 * @param whether or not person is a tutor. Used for user interface.
	 */
	public void setIsTutor(boolean tutor){ isTutor = tutor;}
}
