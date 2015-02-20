/**
	*Class MyMethods
	*@author Ali Jilani
*/
import java.io.*;
import java.util.*;

public class AliMyMethods
{ 
	/** calculate the integer average of the integers in numbers[]
		*@param numbers an array of integers
		*@return an integer representing the average of the contents of the array
		*/
	public static int avgInt (int numbers[])
	{
		int sum = 0;
		for(int i = 0; i < numbers.length; i++)
		{
			sum = sum + numbers[i];		
		}
		
		return sum /numbers.length;
	}
	
	/** calculate the average of the double values in num[]
		*@param num an array of doubles
		*@return a double representing the average of the contents of the array
		*/

	public static double avg (double num[])
	{
		double sum = 0;
		for(int i = 0; i < num.length; i++)
		{
			sum = sum + num[i];		
		}
		
		return sum /num.length;
	}
	
	/** take string s and reverses the letters
		*@param s a string to be reversed
		*@return a string that is the reverse of s
		*/
		
	public static String reverse(String s)
	{
		String reversed = "";
		for(int i = s.length() - 1; i >= 0 ; i--)
		{
			reversed = reversed + s.substring(i, i +1);
		}
		
		return reversed;
	}
	
	/** calculate the factorial of i
		*@param i is an integer to have its factorial calculated
		*@return an integer representing the factorial of i
		*/
	
	public static int factorial(int i)
	{
		int fac = 1;
		for(int x = i; x >= 1; x--)
		{
			fac = fac * x;
		}
		return fac;	
	}
	
	/** opens the file called filename, stores all lines in file into an array of Strings and returns it
		*@param filename is the name of the file you are going to read from
		*@return an array of Strings filled with the contents of the file
		*/
	
	public static String [] readArrayFromFile (String filename)throws Exception
	{
	
		int counter = 0;
		String text = null;
		File file = new File(filename);
		BufferedReader reader = new BufferedReader(new FileReader(file));
		
		while((text = reader.readLine()) != null)
		{
			counter++;
		}
		
		reader.close();
		
		reader = new BufferedReader(new FileReader(file));
		String wordArray[] = new String[counter];
		
		for(int i = 0; i < counter; i++)
		{
			wordArray[i] = reader.readLine();	
		}
		
		reader.close();
		
		return wordArray;
	
	}
	
	/** will round a number to the specified number of decimal points
		*@param num is the number that is to be rounded precision is the number of decimal places that num is to be rounded to
		*@return a double rounded to the specified number of decimal places
		*/

	public static double round(double num, int precision)
	{
		num = num * Math.pow(10, precision);
		
		num = Math.round(num);
		
		return num / Math.pow(10, precision);
	}
	
	/** will write the contents of the array A from index 0 to i to a file titled 					fileName
		*@param filename is the name of the file to be written to
			        A[] is the array that is to be written to the file
			        num is the number of elements from the A that will be written to the file 				    	starting at index 0
		*/
	public static void writeArrayFile (String filename, String[] A, int num)throws Exception
	{
		FileOutputStream fileHandle = new FileOutputStream(filename);
		PrintWriter fileOut = new PrintWriter(fileHandle);
		
		for(int i = 0; i< num; i++)
		{
			fileOut.println(A[i]);
		}
		fileOut.close();
	}
	
	public static Vector vsCustomerVector () throws IOException
	{
		File fileC = new File("Customers.txt");
		BufferedReader readerC = null;
      readerC = new BufferedReader(new FileReader(fileC));
		
		Customer customers;
		Vector<Customer> customerVector = new Vector();
		
		String firstName = "";
      String lastName = "";
      String pNum;  
      long phoneNumber = 0;
      String moviee;
		String text;
		
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
		return customerVector;
		
		}
		
		public static Vector vsMovieVector () throws IOException
		{
			File fileM = new File("Movies.txt"); //the file
			BufferedReader readerM = null;
         readerM = new BufferedReader(new FileReader(fileM));
			
			Movie movies;
			Vector<Movie> movieVector = new Vector();
			
			String titleM;
         String genreM;
         String rentM;
         boolean rentedM;
         String custPhoneM;
         long cPhoneM;
         String dinDate;
         int dateM;
			String text;
			
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
			return movieVector;		
		
	}
}