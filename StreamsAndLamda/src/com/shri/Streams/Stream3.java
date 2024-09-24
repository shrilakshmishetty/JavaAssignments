/*Q3: Create a program that reads a list of words from a file, uses Streams and Lambda Expressions to group 
 * the words by their first letter, and then counts the number of words in each group. Print the result.*/
package com.shri.Streams;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Stream3 {
	public static void main(String[] args) {
		List<String> list =Arrays.asList("milk","biscuit","coffee","caramel","jaggery","cream");
		Map<Character, Long> mp=list.stream().collect(Collectors.groupingBy(n->n.charAt(0),Collectors.counting()));
		mp.forEach((firstLetter,count)->System.out.println(firstLetter+" : "+count));
	}

}
