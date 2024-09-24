//Q2: Write a program for binary search.
package com.shri.java;

public class BinarySearch {
	public static int binarySearch(int[] arr,int key) {
		
		int left=0;
		int right=arr.length;
		while(left<right) {
			int mid=(left+right)/2;
			if(arr[mid]==key) {
				return mid;
			}
			else if(arr[mid]>key) {
				right=mid-1;
			}else {
				left=mid+1;
			}
		}
		return -1;
		
	}
	public static void main(String[] args) {
		int[] arr= {1,2,3,4};
		int key=5;
		if(binarySearch(arr,key)==-1) {
			System.out.println("Key Not found");
		}
		else {
		System.out.println("The key "+key+" is found at the index ->"+binarySearch(arr,key) );
		}

}
}

