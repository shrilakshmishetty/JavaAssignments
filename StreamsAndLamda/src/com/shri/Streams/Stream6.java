/*Q6: Write a program that uses Streams and Lambda Expressions to process a list of strings. 
 * Print each string's length, convert it to uppercase, and then print the modified string.
 *  Use the peek method for debugging purposes.
 */
package com.shri.Streams;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Stream6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> list =Arrays.asList("milk","biscuit","coffee","caramel","jaggery","cream");
		list.stream().forEach(m->System.out.println(m+" :"+m.length()+" "));
		list.stream().peek(n->System.out.print(n+" :")).map(n->n.toUpperCase()).forEach(m->System.out.println(m));
	}
}