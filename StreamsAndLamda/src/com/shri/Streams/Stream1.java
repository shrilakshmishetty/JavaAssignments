
/*Q1: Write a Java program that uses Streams and Lambda Expressions 
 *  filter a list of integers and then square each of the remaining numbers. 
 *  Finally, print the squared numbers.
 */
package com.shri.Streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Stream1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> list = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		System.out.println("enter the length of the array");
		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			list.add(sc.nextInt());

		}
		System.out.println("Filter out even numbers from array and square each number: ");
		list.stream().filter(i -> i % 2 == 0).map(i -> i * i).collect(Collectors.toList()).forEach(System.out::print);

	}

}
