
public class Ticket {
	private int ticketNumber;
	private String passenger;
	private String flight;
	private String seatNumber;
	private String status;

public Ticket() { //================ blank constructor
	 ticketNumber = 13390001;
	 passenger = "Harry Potter";
	 flight = "Singapore Airline";
	 seatNumber = "F22";
	 status = "Pending";
}

public Ticket(int ticketNumber,String passenger,String flight,String seatNumber,String status) { //================ blank constructor
	 this.ticketNumber = ticketNumber; 
	 this.passenger = passenger;
	 this.flight = flight;
	 this.seatNumber = seatNumber;
	 this.status = status;
}

public int getTicketNumber() {
	return ticketNumber;
}

public void setTicketNumber(int ticketNumber) {
	this.ticketNumber = ticketNumber;
}

public String getPassenger() {
	return passenger;
}

public void setPassenger(String passenger) {
	this.passenger = passenger;
}

public String getFlight() {
	return flight;
}

public void setFlight(String flight) {
	this.flight = flight;
}

public String getSeatNumber() {
	return seatNumber;
}

public void setSeatNumber(String seatNumber) {
	this.seatNumber = seatNumber;
}

public String getStatus() {
	return status;
}

public void setStatus(String status) {
	this.status = status;
}
	
}
