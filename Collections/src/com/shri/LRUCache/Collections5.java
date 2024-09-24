/*Q5: Write a program to sort the String characters and the strings 
 * in a List<String>. sorting has to be done in decending 
 * order using comparator.  
 */
package com.shri.LRUCache;

import java.util.List;
import java.util.stream.Collectors;
import java.util.*;

public class Collections5 {
	public static String charSort(String s) {
		return s.chars()
                .mapToObj(c -> (char) c)
                .sorted(Comparator.reverseOrder())
                .map(String::valueOf)
                .collect(Collectors.joining());
		
	}
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("sugar");
		list.add("tea");
		list.add("caramel");
		list.add("coffee");
		for(int i=0;i<list.size();i++) {
			String str=charSort(list.get(i));
			list.set(i, str);
			
		}
		Collections.sort(list,Comparator.reverseOrder());
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i));
		}
		

		
	}

}
