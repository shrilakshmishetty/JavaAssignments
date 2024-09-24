/*
 Q8: Design a priority queue that works with custom objects. The priority should be based on a specific property of the objects, and the queue should efficiently support adding, removing, and updating elements.
 */
package com.shri.LRUCache;


import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

class Employeee{
	int id;
	String name;
	Employeee(int id,String name){
		this.id=id;
		this.name=name;
		}
}

class EmployeeComparator implements Comparator<Employeee>{
	

	@Override
	public int compare(Employeee o1, Employeee o2) {
		// TODO Auto-generated method stub
		return Integer.compare(o2.id, o1.id);
	}

	
}


public class PriorityQueue1 {
	public static void main(String[] args) {
		PriorityQueue<Employeee> pq=new PriorityQueue<>(3,new EmployeeComparator());
		pq.add(new Employeee(1,"shriii"));
		pq.add(new Employeee(2,"shriii1"));
		pq.add(new Employeee(3,"shriii2"));
		Iterator i=pq.iterator();
		for(Employeee e:pq) {
			if(e.id==3) {
				e.name="shr";
			}
			
		}
		
		while(i.hasNext()) {
			Employeee e=pq.poll();
			System.out.println(e.id+" "+e.name);
			
		}
		
		
		
		
	}

}
