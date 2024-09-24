/*Q4: Given a list of lists of integers, use Streams and Lambda Expressions to flatten the 
 * structure (convert it to a single list) and remove duplicate numbers. 
 * Then, print the distinct numbers.
 * 
 */
package com.shri.Streams;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Stream4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<List<String>> list = Arrays.asList(
				Arrays.asList("milk","biscuit","coffee"),
				Arrays.asList("tea","milk","sugar","cream"),
				Arrays.asList("sugar","jaggery","caramel","cream"));
		List<String> list2=list.stream().flatMap(List::stream).distinct().collect(Collectors.toList());
		System.out.println(list2);
	}
}