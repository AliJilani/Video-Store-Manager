/**Class for VideoStore Customer
	*@author Ali Jilani
	*/

public class Customer
{

	//Attributes
	private String firstName;
	private String lastName;
	private long phoneNumber;
	private String movies;
	
	//Constructor
	public Customer()
	{
		firstName = "";
		lastName = "";
		phoneNumber = 0;
		movies = "";
	}
	
	public Customer(String first, String last, long phone, String movie)
	{
		firstName = first;
		lastName = last;
		phoneNumber = phone;
		movies = movie;
	}
	
	//Accessor Methods
	
	/**This will allow the user to get the first name of the Customer
		*@return String containing the first name of the Customer
		*/
		
	public String getFirst()
	{
		return firstName;
	}
	
	/**This will allow the user to get the last name of the Customer
		*@return String containing the first name of the Customer
		*/
		
	public String getLast()
	{
		return lastName;
	}
	
	/**This will allow the user to get the Phone Number of the Customer
		*@return long containing the Phone Number of the Customer
		*/
		
	public long getPhone()
	{
		return phoneNumber;
	}
	
	/**This will allow the user to get the Title of the Movie rented by the Customer
		*@return String containing the title of the Movie rented by the Customer
		*/
		
	public String getMovie()
	{
		return movies;
	}
	
	/**This will allow the user to get the First and Last name of the Customer
		*@return String containing the First and Last Name of the Customer seperated by a space
		*/
		
	public String getFullName()
	{
		return firstName + " " + lastName;
	}
	
	/**This will assign a new First name to the Customer
		*@param first A String containing the new First name to be assigned to the Customer
		*/
		
	public void setFirst(String first)
	{
		firstName = first;
	}
	
	/**This will assign a new Last name to the Customer
		*@param last A String containing the new Last name to be assigned to the Customer
		*/
		
	public void setLast (String last)
	{
		lastName = last;
	}
	
	/**This will assign a new phone number to the Customer
		*@param phone A long containing the new phone number to be assigned to the Customer
		*/
		
	public void setPhone (long phone)
	{
		phoneNumber = phone;
	}
	
	/**This will assign a new Movie to the Customer
		*@param movie A String containing the title of the movie to be assigned to the Customer
		*/
	public void setMovie (String movie)
	{
		movies = movie;
	}
	
	

}