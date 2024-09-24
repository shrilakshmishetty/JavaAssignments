/*Q8: Write a Program to find the first non-repeating character in a string.
 * 
 */
package com.shri.java;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public class NonRepeatingCharacter {
	public static void main(String[] args) {
		String s="shrilakshmi";
		Map<Character,Integer> mp=new LinkedHashMap<>();
		for(int i=0;i<s.length();i++) {
			if(mp.containsKey(s.charAt(i))) {
			mp.put(s.charAt(i), mp.get(s.charAt(i))+1);
			}else {
				mp.put(s.charAt(i), 1);
			}
			
		}
		for(char c:mp.keySet()) {
			if(mp.get(c)==1) {

				System.out.println("The first non-repeating character in string " +s+" is --> " +c);
				break;
			}
		}
		
		
		
		
	}

}
