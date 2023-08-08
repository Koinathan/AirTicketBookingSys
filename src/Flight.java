import java.io.Serializable;

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


public class Flight implements Serializable {

	private String flightNumber;
	private String airline;
	private String source;
	private String destination;
	private int departureTime;
	private int arrivalTime;
	private double price;
	private int availableSeats;
	
	
	
	
	public Flight() { //================ blank constructor
		flightNumber = "SQ110011";
		airline = "Singapore Airline";
		source = "Singapore Changi Airport";
		destination = "Abu Dhabi International Airport";
		departureTime = 1130;
		arrivalTime = 0135;
		price = 666 ;
		availableSeats = 399;
		
	}

	public Flight(String flightNumber, String airline, String source, String destination,int departureTime, int arrivalTime,double price,int availableSeats) { //============= full constructor
		
		this.flightNumber = flightNumber;
		this.airline = airline;
		this.source = source;
		this.destination = destination;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
		this.price = price;
		this.availableSeats = availableSeats;
	}

	public String getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}

	public String getAirline() {
		return airline;
	}

	public void setAirline(String airline) {
		this.airline = airline;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public int getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(int departureTime) {
		this.departureTime = departureTime;
	}

	public int getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(int arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getAvailableSeats() {
		return availableSeats;
	}

	public void setAvailableSeats(int availableSeats) {
		this.availableSeats = availableSeats;
	}
	
	public String toString() {
		return flightNumber + "       " + airline + "    " + source + "    " + destination + "    " + departureTime + "    " + arrivalTime + "    " + price + "    " + availableSeats + "    " ;		 
	}

	
	
}
