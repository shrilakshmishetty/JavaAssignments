/*Q1: Write program for OutofMemory Exception and its prevention (Its design issue or memory leak differentiate it.)
 * */
 package com.shri.Excecptionhandling;

 
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
 
public class Exception1 {
 
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter no. of Objects you to store : ");
		int size = scan.nextInt();
		List<Object> list = new ArrayList<>();
		Runtime runtime=Runtime.getRuntime();
		int total=0;
		long memory=runtime.maxMemory()/(1024*1024);
		
 System.out.println("Max heap size in mb "+memory);
		try {
			while (true) {
                // Allocate memory for each object
                for (int i = 0; i < size; i++) {
                    list.add(new Byte[1024 * 1024]); // Adding 1 MB objects
                }
                System.out.println("Allocated " + size + " MB");
                total=total+size;
                System.out.println("Total allocated "+total+" "+ runtime.totalMemory()/(1024*1024));
                size += size;
                
                
            }
			
		} catch (OutOfMemoryError e) {
			System.out.println("Error allocating "+size+" MB");
		}
	}
 
}