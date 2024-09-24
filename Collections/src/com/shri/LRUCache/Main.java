package com.shri.LRUCache;

import java.util.StringTokenizer;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
 
//Q6: Implement a program that counts the frequency of words in a given text using a ConcurrentHashMap. Ensure that the program efficiently handles concurrent read and write operations without using external locks. input to program can be mutiple paragraphs at a time.
 
 
public class Main {
	private static final int NUM_THREADS = 4;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String text = "This is a sample text. This text is for testing.\n"
                + "We are testing word frequency count.\n"
                + "Testing concurrent processing of text.";
		
		ConcurrentHashMap<String,AtomicInteger> wordCountMap = new ConcurrentHashMap<>();
		
		String[] paragraphs = text.split("\n");
		
		ExecutorService executorService = Executors.newFixedThreadPool(NUM_THREADS);
		
		for(String paragraph:paragraphs) {
			executorService.submit(()->processText(paragraph,wordCountMap));
		}
		
		executorService.shutdown();
		
		wordCountMap.forEach((word, count) ->
        	System.out.println(word + ": " + count));
 
	}
	
	private static void processText(String text, ConcurrentHashMap<String, AtomicInteger> wordCountMap) {
        StringTokenizer tokenizer = new StringTokenizer(text, " \t\n\r,.:;!?()[]{}\"'");
 
        while (tokenizer.hasMoreTokens()) {
            String word = tokenizer.nextToken().toLowerCase();
            wordCountMap.computeIfAbsent(word, k -> new AtomicInteger(0)).incrementAndGet();
        }
    }
}
 
