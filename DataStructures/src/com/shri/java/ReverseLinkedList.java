//Q5: Write a program to Reverse a singly linked list.
package com.shri.java;

import com.shri.java.LinkedList1.Node;

public class ReverseLinkedList {
	Node head;
	class Node{
		Node next;
		int value;
		Node(int value){
			this.value=value;
			this.next=null;
			
		}
	}
	Node addFirst(int value) {
		Node newNode=new Node(value);
		if(head==null) {
			head=newNode;
			return head;
		}
		
		newNode.next=head;
		head=newNode;
		return head;
	}
	void display() {
		Node node=head;
		while(node!=null) {
			System.out.print(node.value+" ");
			node=node.next;
		}
		System.out.println();
	}
	
	void reverse() {
		 Node curr = head;
		 Node prev=null;
		 Node next;
	        while (curr != null) {
	            next = curr.next;
	            curr.next = prev;
	            prev = curr;
	            curr = next;
	        }
	        head=prev;
		
	}

	public static void main(String[] args) {
		ReverseLinkedList l=new ReverseLinkedList();
		l.addFirst(2);
	
		l.addFirst(3);
		l.addFirst(4);
		l.addFirst(5);
		l.display();
		l.reverse();
		l.display();
		 
	}
}
