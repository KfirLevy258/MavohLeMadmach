package MMN11;

import java.util.Scanner;

/* This class reformat a milliseconds */
public class Milliseconds {
	/* This method gets number of milliseconds from user and 
	 * reformatting it to a days-hours-minutes-seconds format */
	public static void main(String[] args) {
		final int MILLISECOND_IN_SECOND = 1000; 
		final int MILLISECOND_IN_MINUTE = MILLISECOND_IN_SECOND * 60;
		final int MILLISECOND_IN_HOUR = MILLISECOND_IN_MINUTE * 60;
		final int MILLISECOND_IN_DAY = MILLISECOND_IN_HOUR * 24;
		
		// Gets user milliseconds number 
		Scanner in = new Scanner(System.in);
		System.out.println ("This program reads an integer which " +
		          		"represents Milliseconds and converts it to days, " +
						"hours, minutes and seconds.");
		System.out.println ("Please enter the number of Milliseconds");
		long milliseconds = in.nextLong();
		
		// Calc time in days, hours, minutes and seconds
		long timeInDays = milliseconds / MILLISECOND_IN_DAY;
		long timeInHours = (milliseconds % MILLISECOND_IN_DAY) / MILLISECOND_IN_HOUR; // Calc the hours without the days
		long timeInMinutes = (milliseconds % MILLISECOND_IN_HOUR) / MILLISECOND_IN_MINUTE; // Calc the minutes without the hours and days
		long timeInSeconds = (milliseconds % MILLISECOND_IN_MINUTE) / MILLISECOND_IN_SECOND; // Calc the seconds without the minutes, hours and days

		// Print the new days-hours-minutes-seconds format to console
		System.out.print(timeInDays + " days " + timeInHours + ":" + timeInMinutes + ":" + timeInSeconds + " hours");
	}
}
