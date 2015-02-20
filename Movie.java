/**Class for VideoStore Movie
	*@suthor Ali Jilani
	*/
import java.util.*;

public class Movie
{

	//Attributes
	private String title;
	private String genre;
	private long customerPhone;
	private int date;
	private boolean rented;
	
	//Constructor
	public Movie()
	{
		title = "";
		genre = "";
		customerPhone = 0;
		rented = false;
	}
	
	public Movie(String title, String g, boolean rent, long cPhone, int dated)
	{
		this.title = title;
		genre = g;
		rented = rent;
		customerPhone = cPhone;
		date = dated;
	}
	
	//Accessor Methods
	
	/**This will allow the user to get the Title of the Movie
		*@return String containing the Title of the Movie
		*/
		
	public String getTitle()
	{
		return title;
	}
	
	/**This will allow the user to get the Genre of the Movie
		*@return String containing the Genre of the Movie
		*/
	
	public String getGenre()
	{
		return genre;
	}
	
	/**This will allow the user to get the phone number of the Customer renting the Movie
		*@return long containing the phone number of the Customer renting the Movie
		*/
	
	public long getCustomer()
	{
		return customerPhone;
	}
	
	/**This will allow the user to get the due date of the Movie
		*@return int containing the due date of the Movie
		*/
	
	public int getDate()
	{
		return date;
	}
	
	/**This will allow the user to check to see if the Movie has been rented
		*@return boolean containing value of true if the Movie is rented and false if it is not
		*/
		
	public boolean checkRented()
	{
		return rented;
	}
	
	/**This will allow the user to get the Title and Genre of the Movie
		*@return String containg the title and genre of the Movie seperated by a colon and space
		*/
	
	public String getMovieInfo()
	{
		return title + ": " + genre;
	}
	
	/**This will assign a new Title to the Movie
		*@param title A String containing the new Title to be assigned to the Movie
		*/
	
	public void setTitle(String title)
	{
		this.title = title;
	}
	
	/**This will assign a new Genre to the Movie
		*@param genre A String containing the new genre to be assigned to the Movie
		*/
		
	public void setGenre (String genre)
	{
		this.genre = genre;
	}
	
	/**This will assign a new due date to the Movie
		*@param datee A int containing the new due date to be assigned to the Movie
		*/
		
	public void setDate(int datee)
	{
		date = datee; //get system clock;
	}
	
	/**This will assign a new Customer to the Movie
		*@param customerPhone A long containing the phone number of the Customer to be assigned to the Movie
		*/
		
	public void setCustomer (long customerPhone)
	{
		this.customerPhone = customerPhone;
	}
	
	/**This will assign availability status to the Movie
		*@param rented A boolean set to true for the movie being rented and false for not rented
		*/
		
	public void setStatus (boolean rented)
	{
		this.rented = rented;
	}

}