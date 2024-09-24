/*Q1:Design and implement a simple LRU (Least Recently Used) cache 
 * using a combination of Linked HashMap and LinkedList. 
 * The cache should have a specified capacity, and old entries should be 
 * evicted when the capacity is exceeded.
 * 
 * 
 */
package com.shri.LRUCache;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class LRUCache {
	int capacity;
	static Map<Integer,String> mp;
	static List<Integer> list;
	
	LRUCache(int capacity){
		this.capacity=capacity;
		this.mp=new LinkedHashMap<>();
		this.list=new LinkedList<>();
	}
	public void put(int key,String value) {
		if(mp.containsKey(key)) {
			mp.remove(key);
			mp.put(key,value);
			list.remove((Integer)key);
			list.addFirst(key);
		}
		else {
			if(mp.size()>=capacity) {
				int last=list.removeLast();
				mp.remove(last);
				
			}
			mp.put(key,value);
			list.addFirst(key);
		}
		
	}
	
	public void get(int key) {
		
		if(mp.containsKey(key)) {
			list.remove((Integer)key);		
			list.addFirst(key);
			System.out.println(mp.get(key));
			
		}
		else {
		System.out.println("Not Present");
		}
		
	}
	public static void main(String[] args) {
		LRUCache lru=new LRUCache(2);
		lru.put(1, "g");
		lru.put(2, "g");
		lru.put(3, "g");
		lru.put(1, "e");
		System.out.println(list);
		System.out.println(mp);
		lru.get(2);
		System.out.println(list);
	}

}
