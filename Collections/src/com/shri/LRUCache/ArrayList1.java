/*Q3: Implement your own ArrayList  using plain 
 * array? supported Add(), indexof(), contains() also implement
 *  Addall() method in your own ArrayList ? 
 *  Write a method  to support add(int index, int value) ? 
 */
package com.shri.LRUCache;

public class ArrayList1 {
	static int[] arr;
	int i;
	int size;
	ArrayList1(int size){
		this.size=size;
		this.arr=new int[size];
		this.i=0;
	}
	
	public void add(int value) {
		if(i==size) {
			resize();
		}
		arr[i++]=value;
		
		
	}
public void add(int index,int value) {
	
	if(i==size) {
		
		resize();
	}
	 for (int i = size-1; i > index; i--) {
         arr[i] = arr[i - 1];
     }
		
		
		arr[index]=value;
		
	}

public int indexOf(int num) {
	for(int i=0;i<arr.length;i++) {
		if(arr[i]==num) {
			return i;
		}	
}
return -1;
}

public boolean contains(int num) {
  int cnt=indexOf(num);
  if(cnt==-1) {
	  return false;
  }
  return true;
}

public void addAll(int[] p) {
	
	for(int j=0;j<p.length;j++) {
		
		add(p[j]);
	}
	for(int i=0;i<arr.length;i++) {
		System.out.print(arr[i]+" ");
		}
}
public void resize() {
	
	size=size*2;
	
	int[] arr1=new int[size];
	
	for(int i=0;i<arr.length;i++) {
		arr1[i]=arr[i];
	}
	arr=arr1;
}
	public static void main(String[] args) {
		ArrayList1 a=new ArrayList1(2);
		
		a.add(3);
		a.add(3);
		a.add(3);
		a.add(3);
		a.add(3);
		a.add(1,2);
		System.out.println(a.contains(4));
		System.out.println(a.indexOf(2));
		for(int i=0;i<arr.length;i++) {
		System.out.print(arr[i]+" ");
		}
		System.out.println();
		int[] p= {1,2,3,4,5};
		a.addAll(p);
	}

}
