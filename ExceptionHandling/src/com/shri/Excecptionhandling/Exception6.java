/*Q6: Create a program that contains nested try-catch blocks. Inside the innermost try block, attempt to divide two numbers. Catch the following exceptions:ArithmeticException: Division by zero
NumberFormatException: If the user enters a non-numeric input*/
package com.shri.Excecptionhandling;


import java.util.Scanner;

public class Exception6 {
 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s=new Scanner(System.in);
		try {
			System.out.println("Enter 2 numbers: ");
			int num1=Integer.parseInt(s.next());
			int num2=Integer.parseInt(s.next());
			try {
				int res=num1/num2;
				System.out.println(res);
			} catch(ArithmeticException e) {
				System.out.println("Exception"+e);
			}
			
		}catch(NumberFormatException e) {
			System.out.println("Please enter valid input");
		}
 
	}
 
}