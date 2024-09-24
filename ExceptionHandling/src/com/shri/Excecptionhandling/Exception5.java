
//Q5: Write a program that demonstrates chained exceptions. Create a custom exception class CustomException and another class that throws an ArithmeticException. Catch the ArithmeticException and throw a CustomException with the ArithmeticException as a chained exception.
package com.shri.Excecptionhandling;
import java.util.Scanner;
class CustomException extends Exception {
	public CustomException(String msg) {
		super(msg);
	}
}
 
public class Exception5 {
 
	public static void main(String[] args) throws CustomException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter 2 numbers:");
		int a = sc.nextInt();
		int b = sc.nextInt();
		try {
			System.out.println("Quotient:"+a/b);
		} catch(ArithmeticException e) {
			System.out.println("Catch arithmetic exception.");
			throw new CustomException("custom exception occured due to arithmetic exception "+e);
		}
	}
 
}
 
 