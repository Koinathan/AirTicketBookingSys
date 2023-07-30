import java.io.Serializable;

public class User implements Serializable {
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
	
	
	private String userID;
	private String name;
	private String email;
	private int password;
	
	
	

	User(String userID, String name, String email, int password) { //============= full constructor
		
		this.userID = userID;
		this.name = name;
		this.email = email;
		this.password = password;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
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

	public int getPassword() {
		return password;
	}

	public void setPassword(int password) {
		this.password = password;
	}
	
	public String toString() {
		return userID + " " + name + " " + email + " " + password;
	}
	
}
