/*Q2: Given a list of strings, use Streams and Lambda Expressions to sort the strings 
 * in descending order of their lengths. Limit the output to the first three sorted */

package com.shri.Streams;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Stream2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> list = Arrays.asList("aa","bjscajvbdajh","gdhgd","gdgWGDEBHE","YGHG","STFDT");
		
		/*List<String> list2=list.stream()
				.sorted()
				.limit(3)
				.collect(Collectors.toList());
				*/
		List<String> list2=list.stream()
				.sorted((s1,s2)->Integer.compare(s2.length(), s1.length()))
				.limit(3)
				.collect(Collectors.toList());
		
		
		System.out.println(list2);
	}
}
