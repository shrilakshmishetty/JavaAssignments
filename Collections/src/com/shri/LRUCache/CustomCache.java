/*Q2: Create your own custom cache using HashMap.
 * Create cache, able to add 2000 values and read values from cache
 */
package com.shri.LRUCache;

import java.util.HashMap;
import java.util.Map;

public class CustomCache {
	int capacity;
	Map<Integer,String> mp;
	int cnt;
	
	
	public CustomCache(int capacity) {
		// TODO Auto-generated constructor stub
		this.capacity=capacity;
		this.mp=new HashMap<>();
		this.cnt=1;
		
	}
	public void put(int key,String value) {
	
		if(mp.size()<capacity) {
			mp.put(key, value);
			System.out.println("Successfull"+(cnt++));
		}
		else if(mp.size()==capacity) {
			System.out.println("Cache is full");
			
		}
		
	}
	public void get(int key) {
		if(mp.containsKey(key)) {
		System.out.println("The value of "+key+" is : "+mp.get(key));
		
			
		
	}
		else {
			System.out.println("key not found");
		}
			
		}


	public static void main(String[] args) {
		CustomCache c=new CustomCache(2000);
		for(int i=0;i<2001;i++){
			c.put(i, "34");
		}
		
	}

}
