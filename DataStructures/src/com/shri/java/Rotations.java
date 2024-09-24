//Q3: Write a program to rotate an array of n elements to the right by k steps.
package com.shri.java;

public class Rotations {
	public static void k_Rotations(int[] arr,int k) {
		int n=arr.length;
		k%=n;
		for(int i=0;i<k;i++) {
			int temp=arr[0];
			for(int j=0;j<n-1;j++) {
				arr[j]=arr[j+1];
				
				
			}
			arr[n-1]=temp;
		}
		System.out.println();
	
		
		
	}
	public static void main(String[] args) {
		int[] arr= {2,3,4,5};
		int k=10;
		for(int c:arr) {
		System.out.print(c+" ");
		}
		
		k_Rotations(arr,k);
		for(int c:arr) {
			System.out.print(c+" ");
			}
		
	}

}
