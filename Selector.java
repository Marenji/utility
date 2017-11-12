import java.util.Scanner;

/**An instance of this class is used as a way of displaying options and getting user input from the command line.*/
public class Selector
{
	/**Scanner object to be used by this class to get user input*/
	private static Scanner scanner = new Scanner(System.in);
	
	/**Asks the user to input a number between a lower and upper bound and returns their input.
	 * <br>Calls {@link java.util.Scanner#nextInt}
	 * @param lowerBound The lowest attribute number the user can select
	 * @param upperBound The highest attribute number the user can select
	 * @return int - The attribute number the user has selected */
	public static int selectOptionInt(int lowerBound, int upperBound)
	{
		if(upperBound-lowerBound < 1 || lowerBound<0 || upperBound<=lowerBound)
		{throw new IllegalArgumentException("The bounds are invalid");}
		int select = -1;
		//Loop will run until the user has made select equal to a valid number
		while(select < lowerBound || select > upperBound)
		{
			//Print all options if there are less than 4 options so its easier to read
			if(upperBound-lowerBound < 4)
			{
				System.out.print("Enter ");
				for(int n = lowerBound; n <= upperBound-2; n++)
				{
					System.out.print(n+", ");
				}
				System.out.print(upperBound-1+" or "+upperBound+": ");
			}
			//Print the range of options if there are less than 4 options so it doesn't print too much
			else
			{
				System.out.print("Enter a choice from "+lowerBound+"-"+upperBound+": ");
			}
			
			try {select = scanner.nextInt();}
			catch(Exception e){scanner.next();} //scanner.next() clears the scanner if the user's input causes an exception
			
		}
		return select;
		
	}
	
}