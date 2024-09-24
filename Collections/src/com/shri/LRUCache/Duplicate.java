/*Q4: Write a program to find and remove duplicate elements from an ArrayList 
 * without using any additional data structures. The goal is
 *  to achieve this with optimal time and space complexity.	
 */
package com.shri.LRUCache;

import java.util.Arrays;
import java.util.Collections;
import java.util.ArrayList;

public class Duplicate {
	public static void main(String[] args) {
		ArrayList<Integer> l=new ArrayList();
		l.add(2);
		l.add(3);
		l.add(4);
		l.add(2);
		l.add(5);
		l.add(6);
		l.add(2);
		l.add(3);
		l.add(4);
		System.out.println(l);
		System.out.println("Sorted elements : ");
		Collections.sort(l);
		System.out.println(l);
		int i=0;
		while(i<l.size()-1) {
			if(l.get(i)==l.get(i+1)) {
				l.remove(i+1);
				
			}
			else {
			i++;
			}
		}
		System.out.println(l);
		
	}

}
