/*
 * Q7: Write program to Store custom objects into tree set and maintain orders of object based on specific object property. Do same with hash set and linked hash set validate the result.
For Example: Employee class has id and name attributes. Set should maintain employee instance by employee id.
*/
package com.shri.LRUCache;
 

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

class Employee implements Comparable<Employee>{
	int id;
	String name;
	Employee(int id,String name){
		this.id=id;
		this.name=name;
		}
	public int compareTo(Employee other) {
	    return Integer.compare(this.id, other.id);
	}

}

public class Collection7  {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Employee emp1=new Employee(1,"sneha");
		Employee emp2=new Employee(2,"divya");
		Employee emp3=new Employee(3,"pradeep");
		Employee emp4=new Employee(4,"shrilakshmi");
		
		
		//Tree Set
		Set<Employee> s=new TreeSet<>();
		s.add(emp4);
		s.add(emp3);
		s.add(emp1);
		s.add(emp2);
		System.out.println("Tree Set ");
		for(Employee e:s) {
			
			System.out.println(e.id +" "+e.name);
		}
		
		//HashSet
		Set<Employee> s1=new HashSet<>();
		s1.add(emp3);
		s1.add(emp4);
		s1.add(emp1);
		s1.add(emp2);
		System.out.println("HashSet");
		for(Employee e:s1) {
			
			System.out.println(e.id +" "+e.name);
		}
		//LinkedHashSet
		Set<Employee> s2=new LinkedHashSet<>();
		s2.add(emp3);
		s2.add(emp4);
		s2.add(emp1);
		s2.add(emp2);
		System.out.println("LinkedHashSet");
		for(Employee e:s2) {
			
			System.out.println(e.id +" "+e.name);
		}
		
		

	}

	
}
