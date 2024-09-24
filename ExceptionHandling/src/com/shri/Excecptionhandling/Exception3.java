/*
 * Q3: Write a program that showcases the difference between unchecked and checked exceptions. Use both types of exceptions in separate scenarios and demonstrate how they are handled differently.
 */package com.shri.Excecptionhandling;
 

import java.io.IOException;

public class Exception3 {
	static void UncheckedException(){
		int[] arr=new int[5];
		
		try {
			for(int i=0;i<=arr.length;i++) {
				arr[i]=i;
				System.out.print(i+" ");
			}
			
		}
		catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("Caught a UncheckedException "+e);
		}
		
	}
	
	 public static void CheckedException() {
	        try {
	            readFile();
	        } catch (IOException e) {
	            System.out.println("Caught a checked exception: " + e);
	        }
	    }

	 //Always handle checked exceptions using throws keyword and try-catch
	    public static void readFile() throws IOException {
	        throw new IOException("IOException");
	    }

	
	public static void main(String[] args) {
		CheckedException();
		UncheckedException();
		
	}

}
