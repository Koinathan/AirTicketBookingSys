import java.io.*;
import java.util.*;

public class MainSystem {

public static void main(String[] args) throws Exception {
		
		//VARIABLES
		int choice = -1;
		
		
		//TXT FILES. 
		File userFile = new File("User.txt"); //USER TXT
		File userpassFile =new File("Userpass.txt");
		File flightFile = new File("Flight.txt"); // FLIGHT TXT
		File ticketFile = new File("Ticket.txt");// TICKET TXT
		File TicketnumFile = new File("Ticketnumber.txt");
		File AdminFile = new File ("Admin.txt");
		File AdminpassFile = new File("Adminpass.txt");
		
		
		//SCANNERS
		Scanner s = new Scanner(System.in); //SCAN INTEGER
		Scanner s1 = new Scanner(System.in); // SCAN STRING
		Scanner s2 = new Scanner(System.in); // SCAN DOUBLE 
		
		//COLLECTIONS
		ArrayList<User> al = new ArrayList<User>();
		ArrayList<User> ts = new ArrayList<User>();
		ArrayList<Flight> fl = new ArrayList<Flight>();
		ArrayList<Ticket> tk = new ArrayList<Ticket>();
		ArrayList<Admin> admin = new ArrayList<Admin>();
		ArrayList<Admin>admpass = new ArrayList<Admin>();
		
		//OOS/OIS/List Iterator
		ObjectOutputStream oos = null;
		ObjectInputStream ois = null;
		
		ObjectOutputStream oos2 = null;
		ObjectInputStream ois2 = null;
		
		
		
		ListIterator li = null; //print as list orderly.
		
		
		
		do { //DISPLAY OPTIONS
			System.out.println("\n\n===============================");
			System.out.println("  Air Ticket Booking System");
			System.out.println("===============================");
			
			
			System.out.println("\n1.CREATE USER ACCOUNT");
			System.out.println("2.DISPLAY USER");
			System.out.println("3.USER LOGIN");
			System.out.println("4.FLIGHT ADMINISTRATOR [ADMIN LOGIN REQUIRED]");
			
			System.out.println("0.EXIT");
			System.out.println("Enter your choice: ");
			choice = s.nextInt();
			
			switch(choice) { //================================ (1)CREATE USER ACCOUNT ======================================================================================
				case 1: 
					File userFile1 = new File("User.txt");
					File userFileWp = new File("UserWp.txt");
					ArrayList<User> us = new ArrayList<User>();
					ArrayList<User> usp = new ArrayList<User>();
					
					
					ObjectOutputStream uoos = null;
					ObjectInputStream uois = null;
					
					System.out.println("Enter how many user you wish to add: ");
					int m = s.nextInt();
					for(int i=0;i<m;i++) {
					
						System.out.print("\n\nEnter UserID No: ");
						String userID = s.next();
						
						System.out.print("Enter your Name: ");
						String name = s.next();
						
						System.out.print("Enter your Email: ");
						String email = s.next();
						
						System.out.print("Enter a password: ");
						int password = s.nextInt();
						
						us.add(new User(userID,name,email)); //without password
						usp.add(new User(userID,name,email,password));
					}
					
					uoos = new ObjectOutputStream(new FileOutputStream(userFile)); //then only will write collection into file
					uoos.writeObject(us);
					uoos.close(); //put object into arraylist then persist it in a txt file
					
					uoos = new ObjectOutputStream(new FileOutputStream(userFileWp));
					uoos.writeObject(usp);
					uoos.close(); 
					
					
					
				break;

			
				case 3: //***************USER LOGIN**********************************************************************************************************************
					
				
					//======AUTHENTICATION===============================================================================================================================
					
					if(userFile.isFile()) {
					uois= new ObjectInputStream(new FileInputStream(userFile));
					usp = (ArrayList<User>)uois.readObject();
					uois.close();
					
					int password = -1;
					boolean found = false;
					boolean auth = false;
					int p1=0;
					String n1 = "";
					System.out.println("-------------------------------------------------------");
					
					System.out.println("Enter your Email address");
					String email = s1.nextLine();
					
					System.out.print("Enter your Password: ");
					 password = s.nextInt();
					 System.out.println("-------------------------------------------------------");
					 li= al.listIterator();
					 
					 while(auth!=true) {
						 while(li.hasNext()) {
							 User e1 =(User)li.next();
							 if(e1.getEmail()== email) {
								 p1 = e1.getPassword();
							 }
							 
						 } 
							 if(p1!=password) {
								 System.out.println("Invalid password, please re-enter password: ");
								 password = s.nextInt();
							 }else if(password==0){
								 System.out.println("Program terminated");
								 System.exit(0);
								 
							 }else {
								 System.out.println("login successful");
								 auth = true;
							 }
						 }System.out.println(auth);
						 
					 }
					
					 
					while(true) {
						System.out.println("1.View Flights \n2.Book a Flight \n3.Exit");
						int option = s.nextInt();
						
						switch(option) {
						case 1: //========================USER DISPLAY FLIGHTS===========================================================================================================================================
							
							if(flightFile.isFile()) {
								ois = new ObjectInputStream(new FileInputStream(flightFile));
								fl = (ArrayList<Flight>)ois.readObject();
								ois.close();
								
								System.out.println("-----------------------------------------------------------------------------------------------");
								System.out.println( "FLIGHTNO." + "    "+ "AIRLINES " + "    " + "SOURCE " + "    " + "DESTINATION " + "    "  + "DEPARTURE " + "    " + "ARRIVAL " + "    " + "PRICE " + "    " + "AVAIL SEATS ");
								li = fl.listIterator();
								while(li.hasNext())
									System.out.println(li.next());
								System.out.println("-----------------------------------------------------------------------------------------------");
							}else {
								System.out.println("File does not exist..!");
							}
							break; //==========================================================================
							
						case 2: //======================== USER FLIGHT BOOKING ALSO DISPLAY FLIGHTS TO SELECT ===============================================================================================================
							
							if(flightFile.isFile()) {
								ois = new ObjectInputStream(new FileInputStream(flightFile));
								fl = (ArrayList<Flight>)ois.readObject();
								ois.close();
								
								System.out.println("-----------------------------------------------------------------------------------------------");
								System.out.println("FLIGHTNO." + "    "+ "AIRLINES " + "    " + "SOURCE " + "    " + "DESTINATION " + "    "  + "DEPARTURE " + "    " + "ARRIVAL " + "    " + "PRICE " + "    " + "AVAIL SEATS " );
								li = fl.listIterator();
								while(li.hasNext())
									System.out.println(li.next());
								System.out.println("-----------------------------------------------------------------------------------------------");
							}else {
								System.out.println("File does not exist..!");
							} // ====================== END OF DISPLAYING FLIGHTS FOR USER ================================================================================================================================
							
							
							
							if(flightFile.isFile()) { //UPDATE AVAILABLE SEATS AFTER BOOKING CONCEPT & PRINT TICKET
								ois = new ObjectInputStream(new FileInputStream(flightFile));
								fl = (ArrayList<Flight>)ois.readObject();
								ois.close();
								
								boolean flightfound = false;
								System.out.println("Please select flight number to Book: ");
								String selectedflightNumber = s1.nextLine();
								
								System.out.println("Please select the number of seats you would like to book: ");
								int AvailableSeats = s.nextInt();
								
								System.out.println("-----------------------------------------------------------------------------------------------");
								li = fl.listIterator();
								while(li.hasNext()) {
									Flight f =(Flight)li.next();
									if(f.getFlightNumber().equals(selectedflightNumber)) {
									f.setAvailableSeats(f.getAvailableSeats()- AvailableSeats);						
									flightfound = true;
									}
								}
								if(flightfound) {
									oos = new ObjectOutputStream(new FileOutputStream(flightFile)); //then only will write collection into file
									oos.writeObject(fl);
									oos.close(); //put object into arraylist then persist it in a txt file
										
									
									
									System.out.println("Flight Booking Successful! ");
								}
								else {
									System.out.println("Record not found....");
								}
								
								// DISPLAY TICKETS
								if(TicketnumFile.isFile()) {
									ois2 = new ObjectInputStream(new FileInputStream(TicketnumFile));
									tk = (ArrayList<Ticket>)ois.readObject();
									ois2.close();
									
									
									li = tk.listIterator();
									
									Ticket e1 = tk.get(tk.size() -1);
									int index1 = e1.getTicketNumber()+1;
									
									System.out.println("-----------------------------------------------------------------------------------------------");
									li = tk.listIterator();
									while(li.hasNext())
										System.out.println(li.next());
									System.out.println("-----------------------------------------------------------------------------------------------");
								}else {
									System.out.println("File does not exist..!");
								}
								break; //==========================================================================
							}
							
							break;
						
						}
						
							
						
					}
					
				case 4: //***************ADMINISTRATOR LOGIN**********************************************************************************************************************
					if(AdminFile.isFile()) {
						ois= new ObjectInputStream(new FileInputStream(AdminFile));
						admin = (ArrayList<Admin>)ois.readObject();
						ois.close();
						
						int password = -1;
						boolean found = false;
						boolean auth = false;
						int p1=0;
						System.out.println("-------------------------------------------------------");
						
							System.out.println("Enter your StaffNumber: ");
							int staffNumber = s1.nextInt();
							
						System.out.print("Enter your Password: ");
						 password = s.nextInt();
						 System.out.println("-------------------------------------------------------");
						 li= admin.listIterator();
						 
						 while(auth!=true) {
							 while(li.hasNext()) {
								 Admin e1 =(Admin)li.next();
								 if(e1.getStaffNumber()== staffNumber) {
									 p1 = e1.getPassword();
								 }
								 
							 } 
								 if(p1!=password) {
									 System.out.println("Invalid password, please re-enter password: ");
									 password = s.nextInt();
								 }else if(password==0){
									 System.out.println("Program terminated");
									 System.exit(0);
									 
								 }else {
									 System.out.println("login successful");
									 auth = true;
								 }
							 }System.out.println(auth);
							 
							 while(auth==true) {
								 System.out.println("=======================================================");
								 System.out.println("   ADMINISTRATION ");
								 System.out.println("=======================================================");
								 
								 System.out.println("\n\n 1.CREATE NEW FLIGHT ADMIN ACCOUNT"); //done 
								 System.out.println("\n\n 2.DISPLAY ALL ADMIN'S PROFILE"); // done
								 System.out.println("\n\n 3.DISPLAY ALL USER'S PROFILE"); // done
								 System.out.println("\n\n 4.EDIT EXISTING USER/ADMIN PROFILE");
								 System.out.println("\n\n 5.SEARCH USER/ADMIN PROFILE");
								 
								 System.out.println("\nEnter your selection: ");
								 int inchoice = -1;
								 inchoice = s.nextInt();
								 
								 switch(inchoice) {
								 
								 case 1:  //================================ (1)CREATE NEW ADMIN ACCOUNT ======================================================================================
									 System.out.println("\n\n CREATE FLIGHT ADMIN ACCOUNT");
									 System.out.println("How many profiles are there to add?:");
									 m = s.nextInt();
									 
									 for(int i=0;i<m;i++) {
											System.out.print("Enter Admin's name ");
											String name = s1.nextLine();
											
											System.out.print("Enter Admin Email: ");
											String email = s1.nextLine();
											
											System.out.print("Enter a password: ");
											password = s.nextInt();
											
											System.out.println("Enter a staffNumber: ");
											staffNumber = s.nextInt();
											
											System.out.println(name + "'s admin profile created sucessfully!");
											
											admin.add(new Admin(name, email,staffNumber));
											admpass.add(new Admin(password));
											
											}
											oos = new ObjectOutputStream(new FileOutputStream(AdminFile));  //Arraylist will be written into file
											oos.writeObject(admin);
											oos.close();
											
											oos = new ObjectOutputStream(new FileOutputStream(AdminpassFile));  //Arraylist will be written into file
											oos.writeObject(admpass);
											oos.close();
											
													
					
											break;//================================ (1) END OF CREATING NEW ADMIN ACCOUNT ======================================================================================
										
											
								 case 2://================================ (2 )DISPLAY ALL ADMIN'S PROFILE) ======================================================================================
									 if(AdminFile.isFile()) {
										 ois = new ObjectInputStream(new FileInputStream(AdminFile));       //read into the file & load it into our collection 
											admin = (ArrayList<Admin>)ois.readObject();
											ois.close();
											
									System.out.println("=======================================================");
									System.out.println("      Name     Email        staffNumber");
									System.out.println("-------------------------------------------------------");
									li = admin.listIterator();
									while(li.hasNext())
										System.out.println(li.next());
									System.out.println("-------------------------------------------------------");
							
									 }else{
										 System.out.println("file does not exist...!");
									 } //================================ (2) END OF DISPLAY ALL ADMIN'S PROFILE) ======================================================================================
									 
									 break;
									 
								 case 3:
									 
									//================(3)DISPLAY USERS PROFILE============================================================================================
										
										ois = new ObjectInputStream(new FileInputStream(userFile));
										al = (ArrayList<User>)ois.readObject();
										ois.close();
										
										System.out.println("-------------------------------------------------------");
										li = al.listIterator();
										while(li.hasNext())
											System.out.println(li.next());
										System.out.println("-------------------------------------------------------");
									break; //================(3) END OF DISPLAY USERS PROFILE============================================================================================
								 
								 case 4: //================(4) EDIT EXISTING USER/ADMIN PROFILE============================================================================================
									 System.out.println("\n========================================= ");
										System.out.println(" Edit Profile  ");
										System.out.println("========================================== ");
										
										
										System.out.println("(1) Admin's Profile");
										System.out.println("(2) User's Profile");
										
										System.out.println("\n\n(0) Return back to Administration");
									 
										int inchoice2 = 0;
										System.out.println("Enter selection: ");
										inchoice2 = s.nextInt();	
										
										switch(inchoice2) {//================ EDIT ADMIN PROFILE =========================================================================================
										
										case 1:
											System.out.println("\n >>>>>>> Admin profile Interface");
											
											
											if(AdminFile.isFile()) {
												ois= new ObjectInputStream(new FileInputStream(AdminFile));
												admin = (ArrayList<Admin>)ois.readObject();
												ois.close();
												
												System.out.println("========================================== ");
												System.out.println("      Name     Email        staffNumber");
												System.out.println("========================================== ");
											
												li= admin.listIterator();
												while (li.hasNext()) {
													System.out.println(li.next());
													System.out.println("-------------------------------------------------------");
												
												}
												
											}else {
												System.out.println("file does not exist...!");
											}
											
										} //================ EDIT USER PROFILE =========================================================================================
										
										System.out.println("\n\n(1) Update \n(2) Delete ");
										
										int InnerChoice2 = -1;
										System.out.print("\nEnter Selection: ");
										InnerChoice2 = s.nextInt();
										
										switch(InnerChoice2) {
											
										case 1: //=====================(1) ADMIN ACCOUNT UPDATE ===============================================================================
											if(AdminFile.isFile()) {
												ois= new ObjectInputStream(new FileInputStream(AdminFile));
												admin = (ArrayList<Admin>)ois.readObject();
												ois.close();
												
												found = false;
												System.out.println("Enter the staff number to update: ");
												staffNumber = s.nextInt(); 
												
												System.out.println("-------------------------------------------------------");
												li = admin.listIterator();
												while(li.hasNext()) {
													Admin e1 =(Admin)li.next();
													if(e1.getStaffNumber()== staffNumber) {
														
														System.out.println("\n Enter new admin name: ");
														String name = s.nextLine();
														
														System.out.println("Enter new email address: ");
														String email = s.nextLine();
														
														System.out.println("Enter new admin password: ");
														password = s.nextInt();
														
														
														System.out.println("Enter your StaffNumber: ");
														staffNumber = s1.nextInt();
														
														
														
														boolean accStatus = true;
														
														System.out.println("A new account has been set for " + name +".");
														li.set(new Admin(name,email,staffNumber));
														
														li.set(new Admin(password));
															
														found = true;
													}
												}if (found) {
													
													oos = new ObjectOutputStream(new FileOutputStream(AdminpassFile));  //Arraylist will be written into file
													oos.writeObject(admpass);
													oos.close();
													
													oos = new ObjectOutputStream(new FileOutputStream(AdminFile)); //then only will write collection into file
													oos.writeObject(admin);
													oos.close(); //put object into arraylist then persist it in a txt file
													
													System.out.println("-------------------------------------------------------");
													System.out.println("Record has updated successfully! ");
													
												}else {
													System.out.println("Record Not Found...!");
										
												}
											}else {
												System.out.println("file does not exist...!");
											}
											
											break;//===================== (1) END OF UPDATE ADMIN ACCOUNT ===============================================================================
									
										
										case 2: //=====================(2) REMOVE ADMIN ACCOUNT ===============================================================================
											if(AdminFile.isFile()) {
												ois= new ObjectInputStream(new FileInputStream(AdminFile));
												admin = (ArrayList<Admin>)ois.readObject();
												ois.close();
												
												
												
												
												found = false;
												System.out.println("Enter the account number to Remove: ");
												staffNumber = s.nextInt(); 
												
												System.out.println("-------------------------------------------------------");
												li = admin.listIterator();
												while(li.hasNext()) {
													Admin e1 = (Admin)li.next();
													if(e1.getStaffNumber()==staffNumber) {
														li.remove();
														found = true;
													}

												}
												li = admpass.listIterator();
												while(li.hasNext()) {
													Admin e1 = (Admin)li.next();
													if(e1.getStaffNumber()==staffNumber) {
														li.remove();
														found = true;
													}

												}
												
												
												
												if (found) {
													oos = new ObjectOutputStream(new FileOutputStream(AdminFile)); //then only will write collection into file
													oos.writeObject(admin);
													oos.close(); //put object into arraylist then persist it in a txt file
													System.out.println("-------------------------------------------------------");
													System.out.println("Record has deleted successfully! ");
													
												}else {
													System.out.println("Record Not Found...!");
										
												}
											}else {
												System.out.println("file does not exist...!");
											}
											
											break;//=====================(2) END OF REMOVE USER ACCOUNT ===============================================================================
										}
									
								 }
								 
								 
								 
									 
							 }
							 
						 }
					
								
				
				/*case 39: //ADMIN ADD FLIGHT
					System.out.println("How many flights are there to add?: ");
					int n = s.nextInt(); 
					
					for(int i=0; i<n; i++) {
					
					System.out.println("Enter Flightnum No: ");
					String Flightnumber = s1.nextLine();
					
					System.out.println("Enter Airlines: ");
					String airline = s1.nextLine();
					
					System.out.println("Enter source: ");
					String source = s1.nextLine();
					
					System.out.println("Enter destination: ");
					String destination = s1.nextLine();
					
					System.out.println("Enter departureTime: ");
					int departureTime = s.nextInt();
					
					System.out.println("Enter arrivaltime: ");
					int arrivalTime = s.nextInt();
					
					System.out.println("Enter price: ");
					double price = s2.nextDouble();
					
					System.out.println("Enter availableSeats: ");
					int availableSeats = s.nextInt();
					
					
					fl.add(new Flight(Flightnumber,airline,source,destination,departureTime,arrivalTime,price,availableSeats));
					
					}
					
					oos = new ObjectOutputStream(new FileOutputStream(flightFile)); //then only will write collection into file
					oos.writeObject(fl);
					oos.close(); //put object into arraylist then persist it in a txt file

					break; */
					
			/*	case 40://ADMIN DELETE FLIGHTNO.
					
					if(flightFile.isFile()) {
						ois = new ObjectInputStream(new FileInputStream(flightFile));
						fl = (ArrayList<Flight>)ois.readObject()
						ois.close();
						
						boolean found1 = false;
						System.out.println("Please select flight number to Delete: ");
						String flightNumber = s1.nextLine();
						System.out.println("-----------------------------------------------------------------------------------------------");
						li = fl.listIterator();
						while(li.hasNext()) {
							Flight f =(Flight)li.next();
							if(f.getFlightNumber().equals(flightNumber)) {
							li.remove();
						
							found1 = true;
							}
						}
						if(found1) {
							oos = new ObjectOutputStream(new FileOutputStream(flightFile)); //then only will write collection into file
							oos.writeObject(fl);
							oos.close(); //put object into arraylist then persist it in a txt file
							System.out.println("Record has been deleted successfully ");
						}
						else {
							System.out.println("Record not found....");
						}
						System.out.println("-----------------------------------------------------------------------------------------------");
					}
					
					else {
						System.out.println("Record file does not exist ");
					}
					break;*/
					
				case 41: //ADMIN UPDATE FLIGHT 
					if(flightFile.isFile()) {
						ois = new ObjectInputStream(new FileInputStream(flightFile));
						fl = (ArrayList<Flight>)ois.readObject();
						ois.close();
						
						boolean found1 = false;
						System.out.println("Please select flight number to Update: ");
						String flightNumber = s1.nextLine();
						System.out.println("-----------------------------------------------------------------------------------------------");
						li = fl.listIterator();
						while(li.hasNext()) {
							Flight f =(Flight)li.next();
							if(f.getFlightNumber().equals(flightNumber)) {
								System.out.println("Enter new Airlines: ");
								String airline = s1.nextLine();
								
								System.out.println("Enter new Source: ");
								String source = s1.nextLine();
								
								System.out.println("Enter new Destination: ");
								String destination = s1.nextLine();
								
								System.out.println("Enter new Departure time: ");
								int departureTime = s.nextInt();
								
								System.out.println("Enter new Arrival time: ");
								int arrivalTime = s.nextInt();
								
								System.out.println("Enter new Ticket price: ");
								double price = s2.nextDouble();
								
								System.out.println("Enter new Seat Availability: ");
								int availableSeats = s.nextInt();
								
								li.set(new Flight (flightNumber,airline,source,destination,departureTime,arrivalTime,price,availableSeats));
								found1 = true;
							}
						}
						if(found1) {
							oos = new ObjectOutputStream(new FileOutputStream(flightFile)); //then only will write collection into file
							oos.writeObject(fl);
							oos.close(); //put object into arraylist then persist it in a txt file
							System.out.println("Record has been updated successfully ");
						}
						else {
							System.out.println("Record not found....");
						}
						System.out.println("-----------------------------------------------------------------------------------------------");
					}else {
						System.out.println("File does not exist...!");
					}
					
					break;
					
				case 42: //ADMIN CREATE NEW TICKET
					
					System.out.println("Enter the number of tickets you intend to add: ");
					int t = s.nextInt();
					
					for (int i=0;i<t;i++) {
					System.out.println("Enter a new Ticketno.: ");
					int ticketNumber = s.nextInt();
					
					System.out.println("Enter passenger name: ");
					String passsenger = s1.nextLine();
					
					System.out.println("Enter flight model: ");
					String flight = s1.nextLine();
					
					System.out.println("Enter a new seatNumber: ");
					String seatNumber = s1.nextLine();
					
					System.out.println("Enter a new Ticketno.: ");
					String status = s1.nextLine();
					
					tk.add(new Ticket(ticketNumber,passsenger,flight,seatNumber,status));
					
					}
					
					oos2 = new ObjectOutputStream(new FileOutputStream(ticketFile)); //then only will write collection into file
					oos2.writeObject(tk);
					oos2.close(); //put object into arraylist then persist it in a txt file
					
					break;
				}
			

				
				
				
				
				
				
				
				
				
	
			
				
			
		}while(choice!=0);
		
		
	}
}
