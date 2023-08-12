
public class Admin extends User{
	
	private int staffNumber;
	private int password;
	
	
	public Admin( String name, String email, int password, int staffNumber) {
		super( name, email, password); // Calling User constructor
		this.staffNumber=staffNumber;
	}
	
	public Admin() { //Admin empty constructor
		getName();
		getEmail();
		staffNumber = 0;
		password = 0;
		
	}
	
	public int getStaffNumber() {
		return staffNumber;
	}

	public void setStaffNumber(int staffNumber) {
		this.staffNumber = staffNumber;
	}

	public int getPassword() {
		return password;
	}

	public void setPassword(int password) {
		this.password = password;
	}
	
	public String toString() {
		
		return getName() + " " + getEmail() + " " + staffNumber + " " + password ;
	}
	
	
}
