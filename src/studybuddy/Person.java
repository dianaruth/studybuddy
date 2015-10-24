package studybuddy;

/** 
* Person class defines a user  
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
	
	/** 
	 * @return email of person
	 */
	public String getEmail(){ return email; }
	
	public void setChangeCode(int number){ changeCode = number; }
	
	public void setPassChange(){ passChange = true;}
	
	public void resetPassChange(){ passChange = false; }
	
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
}
