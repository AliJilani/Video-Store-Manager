 	//Ali and Jin  

   import java.io.*;
   import java.util.*;

    class VideoStore
   {
       public static void main (String args[]) throws IOException
      {
         Scanner readInput = new Scanner (System.in); //scanner object
         
         File fileM = new File("Movies.txt"); //the file
      	
         File fileC = new File("Customers.txt"); //the file
   			
      	//bufferedreader object
         BufferedReader readerM = null;
         readerM = new BufferedReader(new FileReader(fileM));
      
      	//bufferedreader object
         BufferedReader readerC = null;
         readerC = new BufferedReader(new FileReader(fileC));
      		   	
      	//print writer objects
         PrintWriter movieFile;
         PrintWriter customerFile; 
      	
      	//giving file names to the print writer objects
         //movieFile = new PrintWriter(new FileOutputStream("Movies.txt"));
         //customerFile = new PrintWriter(new FileOutputStream("Customers.txt"));
      	
         String text = null; //temporary string that will hold the lines in the nameList file
      	
			//Customer Sorting Variables
			boolean sorterC = true;
			Customer tempC;
			
			//Movie Sorting Variables
			boolean sorterM = true;
			Movie tempM;
			
      	//Option 1 Variables
         long userPhoneNum;
         int userCustomerOp;
			int editSelect;
			int deleteCheck;
      	
			//Option 2 Variables
			String userMovieOp;
			int genreSelect;
			int editSelectM;
			int editSelectM2;
			int deleteCheckM;
			int searchCheck;
			int genreCheck;
			String genreSearch = "";
			
			//Option 3 Variables
			String rentOp;
			boolean availability;
			boolean search = true;
			long userPhoneFind;
			int movieSelected;
			int customerSelected;
			int toRent;
      	
			//Option 4 Variables
			String returnSearch;
			long returnCustPhone;
			
      	//movies
         Movie movies;
         Customer customers;
         Vector<Movie> movieVector = new Vector();
         Vector<Customer> customerVector = new Vector();
      	
      	//names         
         String firstName = "";
         String lastName = "";
         String pNum;  
         long phoneNumber = 0;
         String moviee;
      	
      	//movie
         String titleM;
         String genreM;
         String rentM;
         boolean rentedM;
         String custPhoneM;
         long cPhoneM;
         String dinDate;
         int dateM;   	
      	
      	//new name information from the user
         String newPhoneNum;
         String newFirstName;
         String newLastName;
         
         int optionNum; //what the user wants to do
      	
      	
         boolean theEnd = false; //if this is true, the program will end (menu option number 4)
      
      
      	
      	//read all the lines
         while ((text = readerC.readLine()) != null)
         { 
            firstName = text; //first line is first name
            lastName = readerC.readLine(); //second line is last name
            pNum = readerC.readLine(); // reads in the actual number
            phoneNumber = Long.parseLong(pNum); // parses number
            moviee = readerC.readLine();
         	
         	//save all the name informations into name array
            customers = new Customer(firstName, lastName, phoneNumber, moviee);
            customerVector.add(customers);
         }
      	
			while(sorterC)
			{
				sorterC = false;
				for(int i = 0; i < customerVector.size() - 1; i++)
				{
					if(((customerVector.get(i)).getLast()).compareToIgnoreCase((customerVector.get(i+1)).getLast()) > 0)
					{
						tempC = customerVector.get(i);
						customerVector.set(i,customerVector.get(i+1));
						customerVector.set(i+1, tempC);
						sorterC = true;
					}
				}
			}
			/*
         for(int i = 0; i < customerVector.size(); i++) //Prints out the entire Customer Vector
         {
            System.out.println((customerVector.get(i)).getFirst());
            System.out.println((customerVector.get(i)).getLast());
            System.out.println((customerVector.get(i)).getPhone());
            System.out.println((customerVector.get(i)).getMovie());
         	
         }
			*/
      	
         text = "";
      	
         while ((text = readerM.readLine()) != null) //Reads in and saves the movie file contents into a vector
         {
            titleM = text;
            genreM = readerM.readLine();
            rentM = readerM.readLine();
            if(rentM.equals("true"))//looks for boolean if rented
            {
               rentedM = true;
            }
            else
            {
               rentedM = false;
            }
            
				//Reads Line if there is a phonenumber it will parse
				custPhoneM = readerM.readLine();
            try
            {
               cPhoneM = Long.parseLong(custPhoneM);
            }
                catch (NumberFormatException e)
               {
                  cPhoneM = 0;
               }
         	
				//Reads Line if there is a date it will parse
            dinDate = readerM.readLine();
         	
            try
            {
               dateM = Integer.parseInt(dinDate);
            }
                catch (NumberFormatException f)
               {
                  dateM = 0;
               }
         	
            movies = new Movie(titleM, genreM, rentedM, cPhoneM, dateM);
            movieVector.add(movies);
         	
         }
			
			while(sorterM)
			{
				sorterM = false;
				for(int i = 0; i < movieVector.size() - 1; i++)
				{
					if(((movieVector.get(i)).getTitle()).compareToIgnoreCase((movieVector.get(i+1)).getTitle()) > 0)
					{
						tempM = movieVector.get(i);
						movieVector.set(i,movieVector.get(i+1));
						movieVector.set(i+1, tempM);
						sorterM = true;
					}
				}
			}
						
			genreM = "";
      	/*
         for(int i = 0; i < movieVector.size(); i++) // Prints out the entire MovieVector
         {
            System.out.println((movieVector.get(i)).getTitle());
            System.out.println((movieVector.get(i)).getGenre());
            System.out.println((movieVector.get(i)).checkRented());
            System.out.println((movieVector.get(i)).getCustomer());
            System.out.println((movieVector.get(i)).getDate());
         	
         }
			*/
      
         System.out.println("");
      	
      	//how to chose option
         System.out.println("Type the number beside the option that you would like to choose.");
      	
      	//run until menu option number 5 is chosen
         while (theEnd == false)
         {
         	//show the options
            System.out.println("1. Customer Info");
            System.out.println("2. Movie Info");
            System.out.println("3. Rent");
            System.out.println("4. Return");
            System.out.println("5. Exit");
         	
         	//get the chosen option
            optionNum = readInput.nextInt();
         	
         	//CUSTOMER INFO OPTION
            if (optionNum == 1)
            {
            	//user choses the Customer to access or adds
               System.out.println("Input the phone number of the customer you would like to access, type 2 to add customer or type 3 to view customer list");
               userPhoneNum = readInput.nextLong();
            	
					//ADDING A CUSTOMER
               if(userPhoneNum == 2)
               {
                  readInput.nextLine();
                  System.out.println("First Name:");
                  firstName = readInput.nextLine(); //first line is first name
                  System.out.println("Last Name");
                  lastName = readInput.nextLine(); //second line is last name
                  System.out.println("Phone Number");
                  phoneNumber = readInput.nextLong(); //third line is phone number
                  moviee = "";
                  customers = new Customer(firstName, lastName, phoneNumber, moviee);
                  customerVector.add(customers);
               }
               
					//CUSTOMER LIST
					else if(userPhoneNum == 3)
					{
						System.out.println("");
						for(int i = 0; i < customerVector.size(); i++) //Prints out the entire Customer Vector
         			{
           				System.out.println("Name: " + (customerVector.get(i)).getFirst() + " " + (customerVector.get(i)).getLast());
            			System.out.println("Phone Number: " + (customerVector.get(i)).getPhone());
            			System.out.println("Movie Rented: " + (customerVector.get(i)).getMovie());
							System.out.println("");
        				}
					}
					
					//EDITING A CUSTOMER
               else
               {
						//Linear Search for the correct Customer
                  for(int i = 0; i < customerVector.size(); i++)
                  {
                     if((customerVector.get(i)).getPhone() == userPhoneNum)
                     {
								System.out.println("Customer: " + (customerVector.get(i)).getFirst() + " " + (customerVector.get(i)).getLast());
                        System.out.println("Press 1 to edit Customer, 2 to generate a report, and 3 to delete Customer");
                        userCustomerOp = readInput.nextInt();
                     	
								//loop to make sure valid input
                        while(userCustomerOp == 0 || userCustomerOp > 3)
                        {
                           System.out.println("Invalid Input");
                           System.out.println("Press 1 to edit Customer, or 2 to generate a report");
                           userCustomerOp	= readInput.nextInt();						
                        }
								
								//Edit Customer
                        if(userCustomerOp == 1)
                        {
									System.out.println("1: to edit Name");
									System.out.println("2: to edit Phone");
									editSelect = readInput.nextInt();
									
									if(editSelect == 1)
									{
										readInput.nextLine();
										System.out.println("Edit First Name:");
										(customerVector.get(i)).setFirst(readInput.nextLine());
										System.out.println("Edit Last Name:");
										(customerVector.get(i)).setLast(readInput.nextLine());
									}
									else
									{
										System.out.println("Edit Phone Number:");
										(customerVector.get(i)).setPhone(readInput.nextLong());
									}
									
                        }
								else if (userCustomerOp == 3)
								{
									System.out.println("Press 1 to Delete or 2 to Cancel " + "[Customer: " + (customerVector.get(i)).getFirst() + " " + (customerVector.get(i)).getLast() + "]");
									deleteCheck = readInput.nextInt();
									if(deleteCheck == 1)
									{
										System.out.println("Customer: " + (customerVector.get(i)).getFirst() + " " + (customerVector.get(i)).getLast());
										System.out.println("[STATUS TERMINATED]");
										customerVector.remove(i);
									}

								}
								//Generate a Report
                        else
                        { 
                           System.out.println("Name: " +(customerVector.get(i)).getFirst() + " " + (customerVector.get(i)).getLast());
                           System.out.println("Phone number: " + (customerVector.get(i)).getPhone());
                           System.out.println("Movie Rented " + (customerVector.get(i)).getMovie());
                        }
                     }
                  }
               }         	
            }
            
            
            //MOVIE INFO OPTION
            else if (optionNum == 2)
            {
            
					//user chooses movie to acess or add
					readInput.nextLine();
					System.out.println("Input the Title of the Movie you would like to access, type 2 to add a new movie or type 3 to see the list of movies");
					userMovieOp = readInput.nextLine();
					
					
					//ADDING MOVIE
					if(userMovieOp.equals("2"))
					{
						System.out.println("Movie Title:");
						titleM = readInput.nextLine();
						
						do
						{
							System.out.println("Select Genre: 1.Action");
							System.out.println("              2.Adventure");
							System.out.println("              3.Crime");
							System.out.println("              4.Drama");
							System.out.println("              5.Fantasy");
							System.out.println("              6.Horror");
							System.out.println("              7.Thriller");
							genreSelect = readInput.nextInt();
							
							if(genreSelect == 1)
							{
								genreM = "Action";
							}
							else if(genreSelect == 2)
							{
								genreM = "Adventure";
							}
							else if(genreSelect == 3)
							{
								genreM = "Crime";
							}
							else if(genreSelect == 4)
							{
								genreM = "Drama";
							}
							else if(genreSelect == 5)
							{
								genreM = "Fantasy";
							}
							else if(genreSelect == 6)
							{
								genreM = "Horror";
							}
							else if(genreSelect == 7)
							{
								genreM = "Thriller";
							}
						}while(genreSelect == 0 || genreSelect > 7);
						
						
						rentedM = false;
						cPhoneM = 0;
						dateM = 0;
						
						movies = new Movie(titleM, genreM, rentedM, cPhoneM, dateM);
						movieVector.add(movies);
						
					}
					
					//MOVIE LIST
					else if(userMovieOp.equals("3"))
					{
						System.out.println("Type 1 for a full list of Movies, Type 2 for available movies and Type 3 to Search by Genre");
						searchCheck = readInput.nextInt();
						
						if(searchCheck == 2)
						{
							for(int i = 0; i < movieVector.size(); i++)
							{
								if((movieVector.get(i)).checkRented() != true)
								{
									System.out.println("Title: " + (movieVector.get(i)).getTitle());
            					System.out.println("Genre " + (movieVector.get(i)).getGenre());
									System.out.println("");
								}
							}
						}
						
						else if(searchCheck == 3)
						{
							do
							{
								System.out.println("Select Genre: 1.Action");
								System.out.println("              2.Adventure");
								System.out.println("              3.Crime");
								System.out.println("              4.Drama");
								System.out.println("              5.Fantasy");
								System.out.println("              6.Horror");
								System.out.println("              7.Thriller");
								genreCheck = readInput.nextInt();
							
								if(genreCheck == 1)
								{
									genreSearch = "Action";
								}
								else if(genreCheck == 2)
								{
									genreSearch = "Adventure";
								}
								else if(genreCheck == 3)
								{
									genreSearch = "Crime";
								}
								else if(genreCheck == 4)
								{
									genreSearch = "Drama";
								}
								else if(genreCheck == 5)
								{
									genreSearch = "Fantasy";
								}
								else if(genreCheck == 6)
								{
									genreSearch = "Horror";
								}
								else if(genreCheck == 7)
								{
									genreSearch = "Thriller";
								}
							}while(genreCheck == 0 || genreCheck > 7);
							
							for(int i = 0; i < movieVector.size(); i++)
							{								
								if(((movieVector.get(i)).getGenre()).equals(genreSearch))
								{
									System.out.println("Title: " + (movieVector.get(i)).getTitle());
            					System.out.println("Genre " + (movieVector.get(i)).getGenre());
									System.out.println("Rented Status: " + (movieVector.get(i)).checkRented());
									if((movieVector.get(i)).getDate() != 0)
									{
										System.out.println("Expected Return in " + ((movieVector.get(i)).getDate() - Calendar.DAY_OF_YEAR));
									}
									System.out.println("");
								}
							}
						}
						
						else
						{
							for(int i = 0; i < movieVector.size(); i++) // Prints out the entire MovieVector
         				{
            				System.out.println("Title: " + (movieVector.get(i)).getTitle());
            				System.out.println("Genre: " + (movieVector.get(i)).getGenre());
            				System.out.println("Rented Status: " + (movieVector.get(i)).checkRented());
            				System.out.println("Customer Phone number: " + (movieVector.get(i)).getCustomer());
								if((movieVector.get(i)).getDate() != 0)
								{
									System.out.println("Expected Return in " + ((movieVector.get(i)).getDate() - Calendar.DAY_OF_YEAR) + " days");
								}
								System.out.println("");
        					}	
						}
					}
					
					//EDITING A MOVIE
					else
					{
						//Linear Search to find Movie
						for(int i = 0; i < movieVector.size(); i++)
						{
							if(((movieVector.get(i)).getTitle()).equals(userMovieOp))
							{
								
								do
								{
									System.out.println("Press 1 to edit Movie, Press 2 to generate report or Press 3 to Remove a Movie");
									editSelectM = readInput.nextInt();
									
									//Generate Report	
									if(editSelectM == 3)
									{
										System.out.println("Press 1 to Delete or 2 to Cancel " + "[Movie: " + (movieVector.get(i)).getTitle() + "  Genre:" + (movieVector.get(i)).getGenre() + "]");
										deleteCheckM = readInput.nextInt();
										if(deleteCheckM == 1)
										{
											System.out.println("Movie: " + (movieVector.get(i)).getTitle());
											System.out.println("[STATUS TERMINATED]");
											movieVector.remove(i);
										}
									}
									
									//Edit Movie
									else if(editSelectM == 1)
									{
										System.out.println("Press '1' to edit Title and '2' to edit genre");
										editSelectM2 = readInput.nextInt();
										
										do
										{
											if(editSelectM2 == 1)
											{
												System.out.println("New Title:");
												(movieVector.get(i)).setTitle(readInput.nextLine());
											}
											else if(editSelectM2 == 2)
											{
													do
													{
														System.out.println("Select Genre: 1.Action");
														System.out.println("              2.Adventure");
														System.out.println("              3.Crime");
														System.out.println("              4.Drama");
														System.out.println("              5.Fantasy");
														System.out.println("              6.Horror");
														System.out.println("              7.Thriller");
														genreSelect = readInput.nextInt();
							
														if(genreSelect == 1)
														{
															genreM = "Action";
															(movieVector.get(i)).setGenre(genreM);															
														}
														else if(genreSelect == 2)
														{
															genreM = "Adventure";
															(movieVector.get(i)).setGenre(genreM);
														}
														else if(genreSelect == 3)
														{
															genreM = "Crime";
															(movieVector.get(i)).setGenre(genreM);
														}	
														else if(genreSelect == 4)
														{
															genreM = "Drama";
															(movieVector.get(i)).setGenre(genreM);
														}
														else if(genreSelect == 5)
														{
															genreM = "Fantasy";
															(movieVector.get(i)).setGenre(genreM);
														}
														else if(genreSelect == 6)
														{
															genreM = "Horror";
															(movieVector.get(i)).setGenre(genreM);
														}
														else if(genreSelect == 7)
														{
															genreM = "Thriller";
															(movieVector.get(i)).setGenre(genreM);
														}
													}while(genreSelect == 0 || genreSelect > 7);
											}
										}while(editSelectM2 != 1 && editSelectM2 != 2);
									}
									else
									{
										System.out.println("Title: " + (movieVector.get(i)).getTitle());
        			    				System.out.println("Genre: " + (movieVector.get(i)).getGenre());
          			  				System.out.println("Rented Status: " + (movieVector.get(i)).checkRented());
										if((movieVector.get(i)).getCustomer() != 0)
										{
											System.out.println("Customer's Phone#: " + (movieVector.get(i)).getCustomer());
										}
										if((movieVector.get(i)).getDate() != 0)
										{
											System.out.println("Expected Return in " + ((movieVector.get(i)).getDate() - Calendar.DAY_OF_YEAR) + " days");
										}
										
										System.out.println("");
									}									
								}while(editSelectM != 1 && editSelectM != 2 && editSelectM != 3);
								
							}
						}
					}
            }
            
				

            //RENTING A MOVIE
            else if (optionNum == 3)
            {
					readInput.nextLine();
					do
					{	
						//Find the movie to rent
	
            		System.out.println("Input the Title of the Movie you would like to rent.");
						rentOp = readInput.nextLine();
						for(int i = 0; i < movieVector.size(); i++)
						{
							
							//Check to see if the movie is already rented
							//if rented go back
							if(((movieVector.get(i)).getTitle()).equals(rentOp))
							{
								movieSelected = i;
								
								if(((movieVector.get(i)).checkRented()) == true)
								{
									System.out.println("[Movie Unavailable]");
									System.out.println("[Please Select a Different Movie]");
								}
							
								//If available, get customer throught phone#
								else if (((movieVector.get(i)).checkRented()) == false)
								{
									search = false;
									System.out.println("Please Enter Customer Phone#");
									userPhoneFind = readInput.nextLong();
									
									for(int x =0; x < customerVector.size(); x++)
									{
										if(((customerVector.get(x)).getPhone()) == userPhoneFind)
										{
											customerSelected = x;
											
											System.out.println("Customer: " + (customerVector.get(customerSelected)).getFirst() + " " + (customerVector.get(customerSelected)).getLast() + " " + (customerVector.get(customerSelected)).getPhone());
											System.out.println("Movie: " + (movieVector.get(movieSelected)).getGenre() + ": " +(movieVector.get(movieSelected)).getTitle());
											
											//Confirm Rent
											System.out.println("Press '1' to Rent / Press '2' to Cancel");
											toRent = readInput.nextInt();
											
											if(toRent == 1)
											{	
												//Rent movie to Customer and add Customer phone to Movie
												(customerVector.get(customerSelected)).setMovie((movieVector.get(movieSelected)).getTitle());
												(movieVector.get(movieSelected)).setCustomer((customerVector.get(customerSelected)).getPhone());
												(movieVector.get(movieSelected)).setStatus(true);
												(movieVector.get(movieSelected)).setDate((Calendar.DAY_OF_YEAR + 5));
												
												//Date Setter
												//Renting Invoice
												System.out.println("Customer Name: "+(customerVector.get(customerSelected)).getFirst() + " " + (customerVector.get(customerSelected)).getLast());
            								System.out.println("Phone# :"+(customerVector.get(customerSelected)).getPhone());
            								System.out.println("Movie Rented: " + (customerVector.get(customerSelected)).getMovie());
												System.out.println("Due Date: 5 Days from today");
											}
										}
									}	
								}
							
							}
						}
						search = false;
					}while(search == true);
            }
            
            //writing the file and exiting option
            else if (optionNum == 4)
            {
					readInput.nextLine();
            	System.out.println("Please enter the Title of the Movie to Return: ");
					returnSearch = readInput.nextLine();
					
					for(int i = 0; i < movieVector.size(); i++)
					{
						if(((movieVector.get(i)).getTitle()).equals(returnSearch))
						{
							returnCustPhone = (movieVector.get(i)).getCustomer();
							(movieVector.get(i)).setCustomer(0);
							(movieVector.get(i)).setStatus(false);
							
							if(Calendar.DAY_OF_YEAR > (movieVector.get(i)).getDate())
							{
								System.out.println("[OVERDUE FINE]");
							}
							
							for(int x = 0; x < customerVector.size(); x++)
							{
								if((customerVector.get(x)).getPhone() == returnCustPhone)
								{
									(customerVector.get(x)).setMovie("");
									
									System.out.println("Movie: " + (movieVector.get(i)).getTitle());
									System.out.println("was returned from Customer: " + (customerVector.get(x)).getFirst() + " " + (customerVector.get(x)).getLast());
								}
							}
						}
					}		
            }
            

            else if (optionNum == 5)
            {
					movieFile = new PrintWriter(new FileOutputStream("Movies.txt"));
         		customerFile = new PrintWriter(new FileOutputStream("Customers.txt"));

            	//writes all the new name into namesFile file
               for (int c = 0; c < customerVector.size(); c++)
               {
                  customerFile.println((customerVector.get(c)).getFirst());
						customerFile.println((customerVector.get(c)).getLast());
						customerFile.println((customerVector.get(c)).getPhone());
						customerFile.println((customerVector.get(c)).getMovie());
               }
            	//writes all the new titles and initials into initialsFile file
               for (int b = 0; b < movieVector.size(); b++)
               {
                  movieFile.println((movieVector.get(b)).getTitle());
						movieFile.println((movieVector.get(b)).getGenre());
						movieFile.println((movieVector.get(b)).checkRented());
						if((movieVector.get(b)).getCustomer() != 0)
						{
							movieFile.println((movieVector.get(b)).getCustomer());
						}
						else
						{
							movieFile.println("");
						}
						if((movieVector.get(b)).getDate() != 0)
						{
							movieFile.println((movieVector.get(b)).getDate());
						}
						else
						{
							movieFile.println("");
						}											
               }
               					
					movieFile.close();
					customerFile.close();
            	//end the program by ending this while loop
               theEnd = true;
               
            }
         
         }
         
         System.out.println("[DATA BASE SAVED]");
      	
      	//close the writers and the program

      
         System.exit(0);
      }
   }