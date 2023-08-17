

import java.io.Serializable;

public class User implements Serializable{
	
	
	/*In Java, the Serializable interface is used to indicate that a class can be converted into a byte stream
	 *  and later reconstructed back into an object. 
	 *  
	 * This process is known as object serialization and deserialization.
	 * 
	 * When you implement the Serializable interface, you are essentially telling the Java runtime that 
	 * your class can be saved to a file, sent over the network, or otherwise persisted in a serialized form. 
	 * 
	 * This feature is particularly useful in various scenarios:
	 * 
	 * Object Persistence: You can save the state of an object to a file or a database and later retrieve it to recreate the object exactly as it was. This is commonly used in applications where you need to store and restore the state of objects, such as in web applications or game development.
	*/
	
	
	 // Use the same value as in the serialized data
	
	private int accNumber;
	private boolean accStatus;
	private int password;
	
	
	private String name;
	private String email;
	private String userID;
	
	
	public User(String userID, String name, String email, boolean accStatus, int accNumber ) {
		this.accStatus = accStatus;
		this.accNumber = accNumber;
		
	}
	
	public User() { //============= Match constuctor to Admin
		getName();
		getUserID();
		getEmail();
		accNumber = 012044521;
		accStatus = true;
		password = 0;
	}
	
	public void User1() {//============= Match constuctor to User
		name = "";
		userID = "F24";
		email = "Koinathan@gmail.com";
		
	}
	 public User( String userId, String name, String email, int password) {  //constructor with attributes 
			
			this.userID = userId;
			this.name = name;
			this.email = email;
			this.password = password;
			
	   }
	   
	   public User( String userId, String name, String email) {  //constructor with attributes 
			
			this.userID = userId;
			this.name = name;
			this.email = email;
	   }
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public User(String userID, String name, int password, String email, int accNumber, boolean accStatus) { //full arguments============= full constructor
		
		super();
		this.accNumber = accNumber;
		this.accStatus = accStatus;
	}
	
	public User( int accNumber, int password) { //============= Match constuctor to Admin
		
		this.accNumber = accNumber;
		this.password = password;
	}
	
	//Accessors
	public User(int accNumber) {
		this.accNumber = accNumber;
	}

	public User(int password, String userID, String name, String email) {
		this.password = password;
		this.userID = userID;
		this.name = name;
		this.email = email;
	}

	public int getAccNumber() {
		return accNumber;
	}

	public void setAccNumber(int accNumber) {
		this.accNumber = accNumber;
	}

	public boolean isAccStatus() {
		return accStatus;
	}

	public void setAccStatus(boolean accStatus) {
		this.accStatus = accStatus;
	}

	public int getPassword() {
		return password;
	}

	public void setPassword(int password) {
		this.password = password;
	}
	
	//methods
	void displayUser() {
		System.out.println("Name: " + getName());
		System.out.println("UserID: " + getUserID());
		System.out.println("Name: " + getEmail());
		System.out.println("Account Number: " + getAccNumber());
		System.out.println("Account status: " + isAccStatus());
	}
	public String toString() {
		return getName() + "    " +getUserID() + "    " +getEmail() + "    " + accNumber + "    " + accStatus;
	}

}
