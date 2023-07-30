import java.io.*;
import java.util.*;

public class MainSystem {

public static void main(String[] args) throws Exception {
		
		//VARIABLES
		int choice = -1;
		String userID,name, email;
		int password;
		
		//TXT FILES. 
		File userFile = new File("User.txt"); //USER TXT
		File flightFile = new File("Flight.txt"); // FLIGHT TXT
		File bookingFile = new File("Ticket.txt");// TICKET TXT
		
		//SCANNERS
		Scanner s = new Scanner(System.in);
		Scanner s1 = new Scanner(System.in);
		Scanner s2 = new Scanner(System.in);
		
		//COLLECTIONS
		ArrayList<User> al = new ArrayList<User>();
		ArrayList<Flight> fl = new ArrayList<Flight>();
		ArrayList<Ticket> tk = new ArrayList<Ticket>();
		
		//OOS/OIS/List Iterator
		ObjectOutputStream oos = null;
		ObjectInputStream ois = null;
		ListIterator li = null; //print as list orderly.
		
		
		
		do {
			System.out.println("\n1.CREATE USER ACCOUNT");
			System.out.println("2.DISPLAY USER");
			System.out.println("3.USER LOGIN");
			
			System.out.println("0.EXIT");
			System.out.println("Enter your choice: ");
			choice = s.nextInt();
			
			switch(choice) { //CREATE USER ACCOUNT
				case 1: 
					System.out.print("Enter UserID No: ");
					userID = s1.next();
					
					System.out.print("Enter Name: ");
					name = s1.next();
					
					System.out.print("Enter Email address: ");
					email = s1.next();
					
					System.out.print("Enter password: ");
					password = s.nextInt();
					
					al.add(new User(userID,name,email,password));
					
					oos = new ObjectOutputStream(new FileOutputStream(userFile)); //then only will write collection into file
					oos.writeObject(al);
					oos.close(); //put object into arraylist then persist it in a txt file
					
					
				break;
				case 2: //DISPLAY USERS
					ois = new ObjectInputStream(new FileInputStream(userFile));
					al = (ArrayList<User>)ois.readObject();
					ois.close();
					
					System.out.println("-------------------------------------------------------");
					li = al.listIterator();
					while(li.hasNext())
						System.out.println(li.next());
					System.out.println("-------------------------------------------------------");
				break;
			
				case 3: //USER LOGIN
					System.out.println("Enter your Email address");
					email = s.next();
					
					System.out.print("Enter your Password: ");
					password = s.nextInt();
					
					while(true) {
						
						System.out.println("1.View Flights \n2.Book a Flight \n3.Exit");
						int option = s.nextInt();
						
						switch(option) {
						case 1: //DISPLAY FLIGHTS
							if(flightFile.isFile()) {
								ois = new ObjectInputStream(new FileInputStream(flightFile));
								fl = (ArrayList<Flight>)ois.readObject();
								ois.close();
								
								System.out.println("-------------------------------------------------------");
								li = fl.listIterator();
								while(li.hasNext())
									System.out.println(li.next());
									System.out.println(fl);
								System.out.println("-------------------------------------------------------");
							}else {
								System.out.println("File do not exist..!");
							}
							break; //==========================================================================
						case 2:
							
						}
					}
				
				
				case 39: //admin add flight
					String Flightnumber,source,airline,destination;
					int departureTime,arrivalTime, availableSeats;
					double price;
					
					System.out.println("Enter Flightnum No: ");
					Flightnumber = s.next();
					
					System.out.println("Enter Airlines: ");
					airline = s.next();
					
					System.out.println("Enter source: ");
					source = s.next();
					
					System.out.println("Enter destination: ");
					destination = s.next();
					
					System.out.println("Enter departureTime: ");
					departureTime = s.nextInt();
					
					System.out.println("Enter arrivaltime: ");
					arrivalTime = s.nextInt();
					
					System.out.println("Enter price: ");
					price = s.nextDouble();
					
					System.out.println("Enter availableSeats: ");
					availableSeats = s.nextInt();
					

					
					fl.add(new Flight(Flightnumber,airline,source,destination,departureTime,arrivalTime,price,availableSeats));
					
					oos = new ObjectOutputStream(new FileOutputStream(flightFile)); //then only will write collection into file
					oos.writeObject(fl);
					oos.close(); //put object into arraylist then persist it in a txt file

					break;
					
					
				
									
				
				}
				
				
				
				
				
				
				
				
				
				
				
			
	
			
				
			
		}while(choice!=0);
		
		
	}
}
