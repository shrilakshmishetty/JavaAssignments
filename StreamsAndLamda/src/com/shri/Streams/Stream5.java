/*Q5: Write a program that generates a large list 
 * of random integers and calculates the sum using parallel streams. 
 * Compare the execution time with a sequential stream for the same task.*/

package com.shri.Streams;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Stream5 {
	public static void main(String[] args) {
		List<Long> list=new ArrayList<>();
		long num=100000;
		Random rand=new Random();
		for(int i=0;i<num;i++) {
			long n=rand.nextLong(num);
			
			list.add(n);
		}
		
		long startParallel=System.currentTimeMillis();
		long sum=list.parallelStream().mapToLong(Long::longValue).sum();
		System.out.println(sum);
		long endParallel=System.currentTimeMillis();
		System.out.println(endParallel-startParallel);
		
		long start=System.currentTimeMillis();
		long sum1=list.stream().mapToLong(Long::longValue).sum();
		System.out.println(sum1);
		long end=System.currentTimeMillis();
		System.out.println(end-start);
		
		
		
		
		
	}

}
