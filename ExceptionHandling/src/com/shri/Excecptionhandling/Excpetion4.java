/*Q4: Write a program with three methods - methodA, methodB, and methodC. methodA calls methodB, and methodB calls methodC. Throw a custom exception in methodC and catch it in methodA. Demonstrate exception propagation.
 */package com.shri.Excecptionhandling;
 

public class Excpetion4 {
	
	public static void methodA() {
		try {
		methodB();
		}
		catch(Exception e) {
			System.out.println(e.getMessage()+" : Caught in methodA");
		}
		
	}
    public static void methodB() throws Exception {
    	methodC();
		
	}
    public static void methodC() throws Exception {
    	throw new Exception("Exception in MethodC");
		
	}
    public static void main(String[] args) {
    	methodA();
    }



}
