/*Q2: Create a custom exception named InvalidInputException. 
Write a program that takes user input for a positive integer.
If the input is negative or zero, throw an InvalidInputException with an appropriate error message
*/
package com.shri.Excecptionhandling;


import java.util.Scanner;


class InvalidInputException extends Exception{
	 public InvalidInputException(String message) {
		 super(message);
	 }
	 
}
public class Exception2 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		try {
			System.out.println("Enter a number: ");
			int num=sc.nextInt();
			if(num<=0) {
				throw new InvalidInputException("Number is less than or equal to zero");
			}
			else{
				System.out.println("Number is positive integer");
				
			}
		}
		catch(InvalidInputException e) {
			System.out.println(e);
		}
	}
 }

