
public class Admin extends User{
	
	private int staffNumber;
	private int password;
	
	public Admin() { //Admin empty constructor
		getName();
		getEmail();
		staffNumber = 0;
		password =  0 ;	
	}
	
	public Admin(String name, String email, int staffNumber) {
		super();
		this.staffNumber=staffNumber;
		
	}
	
	public Admin(int password) {
		this.password=password;
	}
	
	public Admin( int staffNumber, int password) {
		this.staffNumber = staffNumber;
		this.password = password;
	}
	

	public Admin(String name, String email, int password, int staffNumber) {
		super();
		this.password=password;
		this.staffNumber=staffNumber;
	}

	public int getPassword() {
		return password;
	}

	public void setPassword(int password) {
		this.password = password;
	}

	public int getStaffNumber() {
		return staffNumber;
	}

	public void setStaffNumber(int staffNumber) {
		this.staffNumber = staffNumber;
	}

	public String toString() {
		
		return getName() + " " + getEmail() + " " + getPassword() + staffNumber + " ";
	}
	
	
}
