package MMN11;

import java.util.Scanner;
import java.math.*;

/* This class playing the Einstein game */
public class Einstein {
	/* This method gets number from user and 
	 * checking if the Einstein game working */
	public static void main(String[] args) {
		final int EINSTEIN_CONSTANT = 1089;
		final int MINIMUM_3_DIGIT_NUMBER = 100;
		final int MAXIMUM_3_DIGIT_NUMBER = 999;
		final int FIRST_DIGIT = 100;
		final int SECOND_DIGIT = 10;

		// Gets user number and explain the rules
		Scanner in = new Scanner(System.in);
		System.out.println ("Welcome to the Einstein magic game.");
		System.out.println ("Please enter a 3 digit positive number whose first and last digits are different:");
		int userInput = in.nextInt();
		
		// Check if number is not three-digit number:
		if (userInput < MINIMUM_3_DIGIT_NUMBER || userInput > MAXIMUM_3_DIGIT_NUMBER) {
			// Number is not three-digit number, prints error message to console
			System.out.print("The number you entered is not a 3 digit positive number");	
		// Check if number first and last digit are the same:
		} else if ((userInput / 100) == (userInput % 10)) {
			// Number is not valid, prints error message to console
			System.out.print("The first and the last digits of the number should be different");	
		} else {
			System.out.println("User number is: " + userInput);
			// Reversing the user number and calc the difference
			int reversedNumber = (userInput / 100) + (userInput / 10 % 10) * SECOND_DIGIT + (userInput % 10) * FIRST_DIGIT;
			int difference = Math.abs(userInput - reversedNumber);
			System.out.println("Difference: " + difference);
			
			// Reversing the difference
			int reversedDifference = (difference / 100) + (difference / 10 % 10) * SECOND_DIGIT + (difference % 10) * FIRST_DIGIT;
			System.out.println("Reversed difference: " + reversedDifference);
			
			// Check if the reversedDifference and the difference is equal to EINSTEIN_CONSTANT
			if (reversedDifference + difference == EINSTEIN_CONSTANT)
				System.out.print("SUCCEEDED");	
			else
				System.out.print("FAILED");	
			
		}
	}
}
