//Q4: Implement own  Stacks and Queue with push() and pop() method
package com.shri.java;

import com.shri.java.Stack.Node;

public class Queue {
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
		Node curr=head;
		Node prev=curr;
		while(curr.next!=null) {
			prev=curr;
			curr=curr.next;
		}
		prev.next=null;
		
		
		return curr.value;
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
		Queue queue=new Queue();
		queue.push(1);
		queue.push(2);
		queue.push(3);
		queue.push(4);
		
		queue.display();
		System.out.println("the popped element from queue is "+queue.pop());
		queue.display();
		
	}

}
