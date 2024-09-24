//Q4: Implement own  Stacks and Queue with push() and pop() method
package com.shri.java;

import com.shri.java.LinkedList1.Node;

public class Stack {
	Node head;
	class Node{
		Node next;
		int value;
		Node(int value){
			this.value=value;
			this.next=null;
			
		}
	}
	Node push(int value) {
		Node newNode=new Node(value);
		if(head==null) {
			head=newNode;
			return head;
		}
		
		newNode.next=head;
		head=newNode;
		return head;
	}
	int pop() {
		
		if(head==null) {
			System.out.println("no element to remove");
		}
		int top=head.value;
		Node curr=head.next;
		head=curr;
		
		return top;
	}
	void display() {
		Node node=head;
		while(node!=null) {
			System.out.print(node.value+" ");
			node=node.next;
		}
		System.out.println();
	}
	public static void main(String[] args) {
		Stack stack=new Stack();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(5);
		stack.display();
		System.out.println("the popped element from stack is "+stack.pop());
		stack.display();
		
	}

}
